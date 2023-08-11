package levelbuilder.controller;

import levelbuilder.entities.Level;
import levelbuilder.view.LevelBuilderView;

public class ScoreController extends EditController{
	Level level;
	LevelBuilderView builder;
	
	int starNum;
	int score;
	int prevScore;
	
	public ScoreController(Level level, LevelBuilderView builder){
		this.level = level;
		this.builder = builder;
	}
	
	public void updateScore(int points){
		level.increaseScore(points);
	}
	
	/*public void actionPerformed(ActionEvent e){
		JTextField tf1 = builder.getGoalScore1();
		JTextField tf2 = builder.getGoalScore2();
		JTextField tf3 = builder.getGoalScore3();
		
		int oneStar = Integer.valueOf(tf1.getText());
		int twoStar = Integer.valueOf(tf2.getText());
		int threeStar = Integer.valueOf(tf3.getText());
		
		level.setGoalScores(oneStar, twoStar, threeStar);
	}*/
	
	public void updateGoalScore(int starNum, int score, int recover){
		level.setGoalScore(starNum, score);
		this.starNum = starNum;
		this.score = score;
		this.prevScore = recover;
		this.level.addEdit(this);
		this.level.getUndoneEdits().clear();
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		level.setGoalScore(starNum, prevScore);
		EditController add = this.level.getMostRecentEdit();
		this.level.addUndo(add);
		this.level.getEdits().removeElementAt(0);
		String undo = (String) String.valueOf(prevScore);
		//this.builder.gettextField_9().setText(undo);
		if (starNum == 1){
			this.builder.gettextField_10().setText(undo);
		}
		else if (starNum == 2){
			this.builder.gettextField_11().setText(undo);
		}
		else {
			this.builder.gettextField_14().setText(undo);
		}
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		level.setGoalScore(starNum, score);
		EditController add = this.level.getMostRecentUndo();
		this.level.addEdit(add);
		this.level.getUndoneEdits().removeElementAt(0);
		String redo = (String) String.valueOf(score);
		//this.builder.gettextField_9().setText(undo);
		if (starNum == 1){
			this.builder.gettextField_10().setText(redo);
		}
		else if (starNum == 2){
			this.builder.gettextField_11().setText(redo);
		}
		else {
			this.builder.gettextField_14().setText(redo);
		}
	}
}
