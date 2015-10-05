package com.common.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import android.graphics.Path;

public class FileModelTool {

	// static String tag = "FileModelTool";
	// static {
	// System.loadLibrary("modeltool");
	// }

	public static native void changeMode();

	public static void changeFileMode(ArrayList<String> list) throws Exception {

		// su命令，的获取之后，必须让其他的命令保证在同一个会话中
		// 或者使用 su -c commd,格式，例如 su -c ls
		Runtime r = Runtime.getRuntime();
		Process proc = r.exec("su");
		Thread.sleep(5 * 1000);// 等待5秒钟是登台super user授权
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(proc.getOutputStream())), true);
		out.println("chmod 777 /");

		for (String str : list) {
			out.println("chmod 777 " + str);
		}
		// 修改微信相关目录信息
		out.println("cd /data/data/com.tencent.mm/MicroMsg/");
		out.println("chmod 777 *");
		out.println("exit");
		out.close();
		proc.destroy();
	}

	public static void changeFileMode(String path) throws Exception {
		// su命令，的获取之后，必须让其他的命令保证在同一个会话中
		// 或者使用 su -c commd,格式，例如 su -c ls
		Runtime r = Runtime.getRuntime();
		Process proc = r.exec("su");
		Thread.sleep(5 * 1000);// 等待5秒钟是登台super user授权
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(proc.getOutputStream())), true);
		out.println("chmod 777 " + path);
		out.println("exit");
		out.close();
		proc.destroy();
	}

	// 抽取这个路径下得所有目录
	public static ArrayList<String> getDirs(String path) {
		ArrayList<String> dires = new ArrayList<String>();
		String lastIndex = "";
		if (!StringUtils.isEmpty(path)) {
			String[] paths = path.split(File.separator);
			for (int i = 0; i < paths.length; i++) {
				lastIndex += File.separator + paths[i];
				dires.add(lastIndex);
			}
		}
		return dires;
	}
}
