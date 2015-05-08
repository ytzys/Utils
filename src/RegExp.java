import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp {

	// 正则表达式的使用
	public static void main(String[] args) {
		String line = "1567109	疯狂外星人	http://pcs.baidu.com/rest/2.0/pcs/file?method=streaming&app_id=250528&BDUSS=TU1WkxKQk5FM21wRG5pVC1-N01KZzNHNmFSLXlIN2VPUVl3VUJlMFhWb2kzRTlWQVFBQUFBJCQAAAAAAAAAAAEAAAD3O104eXVydGVlZQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAACJPKFUiTyhVU&type=M3U8_AUTO_480&path=%2Fxp20150429%2F%E7%96%AF-%E7%8B%82WXR-Home%282015%29720p.HDCAM%E6%9E%AA%E7%89%88%E3%80%90345%E5%BD%B1%E8%A7%86www.345ys.com%E3%80%91.mp4";
		Pattern pattern = Pattern.compile("(\\w+)\\s+(.+)\\s+(.+)");
		Matcher matcher = pattern.matcher(line);
		if (!matcher.find() || !matcher.matches() || matcher.groupCount() <= 0) {
		}
		String id = matcher.group(1).trim();
		String name = matcher.group(2).trim();
		String url = matcher.group(3).trim();
		System.out.println("id:" + id + "\n");
		System.out.println("name:" + name + "\n");
		System.out.println("url:" + url + "\n");
	}
}
