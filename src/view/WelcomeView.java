package view;


import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Game;

public class WelcomeView implements MouseListener{
	JFrame welcome;
	Container content;
	JLabel background;
	ImageIcon picture;
	JButton start;
	Game g;
	public WelcomeView(Game g0) {
		this.g=g0;
		welcome=new JFrame("欢迎来到航海时代");
		picture=new ImageIcon("src/source/picture/start.jpg");
		background=new JLabel(picture);
		content=welcome.getContentPane();
		content.add(background);
		welcome.setBounds(400,100,picture.getIconWidth(), picture.getIconHeight());
		welcome.setVisible(true);
		welcome.addMouseListener(this);
	
	}
	public void mouseClicked(MouseEvent e) {
		if(e.getX()>363&&e.getX()<782&&e.getY()>641&&e.getY()<721) {
			new GameView(g);
			welcome.dispose();
		}

	}
	public void mouseEntered(MouseEvent e) {
		
	}
	public void mouseExited(MouseEvent e) {
		
	}
	public void mousePressed(MouseEvent e) {
		
	}
	public void mouseReleased(MouseEvent e) {
		
	}
	

}
