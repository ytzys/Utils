import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Downloader {

	public static void main(String[] args) {
		try {
			URL url = new URL(
					"http://pcs.baidu.com/rest/2.0/pcs/file?method=streaming&app_id=250528&BDUSS=TU1WkxKQk5FM21wRG5pVC1-N01KZzNHNmFSLXlIN2VPUVl3VUJlMFhWb2kzRTlWQVFBQUFBJCQAAAAAAAAAAAEAAAD3O104eXVydGVlZQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAACJPKFUiTyhVU&type=M3U8_AUTO_480&path=%2Fxp20150420%2F%E6%88%98-%E7%8B%BC-%E5%90%B4-%E4%BA%AC2015%E8%B6%85%E9%AB%98%E6%B8%85%E7%89%88%5B99%E6%90%9C%E7%9B%98%E7%BD%91%E4%B8%93%E4%B8%9A%E7%99%BE%E5%BA%A6%E4%BA%91%E8%B5%84%E6%BA%90%E6%90%9C%E7%B4%A2%5D.mkv");
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
