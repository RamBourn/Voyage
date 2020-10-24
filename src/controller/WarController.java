package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.War;
import view.WarView;

public class WarController implements ActionListener{
     private War w;
     private WarView v;
     private int count=0;
	public WarController(War w,WarView wv){
		this.w=w;
		this.v=wv;
	}
	public void actionPerformed(ActionEvent e) {
		int len=w.getGame().getCountry().length;
		int []cost=new int[len];
		int attackPay=0;
		int defendPay=0;				
		int attackAssist=0;
		int defendAssist=0;
		for(int i=0;i<len;i++){
			cost[i]=v.getCost(i);
			if(i==w.getAttack()){
				attackPay+=cost[i];
				continue;
			}
			if(i==w.getDefend()){
				defendPay+=cost[i];
				continue;
			}
			if(v.atOrde(i))
				defendAssist+=cost[i];
			else
				attackAssist+=cost[i];
		}
		
		w.aWarCost(cost);
		this.v.setends((count),w.aBattle(attackPay, attackAssist, defendPay, defendAssist));
		count++;
		if(count>=3){
			w.win();
			this.v.end();
		}
	}

}
