package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import view.ChooseView1;
import view.GameView;
import view.OpenWar;
import view.withdrawView;

public class GameController implements ActionListener{
private GameView gv;
public GameController(GameView gv){
	this.gv=gv;
	
}
@Override
public void actionPerformed(ActionEvent e) {
	JButton jb=(JButton)e.getSource();
	if(jb.getName().equals("openFire")){
	new OpenWar(gv.getGame());
		
	}
if(jb.getName().equals("sail")){
	new ChooseView1(gv.getGame().getCountry()[0], 0, gv.getGame(), 0);		
	}
if(jb.getName().equals("withdraw")){
	new withdrawView(gv.getGame(),-1);
	
}
	
}
}
