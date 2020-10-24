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

//开战消耗
public void openFireCost(int attack){
	g.getCountry()[attack].changeMoney((int)(0.1*g.getCountry()[attack].getMoney()));	
}
//战后赔偿
public void win(){
	
	if(win>0)
		this.getCompensate( true);
	else
		this.getCompensate( false);
	
		
}
//一场战役
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
//获取赔偿
public void getCompensate(boolean w){
	//低烈度
	if(1==mode){
		//获取探险家
		if(1==choose&&true==w&&g.getCountry()[de].getsNumber()>=1){
			g.getCountry()[at].addSeafarer(true);
			g.getCountry()[de].addSeafarer(false);			
		}
		//获取商人
		if(2==choose&&true==w&&g.getCountry()[de].getmNumber()>=1){
			g.getCountry()[at].addMerchant(true);
			g.getCountry()[de].addMerchant(false);			
		}
		//获取殖民者
		if(3==choose&&true==w&&g.getCountry()[de].getcNumber()>=1){
			g.getCountry()[at].addColonist(true);
			g.getCountry()[de].addColonist(false);			
		}
		//获取已知港口
		if(4==choose&&true==w){
			Port []po=g.getCountry()[de].getHasPort();
			for(int i=0;i<po.length;i++){
				if(po[i]!=null)
					g.getCountry()[at].setHasPort(i, po[i]);
			}
		}
			
	}
	else{
		//失败赔偿一半金钱
		int money=g.getCountry()[at].getMoney();
		g.getCountry()[at].changeMoney(-(int)(0.5*money));
		g.getCountry()[de].changeMoney((int)(0.5*money));		
	}
	if(2==mode){
		//获取所有殖民地
		if(1==choose&&true==w){
		    int []colonyPort=g.getCountry()[de].getColonyPort();
		    for(int i=0;i<colonyPort.length;i++){
			   g.getCountry()[at].colonySuccess(i);
			   g.getCountry()[de].loseColonyPort(i);
			   g.getPort()[i].setColonyCountry(g.getCountry()[at]);
		   }
		}
		//获取一半的探险家，商人，殖民者
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
		//失败赔偿90%金钱
		int money=g.getCountry()[at].getMoney();
		g.getCountry()[at].changeMoney(-(int)(0.9*money));
		g.getCountry()[de].changeMoney((int)(0.9*money));		
	}
	
	if(3==mode)
	if(true==w){
		//获取对方所有资源
		
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
		//失败亦然
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
