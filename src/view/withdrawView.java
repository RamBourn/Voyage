
package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import controller.OpenWarController;
import model.Game;

public class withdrawView extends JFrame implements MouseListener{

Game g;

JPanel choosePanel=new JPanel();
JPanel show=new JPanel();
JPanel items=new JPanel();

ImageIcon []image=new ImageIcon[4];
JLabel []Country=new JLabel[4];

JLabel choiseLabel=new JLabel();

ImageIcon Im;
JRadioButton []port=new JRadioButton[6];

int country=-1;
public withdrawView(Game g,int m){
	this.g=g;	
	for(int i=0;i<4;i++){
		image[i]=new ImageIcon("src/source/picture/"+(i+1)+".jpg");
		Country[i]=new JLabel(image[i]);	
		Country[i].setPreferredSize(new Dimension(250,150));
		Country[i].setName(i+"");
		Country[i].addMouseListener(this);		
		choosePanel.add(Country[i]);
	}
	choosePanel.setLayout(new GridLayout(2,2));
	choosePanel.setPreferredSize(new Dimension(505,302));

	
	Im=new ImageIcon("src/source/picture/"+(m+1)+".jpg");
	choiseLabel=new JLabel(Im);

	show.add(choiseLabel);	
	show.setLayout(new FlowLayout());
	show.setPreferredSize(new Dimension(505,200));
	
	this.setLayout(new BorderLayout());
	this.add(choosePanel,BorderLayout.NORTH);
	this.add(show,BorderLayout.CENTER);
	if(m>=0){
		this.setPorts(m);
		this.setBounds(500, 110, 600, 900);
	}
	else
	this.setBounds(500, 110, 600, 500);
	this.setVisible(true);
	
}
public void setPorts(int i){
	for(int j=0;j<g.getCountry()[i].getHasPort().length;j++){
		if(g.getCountry()[i].getHasPort()[j]!=null){
		port[j]=new JRadioButton(g.getCountry()[i].getHasPort()[j].getName());
	    port[j].setName(""+j);
		items.add(port[j]);
		}		
	}
	JButton ok=new JButton("х╥хо");
	ok.setName("ok");
	ok.setPreferredSize(new Dimension(200,100));
	items.add(ok);
	this.add(items,BorderLayout.SOUTH);
}
@Override
public void mouseClicked(MouseEvent e) {
	JLabel jb=(JLabel)(e.getSource());
	int i=Integer.parseInt(jb.getName());
	
	new withdrawView(g,i);
	this.dispose();
  
}
@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
public void fresh() {
	// TODO Auto-generated method stub
	
}
public Game getGame(){
	return g;
}
public int getCountry() {
	// TODO Auto-generated method stub
	return this.country;
}
}