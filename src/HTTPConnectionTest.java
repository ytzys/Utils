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
				String httpUrl = "http://video.cdn.baidupcs.com/video/netdisk-videotran-ningbo/e43d7f01d5ce3420537019e5c4da4fb8_1074_1_ts?to=vcb&range=1021592-1716815&xcode=46c8358ff1068ed4b0c4cb08d6c262dd1ac7c8e46c2b77000b2977702d3e6764&fid=cb5825aad2a81b02a391f7992f186c55-3040860618&ouk=3040860618&len=695224&time=1436521556&r=303224952&sign=BOUTHNF-F3530edecde9cd71b79378b290804a96-%252FFY1f%252BsJfnAGWnMkzhtD8oJl4Q0%253D&sta_dx=1911&sta_cs=18905&app_id=250528&logid=869146140&region=ningbo";
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
				System.out.println("currentTimeMillis:"
						+ System.currentTimeMillis());
				System.out.println("curTime:" + curTime + " status: " + status);
				// if (status != 200) {
				// long timeCost = System.currentTimeMillis() - startTime;
				// System.out.println("total costed time:" + timeCost);
				// break;
				// }
				sleep(2000);
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
