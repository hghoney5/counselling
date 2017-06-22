package preferences;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class Preferences extends JFrame  {
	
	private String[] labelsName = {"Preference ID",
			"Student ID",
			"Student Name",
			"Rank"
			};
	
	private JTextField preferenceIdTextField = new JTextField();
	private JComboBox studentIdTextField = new JComboBox();
	private JTextField studentNameTextField = new JTextField();
	private JTextField rankTextField = new JTextField();
	
	private JComboBox[] collegeIdComboBox;
	private JTextField[] collegeNameTextField;
	private JTextField[] tradeTextField;
	private String[] preferenceStrings = {
			"First Preference",
			"Second Preference",
			"Third Preference",
			"Fourth Preference",
			"Fifth Preference"
	};
	
	Panel panel = new Panel();
	private JButton btnSubmit = new JButton("Submit");
	private JButton btnCancel = new JButton("Cancel");
	
	private Font labelsFont = new Font("Arial",Font.BOLD,16);
	
	// Get user Screen Resolution
	GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	int screenWidth = gd.getDisplayMode().getWidth();
	int screenHeight = gd.getDisplayMode().getHeight();
	int xScreen = (screenWidth*35)/100;
	
	
	
	public Preferences() {
		Container c = getContentPane();
		panel.setLayout(null);
		panel.setSize(screenWidth,screenHeight);
		
		ImageIcon icon = new ImageIcon("images//collegeBackgroundBlackOpacity.jpg");
		Image img = icon.getImage();
		BufferedImage bi = new BufferedImage(screenWidth, screenHeight, BufferedImage.TYPE_INT_ARGB);
		Graphics g = bi.createGraphics();
		g.drawImage(img, 0, 0, screenWidth, screenHeight, null);
		ImageIcon newIcon = new ImageIcon(bi);
		
		JLabel backgroundImage = new JLabel();
		backgroundImage.setBounds(0,0,screenWidth,screenHeight);
		backgroundImage.setIcon(newIcon);
		
		c.add(panel);
		
		
		JLabel heading = new JLabel("PREFERENCES");
		heading.setFont(new Font("Arial",Font.BOLD,22));
		heading.setBounds(xScreen+100,10,300,50);
		heading.setForeground(new Color(255,255,255));
		
		
		panel.add(heading);
		
		
		
		
		setSize(screenWidth,screenHeight);
//		setSize(800,600);
		// setting frame in maximized state
//		setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
		setResizable(false);
		
		
		
//		printLabels();
//		setFields();
		setPreferences();
		setButtons();
		panel.add(backgroundImage);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	
	private void printLabels() {
		
		JLabel[] labels = new JLabel[labelsName.length];
		
		int x = xScreen, y=80, width=130, height=35;
		
		for(int i=0; i<labels.length; i++)
		{
			if(i==4)
				y=y+height;
			labels[i] = new JLabel();
			labels[i].setText(labelsName[i]);
			labels[i].setBounds(x,y+(height*i),width,height);
			labels[i].setFont(labelsFont);
			labels[i].setForeground(new Color(255,255,255));
			panel.add(labels[i]);
		}
	}
	
	private void setPreferences() {
		JLabel[] preferenceLabels = new JLabel[5];
		JLabel[] labels = new JLabel[5*3];
		String[] preferenceStrings2 = {"College ID","College Name","Trade"};
		collegeIdComboBox = new JComboBox[5];
		
		int x = xScreen, y=80, width=150, height=35,j=0,fieldHeight=25;
		for(int i=0; i<5; i++)
		{
			preferenceLabels[i] = new JLabel();
			preferenceLabels[i].setText(preferenceStrings[i]);
			preferenceLabels[i].setBounds(x,y+(2*height*i),width,height);
			preferenceLabels[i].setFont(labelsFont);
			preferenceLabels[i].setForeground(Color.WHITE);
			panel.add(preferenceLabels[i]);
			
			collegeIdComboBox[i] = new JComboBox();
			collegeIdComboBox[i].setBounds(x+350,y+(2*height*i),width,fieldHeight);
			panel.add(collegeIdComboBox[i]);
//			labels[i] = new JLabel("College ID");
//			labels[i].setBounds(x+200,y+(2*height*i),width,height);
//			labels[i].setFont(labelsFont);
//			labels[i].setForeground(Color.WHITE);
//			panel.add(labels[i]);
			for(int m=0; m<3; m++)
			{
				labels[j] = new JLabel(preferenceStrings2[m]);
				labels[j].setBounds(x+200,y+(height*j),width,height);
				if(m==2)
					labels[j].setBounds(x+550,y+(2*height*i)+height,width,height);
				labels[j].setFont(labelsFont);
				labels[j].setForeground(Color.WHITE);
				panel.add(labels[j]);
				j++;
			}
			
		}
		
	}
	
	/*private void setFields() {
		typeButtonGroup.add(govtRadioButton);
		typeButtonGroup.add(privateRadioButton);
		int x=xScreen+200,y=85,width=170,height=25,spacing=35;
		preferenceIdTextField.setBounds(x,y,width,height);
		collegeNameTextField.setBounds(x,y+(spacing),width,height);
		locationTextField.setBounds(x,y+(2*spacing),width,height);
		addressTextArea.setBounds(x,y+(3*spacing),width,height+25);
		govtRadioButton.setBounds(x,y+(5*spacing),width-80,height);
		privateRadioButton.setBounds(x+100,y+(5*spacing),width-80,height);
		contactTextField.setBounds(x,y+(6*spacing),width,height);
		tradeTextField.setBounds(x,y+(7*spacing),width,height);
		noOfSeatsTextField.setBounds(x,y+(8*spacing),width,height);
		panel.add(collegeIdTextField);
		panel.add(collegeNameTextField);
		panel.add(locationTextField);
		panel.add(addressTextArea);
		panel.add(govtRadioButton);
		panel.add(privateRadioButton);
		panel.add(contactTextField);
		panel.add(tradeTextField);
		panel.add(noOfSeatsTextField);
		
		govtRadioButton.setOpaque(false);
		govtRadioButton.setForeground(Color.WHITE);
		privateRadioButton.setForeground(Color.WHITE);
		privateRadioButton.setOpaque(false);
	}*/
	
	private void setButtons() {
		btnSubmit.setBounds(xScreen+120, 450, 100, 30);
		panel.add(btnSubmit);
		btnCancel.setBounds(xScreen+250, 450,100,30);
		panel.add(btnCancel);
	}
	
	
	
	public static void main(String[] args)
	{
		Preferences obj = new Preferences();
		obj.setVisible(true);
	}

}

