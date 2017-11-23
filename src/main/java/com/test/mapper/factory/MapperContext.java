package com.test.mapper.factory;

import java.io.IOException;
import java.lang.instrument.Instrumentation;
import java.util.ArrayList;
import java.util.List;

import com.test.AppInit;
import com.test.mapper.GlobalMapper;

public class MapperContext {

	@SuppressWarnings("rawtypes")
	public static List<Class<GlobalMapper>> getMappers() {
//		Class[] allLoadedClasses = Loader.instrumentation.getAllLoadedClasses();
//		Class[] allLoadedClasses = ((Instrumentation)System.getProperties().get("inst")).getInitiatedClasses(AppInit.class.getClassLoader());
//		List<Class<GlobalMapper>> mappers = new ArrayList<Class<GlobalMapper>>();
//		for (int x = 0; x < allLoadedClasses.length; x++) {
//		if (GlobalMapper.class.isAssignableFrom((allLoadedClasses[x]))) {
//				System.out.println("class:----------" + " "+ x+ " " + allLoadedClasses[x].getCanonicalName());
//				mappers.add((Class<GlobalMapper>) allLoadedClasses[x]);			}
//		}
//
//		return mappers;
		
		try {
			return AppInit.name();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
