package com.oa.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 获取图片唯一名称类
 * 
 * @author Administrator
 * 
 */
public class FileUtil {
	private static SimpleDateFormat sdf = new SimpleDateFormat();

	/**
	 * 获取文件名
	 * @param appPath
	 * @param fileName
	 * @param userId
	 * @return
	 */
	public static String getNewFileName(String appPath, String fileName,
			String userId) {
		String storePath = "userFiles" + "/" + userId + "/"
				+ getDateFormat("yyyy/MM/", new Date());
		File file = new File(appPath + "/" + storePath);
		if (!file.exists()) {
			file.mkdirs();
		}
		return storePath + UUID.randomUUID().toString() + getFileTex(fileName);
	}

	// 获取时间
	public static String getDateFormat(String format, Date date) {
		sdf.applyPattern(format);
		return sdf.format(date);
	}

	// 获取图片的后缀名
	public static String getFileTex(String fileName) {
		String tex = "";
		if (fileName != null && fileName.length() > 0) {
			tex = fileName.substring(fileName.lastIndexOf("."));

		}
		return tex;
	}
	
}
