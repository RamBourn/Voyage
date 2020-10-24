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

import controller.OpenWarController;
import model.Game;

public class OpenWar extends JFrame implements MouseListener{

Game g;

JPanel choose=new JPanel();
JPanel show=new JPanel();
JPanel items=new JPanel();

ImageIcon []image=new ImageIcon[4];
JLabel []Country=new JLabel[4];

JLabel attack=new JLabel();
JLabel defend=new JLabel();
ImageIcon attackIm;
ImageIcon defendIm;

JComboBox []cho=new JComboBox[3];
JButton []ok=new JButton[3];

int at=0;
int de=0;
int click=0;
OpenWarController opc;
public OpenWar(Game g){
	this.g=g;
	this.opc=new OpenWarController(this);
	for(int i=0;i<4;i++){
		image[i]=new ImageIcon("src/source/picture/"+(i+1)+".jpg");
		Country[i]=new JLabel(image[i]);	
		Country[i].setPreferredSize(new Dimension(250,150));
		Country[i].setName(i+"");
		Country[i].addMouseListener(this);
		
		choose.add(Country[i]);
	}
	choose.setLayout(new GridLayout(2,2));
	choose.setPreferredSize(new Dimension(505,302));
	
	attackIm=new ImageIcon("src/source/picture/"+1+".jpg");
	defendIm=new ImageIcon("src/source/picture/"+2+".jpg");
	attack=new JLabel(attackIm);
	defend=new JLabel(defendIm);
	show.setLayout(new FlowLayout());
	show.add(attack);
	show.add(new JButton("X"));
	show.add(defend);
	show.setPreferredSize(new Dimension(505,200));
	
	JLabel []sort=new JLabel[3];
	JLabel []info=new JLabel[3];
	sort[0]=new JLabel("���Ҷ�");
	sort[1]=new JLabel("���Ҷ�");
	sort[2]=new JLabel("���Ҷ�");
	cho[0]=new JComboBox();
	cho[1]=new JComboBox();
	cho[2]=new JComboBox();
	cho[0].addItem("1��ȡһ��̽�ռ�");
	cho[0].addItem("2��ȡһ������");
	cho[0].addItem("3��ȡһ��ֳ����");
	cho[0].addItem("4��ȡ��ǰ���ҷ��ָۿ�");
   info[0]=new JLabel("ʧ��ɥʧһ���Ǯ");
    
	cho[1].addItem("1��ȡ����ֳ���");
	cho[1].addItem("2��ȡһ��̽�ռң����ˣ�ֳ����");
	info[1]=new JLabel("ʧ��ɥʧ90%��Ǯ");
	 
	cho[2].addItem("1��ȡ�Է�������Դ");
	info[2]=new JLabel("ʧ����������֮��");
	
	items.setLayout(new GridLayout(3,4));
	for(int i=0;i<3;i++){
		items.add(sort[i]);
		items.add(cho[i]);
		items.add(info[i]);
		ok[i]=new JButton("ȷ��");
		ok[i].addActionListener(opc);
		ok[i].setName(""+i);
		items.add(ok[i]);
	}
	items.setPreferredSize(new Dimension(400,200));
    
	

	this.setLayout(new BorderLayout(10,10));
	this.add(choose,BorderLayout.NORTH);
	this.add(show,BorderLayout.CENTER);
	this.add(items,BorderLayout.SOUTH);
	
	
	this.setSize(600, 800);
	this.setVisible(true);
	
}
public int getAttack(){
	return this.at;
}
public int getDefend(){
	return this.de;
}
public boolean isChoose(){
	return true;
}
public int getChoose(int i){
	String s=(String)cho[i].getSelectedItem();
	
	return Integer.parseInt(String.valueOf(s.charAt((0))));
}
public void mouseClicked(MouseEvent e) {
	String s=((JLabel)e.getSource()).getName();
	int i=Integer.parseInt(s);
	if(click==0){			
	    attack.setIcon(image[i]);;
	    attack.setName(""+i);
	    at=i;
	    attack.repaint();
	    click++;
	}
	else
	if(click==1){
		
	   
	    defend.setIcon(image[i]);;
	    defend.setName(""+i);
	    defend.repaint();
	    de=i; 
	    click=0;
	}
	
	
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
public Game getGame() {
	// TODO Auto-generated method stub
	return g;
}
}
