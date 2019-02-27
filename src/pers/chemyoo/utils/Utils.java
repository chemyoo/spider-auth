package pers.chemyoo.utils;

import java.io.File;
import java.util.Map;

import pers.chemyoo.core.Message;

public class Utils {
	
	private Utils() {}
	
	public static boolean exsits(String user, String pass) {
		String dir = System.getProperty("user.dir");
		StringBuilder builder = new StringBuilder(dir);
		builder.append(File.separatorChar)
			   .append(user)
			   .append(File.separatorChar)
			   .append(pass);
		File file = new File(builder.toString());
		return file.exists();
	}
	
	public static synchronized boolean createDir(String user, String pass) {
		String dir = System.getProperty("user.dir");
		StringBuilder builder = new StringBuilder(dir);
		builder.append(File.separatorChar)
			   .append(user);
		File file = new File(builder.toString());
		if(!file.exists()) {
			builder.append(File.separatorChar)
			       .append(pass);
			return new File(builder.toString()).mkdirs();
		}
		return true;
	}
	
	public static synchronized boolean deleteDir(String user) {
		String dir = System.getProperty("user.dir");
		StringBuilder builder = new StringBuilder(dir);
		builder.append(File.separatorChar)
			   .append(user);
		File file = new File(builder.toString());
		return deleteDir(file);
	}
	
	private static boolean deleteDir(File file) {
		if(file.exists()) {
			if(file.isDirectory()) {
				for(File f : file.listFiles()) {
					if(!deleteDir(f))
						return false;
				}
				return file.delete();
			} else {
				return file.delete();
			}
		}
		return true;
	}
	
	public static boolean checkPermission(String adminId) {
		return Message.ADMIN_ID.equals(adminId);
	}
	
	public static boolean checkNotNull(Map<String, String> params, String ... keys) {
		for(String key : keys) {
			String value = params.get(key);
			if(value == null || value.trim().length() == 0)
				return false;
		}
		return true;
	}

}
