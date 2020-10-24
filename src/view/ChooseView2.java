package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
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
/**
 * �ɳ�����ֳ���ߣ���������̽�ռһع�֮��
 * @author hp
 *
 */
public class ChooseView2 extends JFrame {

	private Country c;
	private int next;
	private JPanel cinfo;
	private JPanel sets;
	private JPanel show;
	private Game g;

	private JLabel []m;
	private JLabel []c1;
	private JLabel wht;
	private JRadioButton []p;
	private JButton ok;
	private JPanel right;
	private int mode;
	private int number;
	private int count;
	public ChooseView2(Country cn,int next1,Game g1,int count){
		this.c=cn;
		this.next=next1;
		this.g=g1;
		c.resetMerchant();
		mode=1;
		number=0;
		this.count=count;
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
		this.setfirst("��һ������");
		this.setshow();
		
				
		sets.setPreferredSize(new Dimension(500,380));
		show.setPreferredSize(new Dimension(500,400));
		
		
		this.setVisible(true);
		this.setBounds(300, 100, 1000, 800);
	}
	
		public void setcinfo(){
			cinfo.setLayout(new GridLayout(6,2));
			cinfo.add(new JLabel(c.getName()));
			cinfo.add(new JLabel("��Ǯ:"+String.valueOf(c.getMoney())),new ImageIcon("src/source/picture/start.jpg"));
			cinfo.add(new JLabel("̽�ռ���Ŀ��"+c.getsNumber()),new ImageIcon("src/source/picture/start.jpg"));
			cinfo.add(new JLabel("̽�ռһ��ѣ�"+String.valueOf(c.getsCost())));
			cinfo.add(new JLabel("������Ŀ��"+String.valueOf(c.getmNumber())));
			cinfo.add(new JLabel("���˻���"+String.valueOf(c.getmCost())));
			cinfo.add(new JLabel("ֳ������Ŀ"+String.valueOf(c.getcNumber())));
			cinfo.add(new JLabel("ֳ���߻���"+String.valueOf(c.getcCost())));
			cinfo.add(new JLabel("ֳ���ٶȣ�"+""+c.getCononySpped()));
		    String []p=c.getHasPortNames().split(",");
			JLabel []port=new JLabel[p.length];
			JPanel hasp=new JPanel();
			hasp.setLayout(new GridLayout((p.length+3)/2,2));	
			hasp.add(new JLabel("�ѷ��ָۿ�"));
			hasp.add(new JLabel("��"));	
			for(int i=0;i<p.length;i++){
				port[i]=new JLabel(p[i]);		
				hasp.add(port[i]);
				
			}
			cinfo.add(new JLabel(""+c.getCononySpped()));
			cinfo.add(new JLabel("����ֳ��"+c.getColonyDoingPortName()));
			cinfo.add(new JLabel("��ֳ��:"+c.getColonyPortName()));
			
			
		}
		public void setsets(String name){
			wht.setText(name);
			
		}
		public void setfirst(String name){
			 wht=new JLabel(name);
			 p=new JRadioButton[6];
			 JPanel choose=new JPanel();
			 for(int i=0;i<6;i++){
				 p[i]=new JRadioButton(g.getPort()[i].getName());
			     choose.add(p[i]);
			 }
			 choose.setLayout(new GridLayout(3,2));
			 ok=new JButton("ȷ��");
			 ok.addActionListener(new ActionListener(){
				 public void actionPerformed(ActionEvent e){					
				int judge=judge();
				 if(judge!=-1)				 
			       setone(mode,number,g.getPort()[judge].getName());					 					 					 
				   if(1==mode){					 
						 if((++number)<c.getmNumber()){
								setsets("��"+(number+1)+"������");
								g.sendMerchant(c, judge);
						 }
						 else{
								number=0;
								mode++;
								setsets("��"+1+"��ֳ����");
								}
					 }
				   else
					 if(2==mode)
					 {
						 if((++number)<c.getcNumber()){
								setsets("��"+(number)+"��ֳ����");	
								g.sendColonist(c, judge);
						 }
						 else{
								quit();
								}
					 }
				 }				 
				
			 });
			sets.setLayout(new BorderLayout(0,10));
			wht.setPreferredSize(new Dimension(500,50));
			choose.setPreferredSize(new Dimension(500,270));
			ok.setPreferredSize(new Dimension(500,30));
			sets.add(wht,BorderLayout.NORTH);
			sets.add(choose,BorderLayout.CENTER);
			sets.add(ok,BorderLayout.SOUTH);
			right.add(sets,BorderLayout.NORTH);
			
		}
		
		public int judge(){
			int j;
			for( j=0;j<this.g.getPort().length;j++)
				if(p[j].isSelected())
					return j;
		return -1;
		
			
		}
	
		public void setshow(){
			int all=c.getall();
			show.setLayout(new GridLayout(all,2));
			m=new JLabel[c.getmNumber()];
			c1=new JLabel[c.getcNumber()];
			
			for(int i=0;i<c.getmNumber();i++){
				m[i]=new JLabel("��"+(i+1)+"������");
			show.add(m[i]);
		}
			for(int i=0;i<c.getcNumber();i++){
				c1[i]=new JLabel("��"+(i+1)+"��ֳ����");
			show.add(c1[i]);
			}
			
			right.add(show,BorderLayout.SOUTH);
			
		}
		public void setone(int i,int j,String name){
			
			if(1==i){
				m[j].setText("��"+(j+1)+"������"+name);
			}
			if(2==i){
				c1[j].setText("��"+(j+1)+"��ֳ����"+name);
			}
			
		}
        public void quit(){
        	 next++;    	
        	if(next>=4)        		
        		next=0;
        	if(count<4)		
        	new ChooseView2(g.getCountry()[next], next, g,mode); 
        	else
        		g.continuing();
        			this.dispose();
        	
        }
	
	
		
}

