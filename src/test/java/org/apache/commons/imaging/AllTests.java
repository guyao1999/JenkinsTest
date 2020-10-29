package org.apache.commons.imaging;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import junit.framework.Test;
import junit.framework.TestSuite;

/*
 * 这里进行集成测试
 * 
 */
@RunWith(Suite.class)
@SuiteClasses({})
public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(ImagingTest.class);
		//$JUnit-END$
		return suite;
	}
}
