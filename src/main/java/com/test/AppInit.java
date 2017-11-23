package com.test;

import java.io.File;
import java.io.IOException;
import java.lang.instrument.Instrumentation;
import java.lang.reflect.Field;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.test.bean.SimpleBean;
import com.test.mapper.GlobalMapper;

import sun.management.FileSystem;

public class AppInit {

	public static void main(String[] args)
			throws IOException, SecurityException, NoSuchFieldException, ClassNotFoundException {
		name();
		// Instrumentation instrumentation = (Instrumentation)
		// System.getProperties().get("inst");
		//
		// System.out.println("wowowowowoo" + Loader.instrumentation);
		// for(Class<?> clazz: instrumentation.getAllLoadedClasses()) {
		// System.out.println(clazz.getSimpleName());
		// }
	}

	/**
	 * @return 
	 * @throws IOException
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 * @throws ClassNotFoundException
	 */
	public static List<Class<GlobalMapper>> name() throws IOException, SecurityException, NoSuchFieldException, ClassNotFoundException {

		ClassLoader classLoader = AppInit.class.getClassLoader();
		List<String> names = new ArrayList<String>();
		String root = "";
		Enumeration<URL> urls = classLoader.getResources("");
		List<File> files = new ArrayList<File>();
		while (urls.hasMoreElements()) {
			URL element = (URL) urls.nextElement();
			if (!element.getProtocol().equals("jar")) {
				File folder = new File(element.getFile());
				
				root = folder.getPath();
				files.addAll(getFiles(folder));
				System.out.println(files.size());
			}
		}

		List<Class> classes = new ArrayList<Class>();
		for (File file : files) {
			System.out.println(StringUtils.substringBetween(file.getPath(), root, ".class"));
			classes.add(getInstance(
					StringUtils.replace(StringUtils.substringBetween(file.getPath(), root + File.separator, ".class"),
							File.separator, ".")));
		}
		List<Class<GlobalMapper>> mappersClasses = new ArrayList<Class<GlobalMapper>>();
		for (Class clazz : classes) {
			if (clazz.isInterface() && !GlobalMapper.class.equals(clazz) && GlobalMapper.class.isAssignableFrom(clazz)) {
				mappersClasses.add(clazz);
			}
		}
		System.out.println(mappersClasses.size());
		
		return mappersClasses;

	}

	private static Class<?> getInstance(String file) throws ClassNotFoundException {
		return StringUtils.isNotEmpty(file) ? Class.forName(file) : Object.class;
	}

	private static List<File> getFiles(File file) {
		List<File> files = Arrays.asList(file.listFiles());
		List<File> clazzes = new ArrayList<File>();
		for (File fileItem : files) {
			if (fileItem.isDirectory()) {
				clazzes.addAll(getFiles(fileItem));
			} else {
				clazzes.add(fileItem);
			}
		}
		return clazzes;
	}

}
