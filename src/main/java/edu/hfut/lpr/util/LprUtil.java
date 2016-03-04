package edu.hfut.lpr.util;

import java.io.File;
import java.util.Vector;

/**
 * 工具类
 *
 * @author wanggang
 *
 */
public class LprUtil {

	/**
	 * 获取目录下面的所有文件
	 *
	 * @param path  路径
	 * @param files 文件列表
	 */
	public static void getFiles(final String path, Vector<String> files) {
		getFiles(new File(path), files);
	}

	/**
	 * 使用同样名字创建并删除一个新的目录
	 *
	 * @param dir 目录名
	 */
	public static void recreateDir(final String dir) {
		new File(dir).delete();
		new File(dir).mkdir();
	}

	private static void getFiles(final File dir, Vector<String> files) {
		File[] filelist = dir.listFiles();
		for (File file : filelist) {
			if (file.isDirectory()) {
				getFiles(file, files);
			} else {
				files.add(file.getAbsolutePath());
			}
		}
	}

}
