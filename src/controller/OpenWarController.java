package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.War;
import view.OpenWar;
import view.WarView;


public class OpenWarController implements ActionListener{
private OpenWar op;
	
	public OpenWarController(OpenWar op){
		this.op=op;
	}
	public void actionPerformed(ActionEvent e) {
		int choose=Integer.parseInt(((JButton)e.getSource()).getName());
		if(op.isChoose()){
		new War(op.getGame(),choose,op.getChoose(choose)
		,op.getAttack(),op.getDefend());			
		}
	}
	  
}
