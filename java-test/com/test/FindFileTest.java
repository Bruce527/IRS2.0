/**
 * 
 */
package com.test;

import java.io.File;

/**
 * @author Darker.Wang
 * @date 2016-7-6 下午2:59:50
 * @company SINOSOFT
 */
public class FindFileTest {

	/**
	 * 
	 */
	public FindFileTest() {
		// TODO Auto-generated constructor stub
	}

	public boolean findFile(String tFile) {
		File tf = new File(tFile);
		File[] tfs = tf.listFiles();
		if (tfs == null) {
			System.out.println(tFile);
			return false;
		} else {
			for (int i = 0; i < tfs.length; i++) {
				System.out.println("==> "+tfs[i].getName()+".........");
				if (tfs[i].getName().contains("it_pingw")) {
					System.out.println(tfs[i].getAbsolutePath());
					return true;
				}
				if (tfs[i].getName().contains("IT_PINGW")) {
					System.out.println(tfs[i].getAbsolutePath());
					return true;
				}
				if (tfs[i].isDirectory()) {
					findFile(tfs[i].getAbsolutePath());
				}
			}
		}
		return true;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindFileTest test = new FindFileTest();
		test.findFile("c:/");
	}

}
