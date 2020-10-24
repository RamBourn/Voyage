package model;

import view.WarView;

public class War {
private Game g;
private int win;
private int mode;
int at;
int de;
private int choose;

public War(Game g,int mode,int choose,int at,int de){
	this.g=g;
	this.at=at;
	this.de=de;
	this.choose=choose;
	this.mode=mode;
	this.win=0;
	openFireCost(at);
	new WarView(this);
}

//��ս����
public void openFireCost(int attack){
	g.getCountry()[attack].changeMoney((int)(0.1*g.getCountry()[attack].getMoney()));	
}
//ս���⳥
public void win(){
	
	if(win>0)
		this.getCompensate( true);
	else
		this.getCompensate( false);
	
		
}
//һ��ս��
public int aBattle(int attackPay,int attackAssist,int defendPay,int defendAssist){
	if(1==mode)
		if(attackPay+attackAssist>defendPay*1+defendAssist){
			win++;
			return at;
		}
	if(2==mode)
		if(attackPay+attackAssist>defendPay*1.5+defendAssist){
			win++;
	        return at;
        }
	if(3==mode)
		if(attackPay+attackAssist>defendPay*2+defendAssist){
			win++;
             return at;
        }

		win--; 
		return de;	
}
public void aWarCost(int []cost){
	for(int i=0;i<this.g.getCountry().length;i++)
	this.g.getCountry()[i].changeMoney(-cost[i]);
}
//��ȡ�⳥
public void getCompensate(boolean w){
	//���Ҷ�
	if(1==mode){
		//��ȡ̽�ռ�
		if(1==choose&&true==w&&g.getCountry()[de].getsNumber()>=1){
			g.getCountry()[at].addSeafarer(true);
			g.getCountry()[de].addSeafarer(false);			
		}
		//��ȡ����
		if(2==choose&&true==w&&g.getCountry()[de].getmNumber()>=1){
			g.getCountry()[at].addMerchant(true);
			g.getCountry()[de].addMerchant(false);			
		}
		//��ȡֳ����
		if(3==choose&&true==w&&g.getCountry()[de].getcNumber()>=1){
			g.getCountry()[at].addColonist(true);
			g.getCountry()[de].addColonist(false);			
		}
		//��ȡ��֪�ۿ�
		if(4==choose&&true==w){
			Port []po=g.getCountry()[de].getHasPort();
			for(int i=0;i<po.length;i++){
				if(po[i]!=null)
					g.getCountry()[at].setHasPort(i, po[i]);
			}
		}
			
	}
	else{
		//ʧ���⳥һ���Ǯ
		int money=g.getCountry()[at].getMoney();
		g.getCountry()[at].changeMoney(-(int)(0.5*money));
		g.getCountry()[de].changeMoney((int)(0.5*money));		
	}
	if(2==mode){
		//��ȡ����ֳ���
		if(1==choose&&true==w){
		    int []colonyPort=g.getCountry()[de].getColonyPort();
		    for(int i=0;i<colonyPort.length;i++){
			   g.getCountry()[at].colonySuccess(i);
			   g.getCountry()[de].loseColonyPort(i);
			   g.getPort()[i].setColonyCountry(g.getCountry()[at]);
		   }
		}
		//��ȡһ���̽�ռң����ˣ�ֳ����
		if(2==choose&&true==w){
			if(g.getCountry()[de].getsNumber()>=1){
			     g.getCountry()[at].addSeafarer(true);
			     g.getCountry()[de].addSeafarer(false);			
			}
			if(g.getCountry()[de].getmNumber()>=1){
			     g.getCountry()[at].addMerchant(true);
			     g.getCountry()[de].addMerchant(false);			
			}
			if(g.getCountry()[de].getcNumber()>=1){
			     g.getCountry()[at].addColonist(true);
			     g.getCountry()[de].addColonist(false);			
			}
		}
	}
	else{
		//ʧ���⳥90%��Ǯ
		int money=g.getCountry()[at].getMoney();
		g.getCountry()[at].changeMoney(-(int)(0.9*money));
		g.getCountry()[de].changeMoney((int)(0.9*money));		
	}
	
	if(3==mode)
	if(true==w){
		//��ȡ�Է�������Դ
		
		g.getCountry()[at].changeMoney(g.getCountry()[de].getMoney());
		for(int i=0;i<g.getCountry()[de].getsNumber();i++)
			g.getCountry()[at].addSeafarer(true);
		for(int i=0;i<g.getCountry()[de].getmNumber();i++)
			g.getCountry()[at].addMerchant(true);
		for(int i=0;i<g.getCountry()[de].getcNumber();i++)
			g.getCountry()[at].addColonist(true);
		int []colonyPort=g.getCountry()[de].getColonyPort();
	    for(int i=0;i<colonyPort.length;i++){
		   g.getCountry()[at].colonySuccess(i);
		   g.getCountry()[de].loseColonyPort(i);
		   g.getPort()[i].setColonyCountry(g.getCountry()[at]);		   
           }
	    
	}
	else{
		//ʧ����Ȼ
		int temp=this.at;
		this.at=this.de;
		this.de=this.at;
	    	this.getCompensate(true);
    }
	
}
public Game getGame(){
	return this.g;
}
public int getAttack(){
	return at;
}
public int getDefend(){
	return de;
}
}
