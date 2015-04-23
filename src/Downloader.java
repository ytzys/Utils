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
					"http://cache.m.wasu.cn:8089/cu_iphone.m3u8?userid=RDUCHS-NB3G-IPS-04142968735206948&userip=124.202.227.22&spid=O1p1&pid=O2p2&cid=9999999920120824000000&subcontentid=9999999920120824000001&contenttype=6&preview=1&oma=0&chargeuserid=RDUCHS-NB3G-IPS-04142968735206948&subcontentsize=0&mimetype=&filename=cu_iphone.m3u8&mode=3&portalid=15&proxy=0&timestamp=1429687352&life=172700&enkey=219e81e1918ad2b1fa4c22abb85675d7");
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
