import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class ReadFromFile {
	// 使用Scanner按行读取文件内容
	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(new InputStreamReader(
					new FileInputStream(new File("c:\\baidu.txt")), "UTF-8"));

			String line;
			while (scanner.hasNextLine()) {
				line = scanner.nextLine().trim();
				System.out.println(line + "\n");
			}
			scanner.close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
