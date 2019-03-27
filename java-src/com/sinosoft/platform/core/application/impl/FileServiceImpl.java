package com.sinosoft.platform.core.application.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

import org.apache.log4j.Logger;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.platform.core.application.FileService;
import com.sinosoft.platform.core.application.SqlUtilService;
import com.sinosoft.platform.core.domain.mapper.SqlAdapterMapper;
import com.sinosoft.platform.core.domain.model.SqlAdapter;
import com.sinosoft.platform.core.util.DateUtils;
import com.sinosoft.platform.core.util.NumberUtils;

/**
 * 文件操作服务实现类，用于操作文件
 * @author Darker.Wang
 * @date 2016-7-26 下午8:52:16
 * @company SINOSOFT
 */
@Service
public class FileServiceImpl implements FileService {
	public final int buffer = 2048;
	private Logger logger = Logger.getLogger(FileServiceImpl.class);
	@Autowired
	SqlAdapterMapper sqlAdapterMapper;
	@Autowired
	SqlUtilService sqlUtilService;

	@SuppressWarnings("rawtypes")
	public File toTxtFile(String temppath, String fileName, String sql) {
		File pFile = new File(temppath);
		if (!pFile.exists()) {
			logger.info("PATH ：" + temppath + " NOT EXIST AND CREATE IT。");
			pFile.mkdirs();
			pFile = null;
		}
		File file = null;
		/***********************************
		 * 文件存储及
		 * *********************************/

		FileOutputStream fos = null;
		try {

			if (!temppath.endsWith("/")) {
				temppath += "/";
			}
			file = new File(temppath + fileName);
			SqlAdapter sqlAdapter = new SqlAdapter();
			sqlAdapter.setSql(sql);
			List<Map> src = sqlAdapterMapper.excuteQuery(sqlAdapter);
			List<String> srcCol = sqlUtilService.getSqlColInfo(sql);
			// 获取数据
			for (Map map : src) {
				fos = new FileOutputStream(file, true);
				String colContent = "";
				for (int C = 1; C <= srcCol.size(); C++) {
					String key = srcCol.get(C);
					String value = (String) map.get(key);
					if (value == null || value.equals("")
							|| value.equals("null")) {
						colContent += "|";
					}
					colContent += value;
					if (C != srcCol.size()) {
						colContent += "|";
					} else {
						colContent += "{CR}{LF}";
					}
					// 将数据写入文件，追加！
				}
				fos.write(colContent.getBytes());
				fos.flush();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (null != fos) {
					fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		logger.info("FILE : " + file + " CREATE DONE!");
		return file;
	}
	public File fileToZip(List<File> sFiles, String zipPath, String zipName) {
		File zipFile;
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		FileOutputStream fos = null;
		ZipOutputStream zos = null;
		if (null == sFiles || sFiles.size() < 1) {
			logger.info("NO ZIP FILE ");
			return null;
		}
		try {
			zipFile = new File(zipPath);
			if (!zipFile.isFile()) {
				logger.info("PATH ：" + zipPath + " NOT EXIST AND CREATE IT.");
				zipFile.mkdir();
				zipFile = null;
			}
			if (!zipName.endsWith(".zip")) {
				zipName = zipName + ".zip";
			}
			zipFile = new File(zipPath + "/" + zipName);
			if (zipFile.exists()) {
				logger.info("DICTORY " + zipPath + " EXIST ：" + zipName
						+ " AND WILE UPDATE IT.");
			} else {
				fos = new FileOutputStream(zipFile);
				zos = new ZipOutputStream(new BufferedOutputStream(fos));
				byte[] bufs = new byte[1024 * 10];
				for (int i = 0; i < sFiles.size(); i++) {
					logger.info("====== " + DateUtils.getCurrentTime()
							+ " zipping " + sFiles.get(i));
					// 1、创建zip实体并添加至压缩包zip
					ZipEntry zipEntry = new ZipEntry(sFiles.get(i).getName());
					zos.putNextEntry(zipEntry);
					// 2、读取待压缩的文件并写进压缩包
					fis = new FileInputStream(sFiles.get(i));
					bis = new BufferedInputStream(fis, 1024 * 10);
					int read = 0;
					while ((read = bis.read(bufs, 0, 1024 * 10)) != -1) {
						zos.write(bufs, 0, read);
					}
					zos.flush();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("ZIP FILE FALSE！");
			return null;
		} finally {
			try {
				if (null != bis) {
					bis.close();
				}
				if (null != fis) {
					fis.close();
				}
				if (null != zos) {
					zos.close();
				}
				if (null != fos) {
					fos.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		logger.info("ZIP FILE OVER：" + zipPath + zipName);
		return zipFile;
	}

	public boolean deleteFileList(File[] files) {
		if (files != null) {
			for (int j = 0; j < files.length; j++) {
				File fileT = files[j];
				if (fileT != null && fileT.exists() && fileT.isFile()) {
					logger.info("DELETE TEMP FILE ：" + fileT.getName());
					fileT.delete();
				}
			}
			files = null;
		}
		return true;
	}

	public boolean deleteFile(File file) {
		if (file == null) {
			logger.info("TEMP FILE IS NULL");
			return false;
		}
		if (file.isFile()) {
			file.delete();
		} else {
			File[] files = file.listFiles();
			if (files != null) {
				for (File f : files) {
					if (f.isDirectory()) {
						deleteFile(f);
					}
					if (f != null) {
						f.delete();
					}

				}
			}
		}
		logger.info("TEMP FILE ： " + file.getName() + " DELETE DONE");
		file.delete();
		file = null;
		return true;
	}

	public boolean fileToZip(File inputFile, File zipFileName)
			throws Exception {
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(
				zipFileName, false));
		out.setEncoding("GBK");
		zipStream(out, inputFile, "");
		logger.info(zipFileName.getName() + " DONE");
		out.flush();
		out.close();
		return true;
	}

	private void zipStream(ZipOutputStream out, File f, String base)
			throws Exception {

		if (!f.exists()) {
			f.mkdirs();
		}
		if (f.isDirectory()) {
			File[] fl = f.listFiles();
			// 添加本身
			base = base.length() == 0 ? "" : base + "/";
			for (int i = 0; i < fl.length; i++) {
				zipStream(out, fl[i], base + fl[i].getName());
			}
		} else {
			out.putNextEntry(new ZipEntry(base));
			FileInputStream in = new FileInputStream(f);
			byte[] b = new byte[1024];
			int i = in.read(b);
			while (i != -1) {
				out.write(b, 0, b.length);
				i = in.read(b);
			}
			in.close();
			logger.info(" Entry " + base + "  DONE");
		}
	}
	public File fileToZip(String sFile, String zipPath, String zipName) {
		int number = getlist(new File(sFile));
		zipName = zipName + "_" + NumberUtils.getNumber(number, 3) + ".zip";
		if (!zipPath.endsWith("/")) {
			zipPath = zipPath + "/";
		}
		if (!zipName.endsWith(".zip")) {
			zipName = zipName + ".zip";
		}
		makeDir(zipPath);
		String zip = zipPath + zipName;
		File zipFile = new File(zip);
		try {
			boolean result = fileToZip(new File(sFile), zipFile);
			if (result) {
				return zipFile;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

	public boolean makeDir(String tPath) {
		File zipPathFile = new File(tPath);
		if (zipPathFile.exists()) {
			return true;
		}
		if (zipPathFile.isFile()) {
			makeDir(zipPathFile.getParent());
			zipPathFile = null;
		}
		System.out.println("- CREATE PATH : "+tPath);
		zipPathFile.mkdirs();
		zipPathFile = null;
		return true;
	}

	public ZipFile newZipFile(String zipPath, String zipName)
			throws ZipException {

		// Do ZIP INIT INFO
		if (!zipPath.endsWith("/")) {
			zipPath = zipPath + "/";
		}
		if (!zipName.endsWith(".zip")) {
			zipName = zipName + ".zip";
		}
		makeDir(zipPath);
		logger.info("NEW　ZIP FILE : " + zipPath + zipName);
		ZipFile zipFile = new ZipFile(zipPath + zipName);
		return zipFile;
	}

	public ZipFile local2ZipFile(String localfile, String zipPath,String zipName) {
		logger.info("TO DO ZIP PATH ： " + localfile);
		ZipFile zipFile;
		try {
			makeDir(localfile);
			zipFile = newZipFile(zipPath, zipName);
			// Initiate Zip Parameters which define various properties such
			// as compression method, etc.
			logger.info("Initiate Zip Parameters which define various properties such");
			ZipParameters parameters = new ZipParameters();
			// set compression method to store compression
			
			logger.info("set compression method to store compression");
			parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
			
			// Set the compression level
			logger.info("Set the compression level");
			parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
			
			// Add folder to the zip file
			logger.info("Add folder to the zip file ....");
			zipFile.addFolder(localfile, parameters);
			logger.info("add folder to the zip file over");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error(" local2ZipFile exception : "+e.getMessage());
			e.printStackTrace();
			return null;
		}
		logger.info("NEW　ZIP DONE : " + zipPath + zipName);
		return zipFile;
	}

	public int getlist(File f) {
		int size = 0;
		File flist[] = f.listFiles();
		size = flist.length;
		for (int i = 0; i < flist.length; i++) {
			if (flist[i].isDirectory()) {
				size = size + getlist(flist[i]);
				size--;
			}
		}
		return size;
	}


	@SuppressWarnings("rawtypes")
	public boolean toTxtFile(String sql, String filePath) {
		/***********************************
		 * 文件存储及
		 * *********************************/
		try {
			SqlAdapter sqlAdapter = new SqlAdapter();
			sqlAdapter.setSql(sql);
			List<Map> src = sqlAdapterMapper.excuteQuery(sqlAdapter);
			List<String> srcCol = sqlUtilService.getSqlColInfo(sql);
			// 获取数据
			if (src.size() >= 1) {
				for (Map map : src) {
					OutputStreamWriter out = new OutputStreamWriter(
							new FileOutputStream(filePath, true), "UTF-8");
					for (int i = 0; i < srcCol.size(); i++) {
						if (new File(filePath).length() != 0) {
							out.write("\n");
						}
						String colContent = (String) map.get(srcCol.get(i));
						logger.debug("====== " + DateUtils.getCurrentTime()+ " ADDING CONTENT...");
						out.write(colContent);
					}
					out.flush();
					out.close();
				}
			} else {
				deleteFile(new File(filePath));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public int getFileNum(String dictory, String fileType) {
		int num = 0;
		File file = new File(dictory);
		if (file.isFile() && !file.isDirectory()) {
			String filename = file.getName();
			int s = filename.lastIndexOf(".");
			if (s > 1) {
				String type = filename.substring(s + 1, filename.length());
				if (type.equals(fileType)) {
					num = 1;
				}
			}
			return num;
		}
		String[] filel = file.list();
		if (filel == null) {
			return num;
		}
		for (int i = 0; i < filel.length; i++) {
			String f = filel[i];
			if (f.length() <= 2) {
				continue;
			}
			f = dictory + "/" + f;
			File tf = new File(f);
			if (tf.isFile() && !tf.isDirectory()) {
				String tfilename = tf.getName();
				int s = tfilename.lastIndexOf(".");
				if (s > 1) {
					String type = tfilename
							.substring(s + 1, tfilename.length());
					if (type.equals(fileType)) {
						num++;
						continue;
					}
				}
			}
			logger.info(" > COUNT " + f);
			num += getFileNum(f, fileType);
		}
		return num;
	}

	public String updateSqlFile(String file, String content) {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileWriter(file, false));
			pw.println(content);
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (pw != null) {
				pw.close();
				pw = null;
			}
		}
		return file;
	}

	public String unZip(String path) {
		logger.info("UNZIP PATH: " + path);
		int index = -1;
		String savepath = "";
		boolean flag = false;
		File file = null;
		InputStream is = null;
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;

		savepath = path.substring(0, path.lastIndexOf(".")) + "/";
		new File(savepath).mkdirs();
		try {
			org.apache.tools.zip.ZipFile zipFile = new org.apache.tools.zip.ZipFile(
					path);
			Enumeration<?> entries = zipFile.getEntries();
			while (entries.hasMoreElements()) {
				byte data[] = new byte[buffer];
				ZipEntry entry = (ZipEntry) entries.nextElement();
				String filename = entry.getName();
				index = filename.lastIndexOf("/");
				if (index > -1) {
					filename = filename.substring(index + 1);
				}
				filename = savepath + filename;
				flag = isTxt(filename);
				if (!flag) {
					continue;
				}

				file = new File(filename);
				file.createNewFile();

				is = zipFile.getInputStream(entry);
				fos = new FileOutputStream(file, false);
				bos = new BufferedOutputStream(fos);
				int count = is.read(data);
				while (count != -1) {
					bos.write(data, 0, count);
					count = is.read(data);
				}
				fos.flush();
				bos.flush();
				bos.close();
				fos.close();
				is.close();
			}
			zipFile.close();
			// deleteFile(new File(path));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return savepath;
	}

	public boolean isTxt(String filename) {
		if (filename.endsWith(".txt")) {
			return true;
		}
		return false;
	}
}
