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

	//�������Ĺ���Ϊ���ͼƬ��һЩ������Ϣ,����Ϣ��exif����ȡ��������ڸ���Ϣ�����������true��û���򷵻�false��
	public static boolean getImageInfo(File file) {
		
		boolean result=false;
		
		if(Imaging.hasImageFileExtension(file))
		{
			System.out.println("�����ͼƬ����չ��");
		}
		
		//���ļ�����ȡ��һ��ͼƬ����Ϣ
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
			
			System.out.println("ͼƬ��ʽΪ��"+imageinfo.getCompressionAlgorithm());
			System.out.println("ͼƬ��ɫ����Ϊ��"+imageinfo.getColorType());
			System.out.println("ͼƬ��Ϊ��"+imageinfo.getWidth()+"px");
			System.out.println("ͼƬ��Ϊ��"+imageinfo.getWidth()+"px");
			
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
			System.out.println("��ͼ��û��metada��Ϣ");
		}else {
			result=true;
//			System.out.println("�ع�ʱ��Ϊ��"+metadata.getItems().get(32));
//			System.out.println("����ص㾭��Ϊ��"+metadata.getItems().get(64));
//			System.out.println("����ص�γ��Ϊ��"+metadata.getItems().get(60)+"\n");
			System.out.println("ͼƬ������Ϣ���£�");
			for(int i=0;i<metadata.getItems().size();i++)
			{
				System.out.println(i+": "+metadata.getItems().get(i));
			}
		}
		
		return result;
		
	}
}
