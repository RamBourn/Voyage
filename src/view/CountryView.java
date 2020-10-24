package view;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Country;
import model.Game;

public class CountryView extends JPanel{
private Game g;
private JPanel []coun;
public CountryView(){
	this.setLayout(new GridLayout(1,4));
	coun=new JPanel[4];
	coun[0]=new JPanel();
	coun[0].setPreferredSize(new Dimension(400,300));
	
}
}
