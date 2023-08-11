package game.controller;

import game.entity.Level;
import game.view.LevelView;

public class ScoreController {
	
	LevelView levelView;
	Level level;
	
	public ScoreController(LevelView levelView, Level level) {
		this.levelView = levelView;
		this.level = level;
	}
	public void update() {
		this.levelView.getScoreLabel().setText(Integer.toString(this.level.getScore()));
	}
}
