import java.io.File;

/**
 * 
 * @author ytzys
 * 
 *         查找按顺序编号的文件，缺少哪一个
 */
public class FileCounter {
	public static void main(String[] args) {
		String path = "C:\\Documents and Settings\\Administrator\\桌面\\542161461764";
		File file = new File(path);
		File[] files = file.listFiles();
		int segCount = 333;
		boolean[] result = new boolean[segCount];
		for (File tmp : files) {

			String name = tmp.getName();
			if (name.endsWith("m3u8")) {
				continue;
			}
			result[Integer.parseInt(name.substring(0, name.indexOf(".")))] = true;
		}
		for (int i = 0; i < result.length; i++) {
			if (!result[i]) {
				System.out.println("missing file:" + i + ".flv");
			}
		}
	}
}
