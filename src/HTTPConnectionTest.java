import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author ytzys
 * 
 *         ≤‚ ‘url «∑Òø…”√
 * 
 */

public class HTTPConnectionTest {
	public static void main(String[] args) {
		new DownloadThread("1").start();
		// new DownloadThread("2").start();
	}
}

class DownloadThread extends Thread {
	private String index;

	public DownloadThread(String index) {
		this.index = index;
	}

	@Override
	public void run() {
		try {
			SimpleDateFormat format = new SimpleDateFormat(
					"yyyy-MM-dd, HH:mm:ss");
			long startTime = System.currentTimeMillis();
			while (true) {
				String httpUrl = "http://video.cdn.baidupcs.com/video/videotrannb/cb5ac7a7d5b6f9dffaf5f38667206c951074?to=vcb&range=0-14099&xcode=070f508ffb58553b83f21cedeb69d7ac6ff38904bfcecad80b2977702d3e6764&fid=96642a12612a9d0ad0ac15593c8ab78e-993835394&len=14100&time=1429013635&r=418240815&sign=BOUTHNF-F3530edecde9cd71b79378b290804a96-P0dlakQA1jGCGQKdVpKWZhNjIqg%253D&sta_dx=1824&sta_cs=273&app_id=250528&logid=4178240224&region=ningbo";
				URL url = new URL(httpUrl);
				HttpURLConnection conn = (HttpURLConnection) url
						.openConnection();
				// conn.setReadTimeout(5000);
				// conn.setConnectTimeout(5000);
				// conn.setInstanceFollowRedirects(true);
				// conn.setRequestProperty("Charset", "UTF-8");
				// conn.setRequestProperty("User-Agent",
				// "AppleCoreMedia/1.0.0.9B206 (iPad; U; CPU OS 5_1_1 like Mac OS X; zh_cn)");
				int status = conn.getResponseCode();
				String curTime = format.format(new Date());
				System.out.println("curTime:" + curTime + " status: " + status);
				if (status != 200) {
					long timeCost = System.currentTimeMillis() - startTime;
					System.out.println("total costed time:" + timeCost);
					break;
				}
				sleep(10000);
			}
			// InputStream is;
			// int readBytes;
			// byte[] buffer = new byte[1024];
			// if (status == 200) {
			// is = conn.getInputStream();
			// BufferedInputStream bis = new BufferedInputStream(is);
			// String file = "c:\\HTTPtest\\" + index + ".flv";
			// RandomAccessFile accessFile = new RandomAccessFile(file, "rwd");
			// while (true) {
			// readBytes = bis.read(buffer, 0, 1024);
			// if (readBytes < 0) {
			// break;
			// }
			// accessFile.write(buffer, 0, readBytes);
			// }
			// } else {
			// System.out.println("thread " + index + ", status:" + status);
			// }

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
