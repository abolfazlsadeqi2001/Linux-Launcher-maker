package main_page;

import java.awt.Color;
import java.awt.FontFormatException;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import general.Utilities;

public class MainPage extends JFrame {
	private static final long serialVersionUID = 1L;

	private final static String ICON_NAME = "icon.png";
	
	private JTextField txtName = new JTextField();
	private JTextField txtComment = new JTextField();
	private JTextField txtVersion = new JTextField();
	
	private JCheckBox chTerminal = new JCheckBox("");
	
	private JCheckBox chIsApplication = new JCheckBox("");
	private JCheckBox chIsDevelopment = new JCheckBox("Development");
	private JCheckBox chIsUtility = new JCheckBox("Utility");
	private JCheckBox chIsAudioVideo = new JCheckBox("AudioVideo");
	private JCheckBox chIsOffice = new JCheckBox("Office");
	private JCheckBox chIsGraphics = new JCheckBox("Graphics");
	private JCheckBox chIsNetwork = new JCheckBox("Network");
	private JCheckBox chIsSettings = new JCheckBox("Settings");
	private JCheckBox chIsGame = new JCheckBox("Game");
	private JCheckBox chIsEducation = new JCheckBox("Education");
	
	JTextField txtRunnablePath = new JTextField();
	
	JTextField txtImagePath = new JTextField();
	
	JTextField txtPath = new JTextField();
	
	JButton btnGenerate = new JButton("Generate");
	
	private static final String WHO_AM_I_CMD = "whoami";
	private static final String ROOT_USER = "root";
	private static final String SHARE_DESKTOP_FOLDER_ROOT = "/usr/share/applications/";
	private static final String SHARE_DESKTOP_FOLDER_CURRENT_USER = System.getProperty("user.home") + "/.local/share/applications/";
	
	ArrayList<JComponent> components = new ArrayList<JComponent>();
	ArrayList<JCheckBox> categoriesCheckBoxes = new ArrayList<JCheckBox>();
	
	//CONSTRUCTOR FOR PREPARE THE APPLICATION
	public MainPage() {
		//MAKE NAME FIELD
		JPanel panelName = new JPanel();//ADD THEM IN A JPANEL FOR SHOW IN NESSECARY STATE
		panelName.setBounds(0,0,400,37);
		panelName.setLayout(null);
		panelName.setBackground(Color.pink);
		add(panelName);
		
		JLabel lblName = new JLabel("name:");
		components.add(lblName);
		lblName.setBounds(10,7,60,20);
		panelName.add(lblName);
		
		txtName.setBounds(70,3,200,30);
		components.add(txtName);
		panelName.add(txtName);
		
		//MAKE COMMENT FIELD
		JLabel lblComment = new JLabel("comment:");
		components.add(lblComment);
		lblComment.setBounds(10, 45, 70, 20);
		add(lblComment);
		
		txtComment.setBounds(80,40,300,30);
		components.add(txtComment);
		add(txtComment);
		
		//MAKE VERSION FIELD
		JLabel lblVersion = new JLabel("version:");
		components.add(lblVersion);
		lblVersion.setBounds(10, 85, 60, 20);
		add(lblVersion);
		
		txtVersion.setBounds(65, 80, 90, 30);
		components.add(txtVersion);
		add(txtVersion);
		
		//MAKE TERMINAL CHECK BOX FIELD
		JLabel lblTerminal = new JLabel("using in terminal:");
		components.add(lblTerminal);
		lblTerminal.setBounds(10,125,160,20);
		add(lblTerminal);
		
		chTerminal.setBounds(130,125,30,20);
		components.add(chTerminal);
		chTerminal.setSelected(true);
		add(chTerminal);
		
		//MAKE IS IT APPLICATION
		JLabel lblIsApp = new JLabel("is application:");
		components.add(lblIsApp);
		lblIsApp.setBounds(10,150,100,20);
		add(lblIsApp);
		
		chIsApplication.setBounds(110, 150, 20, 20);
		components.add(chIsApplication);
		chIsApplication.setSelected(true);
		add(chIsApplication);
		
		//MAKE CATEGORIES
		JLabel lblCategories = new JLabel("categories:");
		components.add(lblCategories);
		lblCategories.setBounds(10, 180, 100, 20);
		add(lblCategories);
		
		JPanel panelCategories = new JPanel();//ADD THEM IN A JPANEL FOR SHOW IN NESSECARY STATE
		panelCategories.setBounds(0,210,400,70);
		panelCategories.setLayout(new GridLayout(3, 3));
		panelCategories.setBackground(Color.pink);
		add(panelCategories);
		
		//ADD THE CHECK BOXES TO THE ARRAYS AND GRID PANEL
		panelCategories.add(chIsAudioVideo);
		categoriesCheckBoxes.add(chIsAudioVideo);
		components.add(chIsAudioVideo);
		panelCategories.add(chIsDevelopment);
		categoriesCheckBoxes.add(chIsDevelopment);
		components.add(chIsDevelopment);
		panelCategories.add(chIsEducation);
		categoriesCheckBoxes.add(chIsEducation);
		components.add(chIsEducation);
		panelCategories.add(chIsGame);
		categoriesCheckBoxes.add(chIsGame);
		components.add(chIsGame);
		panelCategories.add(chIsGraphics);
		categoriesCheckBoxes.add(chIsGraphics);
		components.add(chIsGraphics);
		panelCategories.add(chIsNetwork);
		categoriesCheckBoxes.add(chIsNetwork);
		components.add(chIsNetwork);
		panelCategories.add(chIsOffice);
		categoriesCheckBoxes.add(chIsOffice);
		components.add(chIsOffice);
		panelCategories.add(chIsSettings);
		categoriesCheckBoxes.add(chIsSettings);
		components.add(chIsSettings);
		panelCategories.add(chIsUtility);
		categoriesCheckBoxes.add(chIsUtility);
		components.add(chIsUtility);
		
		//PATHES
		JPanel panelRunnableAndImage = new JPanel();//ADD THEM IN A PANLE TO SHOW THEM IN NESSECERAY STATE
		panelRunnableAndImage.setBackground(Color.pink);
		panelRunnableAndImage.setBounds(0, 290, 400, 140);
		panelRunnableAndImage.setLayout(null);
		add(panelRunnableAndImage);
		
		//EXECUTABLE FILE FIELD
		JLabel lblRunnablePath = new JLabel("runnable file: ");
		components.add(lblRunnablePath);
		lblRunnablePath.setBounds(10, 0, 110, 20);
		panelRunnableAndImage.add(lblRunnablePath);
		
		txtRunnablePath.setBounds(10,30, 380, 30);
		components.add(txtRunnablePath);
		panelRunnableAndImage.add(txtRunnablePath);
		
		//IAMGE FILE FIELD
		JLabel lblImagePath = new JLabel("image:");
		components.add(lblImagePath);
		lblImagePath.setBounds(10, 65, 70, 20);
		panelRunnableAndImage.add(lblImagePath);
		
		txtImagePath.setBounds(10, 90, 380, 30);
		components.add(txtImagePath);
		panelRunnableAndImage.add(txtImagePath);
		
		//APPLICATION PATH FILED
		JLabel lblPath = new JLabel("directory:");
		components.add(lblPath);
		lblPath.setBounds(10, 440, 140, 20);
		add(lblPath);
		
		txtPath.setBounds(10, 465, 380, 30);
		components.add(txtPath);
		add(txtPath);
		
		//GENERATE BUTTON
		btnGenerate.setBounds(10, 510, 380, 40);
		components.add(btnGenerate);
		btnGenerate.addActionListener((ActionEvent e)->{
			generate();
		});
		add(btnGenerate);
		
		//CHANGE THE CONTENTS FONT
		try {
			Utilities.setFonts(components);
		} catch (FontFormatException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		//CONFIGURE THE FRAME
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(ICON_NAME)));
		
		setLayout(null);
		setResizable(false);
		setSize(400,600);
		setLocationRelativeTo(null);
		setTitle("launcher maker");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//GENERATE THE .DESKTOP FILE
	private void generate() {
		//CHOOSE THE SHARE FOLDER DEPEND ON USER
		String path = null;
		try {
			if(Utilities.runCmd(WHO_AM_I_CMD).trim().equals(ROOT_USER)) {
				path = SHARE_DESKTOP_FOLDER_ROOT;
			}else {
				JOptionPane.showMessageDialog(null, "you aren't root so that for show the launcher \nyou have to restart your computer to see them!");
				path = SHARE_DESKTOP_FOLDER_CURRENT_USER;
			}
		} catch (IOException e) {
			path = SHARE_DESKTOP_FOLDER_CURRENT_USER;
			e.printStackTrace();
		}
		
		//WRITE THE CONTENT OF DESKTOP FILE
		StringBuilder content = new StringBuilder("[Desktop Entry]\n");
		content.append("Name="+txtName.getText()+"\n");
		if(!txtVersion.getText().equals("")) {
			content.append("Comment="+txtComment.getText()+"\n");
		}
		if(!txtVersion.getText().equals("")) {
			content.append("Version="+txtVersion.getText()+"\n");
		}
		content.append("Exec="+txtRunnablePath.getText()+"\n");
		content.append("Icon="+txtImagePath.getText()+"\n");
		if(!txtPath.getText().equals("")) {
			content.append("Path="+txtPath.getText()+"\n");
		}
		content.append("Terminal="+chTerminal.isSelected()+"\n");
		content.append("Type="+((chIsApplication.isSelected())?"Application":"non-Application")+"\n");
		content.append("Categories=");
		for(JCheckBox chb : categoriesCheckBoxes) {
			if(chb.isSelected()) {
				content.append(chb.getText()+";");
			}
		}
		content.append("\n");
		
		//WRITE INTO .DESKTOP FILE
		try {
			String fileName = txtName.getText().toLowerCase().replace(" ", "") + ".desktop";//change the name to lower case and without space
			File destinationFile = new File(path + "/" + fileName);
			FileOutputStream fos = new FileOutputStream(destinationFile);
			fos.write(content.toString().getBytes());
			fos.close();
			JOptionPane.showMessageDialog(null, "generated");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Fail!","fail error",JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
}
