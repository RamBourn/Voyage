package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.WarController;
import model.War;

public class WarView extends JFrame{
private War w;
private WarController wc;
private JLabel attack;
private JLabel defend;
private JTextField []cPay;
private JButton ok;
private JLabel []ends;
private JRadioButton []atackAssist;
private JRadioButton []defendAssist;

public WarView(War w){
	this.w=w;
	wc=new WarController(w, this);
	JPanel warCountry=new JPanel();
	warCountry.setLayout(new FlowLayout());
	ImageIcon[] image=new ImageIcon[4];
	for(int j=0;j<4;j++){
		image[j]=new ImageIcon("src/source/picture/"+(j+1)+".jpg");
	}	
	attack=new JLabel(image[w.getAttack()]);
	defend=new JLabel(image[w.getDefend()]);
	attack.setPreferredSize(new Dimension(300, 250));
	defend.setPreferredSize(new Dimension(300,250));
	warCountry.add(attack);
	JLabel X=new JLabel("X");
	warCountry.add(X);
	warCountry.add(defend);
	warCountry.setPreferredSize(new Dimension(800,250));
	
	JPanel spend=new JPanel();
	spend.setLayout(new GridLayout(5,4));
	JLabel []coun=new JLabel[4];
	atackAssist=new JRadioButton[4];
	defendAssist=new JRadioButton[4];
	cPay=new JTextField[4];
	for(int i=0;i<w.getGame().getCountry().length;i++){
		coun[i]=new JLabel(w.getGame().getCountry()[i].getName());
		cPay[i]=new JTextField("0");
		atackAssist[i]=new JRadioButton("攻击方");	
		defendAssist[i]=new JRadioButton("防守方");	
	    spend.add(coun[i]);
	   
	    if(i!=w.getAttack())
	    spend.add(atackAssist[i]);
	    else
	    	spend.add(new JLabel());
	    
	    if(i!=w.getDefend())
	    spend.add(defendAssist[i]);
	    else
	    	spend.add(new JLabel());
	    
	    spend.add(cPay[i]);
	}
	spend.add(new JLabel());
	ok=new JButton("确认");
	ok.addActionListener(wc);
	spend.add(ok);
	spend.setPreferredSize(new Dimension(800,500));
	
	
	JPanel result=new JPanel();
	ends=new JLabel[3];
	for(int i=0;i<3;i++){
		ends[i]=new JLabel("第"+(i+1)+"回合");
		result.add(ends[i]);
	}
	result.setLayout(new GridLayout(3,1));
	result.setPreferredSize(new Dimension(800,300));
	
	
	this.setLayout(new BorderLayout());
	this.add(warCountry,BorderLayout.NORTH);
	this.add(spend,BorderLayout.CENTER);
	this.add(result,BorderLayout.SOUTH);
	this.setBounds(300,100,800,900);
	this.setVisible(true);
	
}
public boolean atOrde(int i){
	return this.defendAssist[i].isSelected();
}
public int getCost(int i) {
	return Integer.parseInt(this.cPay[i].getText());
}
public void end() {
	this.dispose();;// TODO Auto-generated method stub
	this.w.getGame().fresh();
}
public void setends(int j,int i){
	this.ends[j].setText("第"+(j+1)+"回合："+w.getGame().getCountry()[i].getName());
	
}

}
