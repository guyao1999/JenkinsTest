package myImaging;

import static org.junit.jupiter.api.Assertions.*;


import java.util.Arrays;
import java.util.List;

import org.apache.commons.imaging.ImageFormat;
import org.apache.commons.imaging.ImageFormats;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import myImaging.MyImageInfo;
import myImaging.MyImageInfo.ColorType;
import myImaging.MyImageInfo.CompressionAlgorithm;


/*
 * �������ڶ�MyImageInfo��ķ������е�Ԫ����
 */
class MyImageInfoTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	// ����ColorType���������ַ�����ת���Ƿ�ɹ�
	@Test
	void testColorType() {
		assertEquals("Black and White", ColorType.BW.toString());
		assertEquals(ColorType.BW, ColorType.valueOf("BW"));
	}

	
	// ����ͼƬ��ѹ���㷨�Ƿ����JPEG��ʽ
	@Test
	void testCompressionAlgorithm() {
		assertEquals("JPEG", CompressionAlgorithm.JPEG.toString());
		assertEquals(CompressionAlgorithm.JPEG, CompressionAlgorithm.valueOf("JPEG"));
	}
	
	
	//���Թ��캯���Ƿ���ȷ
	@Test
	public void testImageInfo() {

		final ColorType colorType = ColorType.GRAYSCALE;
		final CompressionAlgorithm compressionAlgorithm = CompressionAlgorithm.JPEG;

		final String formatDetails = "this is a JPEG picuture.";
		final int bitsPerPixel = 2;
		final List<String> comments = Arrays.asList("a", "b", "c");
		final ImageFormat format = ImageFormats.BMP;
		final String formatName = format.getName();
		final int height = 2;
		final String mimeType = "image-info-mimetype";
		final int numberOfImages = 2;
		final int physicalHeightDpi = 2;
		final float physicalHeightInch = 2.0f;
		final int physicalWidthDpi = 2;
		final float physicalWidthInch = 2.0f;
		final int width = 2;
		final boolean progressive = true;
		final boolean transparent = true;
		final boolean usesPalette = true;

		// ���ù��캯��
		final MyImageInfo imageInfo = new MyImageInfo(formatDetails, bitsPerPixel, comments, format, formatName, height,
				mimeType, numberOfImages, physicalHeightDpi, physicalHeightInch, physicalWidthDpi, physicalWidthInch,
				width, progressive, transparent, usesPalette, colorType, compressionAlgorithm);

		// �ж�get�����õ������Ժʹ���������Ƿ���ͬ
		assertEquals(formatDetails, imageInfo.getFormatDetails());
		assertEquals(bitsPerPixel, imageInfo.getBitsPerPixel());
		assertEquals(comments.toString(), imageInfo.getComments().toString());
		assertEquals(format, imageInfo.getFormat());
		assertEquals(formatName, imageInfo.getFormatName());
		assertEquals(height, imageInfo.getHeight());
		assertEquals(mimeType, imageInfo.getMimeType());
		assertEquals(numberOfImages, imageInfo.getNumberOfImages());
		assertEquals(physicalHeightDpi, imageInfo.getPhysicalHeightDpi());
		assertEquals(physicalHeightInch, imageInfo.getPhysicalHeightInch());
		assertEquals(physicalWidthDpi, imageInfo.getPhysicalWidthDpi());
		assertEquals(physicalWidthInch, imageInfo.getPhysicalWidthInch());
		assertEquals(width, imageInfo.getWidth());
		assertEquals(progressive, imageInfo.isProgressive());
		assertEquals(transparent, imageInfo.isTransparent());
		assertEquals(usesPalette, imageInfo.usesPalette());
		assertEquals(colorType, imageInfo.getColorType());
		assertEquals(compressionAlgorithm, imageInfo.getCompressionAlgorithm());
	}

	//���Ե�commentsΪnull��ʱ��toString�����Ƿ�Ԥ�ڵ����
	@Test
	public void testToStringErrorWhenCommentsIsNull() {
		final List<String> comments = null;
		final MyImageInfo imageInfo = new MyImageInfo(null, 0, comments, null, null, 0, null, 0, 0, 0.0f, 0, 0.0f, 0, false,
				false, false, null, null);
		assertEquals("Image Data: Error", imageInfo.toString());
	}

}
