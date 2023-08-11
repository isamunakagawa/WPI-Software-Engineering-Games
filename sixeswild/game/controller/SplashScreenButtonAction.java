package game.controller;

import game.view.GameViewApplication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * 
 */
public class SplashScreenButtonAction implements ActionListener{
	protected GameViewApplication app;
	protected int number;
	
	public SplashScreenButtonAction(GameViewApplication app, int number){
		super();
		this.number = number;
		this.app = app;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new SplashScreenToLevelController(app).switchView(number);
	}
}
