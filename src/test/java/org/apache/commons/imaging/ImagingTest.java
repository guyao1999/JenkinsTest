package org.apache.commons.imaging;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import org.apache.commons.imaging.common.ImageMetadata;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

/*
 *   �������ڶ�Imaging��ķ������е�Ԫ����
*/
class ImagingTest extends TestCase{

	@BeforeEach
	protected
	void setUp() throws Exception {
	}

	
	@AfterEach
	protected
	void tearDown() throws Exception {
	}

	//����hasImageFileExtensionFile()����
	@Test
	void testHasImageFileExtensionFile() {
		
		String url = "images\\Zoro.jpeg";
		File file1 = new File(url);
		assertEquals(true,Imaging.hasImageFileExtension(file1));
		
		String ur2 = "images\\Zoro";
		File file2 = new File(ur2);
		assertEquals(false,Imaging.hasImageFileExtension(file2));
	}

	
	//����guessFormatFile()����
	@Test
	void testGuessFormatFile() {
		String url = "images\\Zoro.jpeg";
		File file1 = new File(url);
		try {
			assertEquals(ImageFormats.JPEG,Imaging.guessFormat(file1));
		} catch (ImageReadException e) {
			e.printStackTrace();
			System.out.println("fail");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("fail");
		}
		
		String ur2 = "images\\2-1.jpg";
		File file2 = new File(ur2);
		try {
			assertEquals(ImageFormats.PNG,Imaging.guessFormat(file2));
		} catch (ImageReadException e) {
			e.printStackTrace();
			System.out.println("fail");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("fail");
		}
	}
	
	
	//����getImageInfoFile()����
	@Test
	void testGetImageInfoFile() {
		String url = "images\\Zoro.jpeg";
		File file1 = new File(url);
		ImageInfo imageinfo=null;
		try {
			 imageinfo=Imaging.getImageInfo(file1);
		} catch (ImageReadException e) {
			e.printStackTrace();
			System.out.println("fail");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("fail");
		}
		assertNotEquals(null,imageinfo);
	}

	
	//����getMetadataFile()����
	@Test
	void testGetMetadataFile() {
		String url = "images\\Zoro.jpeg";
		File file1 = new File(url);
		ImageMetadata metadata=null;
		try {
			 metadata=Imaging.getMetadata(file1);
		} catch (ImageReadException e) {
			e.printStackTrace();
			System.out.println("fail");
		} catch (IOException e) {
			System.out.println("fail");
			e.printStackTrace();
		}
		assertEquals(null,metadata);
	}
}
