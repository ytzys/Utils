import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class WriteToFile {

	// 使用BufferedWriter，以追加的方式，向文件里写入
	public static void main(String[] args) {
		try {
			File file = new File("C:/test.txt");
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(file, true)));
			bw.write("begin\n");
			bw.write("end\n");
			bw.flush();
			bw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
