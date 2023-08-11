package levelbuilder.controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import levelbuilder.view.Application;

public class TextFieldAdapter implements KeyListener{

	protected Application app = null;
	protected JTextField text;
	String recovery;
	int properProb;
	
	public TextFieldAdapter(Application app, JTextField text, int properProb){
		super();
		
		this.app = app;
		this.text = text;
		this.properProb = properProb;
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
		
		recovery = TextFieldAdapter.this.text.getText();
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
			if(TextFieldAdapter.this.text.getText().compareTo(recovery) != 0){
				TextFieldAdapter.this.text.setText(recovery);
			}
		}
		setProb();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		/*try{
		Integer prob = (Integer) Integer.valueOf(TextFieldAdapter.this.text.getText());
		new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(1, prob);
		}catch(NumberFormatException s){
			TextFieldAdapter.this.text.setText("0");
			Integer prob = (Integer) Integer.valueOf(TextFieldAdapter.this.text.getText());
			new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(1, prob);
			TextFieldAdapter.this.text.setText("");
		}*/
	}
	public void setProb(){
		try{
			Integer prob = (Integer) Integer.valueOf(TextFieldAdapter.this.text.getText());
			Integer recover = (Integer) Integer.valueOf(recovery);
			new TileProbabilityController(TextFieldAdapter.this.app.getLevelBuilderView().getLevel(), TextFieldAdapter.this.app.getLevelBuilderView()).updateProbability(properProb, prob, recover);
			}catch(NumberFormatException s){ //in case user hits two letter keys
				/*TextFieldAdapter.this.text.setText("0");
				Integer prob = (Integer) Integer.valueOf(TextFieldAdapter.this.text.getText());
				Integer recover = (Integer) Integer.valueOf(recovery);
				new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(properProb, prob, recover);
				TextFieldAdapter.this.text.setText("");*/
				//TextFieldAdapter.this.text.setText(recovery);
				
				Integer recover;
				Integer prob = (Integer) Integer.valueOf(TextFieldAdapter.this.text.getText());
				if(recovery.equals("")){
					recover = 0;
					new TileProbabilityController(TextFieldAdapter.this.app.getLevelBuilderView().getLevel(), TextFieldAdapter.this.app.getLevelBuilderView()).updateProbability(properProb, prob, recover);
				}
				else{
					TextFieldAdapter.this.text.setText("0");
					recover = (Integer) Integer.valueOf(recovery);
					new TileProbabilityController(TextFieldAdapter.this.app.getLevelBuilderView().getLevel(), TextFieldAdapter.this.app.getLevelBuilderView()).updateProbability(properProb, prob, recover);
					TextFieldAdapter.this.text.setText("");
				}
			}
	}
	
}
