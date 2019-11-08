package ir.main.linux_launcher_maker;

import javax.swing.UIManager;

import general.Utilities;
import main_page.MainPage;

public class App {
	public static void main(String[] args) {
		try {
			//SETUP THE FONT FOR UTILITIES INTO CUNSTRUCTOR
			new Utilities();
			// SETUP THE THEME FOR EACH OPERATING SYSTEM
			String osName = System.getProperty("os.name");
			if (osName.contains("nux")) {// IF IT IS MAC-OS OR LINUX OR UNIX
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
			} else {// IF IT IS A WINDOWS
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// LAUNCH THE MAIN PAGE
		new MainPage();
	}
}
