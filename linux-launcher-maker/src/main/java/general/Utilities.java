package general;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.swing.JComponent;

public class Utilities {
	//SET FONT FOR JCOMPONENTS
	private static final String FONT_NAME = "HYCoffee_Bold.ttf";
	private static InputStream in = null;
	{in = getClass().getResourceAsStream(FONT_NAME);}//RUN IT FOR EACH CONSTRUCTOR
	
	//SET FONT FOR JCOMPONENTS
	public static void setFonts(ArrayList<JComponent> ls) throws FontFormatException, IOException {
		Font fontCoffe = Font.createFont(Font.TRUETYPE_FONT, in);
		Font font = fontCoffe.deriveFont(14.1f);//RESIZE
		
		for(JComponent cmp : ls) {
			cmp.setFont(font);
		}
	}
	
	//RUN THE COMMAND
	public static String runCmd(String cmdText) throws IOException {
		Runtime cmd = Runtime.getRuntime();
		Process prc = cmd.exec(cmdText);
		
		InputStream in = prc.getInputStream();
		byte[] bytes = new byte[in.available()];
		in.read(bytes);
		StringBuilder result = new StringBuilder("");
		for(byte b : bytes) {
			result.append((char)b);
		}
		
		return result.toString();
	}
}
