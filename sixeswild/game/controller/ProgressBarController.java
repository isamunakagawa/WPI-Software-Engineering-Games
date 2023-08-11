package game.controller;

import game.entity.Level;
import game.view.LevelView;

/**
 * 
 * 
 */
public class ProgressBarController {
	
	/** The boundary that the controller accesses.*/
	
	/** The level where the controller gets information.*/
	protected Level level;
	protected LevelView levelView;

	/**
	 * ProgressBarController constructor that creates a controller object
	 * that handles updating the progress bar.
	 * @param level
	 * @param bar
	 */
	public ProgressBarController(Level level, LevelView levelView){
		this.level = level;
		this.levelView = levelView;
	}
	
	/**
	 * Entry method for the controller that updates the progress bar
	 * within the boundary classes.
	 */
	public void updateBar(){
		
		/* 1. When a level is loaded, immediately call setMaximum(int maximum) method with goal score 1 as argument
		 * 2. Whenever score is incremented, check to see if the new score is greater than the current goal score
		 * 3. Whenever the score is updated call the setValue(int n) method with the current score as the value
		 * 4. If this is true, then call setMinimum(int minimum) with the current goal score and call setMaximum(int n) with the next goal score
		 * 5. embed the ProgressBar controller inside the score update mechanism. Don't need to touch it after that
		 * 
		 */
		
		int currentGoal = 0;
		for ( int i = 0; i <= 2; i++){
			if ( this.level.getScore() > this.level.getGoalScores()[i] ) {
				currentGoal = this.level.getGoalScores()[i+1];
			}
		}
		

		if ( currentGoal == this.level.getGoalScores()[2] ){
			this.levelView.getProgressBar().setMinimum(this.level.getGoalScores()[1]);
			this.levelView.getProgressBar().setMaximum(currentGoal);
			this.levelView.getProgressBar().setValue(this.level.getScore());
			this.levelView.getGoalScoreLabels()[1].setVisible(true);
			this.levelView.getGoalScoreLabels()[0].setVisible(true);
		}
		else if ( currentGoal == this.level.getGoalScores()[1]){
			this.levelView.getProgressBar().setMinimum(this.level.getGoalScores()[0]);
			this.levelView.getProgressBar().setMaximum(this.level.getGoalScores()[1]);
			this.levelView.getProgressBar().setValue(this.level.getScore());
			this.levelView.getGoalScoreLabels()[0].setVisible(true);
		}
		else {
			this.levelView.getProgressBar().setMinimum(0);
			this.levelView.getProgressBar().setMaximum(this.level.getGoalScores()[0]);
			this.levelView.getProgressBar().setValue(this.level.getScore());
		}
		
		if ( this.level.getScore() >= this.level.getGoalScores()[2] ){
			this.levelView.getGoalScoreLabels()[2].setVisible(true);
			this.levelView.getGoalScoreLabels()[1].setVisible(true);
			this.levelView.getGoalScoreLabels()[0].setVisible(true);
		}
		
	}
}
