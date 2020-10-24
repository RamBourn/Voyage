

package model;

import java.awt.GridLayout;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JPanel;


import view.ChooseView1;
import view.ChooseView2;
import view.Ends;
import view.GameView;
import view.OpenWar;
import view.WarView;
import view.WelcomeView;
import view.withdrawView;


public class Game {
	
private Port[]port;
private Country []coun;
private Random ra;
private Scanner sc;
public Game(){
	coun=new Country[4];
	coun[0]=new Country("英国",30,2,5,3,3,4,25,1);
	coun[1]=new Country("法国",100,1,10,2,5,3,18,1);
	coun[2]=new Country("荷兰",20,2,10,4,5,1,0,1);
	coun[3]=new Country("西班牙",50,2,4,1,5,3,15,2);	
	port=new Port[6];
	port[0]=new Port("几内亚湾",20,5);
	port[1]=new Port("好望角",50,7);
	port[2]=new Port("印度",100,10);
	port[3]=new Port("菲律宾",100,10);
	port[4]=new Port("加利福尼亚",30,6);
	port[5]=new Port("里约热内卢",35,5);	
	ra=new Random();
	sc=new Scanner(System.in);
}
//港口国家贸易消费
public void countryPortPay(){
	for(int i=0;i<coun.length;i++)
	this.countryDailyExpense(i);		
	
	for(int i=0;i<port.length;i++)
		port[i].sendMoney();
}


/**
 * 派出探险家，选择方向，
 * 随路程增加，找到港口概率降低
 * @param judge
 * @param c
 */
public void sendSeafarer(String judge,Country c){
        int i;
		for(i=0;i<coun.length;i++)
			if(c.equals(coun[i]))
				break;
	
		int find=0;
		Port []p=c.getHasPort();
		if(judge.equals("东"))
		{		
			for(int m=0;p[m]!=null&&m<p.length;m++)				
					find++;
				
		}
		else{			
			for(int m=p.length-1;p[m]!=null&&m>=0;m--)
				find++;
		}
		if((ra.nextInt(99)+1)<=(3-find*0.5)*10){
				c.setHasPort(find, port[find]);
				port[find].setFindCountry(i,c);
				}
		c.changeMoney(-c.getsCost());
		
		}
	
	
//派出商人，只可在已发现港口
public void sendMerchant(Country c,int x){
	
			if(x>0&&x<=6&&c.getHasPort()[x]!=null)
			{
				port[x].setTradeCountry(c);
				c.setTradePort(x);
			}
			c.changeMoney(-c.getmCost());
			
		
}
//派出殖民者，只可在已发现港口
public void sendColonist(Country c,int x){
	
		
		if(x>0&&x<=6&&c.getHasPort()[x]!=null)
		{
			port[x-1].setColonyCountry(c);
			c.setColonyDoingPort(x);
		}
		c.changeMoney(-c.getcCost());
	}

//中断殖民
public void breakColony(int i){
	int x=sc.nextInt();
	x--;
	
	if(x>0&&x<coun[i].getHasPort().length-1&&coun[i].getHasPort()[x]!=null){
		coun[i].colonistHome(x);
		port[x].breakColony(i);
	}
	
}
//殖民进程
public void ColonyProcess(){
	for(int i=0;i<6;i++)
	port[i].reduceResist();
		
}
//殖民成功
public void colonyIsSuccess(){
	for(int i=0;i<6;i++)
	port[i].colonyisSuccess();
}
//国家开销
public void countryDailyExpense(int i){
	
		coun[i].dailyExpense();
}

public void resetMchant(){
	for(int i=0;i<port.length;i++)
		port[i].resetcountry();
	for(int i=0;i<coun.length;i++)
	{
		coun[i].resetMerchant();
	}
}

public void moveLoser1(){
	for(int i=0;i<coun.length;i++)
		if(coun[i].getMoney()<0)
			{
			System.out.println(coun[i].getName()+"");
			this.moveLoser2(i);
			break;
			}
}

private void moveLoser2(int i) {
	Country []c=new Country[coun.length-1];
	for(int j=i;j<coun.length-1;j++)// TODO Auto-generated method stub
	coun[j]=coun[j+1];
	for(int j=0;j<coun.length-1;j++)
	c[j]=coun[j];
	coun=c;
}

public boolean end(){
	if(coun.length==1){		
		return true;
	}
		return false;
	
}

public Country[] getCountry(){
	return this.coun;
}
public Port[]getPort(){
	return this.port;
}
public void fresh(){
	new GameView(this);
}
public void continuing() {
	this.countryPortPay();
	this.resetMchant();
	this.ColonyProcess();
	this.colonyIsSuccess();
	this.moveLoser1();
	if(this.end())
		new Ends(this.coun[0]);
	fresh();
}
public static void main(String []args){
	Game g=new Game();
	new WelcomeView(g);
}


}
