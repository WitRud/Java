import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) throws IOException
	{
		FileReader in = null;
		String text = "";
		FileWriter out = null;
		
		try{
			in = new FileReader("input.txt");
			out = new FileWriter("pages.txt");
		
		int c;
		
		while((c = in.read()) != -1){
			text = text+(char)c;
		}
		String pattern = "(www\\..*?\\.\\S+)";
		
		Pattern r = Pattern.compile(pattern);
		
		Matcher m = r.matcher(text);
		int i = 0;
		while(i<text.length()){
			m.find(i);
			i = m.end();
			out.write(m.group());
			out.write(System.lineSeparator());
		}

	}finally {
		if (in != null) {
			in.close();
		}
		if (out != null){
			out.close();
		}

	}

}
}