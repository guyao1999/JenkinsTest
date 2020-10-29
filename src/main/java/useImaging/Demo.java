package useImaging;


import java.io.File;
import java.io.IOException;
import org.apache.commons.imaging.ImageInfo;
import org.apache.commons.imaging.common.ImageMetadata;
import org.apache.commons.imaging.ImageReadException;
import org.apache.commons.imaging.Imaging;

public class Demo {

	public static void main(String[] args) {
		String url = "images\\Zoro.jpeg";
		File file = new File(url);
		getImageInfo(file);
	}	

	//本函数的功能为输出图片的一些基本信息,该信息从exif中提取，如果存在该信息就输出，返回true，没有则返回false。
	public static boolean getImageInfo(File file) {
		
		boolean result=false;
		
		if(Imaging.hasImageFileExtension(file))
		{
			System.out.println("输入的图片有扩展名");
		}
		
		//从文件流获取到一张图片的信息
		ImageInfo imageinfo = null;
		try {
			imageinfo = Imaging.getImageInfo(file);
		} catch (ImageReadException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(imageinfo!=null)
		{
			
			System.out.println("图片格式为："+imageinfo.getCompressionAlgorithm());
			System.out.println("图片颜色类型为："+imageinfo.getColorType());
			System.out.println("图片宽为："+imageinfo.getWidth()+"px");
			System.out.println("图片高为："+imageinfo.getWidth()+"px");
			
		}
		
		ImageMetadata metadata=null;
		try {
			metadata=Imaging.getMetadata(file);
		} catch (ImageReadException e) {
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		if(metadata==null)
		{
			System.out.println("该图像没有metada信息");
		}else {
			result=true;
//			System.out.println("曝光时间为："+metadata.getItems().get(32));
//			System.out.println("拍摄地点经度为："+metadata.getItems().get(64));
//			System.out.println("拍摄地点纬度为："+metadata.getItems().get(60)+"\n");
			System.out.println("图片其它信息如下：");
			for(int i=0;i<metadata.getItems().size();i++)
			{
				System.out.println(i+": "+metadata.getItems().get(i));
			}
		}
		
		return result;
		
	}
}
