package front;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

import college.RegisterCollege;
import data.Data;
import college.AlterCollege;
import college.DeleteCollege;
import preferences.AlterPreferences;
import preferences.DeletePreferences;
import preferences.RegisterPreferences;
import student.RegisterStudent;
import test.AlterTest;
import test.DeleteTest;
import test.RegisterTest;
import student.AlterStudent;
import student.DeleteStudent;
import user.AlterUser;
import user.DeleteUser;
import user.RegisterUser;

public class Front extends JFrame implements ActionListener,WindowListener{
	
	private JPanel panel = new JPanel();
	// Get user Screen Resolution
	GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	int screenWidth = gd.getDisplayMode().getWidth();
	int screenHeight = gd.getDisplayMode().getHeight();
	int xScreen = (screenWidth*35)/100;

	JMenuBar menuBar=new JMenuBar();
	JMenu registerationMenu =new JMenu("Registeration");
	JMenu alterMenu = new JMenu("Alter");
	JMenu deleteMenu = new JMenu("Delete");
	JMenu TransactionMenu = new JMenu("Transection");
	String[] menuItems = {"Preference","User","College","Student","Test"};
	JMenuItem[] registerMenuItems = new JMenuItem[menuItems.length];
	JMenuItem[] alterMenuItems = new JMenuItem[menuItems.length];
	JMenuItem[] deleteMenuItems = new JMenuItem[menuItems.length];
	
	Data db = new Data();
	
	public Front() {
		menus();
		Container c = getContentPane();
		panel.setLayout(null);
		panel.setSize(screenWidth,screenHeight);
		c.add(panel);
		backgroundImage();
		setSize(screenWidth,screenHeight);
		setVisible(true);
		setResizable(false);
		addWindowListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		checkMenuAvalaibility();
	}
	
	private void backgroundImage() {
		ImageIcon icon = new ImageIcon("images//frontCounselling.jpg");
		Image img = icon.getImage();
		BufferedImage bi = new BufferedImage(screenWidth, screenHeight, BufferedImage.TYPE_INT_ARGB);
		Graphics g = bi.createGraphics();
		g.drawImage(img, 0, 0, screenWidth, screenHeight, null);
		ImageIcon newIcon = new ImageIcon(bi);
		
		JLabel backgroundImage = new JLabel();
		backgroundImage.setBounds(0,0,screenWidth,screenHeight);
		backgroundImage.setIcon(newIcon);
		panel.add(backgroundImage);
	}
	
	private void menus() {
		
		menuBar.add(registerationMenu);
//		registerationMenu.add(new JMenuItem("Student"));
		menuBar.add(alterMenu);
		menuBar.add(deleteMenu);
		for (int i=0; i<menuItems.length; i++)
		{
			registerMenuItems[i] = new JMenuItem(menuItems[i]);
			alterMenuItems[i] = new JMenuItem(menuItems[i]);
			deleteMenuItems[i] = new JMenuItem(menuItems[i]);
			
			registerationMenu.add(registerMenuItems[i]);
			alterMenu.add(alterMenuItems[i]);
			deleteMenu.add(deleteMenuItems[i]);
			
			registerMenuItems[i].addActionListener(this);
			alterMenuItems[i].addActionListener(this);
			deleteMenuItems[i].addActionListener(this);
		}
		
		setJMenuBar(menuBar);
		
	}
	
	public void checkMenuAvalaibility()
	{
		// setting menus disable if no data
		int preference = databaseHasData("preferences");
		int user = databaseHasData("user");
		int test = databaseHasData("test");
		int student = databaseHasData("student");
		int college = databaseHasData("college");
		
		if(preference == 0)
		{
			alterMenuItems[0].setEnabled(false);
			deleteMenuItems[0].setEnabled(false);
		} else {
			alterMenuItems[0].setEnabled(true);
			deleteMenuItems[0].setEnabled(true);
		}
		if(user == 0)
		{
			alterMenuItems[1].setEnabled(false);
			deleteMenuItems[1].setEnabled(false);
		} else {
			alterMenuItems[1].setEnabled(true);
			deleteMenuItems[1].setEnabled(true);
		}
		if(test == 0)
		{
			alterMenuItems[4].setEnabled(false);
			deleteMenuItems[4].setEnabled(false);
		} else {
			alterMenuItems[4].setEnabled(true);
			deleteMenuItems[4].setEnabled(true);
		}
		if(student == 0)
		{
			alterMenuItems[3].setEnabled(false);
			deleteMenuItems[3].setEnabled(false);
		} else {
			alterMenuItems[3].setEnabled(true);
			deleteMenuItems[3].setEnabled(true);
		}
		if(college == 0)
		{
			alterMenuItems[2].setEnabled(false);
			deleteMenuItems[2].setEnabled(false);
		} else {
			alterMenuItems[2].setEnabled(true);
			deleteMenuItems[2].setEnabled(true);
		}
	}
	
	public int databaseHasData(String tableName) {
		String sql = "select count(*) from "+tableName;
		ResultSet rs;
		int count=0;
		try{
			rs = db.executeQuery(sql);
			while(rs.next())
			{
//				return rs.getInt(1);
				count=rs.getInt(1);
//				System.out.println(rs.getString(1));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return count;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		
		// REGISTRATION
		if(e.getSource() == registerMenuItems[0])
		{
			RegisterPreferences obj = new RegisterPreferences();
			obj.setVisible(true);
		}
		else if(e.getSource() == registerMenuItems[1])
		{
			RegisterUser obj = new RegisterUser();
			obj.setVisible(true);
		}
		else if(e.getSource() == registerMenuItems[2])
		{
			RegisterCollege obj = new RegisterCollege();
			obj.setVisible(true);
		}
		else if(e.getSource() == registerMenuItems[3])
		{
			RegisterStudent obj = new RegisterStudent();
			obj.setVisible(true);
		}
		else if(e.getSource() == registerMenuItems[4])
		{
			RegisterTest obj = new RegisterTest();
			obj.setVisible(true);
		}
		
		
		// ALTER
		
		if(e.getSource() == alterMenuItems[0])
		{
			AlterPreferences obj = new AlterPreferences();
			obj.setVisible(true);
		}
		else if(e.getSource() == alterMenuItems[1])
		{
			AlterUser obj = new AlterUser();
			obj.setVisible(true);
		}
		else if(e.getSource() == alterMenuItems[2])
		{
			AlterCollege obj = new AlterCollege();
			obj.setVisible(true);
		}
		else if(e.getSource() == alterMenuItems[3])
		{
			AlterStudent obj = new AlterStudent();
			obj.setVisible(true);
		}
		else if(e.getSource() == alterMenuItems[4])
		{
			AlterTest obj = new AlterTest();
			obj.setVisible(true);
		}
		
		// DELETE
		if(e.getSource() == deleteMenuItems[0])
		{
			DeletePreferences obj = new DeletePreferences();
			obj.setVisible(true);
		}
		else if(e.getSource() == deleteMenuItems[1])
		{
			DeleteUser obj = new DeleteUser();
			obj.setVisible(true);
		}
		else if(e.getSource() == deleteMenuItems[2])
		{
			DeleteCollege obj = new DeleteCollege();
			obj.setVisible(true);
		}
		else if(e.getSource() == deleteMenuItems[3])
		{
			DeleteStudent obj = new DeleteStudent();
			obj.setVisible(true);
		}
		else if(e.getSource() == deleteMenuItems[4])
		{
			DeleteTest obj = new DeleteTest();
			obj.setVisible(true);
		}
	}
	
	public static void main(String[] args)
	{
		Front obj = new Front();
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		checkMenuAvalaibility();
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
