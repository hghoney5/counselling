package front;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import javax.swing.*;

import college.AddCollege;
import student.AddStudent;

public class Front extends JFrame implements ActionListener{
	
	private JPanel panel = new JPanel();
	// Get user Screen Resolution
	GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	int screenWidth = gd.getDisplayMode().getWidth();
	int screenHeight = gd.getDisplayMode().getHeight();
	int xScreen = (screenWidth*35)/100;

	JMenuBar menuBar=new JMenuBar();
	JMenu register=new JMenu("Register");
	JMenuItem studentMenuItem =new JMenuItem("Student");
	JMenuItem teacherMenuItem =new JMenuItem("Teacher");
	JMenuItem collegeMenuItem =new JMenuItem("College");
	
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		setJMenuBar(menuBar);
		menuBar.add(register);
		register.add(studentMenuItem);
		register.add(collegeMenuItem);
		register.add(teacherMenuItem);
		// Add Action Listeners
		studentMenuItem.addActionListener(this);
		collegeMenuItem.addActionListener(this);
		teacherMenuItem.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == studentMenuItem)
		{
			AddStudent obj = new AddStudent();
			obj.setVisible(true);
		}
		if(e.getSource() == collegeMenuItem)
		{
			AddCollege obj = new AddCollege();
			obj.setVisible(true);
		}
	}
	
	public static void main(String[] args)
	{
		Front obj = new Front();
	}

}
