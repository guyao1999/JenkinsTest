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
 * 该类用于对MyImageInfo类的方法进行单元测试
 */
class MyImageInfoTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	// 测试ColorType方法进行字符串的转换是否成功
	@Test
	void testColorType() {
		assertEquals("Black and White", ColorType.BW.toString());
		assertEquals(ColorType.BW, ColorType.valueOf("BW"));
	}

	
	// 测试图片的压缩算法是否存在JPEG格式
	@Test
	void testCompressionAlgorithm() {
		assertEquals("JPEG", CompressionAlgorithm.JPEG.toString());
		assertEquals(CompressionAlgorithm.JPEG, CompressionAlgorithm.valueOf("JPEG"));
	}
	
	
	//测试构造函数是否正确
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

		// 调用构造函数
		final MyImageInfo imageInfo = new MyImageInfo(formatDetails, bitsPerPixel, comments, format, formatName, height,
				mimeType, numberOfImages, physicalHeightDpi, physicalHeightInch, physicalWidthDpi, physicalWidthInch,
				width, progressive, transparent, usesPalette, colorType, compressionAlgorithm);

		// 判断get方法得到的属性和传入的属性是否相同
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

	//测试当comments为null的时候，toString方法是否按预期的输出
	@Test
	public void testToStringErrorWhenCommentsIsNull() {
		final List<String> comments = null;
		final MyImageInfo imageInfo = new MyImageInfo(null, 0, comments, null, null, 0, null, 0, 0, 0.0f, 0, 0.0f, 0, false,
				false, false, null, null);
		assertEquals("Image Data: Error", imageInfo.toString());
	}

}
