import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp {

	// 正则表达式的使用，及使用Scanner按行读取文件内容
	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(new InputStreamReader(
					new FileInputStream(new File("c:\\baidu.txt")), "UTF-8"));

			String line;
			Pattern pattern = Pattern.compile("(\\w+)\\s+(.+)\\s+(.+)");
			while (scanner.hasNextLine()) {
				line = scanner.nextLine().trim();
				Matcher matcher = pattern.matcher(line);
				if (!matcher.find() || !matcher.matches()
						|| matcher.groupCount() <= 0) {
					continue;
				}
				String id = matcher.group(1).trim();
				String name = matcher.group(2).trim();
				String url = matcher.group(3).trim();
				System.out.println("id:" + id + "\n");
				System.out.println("name:" + name + "\n");
				System.out.println("url:" + url + "\n");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
