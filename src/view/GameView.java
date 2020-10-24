package view;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.io.File;
import java.net.URI;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import controller.GameController;
import model.Game;

public class GameView {
	JFrame game;
	JTextArea []countryInfo=new JTextArea[4];
	JTextArea []portInfo=new JTextArea[6];
	ImageIcon []image=new ImageIcon[4];
	ImageIcon picture;
	JLabel background;
	JLabel []CountryFlag=new JLabel[4];
	JPanel countryPanel,gamePanel;
	JPanel portPanel;
	JPanel []counPanel=new JPanel[4];
	Game g;
	GameController gc;
	public GameView(Game g) {
		this.g=g;
		this.gc=new GameController(this);
		game=new JFrame("����ʱ��");
		picture=new ImageIcon("src/source/picture/game.jpg");
		
		background=new JLabel(picture);
		countryPanel=new JPanel(new GridLayout(2,2));
		//���ù��ң��ۿڷֽ���
		for(int i=0;i<4;i++){
			String a="src/source/picture/"+(i+1)+".jpg";
			image[i]=new ImageIcon(a);
			CountryFlag[i]=new JLabel(image[i]);
			counPanel[i]=new JPanel(new GridLayout(2,1));
			countryInfo[i]=new JTextArea(g.getCountry()[i].getName()+"��ǰ����״̬");
			countryInfo[i].append("\n��Ǯ��"+g.getCountry()[i].getMoney()+"\n�ѷ��ָۿڣ�\n"+g.getCountry()[i].getHasPortNames());
			counPanel[i].add(CountryFlag[i]);
			counPanel[i].add(countryInfo[i]);
			counPanel[i].setPreferredSize(new Dimension(200,125));			
			countryPanel.add(counPanel[i]);
			
		}
		
		portPanel= new JPanel(new GridLayout(1,6));
		
		gamePanel=new JPanel();
		for(int i=0;i<6;i++){
			portInfo[i]=new JTextArea(g.getPort()[i].getName()+"��ǰ����״̬");
			portInfo[i].append("\n"+"��Ǯ\n"+g.getPort()[i].getMoney()+
					"\n�ѷ��ֹ���\n"+g.getPort()[i].getHasCountryNmae()+"\nֳ�����\n"+g.getPort()[i].getColonyCountryNmae());
			portPanel.add(portInfo[i]);
		}
		//��Ϸ��ͼ
		Container gm=game.getContentPane();
		gm.setLayout(new BorderLayout());
		gamePanel.add(background);
		gamePanel.setPreferredSize(new Dimension(picture.getIconWidth(),picture.getIconHeight()));
		
		//����������ӿ�
		
		//ս���ӿ�
		JButton openFire=new JButton("Open Fire");
		openFire.setName("openFire");
		openFire.setIcon(new ImageIcon("src/source/picture/war.jpg"));
		openFire.addActionListener(gc);
		
		countryPanel.setPreferredSize(new Dimension(400,550));
		openFire.setPreferredSize(new Dimension(200,150));
		JPanel west=new JPanel();
		west.setLayout(new BorderLayout());
		west.add(countryPanel,BorderLayout.NORTH);
		west.add(openFire,BorderLayout.SOUTH);
		//������ó����ֳ��
		JButton sail=new JButton("Sail");
		sail.setName("sail");
		sail.addActionListener(gc);
		sail.setBounds(0, 0, 100, 50);
		background.add(sail);
		//����ֳ����
		JButton withdraw=new JButton("withdraw");
		withdraw.setName("withdraw");
		withdraw.addActionListener(gc);
		withdraw.setBounds(1100, 650, 100, 50);
		background.add(withdraw);
		//���������ô�С����	
		portPanel.setPreferredSize(new Dimension(1500,150));
		gm.add(portPanel,BorderLayout.NORTH);
		gm.add(gamePanel,BorderLayout.CENTER);
		gm.add(west,BorderLayout.WEST);
		this.Music();
		game.setBounds(200,80,1600,900);
		game.setVisible(true);
		
	}
	public void Music(){
		 try {      
			              File f = new File("D:\\1.ape"); //����·��
			             URI  uri = f.toURI();
			              URL url = uri.toURL(); //����·��
			               AudioClip aau; 
			               aau = Applet.newAudioClip(url);
			               aau.loop();  //����ѭ��
			           } catch (Exception e) 
			          { 
			              e.printStackTrace();
			          } 

	}
	public Game getGame() {
		// TODO Auto-generated method stub
		return g;
	}

}
class mypanel extends JPanel 
{ 
private ImageIcon imageicon; 
public mypanel() 
{ 
imageicon=new ImageIcon("src/source/picture/port2.gif"); 
} 
public void paintComponent(Graphics g) 
{ 
super.paintComponent(g); 
imageicon.paintIcon(this, g, 0, 0); 
} 
public Dimension getPreferredSize() 
{ 
return new Dimension(imageicon.getIconWidth(),imageicon.getIconHeight()); 
} 
} 
