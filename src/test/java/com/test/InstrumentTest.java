package com.test;

import java.io.IOException;
import java.lang.instrument.Instrumentation;
import java.net.URL;
import java.util.Enumeration;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class InstrumentTest {

	@Test
	public void getAllaClassesTest() throws IOException {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		Enumeration<URL> resources = classLoader.getResources("com");
		System.out.println("eyyy");
		while (resources.hasMoreElements()) {
			URL url = (URL) resources.nextElement();
			System.out.println("Class :" + url.getPath());
		}
	}

	@Test
	public void InstrumentationTest() {
		Instrumentation inst = (Instrumentation) System.getProperties().get("inst");
		Class[] initiatedClasses = inst.getAllLoadedClasses();
		Assert.assertNotNull(initiatedClasses);
		for(int x = 0; x<initiatedClasses.length; x++) {
			System.out.println("CLass: " + initiatedClasses[x].getCanonicalName());
		}
	}
	


}
