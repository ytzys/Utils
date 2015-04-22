import java.io.File;

public class FileCounter {
	public static void main(String[] args) {
		String path = "c:/53891530884";
		File file = new File(path);
		File[] files = file.listFiles();
		int segCount = 951;
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
