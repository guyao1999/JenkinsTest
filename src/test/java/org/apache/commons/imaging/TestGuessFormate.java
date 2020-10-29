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
		
		mock(MyImaging.class);
		//mock(Imaging.class);
		
		
		ByteSource byteSource=new ByteSourceFile(file1);
		try {
			
		//在这里使用桩模块出现问题	
		when(MyImaging.guessFormat(byteSource)).thenReturn(ImageFormats.JPEG);
		//when(Imaging.guessFormat(byteSource)).thenReturn(ImageFormats.JPEG);
		} catch (ImageReadException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		try {
			assertEquals(ImageFormats.JPEG,MyImaging.guessFormat(file1));
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
