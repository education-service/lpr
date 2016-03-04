package edu.hfut.lpr.run;

import java.io.File;

/**
 * 洪都样本测试
 *
 * @author wanggang
 *
 */
public class HDSampleRun {

	public static void main(String[] args) {
		File dir = new File("data/image/hd20150608");
		File[] files = dir.listFiles();
		int count = 0;
		for (File file : files) {
			count++;
			System.err.println(file.getName());
		}
		System.out.println("样本总数：" + count);
	}

}
