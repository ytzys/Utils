import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 
 * @author ytzys
 * 
 *         一个简单的文件下载类
 */
public class Downloader {

	public static void main(String[] args) {
		try {
			URL url = new URL(
					"http://172.16.16.221/test/cachingwhileplaying.m3u8");
			byte[] buffer = new byte[1024 * 8];
			int readSize;
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			System.out.println("response code:" + conn.getResponseCode());
			if (conn.getResponseCode() == 200) {
				InputStream is = conn.getInputStream();
				FileOutputStream fos = new FileOutputStream(new File(
						"C:\\downloader.m3u8"));
				while ((readSize = is.read(buffer)) >= 0) {
					fos.write(buffer, 0, readSize);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
