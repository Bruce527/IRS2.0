/**
 * 
 */
package com.sinosoft.platform.core.application;

import java.io.File;
import java.util.List;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

/**
 * 文件操作服务接口，用于操作文件
 * @author Darker.Wang
 * @date 2016-7-27 上午11:30:42
 * @company SINOSOFT
 */
public interface FileService {
	
	/**
	 * 新建ZIP 并将指定文件集合添加到ZIP中
	 * @param sFiles 指定文件集合
	 * @param zipPath 新建ZIP文件路径
	 * @param zipName 新建ZIP文件名称
	 * @return
	 */
	public File fileToZip(List<File> sFiles, String zipPath, String zipName);
	/**
	 * 删除指定文件集合
	 * @param files
	 * @return
	 */
	public boolean deleteFileList(File[] files);
	/**
	 * 删除指定文件
	 * @param file
	 * @return
	 */
	public boolean deleteFile(File file);
	/**
	 * 指定文件压缩成ZIP文件
	 * @param inputFile
	 * @param zipFileName
	 * @return
	 * @throws Exception
	 */
	public boolean fileToZip(File inputFile, File zipFileName) throws Exception;
	/**
	 * 指定文件路径压缩成ZIP文件
	 * @param sFile
	 * @param zipPath
	 * @param zipName
	 * @return
	 */
	public File fileToZip(String sFile, String zipPath, String zipName);
	/**
	 * 创建文件路径
	 * @param tPath
	 * @return
	 */
	public boolean makeDir(String tPath);
	/**
	 * 新建ZIP文件
	 * @param zipPath
	 * @param zipName
	 * @return
	 * @throws ZipException
	 */
	public ZipFile newZipFile(String zipPath, String zipName) throws ZipException;
	/**
	 * 本地指定文件夹压缩，指定压缩有文件路径及文件名称
	 * @param localfile 指定文件夹
	 * @param zipPath 压缩后文件路径
	 * @param zipName 压缩有文件名称
	 * @return
	 */
	public ZipFile local2ZipFile(String localfile, String zipPath,String zipName);
	/**
	 * 递归获取文件下的所有文件个数
	 * @param f
	 * @return
	 */
	public int getlist(File f);
	
	/**
	 * 将SQL查询结果生成TXT文件
	 * @param sql
	 * @param filePath
	 * @return
	 */
	public boolean toTxtFile(String sql, String filePath);
	/**
	 * 将SQL查询结果生成TXT文件
	 * @param temppath
	 * @param fileName
	 * @param sql
	 * @return
	 */
	public File toTxtFile(String temppath, String fileName, String sql);
	
	/**
	 * 统计指定文件路径下的指定文件类型的个数
	 * @param dictory
	 * @param fileType
	 * @return
	 */
	public int getFileNum(String dictory, String fileType);
	
	/**
	 * 解压ZIP文件返回解压后文件路基功能
	 * @param path 返回解压后的路径
	 * @return
	 */
	public String unZip(String path);
	/**
	 * 判断是否是TXT文件
	 * @param filename
	 * @return
	 */
	public boolean isTxt(String filename);
}
