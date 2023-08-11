package levelbuilder.controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import levelbuilder.view.Application;

public class TextFieldAdapterScore implements KeyListener{
	
	protected Application app = null;
	protected JTextField text;
	String recovery;
	int properScore;

	public TextFieldAdapterScore(Application app, JTextField text, int properScore){
		super();
		
		this.app = app;
		this.text = text;
		this.properScore = properScore;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		/*// TODO Auto-generated method stub
		for (int z = 96; z <= 105; z++){
			if (e.getKeyCode() == z){
				keyTyped(e);
			}
		}
		
		for (int v = 48; v <= 57; v++){
			if (e.getKeyCode() == v){
				keyTyped(e);
			}
		}*/
		
		recovery = text.getText();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		boolean numFlag = false;
		for (int z = 96; z <= 105; z++){ //num pad
			if (e.getKeyCode() == z){
				numFlag = true;
			}
		}
		
		for (int v = 48; v <= 57; v++){ //number keys
			if (e.getKeyCode() == v){
				numFlag = true;
			}
		}
		
		if(e.getKeyCode() == 8){ //backspace
			numFlag = true;
		}
		else if (e.getKeyCode() == 127){ //delete
			numFlag = true;
		}
				
		if (!numFlag){
			if(text.getText().compareTo(recovery) != 0){
				text.setText(recovery);
			}
		}
		setProb();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		/*try{
		Integer prob = (Integer) Integer.valueOf(textField.getText());
		new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(1, prob);
		}catch(NumberFormatException s){
			textField.setText("0");
			Integer prob = (Integer) Integer.valueOf(textField.getText());
			new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(1, prob);
			textField.setText("");
		}*/
	}
	public void setProb(){
		try{
			Integer score = (Integer) Integer.valueOf(text.getText());
			Integer recover = (Integer) Integer.valueOf(recovery);
			new ScoreController(TextFieldAdapterScore.this.app.getLevelBuilderView().getLevel(), TextFieldAdapterScore.this.app.getLevelBuilderView()).updateGoalScore(properScore, score, recover);
			/*Integer score = (Integer) Integer.valueOf(text.getText());
			Integer score2 = (Integer) Integer.valueOf(textField_11.getText());
			Integer score3 = (Integer) Integer.valueOf(textField_14.getText());
			if(score < score2){
				new ScoreController(LevelBuilderView.this.level, LevelBuilderView.this).updateGoalScore(1, score);
			}
			else if (score > score2){
				new ScoreController(LevelBuilderView.this.level, LevelBuilderView.this).updateGoalScore(2, score);
				new ScoreController(LevelBuilderView.this.level, LevelBuilderView.this).updateGoalScore(1, score2);
				text.setText("" + score2);
				textField_11.setText("" + score);
			}
			else if (score > score3){
				new ScoreController(LevelBuilderView.this.level, LevelBuilderView.this).updateGoalScore(3, score);
				new ScoreController(LevelBuilderView.this.level, LevelBuilderView.this).updateGoalScore(2, score3);
				new ScoreController(LevelBuilderView.this.level, LevelBuilderView.this).updateGoalScore(1, score2);
				text.setText("" + score3);
				textField_11.setText("" + score2);
				textField_14.setText("" + score);
			}*/
			}catch(NumberFormatException s){ //in case user hits two letter keys
				/*text.setText("0");
				Integer score = (Integer) Integer.valueOf(text.getText());
				Integer recover = (Integer) Integer.valueOf(recovery);
				new ScoreController(LevelBuilderView.this.level, LevelBuilderView.this).updateGoalScore(1, score, recover);
				text.setText("");*/
				//textField.setText(recovery);
				
				Integer recover;
				Integer score = (Integer) Integer.valueOf(text.getText());
				if(recovery.equals("")){
					recover = 0;
					new ScoreController(TextFieldAdapterScore.this.app.getLevelBuilderView().getLevel(), TextFieldAdapterScore.this.app.getLevelBuilderView()).updateGoalScore(1, score, recover);
				}
				else{
					text.setText("0");
					recover = (Integer) Integer.valueOf(recovery);
					new ScoreController(TextFieldAdapterScore.this.app.getLevelBuilderView().getLevel(), TextFieldAdapterScore.this.app.getLevelBuilderView()).updateGoalScore(1, score, recover);
					text.setText("");
				}
			}
	}
}
