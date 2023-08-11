package levelbuilder.view;

import java.awt.Font;

/**
 * 
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

import levelbuilder.controller.*;
import levelbuilder.entities.*;
import levelbuilder.entities.Mode.gameMode;

public class LevelBuilderView extends JPanel {
	
	private JTextField textField;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_14;
	private JLabel lblStar_2;
	private JLabel lblVariable;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_13;
	private JTextField textField_15;
	private JTextField textField_16;
	private Application app;
	
	final JComboBox comboBox = new JComboBox();
	
	private Level level;
	
	private String recovery;
	
	private String modeRecovery;
	
	JToggleButton squareSelect[][] = new JToggleButton[9][9];
	
	private JLabel lblBucketColumns;
	/*private JRadioButton rdbtnNewRadioButton1, rdbtnNewRadioButton2, rdbtnNewRadioButton3,	rdbtnNewRadioButton4,
	rdbtnNewRadioButton5, rdbtnNewRadioButton6, rdbtnNewRadioButton7, rdbtnNewRadioButton8, rdbtnNewRadioButton9;*/
	
	private JRadioButton bucketColumn[] = new JRadioButton[9];
	private JButton btnUndo;
	private JTextField levelNumField;
	
	private boolean modeBoolean = true;

	public LevelBuilderView(Application app, Level level){
		super();
		this.app = app;
		
		this.level = level;
		setLayout(null);
		
		JToggleButton toggleButton = new JToggleButton("");
		toggleButton.setBounds(690, 50, 35, 35);
		this.add(toggleButton);
		
		JLabel lblGameBoard = new JLabel("GAME BOARD");
		lblGameBoard.setFont(new Font("Levenim MT", Font.PLAIN, 30));
		lblGameBoard.setBounds(443, 11, 207, 43);
		this.add(lblGameBoard);
		
		JLabel lblSettings = new JLabel("SETTINGS");
		lblSettings.setFont(new Font("Levenim MT", Font.PLAIN, 30));
		lblSettings.setBounds(90, 11, 127, 43);
		this.add(lblSettings);
		
		JLabel lblProbability = new JLabel("PROBABILITY");
		lblProbability.setFont(new Font("Levenim MT", Font.BOLD, 15));
		lblProbability.setBounds(25, 65, 89, 22);
		this.add(lblProbability);
		
		textField = new JTextField();
		textField.setFont(new Font("Levenim MT", Font.PLAIN, 11));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(25, 118, 28, 22);
		textField.setText("1");
		this.add(textField);
		textField.setColumns(2);
		new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(1, 1, 1);
		/*textField.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Integer prob = (Integer) Integer.valueOf(textField.getText());
				new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(1, prob);
			} 					
		});*/
		textField.addKeyListener(new TextFieldAdapter(this.app, this.gettextField(), 1));
		/*textField.addKeyListener(new KeyListener(){

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
				
				recovery = textField.getText();
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
					if(textField.getText().compareTo(recovery) != 0){
						textField.setText(recovery);
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
				}
			}
			public void setProb(){
				try{
					Integer prob = (Integer) Integer.valueOf(textField.getText());
					Integer recover = (Integer) Integer.valueOf(recovery);
					new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(1, prob, recover);
					}catch(NumberFormatException s){ //in case user hits two letter keys
						/*textField.setText("0");
						Integer prob = (Integer) Integer.valueOf(textField.getText());
						Integer recover = (Integer) Integer.valueOf(recovery);
						new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(1, prob, recover);
						textField.setText("");
						//textField.setText(recovery);
						
						Integer recover;
						Integer prob = (Integer) Integer.valueOf(textField.getText());
						if(recovery.equals("")){
							recover = 0;
							new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(1, prob, recover);
						}
						else{
							textField.setText("0");
							recover = (Integer) Integer.valueOf(recovery);
							new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(1, prob, recover);
							textField.setText("");
						}
					}
			}
			
		});*/
		
		levelNumField = new JTextField();
		levelNumField.setText("1");
		levelNumField.setHorizontalAlignment(SwingConstants.CENTER);
		levelNumField.setFont(new Font("Dialog", Font.PLAIN, 11));
		levelNumField.setColumns(2);
		levelNumField.setBounds(234, 397, 55, 22);
		add(levelNumField);
		
		JLabel label = new JLabel("1");
		label.setFont(new Font("Levenim MT", Font.PLAIN, 25));
		label.setBounds(32, 87, 14, 36);
		this.add(label);
		
		JLabel lblMultiplier = new JLabel("MULTIPLIER");
		lblMultiplier.setFont(new Font("Levenim MT", Font.BOLD, 15));
		lblMultiplier.setBounds(25, 164, 77, 22);
		this.add(lblMultiplier);
		
		JLabel lblX = new JLabel("x1");
		lblX.setFont(new Font("Levenim MT", Font.PLAIN, 25));
		lblX.setBounds(27, 197, 26, 36);
		this.add(lblX);
		
		textField_6 = new JTextField();
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setFont(new Font("Levenim MT", Font.PLAIN, 11));
		textField_6.setColumns(2);
		textField_6.setBounds(25, 230, 28, 22);
		textField_6.setText("1");
		this.add(textField_6);
		new MultiplierProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).setMultProb(1, 1, 1);
		/*textField_6.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Integer prob = (Integer) Integer.valueOf(textField_6.getText());
				new MultiplierProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).setMultProb(1, prob);
			} 					
		});*/
		textField_6.addKeyListener(new TextFieldAdapterMultProb(this.app, this.gettextField_6(), 1));
		/*textField_6.addKeyListener(new KeyListener(){

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
				
				recovery = textField_6.getText();
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
					if(textField_6.getText().compareTo(recovery) != 0){
						textField_6.setText(recovery);
					}
				}
				setProb();
			}

			@Override
			public void keyTyped(KeyEvent e) {
				try{
				Integer prob = (Integer) Integer.valueOf(textField.getText());
				new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(1, prob);
				}catch(NumberFormatException s){
					textField.setText("0");
					Integer prob = (Integer) Integer.valueOf(textField.getText());
					new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(1, prob);
					textField.setText("");
				}
			}
			public void setProb(){
				try{
					Integer prob = (Integer) Integer.valueOf(textField_6.getText());
					Integer recover = (Integer) Integer.valueOf(recovery);
					new MultiplierProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).setMultProb(1, prob, recover);
					}catch(NumberFormatException s){ //in case user hits two letter keys
						/*textField_6.setText("0");
						Integer prob = (Integer) Integer.valueOf(textField_6.getText());
						Integer recover = (Integer) Integer.valueOf(recovery);
						new MultiplierProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).setMultProb(1, prob, recover);
						textField_6.setText("");
						//textField.setText(recovery);
						
						Integer recover;
						Integer prob = (Integer) Integer.valueOf(textField_6.getText());
						if(recovery.equals("")){
							recover = 0;
							new MultiplierProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).setMultProb(1, prob, recover);
						}
						else{
							textField_6.setText("0");
							recover = (Integer) Integer.valueOf(recovery);
							new MultiplierProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).setMultProb(1, prob, recover);
							textField_6.setText("");
						}
					}
			}
			
		});*/
		
		JLabel lblX_1 = new JLabel("x2");
		lblX_1.setFont(new Font("Levenim MT", Font.PLAIN, 25));
		lblX_1.setBounds(76, 197, 26, 36);
		this.add(lblX_1);
		
		textField_7 = new JTextField();
		textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		textField_7.setFont(new Font("Levenim MT", Font.PLAIN, 11));
		textField_7.setColumns(2);
		textField_7.setBounds(76, 230, 28, 22);
		textField_7.setText("1");
		this.add(textField_7);
		new MultiplierProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).setMultProb(2, 1, 1);
		/*textField_7.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Integer prob = (Integer) Integer.valueOf(textField_7.getText());
				new MultiplierProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).setMultProb(2, prob);
			} 					
		});*/
		textField_7.addKeyListener(new TextFieldAdapterMultProb(this.app, this.gettextField_7(), 2));
		/*textField_7.addKeyListener(new KeyListener(){

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
				
				recovery = textField_7.getText();
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
					if(textField_7.getText().compareTo(recovery) != 0){
						textField_7.setText(recovery);
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
				}
			}
			public void setProb(){
				try{
					Integer prob = (Integer) Integer.valueOf(textField_7.getText());
					Integer recover = (Integer) Integer.valueOf(recovery);
					new MultiplierProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).setMultProb(2, prob, recover);
					}catch(NumberFormatException s){ //in case user hits two letter keys
						/*textField_7.setText("0");
						Integer prob = (Integer) Integer.valueOf(textField_7.getText());
						Integer recover = (Integer) Integer.valueOf(recovery);
						new MultiplierProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).setMultProb(2, prob, recover);
						textField_7.setText("");
						//textField.setText(recovery);
						
						Integer recover;
						Integer prob = (Integer) Integer.valueOf(textField_7.getText());
						if(recovery.equals("")){
							recover = 0;
							new MultiplierProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).setMultProb(2, prob, recover);
						}
						else{
							textField_7.setText("0");
							recover = (Integer) Integer.valueOf(recovery);
							new MultiplierProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).setMultProb(2, prob, recover);
							textField_7.setText("");
						}
					}
			}
			
		});*/
		
		JLabel lblX_2 = new JLabel("x3");
		lblX_2.setFont(new Font("Levenim MT", Font.PLAIN, 25));
		lblX_2.setBounds(122, 197, 26, 36);
		this.add(lblX_2);
		
		textField_8 = new JTextField();
		textField_8.setHorizontalAlignment(SwingConstants.CENTER);
		textField_8.setFont(new Font("Levenim MT", Font.PLAIN, 11));
		textField_8.setColumns(2);
		textField_8.setBounds(120, 230, 28, 22);
		textField_8.setText("1");
		this.add(textField_8);
		new MultiplierProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).setMultProb(3, 1, 1);
		/*textField_8.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Integer prob = (Integer) Integer.valueOf(textField_8.getText());
				new MultiplierProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).setMultProb(3, prob);
			} 					
		});*/
		textField_8.addKeyListener(new TextFieldAdapterMultProb(this.app, this.gettextField_8(), 3));
		/*textField_8.addKeyListener(new KeyListener(){

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
				
				recovery = textField_8.getText();
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
					if(textField_8.getText().compareTo(recovery) != 0){
						textField_8.setText(recovery);
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
				}
			}
			public void setProb(){
				try{
					Integer prob = (Integer) Integer.valueOf(textField_8.getText());
					Integer recover = (Integer) Integer.valueOf(recovery);
					new MultiplierProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).setMultProb(3, prob, recover);
					}catch(NumberFormatException s){ //in case user hits two letter keys
						/*textField_8.setText("0");
						Integer prob = (Integer) Integer.valueOf(textField_8.getText());
						Integer recover = (Integer) Integer.valueOf(recovery);
						new MultiplierProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).setMultProb(3, prob, recover);
						textField_8.setText("");
						//textField.setText(recovery);
						
						Integer recover;
						Integer prob = (Integer) Integer.valueOf(textField_8.getText());
						if(recovery.equals("")){
							recover = 0;
							new MultiplierProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).setMultProb(3, prob, recover);
						}
						else{
							textField_8.setText("0");
							recover = (Integer) Integer.valueOf(recovery);
							new MultiplierProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).setMultProb(3, prob, recover);
							textField_8.setText("");
						}
					}
			}
			
		});*/
		
		JLabel lblGameMode = new JLabel("GAME MODE");
		lblGameMode.setFont(new Font("Levenim MT", Font.BOLD, 15));
		lblGameMode.setBounds(25, 279, 97, 22);
		this.add(lblGameMode);
		
		JLabel lblCountdown = new JLabel("COUNTDOWN");
		lblCountdown.setFont(new Font("Levenim MT", Font.BOLD, 15));
		lblCountdown.setBounds(25, 364, 101, 22);
		this.add(lblCountdown);
		
		JLabel lblLevelNum = new JLabel("LEVEL NUMBER");
		lblLevelNum.setFont(new Font("Dialog", Font.BOLD, 15));
		lblLevelNum.setBounds(235, 364, 116, 22);
		add(lblLevelNum);
		
		textField_9 = new JTextField();
		textField_9.setFont(new Font("Levenim MT", Font.PLAIN, 11));
		textField_9.setBounds(25, 397, 116, 22);
		textField_9.setText("1");
		this.add(textField_9);
		textField_9.setColumns(10);
		new CountdownController(LevelBuilderView.this.level, LevelBuilderView.this.app).updateCountdown(1, 1);
		/*textField_9.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Integer count = (Integer) Integer.valueOf(textField_9.getText());
				new CountdownController(LevelBuilderView.this.level, LevelBuilderView.this.app).updateCountdown(count);
			} 					
		});*/
		textField_9.addKeyListener(new TextFieldAdapterCountdown(this.app, this.gettextField_9()));
		/*textField_9.addKeyListener(new KeyListener(){

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
				
				recovery = textField_9.getText();
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
					if(textField_9.getText().compareTo(recovery) != 0){
						textField_9.setText(recovery);
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
				}
			}
			public void setProb(){
				try{
					Integer count = (Integer) Integer.valueOf(textField_9.getText());
					Integer recover = (Integer) Integer.valueOf(recovery);
					new CountdownController(LevelBuilderView.this.level, LevelBuilderView.this.app).updateCountdown(count, recover);
					}catch(NumberFormatException s){ //in case user hits two letter keys
						Integer recover;
						Integer count = (Integer) Integer.valueOf(textField_9.getText());
						if(recovery.equals("")){
							recover = 0;
							new CountdownController(LevelBuilderView.this.level, LevelBuilderView.this.app).updateCountdown(count, recover);
						}
						else{
							textField_9.setText("0");
							recover = (Integer) Integer.valueOf(recovery);
							new CountdownController(LevelBuilderView.this.level, LevelBuilderView.this.app).updateCountdown(count, recover);
							textField_9.setText("");
						}
						
						//textField.setText(recovery);
					}
			}
			
		});*/
		
		JButton btnSave = new JButton("SAVE");
		btnSave.setBounds(25, 428, 89, 23);
		this.add(btnSave);
		btnSave.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				SaveController sc = new SaveController(LevelBuilderView.this.level);
				if(!sc.saveLevel(LevelBuilderView.this.levelNumField.getText() + ".ini"))
					throw new RuntimeException("File could not be saved to this location.");
			}
		});
		
		JButton btnPreview = new JButton("PREVIEW");
		btnPreview.setBounds(118, 428, 99, 23);
		this.add(btnPreview);
		btnPreview.addActionListener(new ActionAdapterPreview(app));
		/*btnPreview.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < 9; i++){
					for (int j = 0; j < 9; j++){
						if(!LevelBuilderView.this.level.getBoard().getSquare(i, j).getActive()){
							System.out.println("inactive: " + i + " " + j);
						}
					}
				}
				
				for (int i = 0; i < 9; i++){
					for (int j = 0; j < 9; j++){
						boolean active = (boolean) LevelBuilderView.this.squareSelect[i][j].isSelected();
						new SelectUnusableController(LevelBuilderView.this.level, LevelBuilderView.this.app).makeUnusable(i, j, active);
						LevelBuilderView.this.level.getEdits().removeElementAt(0);
					}
				}
				
				String selection = (String) comboBox.getSelectedItem();
				new SelectGameTypeController(LevelBuilderView.this).selectType(selection);
				ModeController mode = new ModeController (LevelBuilderView.this.level, LevelBuilderView.this.app);
				mode.updateMode(selection, modeRecovery);
				LevelBuilderView.this.level.getEdits().removeElementAt(0);
				
				for (int r = 0; r < 9; r++){
					if (LevelBuilderView.this.level.getMode().isRelease()){
						boolean active = (boolean) LevelBuilderView.this.bucketColumn[r].isSelected();
						new BucketController(LevelBuilderView.this.level, LevelBuilderView.this).updateBucket(r, active);
						LevelBuilderView.this.level.getEdits().removeElementAt(0);
					}
					else{
						new BucketController(LevelBuilderView.this.level, LevelBuilderView.this).updateBucket(r, false);
						LevelBuilderView.this.level.getEdits().removeElementAt(0);
					}
				}
				
				Integer score = (Integer) Integer.valueOf(textField_10.getText());
				Integer score2 = (Integer) Integer.valueOf(textField_11.getText());
				Integer score3 = (Integer) Integer.valueOf(textField_14.getText());
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
				
				new ScoreController(LevelBuilderView.this.level, LevelBuilderView.this).updateGoalScore(3, scores[2], scores[2]);
				new ScoreController(LevelBuilderView.this.level, LevelBuilderView.this).updateGoalScore(2, scores[1], scores[1]);
				new ScoreController(LevelBuilderView.this.level, LevelBuilderView.this).updateGoalScore(1, scores[0], scores[0]);
				textField_10.setText("" + scores[0]);
				textField_11.setText("" + scores[1]);
				textField_14.setText("" + scores[2]);
				LevelBuilderView.this.level.getEdits().removeElementAt(0);
				LevelBuilderView.this.level.getEdits().removeElementAt(0);
				LevelBuilderView.this.level.getEdits().removeElementAt(0);
				
				recovery = textField.getText();
				try{
					Integer prob = (Integer) Integer.valueOf(textField.getText());
					Integer recover = (Integer) Integer.valueOf(recovery);
					new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(1, prob, recover);
					}catch(NumberFormatException s){ //in case user hits two letter keys
						/*textField.setText("0");
						Integer prob = (Integer) Integer.valueOf(textField.getText());
						Integer recover = (Integer) Integer.valueOf(recovery);
						new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(1, prob, recover);
						textField.setText("");
						//textField.setText(recovery);
						
						Integer recover;
						Integer prob = (Integer) Integer.valueOf(textField.getText());
						if(recovery.equals("")){
							recover = 0;
							new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(1, prob, recover);
						}
						else{
							textField.setText("0");
							recover = (Integer) Integer.valueOf(recovery);
							new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(1, prob, recover);
							textField.setText("");
						}
					}
				LevelBuilderView.this.level.getEdits().removeElementAt(0);
				
				recovery = textField_1.getText();
				try{
					Integer prob = (Integer) Integer.valueOf(textField_1.getText());
					Integer recover = (Integer) Integer.valueOf(recovery);
					new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(2, prob, recover);
					}catch(NumberFormatException s){ //in case user hits two letter keys
						/*textField_1.setText("0");
						Integer prob = (Integer) Integer.valueOf(textField_1.getText());
						Integer recover = (Integer) Integer.valueOf(recovery);
						new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(2, prob, recover);
						textField_1.setText("");
						//textField.setText(recovery);
						
						Integer recover;
						Integer prob = (Integer) Integer.valueOf(textField_1.getText());
						if(recovery.equals("")){
							recover = 0;
							new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(2, prob, recover);
						}
						else{
							textField_1.setText("0");
							recover = (Integer) Integer.valueOf(recovery);
							new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(2, prob, recover);
							textField_1.setText("");
						}
					}
				LevelBuilderView.this.level.getEdits().removeElementAt(0);
				
				recovery = textField_2.getText();
				try{
					Integer prob = (Integer) Integer.valueOf(textField_2.getText());
					Integer recover = (Integer) Integer.valueOf(recovery);
					new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(3, prob, recover);
					}catch(NumberFormatException s){ //in case user hits two letter keys
						/*textField_2.setText("0");
						Integer prob = (Integer) Integer.valueOf(textField_2.getText());
						Integer recover = (Integer) Integer.valueOf(recovery);
						new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(3, prob, recover);
						textField_2.setText("");
						//textField.setText(recovery);
						
						Integer recover;
						Integer prob = (Integer) Integer.valueOf(textField_2.getText());
						if(recovery.equals("")){
							recover = 0;
							new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(3, prob, recover);
						}
						else{
							textField_2.setText("0");
							recover = (Integer) Integer.valueOf(recovery);
							new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(3, prob, recover);
							textField_2.setText("");
						}
					}
				LevelBuilderView.this.level.getEdits().removeElementAt(0);
				
				recovery = textField_13.getText();
				try{
					Integer prob = (Integer) Integer.valueOf(textField_13.getText());
					Integer recover = (Integer) Integer.valueOf(recovery);
					new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(4, prob, recover);
					}catch(NumberFormatException s){ //in case user hits two letter keys
						/*textField_13.setText("0");
						Integer prob = (Integer) Integer.valueOf(textField_13.getText());
						Integer recover = (Integer) Integer.valueOf(recovery);
						new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(4, prob, recover);
						textField_13.setText("");
						//textField.setText(recovery);
						
						Integer recover;
						Integer prob = (Integer) Integer.valueOf(textField_13.getText());
						if(recovery.equals("")){
							recover = 0;
							new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(4, prob, recover);
						}
						else{
							textField_13.setText("0");
							recover = (Integer) Integer.valueOf(recovery);
							new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(4, prob, recover);
							textField_13.setText("");
						}
					}
				LevelBuilderView.this.level.getEdits().removeElementAt(0);
				
				recovery = textField_15.getText();
				try{
					Integer prob = (Integer) Integer.valueOf(textField_15.getText());
					Integer recover = (Integer) Integer.valueOf(recovery);
					new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(5, prob, recover);
					}catch(NumberFormatException s){ //in case user hits two letter keys
						/*textField_15.setText("0");
						Integer prob = (Integer) Integer.valueOf(textField_15.getText());
						Integer recover = (Integer) Integer.valueOf(recovery);
						new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(5, prob, recover);
						textField_15.setText("");
						//textField.setText(recovery);
						
						Integer recover;
						Integer prob = (Integer) Integer.valueOf(textField_15.getText());
						if(recovery.equals("")){
							recover = 0;
							new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(5, prob, recover);
						}
						else{
							textField_15.setText("0");
							recover = (Integer) Integer.valueOf(recovery);
							new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(5, prob, recover);
							textField_15.setText("");
						}
					}
				
				LevelBuilderView.this.level.getEdits().removeElementAt(0);
				
				recovery = textField_16.getText();
				try{
					Integer prob = (Integer) Integer.valueOf(textField_16.getText());
					Integer recover = (Integer) Integer.valueOf(recovery);
					new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(6, prob, recover);
					}catch(NumberFormatException s){ //in case user hits two letter keys
						/*textField_16.setText("0");
						Integer prob = (Integer) Integer.valueOf(textField_16.getText());
						Integer recover = (Integer) Integer.valueOf(recovery);
						new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(6, prob, recover);
						textField_16.setText("");
						//textField.setText(recovery);
						
						Integer recover;
						Integer prob = (Integer) Integer.valueOf(textField_16.getText());
						if(recovery.equals("")){
							recover = 0;
							new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(6, prob, recover);
						}
						else{
							textField_16.setText("0");
							recover = (Integer) Integer.valueOf(recovery);
							new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(6, prob, recover);
							textField_16.setText("");
						}
					}
				LevelBuilderView.this.level.getEdits().removeElementAt(0);
				
				new PreviewController(LevelBuilderView.this.level, LevelBuilderView.this.app).previewLevel();
				/*System.out.println("countdown: " + LevelBuilderView.this.level.getMode().getCountdown());
				System.out.println("mult: " + LevelBuilderView.this.level.getBoard().getTileGen().getValProb(1-1));
				System.out.println("mult: " + LevelBuilderView.this.level.getBoard().getTileGen().getValProb(2-1));
				System.out.println("mult: " + LevelBuilderView.this.level.getBoard().getTileGen().getValProb(3-1));
				System.out.println("mult: " + LevelBuilderView.this.level.getBoard().getTileGen().getValProb(4-1));
				System.out.println("mult: " + LevelBuilderView.this.level.getBoard().getTileGen().getValProb(5-1));
				System.out.println("mult: " + LevelBuilderView.this.level.getBoard().getTileGen().getValProb(6-1));*/
				/*for (int i = 0; i < 9; i++){
					for (int j = 0; j < 9; j++){
						if(!level.getBoard().getSquare(i, j).getActive()){
							System.out.println("inactive: " + i + " " + j);
						}
					}
				}
			} 
				
				
		});*/
		
		/*lblStar_2 = new JLabel("STARTING COLUMNS");
		lblStar_2.setFont(new Font("Levenim MT", Font.BOLD, 13));
		lblStar_2.setBounds(196, 322, 129, 19);
		lblStar_2.setVisible(false);
		this.add(lblStar_2);
				
		textField_12 = new JTextField();
		textField_12.setHorizontalAlignment(SwingConstants.CENTER);
		textField_12.setFont(new Font("Levenim MT", Font.PLAIN, 11));
		textField_12.setColumns(2);
		textField_12.setBounds(196, 352, 129, 22);
		textField_12.setVisible(false);
		this.add(textField_12);*/
		
		lblVariable = new JLabel("moves");
		lblVariable.setFont(new Font("Levenim MT", Font.BOLD, 12));
		lblVariable.setBounds(151, 399, 66, 18);
		this.add(lblVariable);
		
		//final JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Levenim MT", Font.BOLD, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Puzzle", "Lightning", "Release", "Elimination"}));
		comboBox.setBounds(25, 309, 105, 24);
		this.add(comboBox);
		new ModeController (LevelBuilderView.this.level, LevelBuilderView.this.app).updateMode("Puzzle", "Puzzle");
		comboBox.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if (modeBoolean){
					String selection = (String) comboBox.getSelectedItem();
					new SelectGameTypeController(LevelBuilderView.this).selectType(selection);
					ModeController mode = new ModeController (LevelBuilderView.this.level, LevelBuilderView.this.app);
					mode.updateMode(selection, modeRecovery);
					modeRecovery = (String) selection;
				}
			} 
				
				
		});
		//MODE NOT WORKING!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		/*comboBox.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});*/
		
		JLabel lblGoalScores = new JLabel("GOAL SCORES");
		lblGoalScores.setFont(new Font("Levenim MT", Font.BOLD, 15));
		lblGoalScores.setBounds(229, 164, 107, 22);
		this.add(lblGoalScores);
		
		JLabel lblStar = new JLabel("1 STAR");
		lblStar.setFont(new Font("Levenim MT", Font.BOLD, 13));
		lblStar.setBounds(229, 197, 42, 19);
		this.add(lblStar);
		
		textField_10 = new JTextField();
		textField_10.setHorizontalAlignment(SwingConstants.CENTER);
		textField_10.setFont(new Font("Levenim MT", Font.PLAIN, 11));
		textField_10.setColumns(2);
		textField_10.setBounds(281, 197, 55, 22);
		textField_10.setText("1");
		this.add(textField_10);
		new ScoreController(LevelBuilderView.this.level, LevelBuilderView.this).updateGoalScore(1, 1, 1);
		/*textField_10.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Integer score = (Integer) Integer.valueOf(textField_10.getText());
				new ScoreController(LevelBuilderView.this.level, LevelBuilderView.this).updateGoalScore(1, score);
			} 					
		});*/
		textField_10.addKeyListener(new TextFieldAdapterScore(this.app, this.gettextField_10(), 1));
		/*textField_10.addKeyListener(new KeyListener(){

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
				
				recovery = textField_10.getText();
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
					if(textField_10.getText().compareTo(recovery) != 0){
						textField_10.setText(recovery);
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
				}
			}
			public void setProb(){
				try{
					Integer score = (Integer) Integer.valueOf(textField_10.getText());
					Integer recover = (Integer) Integer.valueOf(recovery);
					new ScoreController(LevelBuilderView.this.level, LevelBuilderView.this).updateGoalScore(1, score, recover);
					/*Integer score = (Integer) Integer.valueOf(textField_10.getText());
					Integer score2 = (Integer) Integer.valueOf(textField_11.getText());
					Integer score3 = (Integer) Integer.valueOf(textField_14.getText());
					if(score < score2){
						new ScoreController(LevelBuilderView.this.level, LevelBuilderView.this).updateGoalScore(1, score);
					}
					else if (score > score2){
						new ScoreController(LevelBuilderView.this.level, LevelBuilderView.this).updateGoalScore(2, score);
						new ScoreController(LevelBuilderView.this.level, LevelBuilderView.this).updateGoalScore(1, score2);
						textField_10.setText("" + score2);
						textField_11.setText("" + score);
					}
					else if (score > score3){
						new ScoreController(LevelBuilderView.this.level, LevelBuilderView.this).updateGoalScore(3, score);
						new ScoreController(LevelBuilderView.this.level, LevelBuilderView.this).updateGoalScore(2, score3);
						new ScoreController(LevelBuilderView.this.level, LevelBuilderView.this).updateGoalScore(1, score2);
						textField_10.setText("" + score3);
						textField_11.setText("" + score2);
						textField_14.setText("" + score);
					}
					}catch(NumberFormatException s){ //in case user hits two letter keys
						/*textField_10.setText("0");
						Integer score = (Integer) Integer.valueOf(textField_10.getText());
						Integer recover = (Integer) Integer.valueOf(recovery);
						new ScoreController(LevelBuilderView.this.level, LevelBuilderView.this).updateGoalScore(1, score, recover);
						textField_10.setText("");
						//textField.setText(recovery);
						
						Integer recover;
						Integer score = (Integer) Integer.valueOf(textField_10.getText());
						if(recovery.equals("")){
							recover = 0;
							new ScoreController(LevelBuilderView.this.level, LevelBuilderView.this).updateGoalScore(1, score, recover);
						}
						else{
							textField_10.setText("0");
							recover = (Integer) Integer.valueOf(recovery);
							new ScoreController(LevelBuilderView.this.level, LevelBuilderView.this).updateGoalScore(1, score, recover);
							textField_10.setText("");
						}
					}
			}
			
		});*/
		
		textField_11 = new JTextField();
		textField_11.setHorizontalAlignment(SwingConstants.CENTER);
		textField_11.setFont(new Font("Levenim MT", Font.PLAIN, 11));
		textField_11.setColumns(2);
		textField_11.setBounds(281, 230, 55, 22);
		textField_11.setText("2");
		this.add(textField_11);
		new ScoreController(LevelBuilderView.this.level, LevelBuilderView.this).updateGoalScore(2, 1, 1);
		/*textField_11.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Integer score = (Integer) Integer.valueOf(textField_11.getText());
				new ScoreController(LevelBuilderView.this.level, LevelBuilderView.this).updateGoalScore(2, score);
			} 					
		});*/
		textField_11.addKeyListener(new TextFieldAdapterScore(this.app, this.gettextField_11(), 2));
		/*textField_11.addKeyListener(new KeyListener(){

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
				
				recovery = textField_11.getText();
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
					if(textField_11.getText().compareTo(recovery) != 0){
						textField_11.setText(recovery);
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
				}
			}
			public void setProb(){
				try{
					Integer score = (Integer) Integer.valueOf(textField_11.getText());
					Integer recover = (Integer) Integer.valueOf(recovery);
					new ScoreController(LevelBuilderView.this.level, LevelBuilderView.this).updateGoalScore(2, score, recover);
					}catch(NumberFormatException s){ //in case user hits two letter keys
						/*textField_11.setText("0");
						Integer score = (Integer) Integer.valueOf(textField_11.getText());
						Integer recover = (Integer) Integer.valueOf(recovery);
						new ScoreController(LevelBuilderView.this.level, LevelBuilderView.this).updateGoalScore(2, score, recover);
						textField_11.setText("");
						//textField.setText(recovery);
						
						Integer recover;
						Integer score = (Integer) Integer.valueOf(textField_11.getText());
						if(recovery.equals("")){
							recover = 0;
							new ScoreController(LevelBuilderView.this.level, LevelBuilderView.this).updateGoalScore(2, score, recover);
						}
						else{
							textField_11.setText("0");
							recover = (Integer) Integer.valueOf(recovery);
							new ScoreController(LevelBuilderView.this.level, LevelBuilderView.this).updateGoalScore(2, score, recover);
							textField_11.setText("");
						}
					}
			}
			
		});*/
		
		JLabel lblStar_1 = new JLabel("2 STAR");
		lblStar_1.setFont(new Font("Levenim MT", Font.BOLD, 13));
		lblStar_1.setBounds(229, 231, 42, 19);
		this.add(lblStar_1);
		
		JLabel lblStar_3 = new JLabel("3 STAR");
		lblStar_3.setFont(new Font("Levenim MT", Font.BOLD, 13));
		lblStar_3.setBounds(229, 267, 42, 19);
		this.add(lblStar_3);
		
		textField_14 = new JTextField();
		textField_14.setHorizontalAlignment(SwingConstants.CENTER);
		textField_14.setFont(new Font("Levenim MT", Font.PLAIN, 11));
		textField_14.setColumns(2);
		textField_14.setBounds(281, 263, 55, 22);
		textField_14.setText("3");
		this.add(textField_14);
		new ScoreController(LevelBuilderView.this.level, LevelBuilderView.this).updateGoalScore(3, 1, 1);
		/*textField_14.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Integer score = (Integer) Integer.valueOf(textField_14.getText());
				new ScoreController(LevelBuilderView.this.level, LevelBuilderView.this).updateGoalScore(3, score);
			} 					
		});*/
		textField_14.addKeyListener(new TextFieldAdapterScore(this.app, this.gettextField_14(), 3));
		/*textField_14.addKeyListener(new KeyListener(){

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
				
				recovery = textField_14.getText();
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
					if(textField_14.getText().compareTo(recovery) != 0){
						textField_14.setText(recovery);
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
				}
			}
			public void setProb(){
				try{
					Integer score = (Integer) Integer.valueOf(textField_14.getText());
					Integer recover = (Integer) Integer.valueOf(recovery);
					new ScoreController(LevelBuilderView.this.level, LevelBuilderView.this).updateGoalScore(3, score, recover);
					}catch(NumberFormatException s){ //in case user hits two letter keys
						/*textField_14.setText("0");
						Integer score = (Integer) Integer.valueOf(textField_14.getText());
						Integer recover = (Integer) Integer.valueOf(recovery);
						new ScoreController(LevelBuilderView.this.level, LevelBuilderView.this).updateGoalScore(3, score, recover);
						textField_14.setText("");
						//textField.setText(recovery);
						
						Integer recover;
						Integer score = (Integer) Integer.valueOf(textField_14.getText());
						if(recovery.equals("")){
							recover = 0;
							new ScoreController(LevelBuilderView.this.level, LevelBuilderView.this).updateGoalScore(3, score, recover);
						}
						else{
							textField_14.setText("0");
							recover = (Integer) Integer.valueOf(recovery);
							new ScoreController(LevelBuilderView.this.level, LevelBuilderView.this).updateGoalScore(3, score, recover);
							textField_14.setText("");
						}
					}
			}
			
		});*/
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Levenim MT", Font.PLAIN, 11));
		textField_1.setColumns(2);
		textField_1.setBounds(68, 118, 28, 22);
		textField_1.setText("1");
		add(textField_1);
		new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(2, 1, 1);
		/*textField_1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Integer prob = (Integer) Integer.valueOf(textField_1.getText());
				new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(2, prob);
			} 					
		});*/
		textField_1.addKeyListener(new TextFieldAdapter(this.app, this.gettextField_1(), 2));
		/*textField_1.addKeyListener(new KeyListener(){

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
				
				recovery = textField_1.getText();
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
					if(textField_1.getText().compareTo(recovery) != 0){
						textField_1.setText(recovery);
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
				}
			}
			public void setProb(){
				try{
					Integer prob = (Integer) Integer.valueOf(textField_1.getText());
					Integer recover = (Integer) Integer.valueOf(recovery);
					new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(2, prob, recover);
					}catch(NumberFormatException s){ //in case user hits two letter keys
						/*textField_1.setText("0");
						Integer prob = (Integer) Integer.valueOf(textField_1.getText());
						Integer recover = (Integer) Integer.valueOf(recovery);
						new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(2, prob, recover);
						textField_1.setText("");
						//textField.setText(recovery);
						
						Integer recover;
						Integer prob = (Integer) Integer.valueOf(textField_1.getText());
						if(recovery.equals("")){
							recover = 0;
							new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(2, prob, recover);
						}
						else{
							textField_1.setText("0");
							recover = (Integer) Integer.valueOf(recovery);
							new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(2, prob, recover);
							textField_1.setText("");
						}
					}
			}
			
		});*/
		
		JLabel label_1 = new JLabel("2");
		label_1.setFont(new Font("Levenim MT", Font.PLAIN, 25));
		label_1.setBounds(75, 87, 14, 36);
		add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(new Font("Levenim MT", Font.PLAIN, 11));
		textField_2.setColumns(2);
		textField_2.setBounds(109, 118, 28, 22);
		textField_2.setText("1");
		add(textField_2);
		new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(3, 1, 1);
		/*textField_2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Integer prob = (Integer) Integer.valueOf(textField_2.getText());
				new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(3, prob);
			} 					
		});*/
		textField_2.addKeyListener(new TextFieldAdapter(this.app, this.gettextField_2(), 3));
		/*textField_2.addKeyListener(new KeyListener(){

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
				
				recovery = textField_2.getText();
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
					if(textField_2.getText().compareTo(recovery) != 0){
						textField_2.setText(recovery);
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
				}
			}
			public void setProb(){
				try{
					Integer prob = (Integer) Integer.valueOf(textField_2.getText());
					Integer recover = (Integer) Integer.valueOf(recovery);
					new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(3, prob, recover);
					}catch(NumberFormatException s){ //in case user hits two letter keys
						/*textField_2.setText("0");
						Integer prob = (Integer) Integer.valueOf(textField_2.getText());
						Integer recover = (Integer) Integer.valueOf(recovery);
						new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(3, prob, recover);
						textField_2.setText("");
						//textField.setText(recovery);
						
						Integer recover;
						Integer prob = (Integer) Integer.valueOf(textField_2.getText());
						if(recovery.equals("")){
							recover = 0;
							new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(3, prob, recover);
						}
						else{
							textField_2.setText("0");
							recover = (Integer) Integer.valueOf(recovery);
							new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(3, prob, recover);
							textField_2.setText("");
						}
					}
			}
			
		});*/
		
		JLabel label_2 = new JLabel("3");
		label_2.setFont(new Font("Levenim MT", Font.PLAIN, 25));
		label_2.setBounds(116, 87, 14, 36);
		add(label_2);
		
		textField_13 = new JTextField();
		textField_13.setHorizontalAlignment(SwingConstants.CENTER);
		textField_13.setFont(new Font("Levenim MT", Font.PLAIN, 11));
		textField_13.setColumns(2);
		textField_13.setBounds(150, 118, 28, 22);
		textField_13.setText("1");
		add(textField_13);
		new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(4, 1, 1);
		/*textField_13.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Integer prob = (Integer) Integer.valueOf(textField_13.getText());
				new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(4, prob);
			} 					
		});*/
		textField_13.addKeyListener(new TextFieldAdapter(this.app, this.gettextField_13(), 4));
		/*textField_13.addKeyListener(new KeyListener(){

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
				
				recovery = textField_13.getText();
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
					if(textField_13.getText().compareTo(recovery) != 0){
						textField_13.setText(recovery);
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
				}
			}
			public void setProb(){
				try{
					Integer prob = (Integer) Integer.valueOf(textField_13.getText());
					Integer recover = (Integer) Integer.valueOf(recovery);
					new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(4, prob, recover);
					}catch(NumberFormatException s){ //in case user hits two letter keys
						/*textField_13.setText("0");
						Integer prob = (Integer) Integer.valueOf(textField_13.getText());
						Integer recover = (Integer) Integer.valueOf(recovery);
						new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(4, prob, recover);
						textField_13.setText("");
						//textField.setText(recovery);
						
						Integer recover;
						Integer prob = (Integer) Integer.valueOf(textField_13.getText());
						if(recovery.equals("")){
							recover = 0;
							new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(4, prob, recover);
						}
						else{
							textField_13.setText("0");
							recover = (Integer) Integer.valueOf(recovery);
							new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(4, prob, recover);
							textField_13.setText("");
						}
					}
			}
			
		});*/
		
		JLabel label_6 = new JLabel("4");
		label_6.setFont(new Font("Levenim MT", Font.PLAIN, 25));
		label_6.setBounds(157, 87, 14, 36);
		add(label_6);
		
		textField_15 = new JTextField();
		textField_15.setHorizontalAlignment(SwingConstants.CENTER);
		textField_15.setFont(new Font("Levenim MT", Font.PLAIN, 11));
		textField_15.setColumns(2);
		textField_15.setBounds(189, 118, 28, 22);
		textField_15.setText("1");
		add(textField_15);
		new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(5, 1, 1);
		/*textField_15.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Integer prob = (Integer) Integer.valueOf(textField_15.getText());
				new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(5, prob);
			} 					
		});*/
		textField_15.addKeyListener(new TextFieldAdapter(this.app, this.gettextField_15(), 5));
		/*textField_15.addKeyListener(new KeyListener(){

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
				
				recovery = textField_15.getText();
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
					if(textField_15.getText().compareTo(recovery) != 0){
						textField_15.setText(recovery);
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
				}
			}
			public void setProb(){
				try{
					Integer prob = (Integer) Integer.valueOf(textField_15.getText());
					Integer recover = (Integer) Integer.valueOf(recovery);
					new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(5, prob, recover);
					}catch(NumberFormatException s){ //in case user hits two letter keys
						/*textField_15.setText("0");
						Integer prob = (Integer) Integer.valueOf(textField_15.getText());
						Integer recover = (Integer) Integer.valueOf(recovery);
						new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(5, prob, recover);
						textField_15.setText("");
						//textField.setText(recovery);
						
						Integer recover;
						Integer prob = (Integer) Integer.valueOf(textField_15.getText());
						if(recovery.equals("")){
							recover = 0;
							new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(5, prob, recover);
						}
						else{
							textField_15.setText("0");
							recover = (Integer) Integer.valueOf(recovery);
							new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(5, prob, recover);
							textField_15.setText("");
						}
					}
			}
			
		});*/
		
		JLabel label_7 = new JLabel("5");
		label_7.setFont(new Font("Levenim MT", Font.PLAIN, 25));
		label_7.setBounds(196, 87, 14, 36);
		add(label_7);
		
		textField_16 = new JTextField();
		textField_16.setHorizontalAlignment(SwingConstants.CENTER);
		textField_16.setFont(new Font("Levenim MT", Font.PLAIN, 11));
		textField_16.setColumns(2);
		textField_16.setBounds(227, 118, 28, 22);
		textField_16.setText("1");
		add(textField_16);
		new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(6, 1, 1);
		/*textField_16.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Integer prob = (Integer) Integer.valueOf(textField_16.getText());
				new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(6, prob);
			} 					
		});*/
		textField_16.addKeyListener(new TextFieldAdapter(this.app, this.gettextField_16(), 6));
		/*textField_16.addKeyListener(new KeyListener(){

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
				
				recovery = textField_16.getText();
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
					if(textField_16.getText().compareTo(recovery) != 0){
						textField_16.setText(recovery);
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
				}
			}
			public void setProb(){
				try{
					Integer prob = (Integer) Integer.valueOf(textField_16.getText());
					Integer recover = (Integer) Integer.valueOf(recovery);
					new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(6, prob, recover);
					}catch(NumberFormatException s){ //in case user hits two letter keys
						/*textField_16.setText("0");
						Integer prob = (Integer) Integer.valueOf(textField_16.getText());
						Integer recover = (Integer) Integer.valueOf(recovery);
						new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(6, prob, recover);
						textField_16.setText("");
						//textField.setText(recovery);
						
						Integer recover;
						Integer prob = (Integer) Integer.valueOf(textField_16.getText());
						if(recovery.equals("")){
							recover = 0;
							new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(6, prob, recover);
						}
						else{
							textField_16.setText("0");
							recover = (Integer) Integer.valueOf(recovery);
							new TileProbabilityController(LevelBuilderView.this.level, LevelBuilderView.this).updateProbability(6, prob, recover);
							textField_16.setText("");
						}
					}
			}
			
		});*/
		
		JLabel label_8 = new JLabel("6");
		label_8.setFont(new Font("Levenim MT", Font.PLAIN, 25));
		label_8.setBounds(234, 87, 14, 36);
		add(label_8);
		
		for (int i = 0; i < 9; i++){
			for (int j = 0; j < 9; j++){
				final int k = i;
				final int l = j;
				squareSelect[i][j] = new JToggleButton("");
				squareSelect[i][j].setBounds(370+40*j, 50 + 38*i, 35, 35);
				add(squareSelect[i][j]);
				new SelectUnusableController(LevelBuilderView.this.level, LevelBuilderView.this.app).makeUnusable(k, l, false);
				squareSelect[i][j].addActionListener(new ActionListener(){
					
					@Override
					public void actionPerformed(ActionEvent e) {
						boolean active = (boolean) LevelBuilderView.this.squareSelect[k][l].isSelected();
						new SelectUnusableController(LevelBuilderView.this.level, LevelBuilderView.this.app).makeUnusable(k, l, active);
					} 					
				});
			}
		}
		/*
		JToggleButton toggleButton_1 = new JToggleButton("");
		toggleButton_1.setBounds(650, 50, 35, 35);
		add(toggleButton_1);
		
		JToggleButton toggleButton_2 = new JToggleButton("");
		toggleButton_2.setBounds(610, 50, 35, 35);
		add(toggleButton_2);
		
		JToggleButton toggleButton_3 = new JToggleButton("");
		toggleButton_3.setBounds(570, 50, 35, 35);
		add(toggleButton_3);
		
		JToggleButton toggleButton_4 = new JToggleButton("");
		toggleButton_4.setBounds(530, 50, 35, 35);
		add(toggleButton_4);
		
		JToggleButton toggleButton_5 = new JToggleButton("");
		toggleButton_5.setBounds(490, 50, 35, 35);
		add(toggleButton_5);
		
		JToggleButton toggleButton_6 = new JToggleButton("");
		toggleButton_6.setBounds(370, 50, 35, 35);
		add(toggleButton_6);
		
		JToggleButton toggleButton_7 = new JToggleButton("");
		toggleButton_7.setBounds(410, 50, 35, 35);
		add(toggleButton_7);
		
		JToggleButton toggleButton_8 = new JToggleButton("");
		toggleButton_8.setBounds(450, 50, 35, 35);
		add(toggleButton_8);
		
		JToggleButton toggleButton_9 = new JToggleButton("");
		toggleButton_9.setBounds(690, 88, 35, 35);
		add(toggleButton_9);
		
		JToggleButton toggleButton_10 = new JToggleButton("");
		toggleButton_10.setBounds(650, 88, 35, 35);
		add(toggleButton_10);
		
		JToggleButton toggleButton_11 = new JToggleButton("");
		toggleButton_11.setBounds(610, 88, 35, 35);
		add(toggleButton_11);
		
		JToggleButton toggleButton_12 = new JToggleButton("");
		toggleButton_12.setBounds(570, 88, 35, 35);
		add(toggleButton_12);
		
		JToggleButton toggleButton_13 = new JToggleButton("");
		toggleButton_13.setBounds(530, 88, 35, 35);
		add(toggleButton_13);
		
		JToggleButton toggleButton_14 = new JToggleButton("");
		toggleButton_14.setBounds(490, 88, 35, 35);
		add(toggleButton_14);
		
		JToggleButton toggleButton_15 = new JToggleButton("");
		toggleButton_15.setBounds(450, 88, 35, 35);
		add(toggleButton_15);
		
		JToggleButton toggleButton_16 = new JToggleButton("");
		toggleButton_16.setBounds(410, 88, 35, 35);
		add(toggleButton_16);
		
		JToggleButton toggleButton_17 = new JToggleButton("");
		toggleButton_17.setBounds(370, 88, 35, 35);
		add(toggleButton_17);
		
		JToggleButton toggleButton_18 = new JToggleButton("");
		toggleButton_18.setBounds(690, 167, 35, 35);
		add(toggleButton_18);
		
		JToggleButton toggleButton_19 = new JToggleButton("");
		toggleButton_19.setBounds(650, 167, 35, 35);
		add(toggleButton_19);
		
		JToggleButton toggleButton_20 = new JToggleButton("");
		toggleButton_20.setBounds(610, 167, 35, 35);
		add(toggleButton_20);
		
		JToggleButton toggleButton_21 = new JToggleButton("");
		toggleButton_21.setBounds(570, 167, 35, 35);
		add(toggleButton_21);
		
		JToggleButton toggleButton_22 = new JToggleButton("");
		toggleButton_22.setBounds(530, 167, 35, 35);
		add(toggleButton_22);
		
		JToggleButton toggleButton_23 = new JToggleButton("");
		toggleButton_23.setBounds(490, 167, 35, 35);
		add(toggleButton_23);
		
		JToggleButton toggleButton_24 = new JToggleButton("");
		toggleButton_24.setBounds(450, 167, 35, 35);
		add(toggleButton_24);
		
		JToggleButton toggleButton_25 = new JToggleButton("");
		toggleButton_25.setBounds(410, 167, 35, 35);
		add(toggleButton_25);
		
		JToggleButton toggleButton_26 = new JToggleButton("");
		toggleButton_26.setBounds(370, 167, 35, 35);
		add(toggleButton_26);
		
		JToggleButton toggleButton_27 = new JToggleButton("");
		toggleButton_27.setBounds(690, 129, 35, 35);
		add(toggleButton_27);
		
		JToggleButton toggleButton_28 = new JToggleButton("");
		toggleButton_28.setBounds(650, 129, 35, 35);
		add(toggleButton_28);
		
		JToggleButton toggleButton_29 = new JToggleButton("");
		toggleButton_29.setBounds(610, 129, 35, 35);
		add(toggleButton_29);
		
		JToggleButton toggleButton_30 = new JToggleButton("");
		toggleButton_30.setBounds(570, 129, 35, 35);
		add(toggleButton_30);
		
		JToggleButton toggleButton_31 = new JToggleButton("");
		toggleButton_31.setBounds(530, 129, 35, 35);
		add(toggleButton_31);
		
		JToggleButton toggleButton_32 = new JToggleButton("");
		toggleButton_32.setBounds(490, 129, 35, 35);
		add(toggleButton_32);
		
		JToggleButton toggleButton_33 = new JToggleButton("");
		toggleButton_33.setBounds(450, 129, 35, 35);
		add(toggleButton_33);
		
		JToggleButton toggleButton_34 = new JToggleButton("");
		toggleButton_34.setBounds(410, 129, 35, 35);
		add(toggleButton_34);
		
		JToggleButton toggleButton_35 = new JToggleButton("");
		toggleButton_35.setBounds(370, 129, 35, 35);
		add(toggleButton_35);
		
		JToggleButton toggleButton_36 = new JToggleButton("");
		toggleButton_36.setBounds(690, 322, 35, 35);
		add(toggleButton_36);
		
		JToggleButton toggleButton_37 = new JToggleButton("");
		toggleButton_37.setBounds(690, 284, 35, 35);
		add(toggleButton_37);
		
		JToggleButton toggleButton_38 = new JToggleButton("");
		toggleButton_38.setBounds(690, 243, 35, 35);
		add(toggleButton_38);
		
		JToggleButton toggleButton_39 = new JToggleButton("");
		toggleButton_39.setBounds(690, 205, 35, 35);
		add(toggleButton_39);
		
		JToggleButton toggleButton_40 = new JToggleButton("");
		toggleButton_40.setBounds(650, 205, 35, 35);
		add(toggleButton_40);
		
		JToggleButton toggleButton_41 = new JToggleButton("");
		toggleButton_41.setBounds(650, 243, 35, 35);
		add(toggleButton_41);
		
		JToggleButton toggleButton_42 = new JToggleButton("");
		toggleButton_42.setBounds(650, 284, 35, 35);
		add(toggleButton_42);
		
		JToggleButton toggleButton_43 = new JToggleButton("");
		toggleButton_43.setBounds(650, 322, 35, 35);
		add(toggleButton_43);
		
		JToggleButton toggleButton_44 = new JToggleButton("");
		toggleButton_44.setBounds(610, 322, 35, 35);
		add(toggleButton_44);
		
		JToggleButton toggleButton_45 = new JToggleButton("");
		toggleButton_45.setBounds(610, 284, 35, 35);
		add(toggleButton_45);
		
		JToggleButton toggleButton_46 = new JToggleButton("");
		toggleButton_46.setBounds(610, 243, 35, 35);
		add(toggleButton_46);
		
		JToggleButton toggleButton_47 = new JToggleButton("");
		toggleButton_47.setBounds(610, 205, 35, 35);
		add(toggleButton_47);
		
		JToggleButton toggleButton_48 = new JToggleButton("");
		toggleButton_48.setBounds(570, 205, 35, 35);
		add(toggleButton_48);
		
		JToggleButton toggleButton_49 = new JToggleButton("");
		toggleButton_49.setBounds(570, 243, 35, 35);
		add(toggleButton_49);
		
		JToggleButton toggleButton_50 = new JToggleButton("");
		toggleButton_50.setBounds(570, 284, 35, 35);
		add(toggleButton_50);
		
		JToggleButton toggleButton_51 = new JToggleButton("");
		toggleButton_51.setBounds(570, 322, 35, 35);
		add(toggleButton_51);
		
		JToggleButton toggleButton_52 = new JToggleButton("");
		toggleButton_52.setBounds(530, 322, 35, 35);
		add(toggleButton_52);
		
		JToggleButton toggleButton_53 = new JToggleButton("");
		toggleButton_53.setBounds(530, 284, 35, 35);
		add(toggleButton_53);
		
		JToggleButton toggleButton_54 = new JToggleButton("");
		toggleButton_54.setBounds(530, 205, 35, 35);
		add(toggleButton_54);
		
		JToggleButton toggleButton_55 = new JToggleButton("");
		toggleButton_55.setBounds(530, 243, 35, 35);
		add(toggleButton_55);
		
		JToggleButton toggleButton_56 = new JToggleButton("");
		toggleButton_56.setBounds(490, 205, 35, 35);
		add(toggleButton_56);
		
		JToggleButton toggleButton_57 = new JToggleButton("");
		toggleButton_57.setBounds(450, 205, 35, 35);
		add(toggleButton_57);
		
		JToggleButton toggleButton_58 = new JToggleButton("");
		toggleButton_58.setBounds(450, 243, 35, 35);
		add(toggleButton_58);
		
		JToggleButton toggleButton_59 = new JToggleButton("");
		toggleButton_59.setBounds(490, 243, 35, 35);
		add(toggleButton_59);
		
		JToggleButton toggleButton_60 = new JToggleButton("");
		toggleButton_60.setBounds(490, 284, 35, 35);
		add(toggleButton_60);
		
		JToggleButton toggleButton_61 = new JToggleButton("");
		toggleButton_61.setBounds(450, 284, 35, 35);
		add(toggleButton_61);
		
		JToggleButton toggleButton_62 = new JToggleButton("");
		toggleButton_62.setBounds(490, 322, 35, 35);
		add(toggleButton_62);
		
		JToggleButton toggleButton_63 = new JToggleButton("");
		toggleButton_63.setBounds(450, 322, 35, 35);
		add(toggleButton_63);
		
		JToggleButton toggleButton_64 = new JToggleButton("");
		toggleButton_64.setBounds(410, 322, 35, 35);
		add(toggleButton_64);
		
		JToggleButton toggleButton_65 = new JToggleButton("");
		toggleButton_65.setBounds(370, 322, 35, 35);
		add(toggleButton_65);
		
		JToggleButton toggleButton_66 = new JToggleButton("");
		toggleButton_66.setBounds(370, 284, 35, 35);
		add(toggleButton_66);
		
		JToggleButton toggleButton_67 = new JToggleButton("");
		toggleButton_67.setBounds(410, 284, 35, 35);
		add(toggleButton_67);
		
		JToggleButton toggleButton_68 = new JToggleButton("");
		toggleButton_68.setBounds(410, 243, 35, 35);
		add(toggleButton_68);
		
		JToggleButton toggleButton_69 = new JToggleButton("");
		toggleButton_69.setBounds(370, 243, 35, 35);
		add(toggleButton_69);
		
		JToggleButton toggleButton_70 = new JToggleButton("");
		toggleButton_70.setBounds(370, 205, 35, 35);
		add(toggleButton_70);
		
		JToggleButton toggleButton_71 = new JToggleButton("");
		toggleButton_71.setBounds(410, 205, 35, 35);
		add(toggleButton_71);
		
		JToggleButton toggleButton_72 = new JToggleButton("");
		toggleButton_72.setBounds(690, 364, 35, 35);
		add(toggleButton_72);
		
		JToggleButton toggleButton_73 = new JToggleButton("");
		toggleButton_73.setBounds(650, 364, 35, 35);
		add(toggleButton_73);
		
		JToggleButton toggleButton_74 = new JToggleButton("");
		toggleButton_74.setBounds(610, 364, 35, 35);
		add(toggleButton_74);
		
		JToggleButton toggleButton_75 = new JToggleButton("");
		toggleButton_75.setBounds(570, 364, 35, 35);
		add(toggleButton_75);
		
		JToggleButton toggleButton_76 = new JToggleButton("");
		toggleButton_76.setBounds(530, 364, 35, 35);
		add(toggleButton_76);
		
		JToggleButton toggleButton_77 = new JToggleButton("");
		toggleButton_77.setBounds(490, 364, 35, 35);
		add(toggleButton_77);
		
		JToggleButton toggleButton_78 = new JToggleButton("");
		toggleButton_78.setBounds(450, 364, 35, 35);
		add(toggleButton_78);
		
		JToggleButton toggleButton_79 = new JToggleButton("");
		toggleButton_79.setBounds(410, 364, 35, 35);
		add(toggleButton_79);
		
		JToggleButton toggleButton_80 = new JToggleButton("");
		toggleButton_80.setBounds(370, 364, 35, 35);
		add(toggleButton_80);*/
		
		/*rdbtnNewRadioButton1 = new JRadioButton("1");
		rdbtnNewRadioButton1.setBounds(370, 406, 35, 23);
		rdbtnNewRadioButton1.setVisible(false);
		add(rdbtnNewRadioButton1);
		
		rdbtnNewRadioButton2 = new JRadioButton("2");
		rdbtnNewRadioButton2.setBounds(410, 406, 35, 23);
		rdbtnNewRadioButton2.setVisible(false);
		add(rdbtnNewRadioButton2);
		
		rdbtnNewRadioButton3 = new JRadioButton("3");
		rdbtnNewRadioButton3.setBounds(450, 406, 35, 23);
		rdbtnNewRadioButton3.setVisible(false);
		add(rdbtnNewRadioButton3);
		
		rdbtnNewRadioButton4 = new JRadioButton("4");
		rdbtnNewRadioButton4.setBounds(490, 406, 35, 23);
		rdbtnNewRadioButton4.setVisible(false);
		add(rdbtnNewRadioButton4);
		
		rdbtnNewRadioButton5 = new JRadioButton("5");
		rdbtnNewRadioButton5.setBounds(530, 406, 35, 23);
		rdbtnNewRadioButton5.setVisible(false);
		add(rdbtnNewRadioButton5);
		
		rdbtnNewRadioButton6 = new JRadioButton("6");
		rdbtnNewRadioButton6.setBounds(570, 406, 35, 23);
		rdbtnNewRadioButton6.setVisible(false);
		add(rdbtnNewRadioButton6);
		
		rdbtnNewRadioButton7 = new JRadioButton("7");
		rdbtnNewRadioButton7.setBounds(610, 406, 35, 23);
		rdbtnNewRadioButton7.setVisible(false);
		add(rdbtnNewRadioButton7);
		
		rdbtnNewRadioButton8 = new JRadioButton("8");
		rdbtnNewRadioButton8.setBounds(650, 406, 35, 23);
		rdbtnNewRadioButton8.setVisible(false);
		add(rdbtnNewRadioButton8);
		
		rdbtnNewRadioButton9 = new JRadioButton("9");
		rdbtnNewRadioButton9.setBounds(690, 406, 35, 23);
		rdbtnNewRadioButton9.setVisible(false);
		add(rdbtnNewRadioButton9);*/
		
		for (int q = 0; q < 9; q++){
			bucketColumn[q] = new JRadioButton("" + (q+1));
			bucketColumn[q].setBounds(370 + 40*q, 406, 35, 23);
			bucketColumn[q].setVisible(false);
			add(bucketColumn[q]);
			final int r = q;
			bucketColumn[q].addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					boolean active = (boolean) LevelBuilderView.this.bucketColumn[r].isSelected();
					new BucketController(LevelBuilderView.this.level, LevelBuilderView.this).updateBucket(r, active);
				} 					
			});
			
		}
		
		lblBucketColumns = new JLabel("Bucket Columns");
		lblBucketColumns.setHorizontalAlignment(SwingConstants.CENTER);
		lblBucketColumns.setFont(new Font("Levenim MT", Font.PLAIN, 11));
		lblBucketColumns.setBounds(490, 432, 115, 14);
		lblBucketColumns.setVisible(false);
		add(lblBucketColumns);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setFont(new Font("Levenim MT", Font.PLAIN, 11));
		btnExit.setBounds(650, 430, 60, 23);
		add(btnExit);
		
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ExitButtonController(LevelBuilderView.this.app).exitView();
			}
		});
		
		//@SuppressWarnings("deprecation")
		//KeyEvent init1 = new KeyEvent(textField, 400, 1, 0, 10);
		

		btnUndo = new JButton("Undo");
		btnUndo.setBounds(247, 428, 89, 23);
		/*if (LevelBuilderView.this.level.emptyEdit()){
			btnUndo.setEnabled(false);
		}
		else{
			btnUndo.setEnabled(true);
		}*/
		add(btnUndo);
		btnUndo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				if (!LevelBuilderView.this.level.emptyEdit()){
					LevelBuilderView.this.level.getMostRecentEdit().undo();
				}
			}
		});
		
		JButton btnRedo = new JButton("Redo");
		btnRedo.setBounds(346, 428, 89, 23);
		/*if (LevelBuilderView.this.level.emptyUndo()){
			btnRedo.setEnabled(false);
		}
		else{
			btnRedo.setEnabled(true);
		}*/
		add(btnRedo);
		btnRedo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				if (!LevelBuilderView.this.level.emptyUndo()){
					LevelBuilderView.this.level.getMostRecentUndo().redo();
				}
			}
		});
		
		resetEditList();
		new ModeController (LevelBuilderView.this.level, LevelBuilderView.this.app).updateMode("Puzzle", "Puzzle");
		new SelectGameTypeController(LevelBuilderView.this).selectType("Puzzle");
	}
	
	public JTextField gettextField_12() {
		return textField_12;
	}
	
	public JTextField gettextField_9() {
		return textField_9;
	}
	
	public JTextField gettextField_10() {
		return textField_10;
	}
	
	public JTextField gettextField_11() {
		return textField_11;
	}
	
	public JTextField gettextField_14() {
		return textField_14;
	}
	
	public JTextField gettextField_6() {
		return textField_6;
	}
	
	public JTextField gettextField_7() {
		return textField_7;
	}
	
	public JTextField gettextField_8() {
		return textField_8;
	}
	
	public JTextField gettextField() {
		return textField;
	}
	
	public JTextField gettextField_1() {
		return textField_1;
	}
	
	public JTextField gettextField_2() {
		return textField_2;
	}
	
	public JTextField gettextField_13() {
		return textField_13;
	}
	
	public JTextField gettextField_15() {
		return textField_15;
	}
	
	public JTextField gettextField_16() {
		return textField_16;
	}
	
	public JLabel getlblStar_2() {
		return lblStar_2;
	}
	
	public JLabel getlblVariable() {
		return lblVariable;
	}
	
	/*public JRadioButton getrdbtnNewRadioButton1(){
		return rdbtnNewRadioButton1;
	}
	
	public JRadioButton getrdbtnNewRadioButton2(){
		return rdbtnNewRadioButton2;
	}
	
	public JRadioButton getrdbtnNewRadioButton3(){
		return rdbtnNewRadioButton3;
	}
	
	public JRadioButton getrdbtnNewRadioButton4(){
		return rdbtnNewRadioButton4;
	}
	
	public JRadioButton getrdbtnNewRadioButton5(){
		return rdbtnNewRadioButton5;
	}
	
	public JRadioButton getrdbtnNewRadioButton6(){
		return rdbtnNewRadioButton6;
	}
	
	public JRadioButton getrdbtnNewRadioButton7(){
		return rdbtnNewRadioButton7;
	}
	
	public JRadioButton getrdbtnNewRadioButton8(){
		return rdbtnNewRadioButton8;
	}
	
	public JRadioButton getrdbtnNewRadioButton9(){
		return rdbtnNewRadioButton9;
	}*/
	
	public JRadioButton getBucketColumn(int index){
		return bucketColumn[index];
	}
	
	public JLabel getlblBucketColumns(){
		return lblBucketColumns;
	}
	
	public JTextField getProb1(){
		return textField;
	}
	
	public JTextField getProb2(){
		return textField_1;
	}

	public JTextField getProb3(){
		return textField_2;
	}

	public JTextField getProb4(){
		return textField_13;
	}

	public JTextField getProb5(){
		return textField_15;
	}

	public JTextField getProb6(){
		return textField_16;
	}
	
	public JTextField getMult1(){
		return textField_6;
	}
	
	public JTextField getMult2(){
		return textField_7;
	}
	
	public JTextField getMult3(){
		return textField_8;
	}
	
	public JTextField getGoalScore1(){
		return textField_10;
	}
	
	public JTextField getGoalScore2(){
		return textField_11;
	}
	
	public JTextField getGoalScore3(){
		return textField_14;
	}
	
	public JToggleButton getActiveSquare(int y, int x){
		return squareSelect[y][x];
	}
	
	public JComboBox getComboBox(){
		return comboBox;
	}
	
	public void resetEditList(){
		this.level.getEdits().clear();
	}
	
	public String getModeRecovery(){
		return this.modeRecovery;
	}
	
	public void setModeBoolean(boolean doMoveController){
		this.modeBoolean = doMoveController;
	}
	
	public Level getLevel() {
		return this.level;
	}
}
