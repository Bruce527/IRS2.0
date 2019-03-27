package com.sinosoft.platform.core.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Enumeration;
import org.apache.tools.zip.ZipEntry;

/**
 * 平台文件工具包
 * 
 * @author MrWang
 * @date 2015-11-19
 */
public class PlatFileUtil {
	/** 分割符1 | **/
	public static final int buffer = 2048;

	public static String unZip(String path) {
		System.out.println("ERROR ZIP PATH: " + path);
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

	private static boolean isTxt(String filename) {
		if (filename.endsWith(".txt")) {
			return true;
		}
		return false;
	}
}
