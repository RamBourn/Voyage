package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import model.Country;
import model.Game;

public class ChooseView1 extends JFrame {


private Country c;
private int next;
private JPanel cinfo;
private JPanel sets;
private JPanel show;
private Game g;

private JLabel []s;

private JLabel wht;
private JRadioButton east;
private JRadioButton west;
private JButton ok;
private JButton skip;

private JPanel right;
private int number;
private int count;

/**
 * 派出探险家
 * @param cn
 * @param next1
 * @param g1
 * @param count
 */
public ChooseView1(Country cn,int next1,Game g1,int count){
	this.c=cn;
	this.next=next1;
	this.g=g1;
	c.resetMerchant();
    this.count=count;
	number=0;
	this.setLayout(new BorderLayout());
	 cinfo=new JPanel();
	 show=new JPanel();
	 sets=new JPanel();
	 
	cinfo.setPreferredSize(new Dimension(300,800));
	right=new JPanel();
	right.setPreferredSize(new Dimension(500,800));
	right.setLayout(new BorderLayout(0,0));
	this.add(cinfo,BorderLayout.WEST);
	this.add(right,BorderLayout.EAST);		
	
	this.setcinfo();
	this.setfirst("第一个探险家");
	this.setshow();
	
			
	sets.setPreferredSize(new Dimension(500,300));
	show.setPreferredSize(new Dimension(500,400));
	
	ImageIcon picture1=new ImageIcon("src/source/picture/game.jpg");
	
	this.setVisible(true);
	this.setBounds(300, 100, 1000, 800);
}

	public void setcinfo(){
	cinfo.setLayout(new GridLayout(6,2));
	cinfo.add(new JLabel(c.getName()));
	cinfo.add(new JLabel("金钱:"+String.valueOf(c.getMoney())),new ImageIcon("src/source/picture/start.jpg"));
	cinfo.add(new JLabel("探险家数目："+c.getsNumber()),new ImageIcon("src/source/picture/start.jpg"));
	cinfo.add(new JLabel("探险家花费："+String.valueOf(c.getsCost())));
	cinfo.add(new JLabel("商人数目："+String.valueOf(c.getmNumber())));
	cinfo.add(new JLabel("商人花费"+String.valueOf(c.getmCost())));
	cinfo.add(new JLabel("殖民者数目"+String.valueOf(c.getcNumber())));
	cinfo.add(new JLabel("殖民者花费"+String.valueOf(c.getcCost())));
	cinfo.add(new JLabel("殖民速度："+""+c.getCononySpped()));
    String []p=c.getHasPortNames().split(",");
	JLabel []port=new JLabel[p.length];
	JPanel hasp=new JPanel();
	hasp.setLayout(new GridLayout((p.length+3)/2,2));	
	hasp.add(new JLabel("已发现港口"));
	hasp.add(new JLabel("："));	
	for(int i=0;i<p.length;i++){
		port[i]=new JLabel(p[i]);		
		hasp.add(port[i]);
		
	}
	cinfo.add(new JLabel(""+c.getCononySpped()));
	cinfo.add(new JLabel("正在殖民："+c.getColonyDoingPortName()));
	cinfo.add(new JLabel("已殖民:"+c.getColonyPortName()));
	
	
	
}
	public void setsets(String name){
		wht.setText(name);		
	}
	public void setfirst(String name){
		 wht=new JLabel(name);
		 east=new JRadioButton("东");
		 west=new JRadioButton("西");
		 skip=new JButton("跳过");
		 ok=new JButton("确认");
		 ok.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e){
							String judge=judge();
						 setone(number,judge());					 
						if((++number)<c.getsNumber()){
							setsets("第"+(number+1)+"个探险家:");	
							g.sendSeafarer(judge(), c);
							return;
						}
						else{
						quit();						
						}
					 
			
			 }
			 
		 });
					 
		sets.setLayout(new BorderLayout(0,10));
		wht.setPreferredSize(new Dimension(500,100));
		west.setPreferredSize(new Dimension(200,50));
		east.setPreferredSize(new Dimension(200,50));
		JPanel center=new JPanel();
		center.add(east);
		center.add(west);
		center.setLayout(new FlowLayout());
		center.setPreferredSize(new Dimension(500,50));
		ok.setPreferredSize(new Dimension(500,30));
		sets.add(wht,BorderLayout.NORTH);								
		sets.add(center,BorderLayout.CENTER);	
		sets.add(ok,BorderLayout.SOUTH);
		right.add(sets,BorderLayout.NORTH);
		
	}
	
	public String judge(){
		String judge="无";
		if(east.isSelected())
		  judge="东";
		if(west.isSelected())
			judge="西";
		return judge;
	}
	
	public void setshow(){
		show.setLayout(new GridLayout(c.getsNumber(),1));
		s=new JLabel[c.getsNumber()];	
		for(int i=0;i<c.getsNumber();i++){
			s[i]=new JLabel("第"+(i+1)+"个探险家:");				
			show.add(s[i]);
		}
		
		
		right.add(show,BorderLayout.SOUTH);
		
	}
	public void setone(int j,String name){
	
			s[j].setText("第"+(j+1)+"个探险家:"+name);				
		
	}
    public void quit(){
    	  count++;
    	  next++;
    	if(next>=4)    		
    			next=0;
    	if(count<4)   		
    	new ChooseView1(g.getCountry()[next],next, g,count);
    	else{
    		this.g.fresh();
    		
    		new ChooseView2(g.getCountry()[0],0, g,0);
        	
    	}
    			this.dispose();    	
    }


	
}

