package useImaging;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
 * 该类用于对Demo类进行测试
*/
class DemoTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		String url1 = "images\\Zoro.jpeg";
		File file1 = new File(url1);
		assertEquals(false,Demo.getImageInfo(file1));
		
		String url2 = "images\\1.jpg";
		File file2 = new File(url2);
		assertEquals(true,Demo.getImageInfo(file2));
	}
	
}
