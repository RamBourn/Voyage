package view;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import model.Country;

public class Ends extends JFrame{
	/**
	 * ʤ��
	 * @param c
	 */
public Ends(Country c){
	super("Victory");
	this.add(new JLabel("��ʤ�ߣ�"+c.getName()));
	this.setBounds(500, 200, 300, 200);
	this.setVisible(true);
}
}
