package game.controller;

import game.view.GameViewApplication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 */
public class LevelSelectButtonAction implements ActionListener{
	
	protected GameViewApplication app;
	protected int number;
	
	public LevelSelectButtonAction(GameViewApplication app, int number){
		super();
		this.number = number;
		this.app = app;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new LevelSelectToLevelController(app).switchView(number);
	}

}
