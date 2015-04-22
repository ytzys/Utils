import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp {

	public static void main(String[] args) {
		String url = "http://www.baidu.com";
		String destDir = "c:/zys";
		try {
			HttpURLConnection conn;
			conn = (HttpURLConnection) new URL(url).openConnection();
			InputStream inputStream = conn.getInputStream();
			FileOutputStream fileOutputStream = new FileOutputStream(destDir
					+ File.separator + "video.key");
			byte[] buffer = new byte[4096];
			while (inputStream.read(buffer) != -1) {
				fileOutputStream.write(buffer);
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
