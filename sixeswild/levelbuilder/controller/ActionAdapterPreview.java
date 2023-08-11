package levelbuilder.controller;

import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import levelbuilder.view.Application;
import levelbuilder.view.LevelBuilderView;

public class ActionAdapterPreview implements ActionListener{

	protected Application app = null;
	String recovery;
	String modeRecovery;
	
	public ActionAdapterPreview(Application app){
		this.app = app;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 9; i++){
			for (int j = 0; j < 9; j++){
				if(!app.getLevelBuilderView().getLevel().getBoard().getSquare(i, j).getActive()){
					System.out.println("inactive: " + i + " " + j);
				}
			}
		}
		
		for (int i = 0; i < 9; i++){
			for (int j = 0; j < 9; j++){
				boolean active = (boolean) app.getLevelBuilderView().getActiveSquare(i, j).isSelected();
				new SelectUnusableController(app.getLevelBuilderView().getLevel(), app).makeUnusable(i, j, active);
				app.getLevelBuilderView().getLevel().getEdits().removeElementAt(0);
			}
		}
		
		String selection = (String) app.getLevelBuilderView().getComboBox().getSelectedItem();
		new SelectGameTypeController(app.getLevelBuilderView()).selectType(selection);
		ModeController mode = new ModeController (app.getLevelBuilderView().getLevel(), app);
		mode.updateMode(selection, modeRecovery);
		app.getLevelBuilderView().getLevel().getEdits().removeElementAt(0);
		
		for (int r = 0; r < 9; r++){
			if (app.getLevelBuilderView().getLevel().getMode().isRelease()){
				boolean active = (boolean) app.getLevelBuilderView().getBucketColumn(r).isSelected();
				new BucketController(app.getLevelBuilderView().getLevel(), app.getLevelBuilderView()).updateBucket(r, active);
				app.getLevelBuilderView().getLevel().getEdits().removeElementAt(0);
			}
			else{
				new BucketController(app.getLevelBuilderView().getLevel(), app.getLevelBuilderView()).updateBucket(r, false);
				app.getLevelBuilderView().getLevel().getEdits().removeElementAt(0);
			}
		}
		
		Integer score = (Integer) Integer.valueOf(app.getLevelBuilderView().gettextField_10().getText());
		Integer score2 = (Integer) Integer.valueOf(app.getLevelBuilderView().gettextField_11().getText());
		Integer score3 = (Integer) Integer.valueOf(app.getLevelBuilderView().gettextField_14().getText());
		int scores[] = new int[3];
		scores[0] = score;
		scores[1] = score2;
		scores[2] = score3;
		
		for (int t = 0; t < 2; t++){
			if (scores[t] > scores[t+1]){
				int holder = scores[t+1];
				scores[t+1] = scores[t];
				scores[t] = holder;
			}
			if ((t != 1) &&scores[t] > scores[t+2]){
				int holder = scores[t+2];
				scores[t+2] = scores[t];
				scores[t] = holder;
			}
		}
		
		new ScoreController(app.getLevelBuilderView().getLevel(), app.getLevelBuilderView()).updateGoalScore(3, scores[2], scores[2]);
		new ScoreController(app.getLevelBuilderView().getLevel(), app.getLevelBuilderView()).updateGoalScore(2, scores[1], scores[1]);
		new ScoreController(app.getLevelBuilderView().getLevel(), app.getLevelBuilderView()).updateGoalScore(1, scores[0], scores[0]);
		app.getLevelBuilderView().gettextField_10().setText("" + scores[0]);
		app.getLevelBuilderView().gettextField_11().setText("" + scores[1]);
		app.getLevelBuilderView().gettextField_14().setText("" + scores[2]);
		app.getLevelBuilderView().getLevel().getEdits().removeElementAt(0);
		app.getLevelBuilderView().getLevel().getEdits().removeElementAt(0);
		app.getLevelBuilderView().getLevel().getEdits().removeElementAt(0);
		
		recovery = app.getLevelBuilderView().gettextField().getText();
		try{
			Integer prob = (Integer) Integer.valueOf(app.getLevelBuilderView().gettextField().getText());
			Integer recover = (Integer) Integer.valueOf(recovery);
			new TileProbabilityController(app.getLevelBuilderView().getLevel(), app.getLevelBuilderView()).updateProbability(1, prob, recover);
			}catch(NumberFormatException s){ //in case user hits two letter keys
				/*textField.setText("0");
				Integer prob = (Integer) Integer.valueOf(textField.getText());
				Integer recover = (Integer) Integer.valueOf(recovery);
				new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(1, prob, recover);
				textField.setText("");*/
				//textField.setText(recovery);
				
				Integer recover;
				Integer prob = (Integer) Integer.valueOf(app.getLevelBuilderView().gettextField().getText());
				if(recovery.equals("")){
					recover = 0;
					new TileProbabilityController(app.getLevelBuilderView().getLevel(), app.getLevelBuilderView()).updateProbability(1, prob, recover);
				}
				else{
					app.getLevelBuilderView().gettextField().setText("0");
					recover = (Integer) Integer.valueOf(recovery);
					new TileProbabilityController(app.getLevelBuilderView().getLevel(), app.getLevelBuilderView()).updateProbability(1, prob, recover);
					app.getLevelBuilderView().gettextField().setText("");
				}
			}
		app.getLevelBuilderView().getLevel().getEdits().removeElementAt(0);
		
		recovery = app.getLevelBuilderView().gettextField_1().getText();
		try{
			Integer prob = (Integer) Integer.valueOf(app.getLevelBuilderView().gettextField_1().getText());
			Integer recover = (Integer) Integer.valueOf(recovery);
			new TileProbabilityController(app.getLevelBuilderView().getLevel(), app.getLevelBuilderView()).updateProbability(2, prob, recover);
			}catch(NumberFormatException s){ //in case user hits two letter keys
				/*textField_1.setText("0");
				Integer prob = (Integer) Integer.valueOf(textField_1.getText());
				Integer recover = (Integer) Integer.valueOf(recovery);
				new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(2, prob, recover);
				textField_1.setText("");*/
				//textField.setText(recovery);
				
				Integer recover;
				Integer prob = (Integer) Integer.valueOf(app.getLevelBuilderView().gettextField_1().getText());
				if(recovery.equals("")){
					recover = 0;
					new TileProbabilityController(app.getLevelBuilderView().getLevel(), app.getLevelBuilderView()).updateProbability(2, prob, recover);
				}
				else{
					app.getLevelBuilderView().gettextField_1().setText("0");
					recover = (Integer) Integer.valueOf(recovery);
					new TileProbabilityController(app.getLevelBuilderView().getLevel(), app.getLevelBuilderView()).updateProbability(2, prob, recover);
					app.getLevelBuilderView().gettextField_1().setText("");
				}
			}
		app.getLevelBuilderView().getLevel().getEdits().removeElementAt(0);
		
		recovery = app.getLevelBuilderView().gettextField_2().getText();
		try{
			Integer prob = (Integer) Integer.valueOf(app.getLevelBuilderView().gettextField_2().getText());
			Integer recover = (Integer) Integer.valueOf(recovery);
			new TileProbabilityController(app.getLevelBuilderView().getLevel(), app.getLevelBuilderView()).updateProbability(3, prob, recover);
			}catch(NumberFormatException s){ //in case user hits two letter keys
				/*textField_2.setText("0");
				Integer prob = (Integer) Integer.valueOf(textField_2.getText());
				Integer recover = (Integer) Integer.valueOf(recovery);
				new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(3, prob, recover);
				textField_2.setText("");*/
				//textField.setText(recovery);
				
				Integer recover;
				Integer prob = (Integer) Integer.valueOf(app.getLevelBuilderView().gettextField_2().getText());
				if(recovery.equals("")){
					recover = 0;
					new TileProbabilityController(app.getLevelBuilderView().getLevel(), app.getLevelBuilderView()).updateProbability(3, prob, recover);
				}
				else{
					app.getLevelBuilderView().gettextField_2().setText("0");
					recover = (Integer) Integer.valueOf(recovery);
					new TileProbabilityController(app.getLevelBuilderView().getLevel(), app.getLevelBuilderView()).updateProbability(3, prob, recover);
					app.getLevelBuilderView().gettextField_2().setText("");
				}
			}
		app.getLevelBuilderView().getLevel().getEdits().removeElementAt(0);
		
		recovery = app.getLevelBuilderView().gettextField_13().getText();
		try{
			Integer prob = (Integer) Integer.valueOf(app.getLevelBuilderView().gettextField_13().getText());
			Integer recover = (Integer) Integer.valueOf(recovery);
			new TileProbabilityController(app.getLevelBuilderView().getLevel(), app.getLevelBuilderView()).updateProbability(4, prob, recover);
			}catch(NumberFormatException s){ //in case user hits two letter keys
				/*textField_13.setText("0");
				Integer prob = (Integer) Integer.valueOf(textField_13.getText());
				Integer recover = (Integer) Integer.valueOf(recovery);
				new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(4, prob, recover);
				textField_13.setText("");*/
				//textField.setText(recovery);
				
				Integer recover;
				Integer prob = (Integer) Integer.valueOf(app.getLevelBuilderView().gettextField_13().getText());
				if(recovery.equals("")){
					recover = 0;
					new TileProbabilityController(app.getLevelBuilderView().getLevel(), app.getLevelBuilderView()).updateProbability(4, prob, recover);
				}
				else{
					app.getLevelBuilderView().gettextField_13().setText("0");
					recover = (Integer) Integer.valueOf(recovery);
					new TileProbabilityController(app.getLevelBuilderView().getLevel(), app.getLevelBuilderView()).updateProbability(4, prob, recover);
					app.getLevelBuilderView().gettextField_13().setText("");
				}
			}
		app.getLevelBuilderView().getLevel().getEdits().removeElementAt(0);
		
		recovery = app.getLevelBuilderView().gettextField_15().getText();
		try{
			Integer prob = (Integer) Integer.valueOf(app.getLevelBuilderView().gettextField_15().getText());
			Integer recover = (Integer) Integer.valueOf(recovery);
			new TileProbabilityController(app.getLevelBuilderView().getLevel(), app.getLevelBuilderView()).updateProbability(5, prob, recover);
			}catch(NumberFormatException s){ //in case user hits two letter keys
				/*textField_15.setText("0");
				Integer prob = (Integer) Integer.valueOf(textField_15.getText());
				Integer recover = (Integer) Integer.valueOf(recovery);
				new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(5, prob, recover);
				textField_15.setText("");*/
				//textField.setText(recovery);
				
				Integer recover;
				Integer prob = (Integer) Integer.valueOf(app.getLevelBuilderView().gettextField_15().getText());
				if(recovery.equals("")){
					recover = 0;
					new TileProbabilityController(app.getLevelBuilderView().getLevel(), app.getLevelBuilderView()).updateProbability(5, prob, recover);
				}
				else{
					app.getLevelBuilderView().gettextField_15().setText("0");
					recover = (Integer) Integer.valueOf(recovery);
					new TileProbabilityController(app.getLevelBuilderView().getLevel(), app.getLevelBuilderView()).updateProbability(5, prob, recover);
					app.getLevelBuilderView().gettextField_15().setText("");
				}
			}
		
		app.getLevelBuilderView().getLevel().getEdits().removeElementAt(0);
		
		recovery = app.getLevelBuilderView().gettextField_16().getText();
		try{
			Integer prob = (Integer) Integer.valueOf(app.getLevelBuilderView().gettextField_16().getText());
			Integer recover = (Integer) Integer.valueOf(recovery);
			new TileProbabilityController(app.getLevelBuilderView().getLevel(), app.getLevelBuilderView()).updateProbability(6, prob, recover);
			}catch(NumberFormatException s){ //in case user hits two letter keys
				/*textField_16.setText("0");
				Integer prob = (Integer) Integer.valueOf(textField_16.getText());
				Integer recover = (Integer) Integer.valueOf(recovery);
				new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(6, prob, recover);
				textField_16.setText("");*/
				//textField.setText(recovery);
				
				Integer recover;
				Integer prob = (Integer) Integer.valueOf(app.getLevelBuilderView().gettextField_16().getText());
				if(recovery.equals("")){
					recover = 0;
					new TileProbabilityController(app.getLevelBuilderView().getLevel(), app.getLevelBuilderView()).updateProbability(6, prob, recover);
				}
				else{
					app.getLevelBuilderView().gettextField_16().setText("0");
					recover = (Integer) Integer.valueOf(recovery);
					new TileProbabilityController(app.getLevelBuilderView().getLevel(), app.getLevelBuilderView()).updateProbability(6, prob, recover);
					app.getLevelBuilderView().gettextField_16().setText("");
				}
			}
		app.getLevelBuilderView().getLevel().getEdits().removeElementAt(0);
		
		new PreviewController(app.getLevelBuilderView().getLevel(), app).previewLevel();
	}

}
