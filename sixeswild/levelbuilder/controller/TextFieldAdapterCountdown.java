package levelbuilder.controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import levelbuilder.view.Application;

public class TextFieldAdapterCountdown implements KeyListener{

	protected Application app = null;
	protected JTextField text;
	String recovery;

	public TextFieldAdapterCountdown(Application app, JTextField text){
		super();
		
		this.app = app;
		this.text = text;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		for (int z = 96; z <= 105; z++){
			if (e.getKeyCode() == z){
				keyTyped(e);
			}
		}
		
		for (int v = 48; v <= 57; v++){
			if (e.getKeyCode() == v){
				keyTyped(e);
			}
		}
		
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
			Integer count = (Integer) Integer.valueOf(text.getText());
			Integer recover = (Integer) Integer.valueOf(recovery);
			new CountdownController(TextFieldAdapterCountdown.this.app.getLevelBuilderView().getLevel(), TextFieldAdapterCountdown.this.app).updateCountdown(count, recover);
			}catch(NumberFormatException s){ //in case user hits two letter keys
				Integer recover;
				Integer count = (Integer) Integer.valueOf(text.getText());
				if(recovery.equals("")){
					recover = 0;
					new CountdownController(TextFieldAdapterCountdown.this.app.getLevelBuilderView().getLevel(), TextFieldAdapterCountdown.this.app).updateCountdown(count, recover);
				}
				else{
					text.setText("0");
					recover = (Integer) Integer.valueOf(recovery);
					new CountdownController(TextFieldAdapterCountdown.this.app.getLevelBuilderView().getLevel(), TextFieldAdapterCountdown.this.app).updateCountdown(count, recover);
					text.setText("");
				}
				
				//textField.setText(recovery);
			}
	}
}
