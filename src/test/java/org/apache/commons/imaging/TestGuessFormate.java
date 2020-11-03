package org.apache.commons.imaging;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.IOException;


import org.apache.commons.imaging.common.bytesource.ByteSource;
import org.apache.commons.imaging.common.bytesource.ByteSourceFile;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.spy;


class TestGuessFormate {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		String url = "images\\Zoro.jpeg";
		File file1 = new File(url);
		
		
		//使用spy只虚拟对象的某一个方法，其它的方法依旧可以按照原来的方式执行
		MyImaging myimaging = spy(MyImaging.class);
		
		//mock(Imaging.class);
		
		
		ByteSource byteSource=new ByteSourceFile(file1);
		
		
		try {
			
		//在这里使用桩模块出现问题	
		//	
		when(myimaging.guessFormat(byteSource)).thenReturn(ImageFormats.JPEG);
		} catch (ImageReadException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		try {
			assertEquals(ImageFormats.JPEG,myimaging.guessFormat(file1));
			//assertEquals(null,myimaging.guessFormat(file1));
			
		} catch (ImageReadException e) {
			e.printStackTrace();
			System.out.println("fail");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("fail");
		}
//		
//		String ur2 = "images\\2-1.jpg";
//		File file2 = new File(ur2);
//		try {
//			assertEquals(ImageFormats.PNG,Imaging.guessFormat(file2));
//		} catch (ImageReadException e) {
//			e.printStackTrace();
//			System.out.println("fail");
//		} catch (IOException e) {
//			e.printStackTrace();
//			System.out.println("fail");
//		}
	}

}
