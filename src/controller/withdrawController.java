package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import view.withdrawView;

public class withdrawController implements ActionListener{
	withdrawView wv; 

	public withdrawController(withdrawView wv){
		this.wv=wv;
	}
	public void actionPerformed(ActionEvent e) {
		JButton jb=(JButton)(e.getSource());
		
		if(jb.getName().equals("ok"))
			wv.getGame().breakColony(wv.getCountry());
	}

}
