package game.view;
/**
 * 
 */
import game.controller.ExitLevelSelectController;
import game.controller.LevelSelectButtonAction;
import game.controller.LevelSelectToLevelController;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class LevelSelectView extends JPanel {
	/** The application.*/
	private GameViewApplication app;
	protected int level_number;
	protected JButton[] buttons = new JButton[20];
	protected int[] records;
	
	/**
	 * The LevelSelectView constructor that initializes 
	 * all the elements (visual components) of the level select window.
	 * @param app
	 */
	public LevelSelectView(GameViewApplication app, int level_number, int[] records) {
		super();
		this.app = app;
		this.records = records;
		this.setBounds(0, 0, 750, 666);
		this.setLayout(null);
		
		JLabel lblLevelSelect = new JLabel("LEVEL SELECT");
		lblLevelSelect.setFont(new Font("Trajan Pro", Font.PLAIN, 15));
		lblLevelSelect.setHorizontalAlignment(SwingConstants.CENTER);
		lblLevelSelect.setBounds(275, 10, 200, 50);
		add(lblLevelSelect);
		
		JButton button_1 = new JButton("START LEVEL");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 8));
		button_1.setBounds(50, 135, 89, 23);
		add(button_1);
		buttons[0] = button_1;
		
		JLabel lblNewLabel = new JLabel("PUZZLE");
		lblNewLabel.setLabelFor(button_1);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(50, 93, 89, 23);
		add(lblNewLabel);
		
		JLabel lblLevel = new JLabel("LEVEL 1");
		lblLevel.setLabelFor(button_1);
		lblLevel.setHorizontalAlignment(SwingConstants.CENTER);
		lblLevel.setBounds(50, 73, 89, 23);
		add(lblLevel);
		
		JButton button_2 = new JButton("START LEVEL");
		button_2.setEnabled(false);
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 8));
		button_2.setBounds(189, 135, 89, 23);
		add(button_2);
		buttons[1] = button_2;
		
		JLabel lblLightning = new JLabel("LIGHTNING");
		lblLightning.setHorizontalAlignment(SwingConstants.CENTER);
		lblLightning.setBounds(189, 93, 89, 23);
		add(lblLightning);
		
		JLabel lblLevel_1 = new JLabel("LEVEL 2");
		lblLevel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblLevel_1.setBounds(189, 73, 89, 23);
		add(lblLevel_1);
		
		JButton button_3 = new JButton("START LEVEL");
		button_3.setEnabled(false);
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 8));
		button_3.setBounds(328, 135, 89, 23);
		add(button_3);
		buttons[2] = button_3;
		
		JLabel lblElimination = new JLabel("ELIMINATION");
		lblElimination.setHorizontalAlignment(SwingConstants.CENTER);
		lblElimination.setBounds(328, 93, 89, 23);
		add(lblElimination);
		
		JLabel lblLevel_2 = new JLabel("LEVEL 3");
		lblLevel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblLevel_2.setBounds(328, 73, 89, 23);
		add(lblLevel_2);
		
		JButton button_4 = new JButton("START LEVEL");
		button_4.setEnabled(false);
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 8));
		button_4.setBounds(467, 135, 89, 23);
		add(button_4);
		buttons[3] = button_4;
		
		JLabel lblRelease = new JLabel("RELEASE");
		lblRelease.setHorizontalAlignment(SwingConstants.CENTER);
		lblRelease.setBounds(467, 93, 89, 23);
		add(lblRelease);
		
		JLabel lblLevel_3 = new JLabel("LEVEL 4");
		lblLevel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblLevel_3.setBounds(467, 73, 89, 23);
		add(lblLevel_3);
		
		JButton button_5 = new JButton("START LEVEL");
		button_5.setEnabled(false);
		button_5.setFont(new Font("Tahoma", Font.PLAIN, 8));
		button_5.setBounds(606, 135, 89, 23);
		add(button_5);
		buttons[4] = button_5;
		
		JLabel label_6 = new JLabel("PUZZLE");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBounds(606, 93, 89, 23);
		add(label_6);
		
		JLabel lblLevel_4 = new JLabel("LEVEL 5");
		lblLevel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblLevel_4.setBounds(606, 73, 89, 23);
		add(lblLevel_4);
		
		JLabel lblLevel_5 = new JLabel("LEVEL 6");
		lblLevel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblLevel_5.setBounds(50, 197, 89, 23);
		add(lblLevel_5);
		
		JLabel lblLightning_1 = new JLabel("LIGHTNING");
		lblLightning_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblLightning_1.setBounds(50, 217, 89, 23);
		add(lblLightning_1);
		
		JButton button_6 = new JButton("START LEVEL");
		button_6.setEnabled(false);
		button_6.setFont(new Font("Tahoma", Font.PLAIN, 8));
		button_6.setBounds(50, 261, 89, 23);
		add(button_6);
		buttons[5] = button_6;
		
		JLabel lblLevel_6 = new JLabel("LEVEL 7");
		lblLevel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblLevel_6.setBounds(189, 197, 89, 23);
		add(lblLevel_6);
		
		JLabel lblElimination_1 = new JLabel("ELIMINATION");
		lblElimination_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblElimination_1.setBounds(189, 217, 89, 23);
		add(lblElimination_1);
		
		JButton button_7 = new JButton("START LEVEL");
		button_7.setEnabled(false);
		button_7.setFont(new Font("Tahoma", Font.PLAIN, 8));
		button_7.setBounds(189, 261, 89, 23);
		add(button_7);
		buttons[6] = button_7;
		
		JLabel lblLevel_7 = new JLabel("LEVEL 8");
		lblLevel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblLevel_7.setBounds(328, 197, 89, 23);
		add(lblLevel_7);
		
		JLabel lblRelease_1 = new JLabel("RELEASE");
		lblRelease_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblRelease_1.setBounds(328, 217, 89, 23);
		add(lblRelease_1);
		
		JButton button_8 = new JButton("START LEVEL");
		button_8.setEnabled(false);
		button_8.setFont(new Font("Tahoma", Font.PLAIN, 8));
		button_8.setBounds(328, 261, 89, 23);
		add(button_8);
		buttons[7] = button_8;
		
		JLabel lblLevel_8 = new JLabel("LEVEL 9");
		lblLevel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblLevel_8.setBounds(467, 197, 89, 23);
		add(lblLevel_8);
		
		JLabel label_15 = new JLabel("PUZZLE");
		label_15.setHorizontalAlignment(SwingConstants.CENTER);
		label_15.setBounds(467, 217, 89, 23);
		add(label_15);
		
		JButton button_9 = new JButton("START LEVEL");
		button_9.setEnabled(false);
		button_9.setFont(new Font("Tahoma", Font.PLAIN, 8));
		button_9.setBounds(467, 261, 89, 23);
		add(button_9);
		buttons[8] = button_9;
		
		JLabel lblLevel_9 = new JLabel("LEVEL 10");
		lblLevel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblLevel_9.setBounds(606, 197, 89, 23);
		add(lblLevel_9);
		
		JLabel lblLightning_2 = new JLabel("LIGHTNING");
		lblLightning_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblLightning_2.setBounds(606, 217, 89, 23);
		add(lblLightning_2);
		
		JButton button_10 = new JButton("START LEVEL");
		button_10.setEnabled(false);
		button_10.setFont(new Font("Tahoma", Font.PLAIN, 8));
		button_10.setBounds(606, 261, 89, 23);
		add(button_10);
		buttons[9] = button_10;
		
		JLabel lblLevel_10 = new JLabel("LEVEL 11");
		lblLevel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblLevel_10.setBounds(50, 301, 89, 23);
		add(lblLevel_10);
		
		JLabel lblElimination_2 = new JLabel("ELIMINATION");
		lblElimination_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblElimination_2.setBounds(50, 321, 89, 23);
		add(lblElimination_2);
		
		JButton button_11 = new JButton("START LEVEL");
		button_11.setEnabled(false);
		button_11.setFont(new Font("Tahoma", Font.PLAIN, 8));
		button_11.setBounds(50, 363, 89, 23);
		add(button_11);
		buttons[10] = button_11;
		
		JLabel lblLevel_11 = new JLabel("LEVEL 12");
		lblLevel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblLevel_11.setBounds(189, 301, 89, 23);
		add(lblLevel_11);
		
		JLabel lblRelease_2 = new JLabel("RELEASE");
		lblRelease_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblRelease_2.setBounds(189, 321, 89, 23);
		add(lblRelease_2);
		
		JButton button_12 = new JButton("START LEVEL");
		button_12.setEnabled(false);
		button_12.setFont(new Font("Tahoma", Font.PLAIN, 8));
		button_12.setBounds(189, 363, 89, 23);
		add(button_12);
		buttons[11] = button_12;
		
		JLabel lblLevel_12 = new JLabel("LEVEL 13");
		lblLevel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblLevel_12.setBounds(328, 301, 89, 23);
		add(lblLevel_12);
		
		JLabel label_23 = new JLabel("PUZZLE");
		label_23.setHorizontalAlignment(SwingConstants.CENTER);
		label_23.setBounds(328, 321, 89, 23);
		add(label_23);
		
		JButton button_13 = new JButton("START LEVEL");
		button_13.setEnabled(false);
		button_13.setFont(new Font("Tahoma", Font.PLAIN, 8));
		button_13.setBounds(328, 363, 89, 23);
		add(button_13);
		buttons[12] = button_13;
		
		JLabel lblLevel_13 = new JLabel("LEVEL 14");
		lblLevel_13.setHorizontalAlignment(SwingConstants.CENTER);
		lblLevel_13.setBounds(467, 301, 89, 23);
		add(lblLevel_13);
		
		JLabel lblLightning_3 = new JLabel("LIGHTNING");
		lblLightning_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblLightning_3.setBounds(467, 321, 89, 23);
		add(lblLightning_3);
		
		JButton button_14 = new JButton("START LEVEL");
		button_14.setEnabled(false);
		button_14.setFont(new Font("Tahoma", Font.PLAIN, 8));
		button_14.setBounds(467, 363, 89, 23);
		add(button_14);
		buttons[13] = button_14;
		
		JLabel lblLevel_14 = new JLabel("LEVEL 15");
		lblLevel_14.setHorizontalAlignment(SwingConstants.CENTER);
		lblLevel_14.setBounds(606, 301, 89, 23);
		add(lblLevel_14);
		
		JLabel lblElimination_3 = new JLabel("ELIMINATION");
		lblElimination_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblElimination_3.setBounds(606, 321, 89, 23);
		add(lblElimination_3);
		
		JButton button_15 = new JButton("START LEVEL");
		button_15.setEnabled(false);
		button_15.setFont(new Font("Tahoma", Font.PLAIN, 8));
		button_15.setBounds(606, 363, 89, 23);
		add(button_15);
		buttons[14] = button_15;
		
		JLabel lblLevel_15 = new JLabel("LEVEL 16");
		lblLevel_15.setHorizontalAlignment(SwingConstants.CENTER);
		lblLevel_15.setBounds(50, 417, 89, 23);
		add(lblLevel_15);
		
		JLabel lblRelease_3 = new JLabel("RELEASE");
		lblRelease_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblRelease_3.setBounds(50, 437, 89, 23);
		add(lblRelease_3);
		
		JButton button_16 = new JButton("START LEVEL");
		button_16.setEnabled(false);
		button_16.setFont(new Font("Tahoma", Font.PLAIN, 8));
		button_16.setBounds(50, 476, 89, 23);
		add(button_16);
		buttons[15] = button_16;
		
		JLabel lblLevel_16 = new JLabel("LEVEL 17");
		lblLevel_16.setHorizontalAlignment(SwingConstants.CENTER);
		lblLevel_16.setBounds(189, 417, 89, 23);
		add(lblLevel_16);
		
		JLabel label_31 = new JLabel("PUZZLE");
		label_31.setHorizontalAlignment(SwingConstants.CENTER);
		label_31.setBounds(189, 437, 89, 23);
		add(label_31);
		
		JButton button_17 = new JButton("START LEVEL");
		button_17.setEnabled(false);
		button_17.setFont(new Font("Tahoma", Font.PLAIN, 8));
		button_17.setBounds(189, 476, 89, 23);
		add(button_17);
		buttons[16] = button_17;
		
		JLabel lblLevel_17 = new JLabel("LEVEL 18");
		lblLevel_17.setHorizontalAlignment(SwingConstants.CENTER);
		lblLevel_17.setBounds(328, 417, 89, 23);
		add(lblLevel_17);
		
		JLabel lblLightning_4 = new JLabel("LIGHTNING");
		lblLightning_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblLightning_4.setBounds(328, 437, 89, 23);
		add(lblLightning_4);
		
		JButton button_18 = new JButton("START LEVEL");
		button_18.setEnabled(false);
		button_18.setFont(new Font("Tahoma", Font.PLAIN, 8));
		button_18.setBounds(328, 476, 89, 23);
		add(button_18);
		buttons[17] = button_18;
		
		JLabel lblLevel_18 = new JLabel("LEVEL 19");
		lblLevel_18.setHorizontalAlignment(SwingConstants.CENTER);
		lblLevel_18.setBounds(467, 417, 89, 23);
		add(lblLevel_18);
		
		JLabel lblElimination_4 = new JLabel("ELIMINATION");
		lblElimination_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblElimination_4.setBounds(467, 437, 89, 23);
		add(lblElimination_4);
		
		JButton button_19 = new JButton("START LEVEL");
		button_19.setEnabled(false);
		button_19.setFont(new Font("Tahoma", Font.PLAIN, 8));
		button_19.setBounds(467, 476, 89, 23);
		add(button_19);
		buttons[18] = button_19;
		
		JLabel lblLevel_19 = new JLabel("LEVEL 20");
		lblLevel_19.setHorizontalAlignment(SwingConstants.CENTER);
		lblLevel_19.setBounds(606, 417, 89, 23);
		add(lblLevel_19);
		
		JLabel lblRelease_4 = new JLabel("RELEASE");
		lblRelease_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblRelease_4.setBounds(606, 437, 89, 23);
		add(lblRelease_4);
		
		JButton button_20 = new JButton("START LEVEL");
		button_20.setEnabled(false);
		button_20.setFont(new Font("Tahoma", Font.PLAIN, 8));
		button_20.setBounds(606, 476, 89, 23);
		add(button_20);
		buttons[19] = button_20;
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setBounds(330, 550, 89, 23);
		add(btnExit);
		
		JLabel lblLabel = new JLabel(Integer.toString(this.records[0]));
		lblLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblLabel.setBounds(50, 116, 89, 23);
		add(lblLabel);
		
		JLabel label = new JLabel(Integer.toString(this.records[1]));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(189, 116, 89, 23);
		add(label);
		
		JLabel label_1 = new JLabel(Integer.toString(this.records[2]));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(328, 116, 89, 23);
		add(label_1);
		
		JLabel label_2 = new JLabel(Integer.toString(this.records[3]));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(467, 116, 89, 23);
		add(label_2);
		
		JLabel label_3 = new JLabel(Integer.toString(this.records[4]));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(606, 116, 89, 23);
		add(label_3);
		
		JLabel label_4 = new JLabel(Integer.toString(this.records[5]));
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(50, 240, 89, 23);
		add(label_4);
		
		JLabel label_5 = new JLabel(Integer.toString(this.records[6]));
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(189, 240, 89, 23);
		add(label_5);
		
		JLabel label_7 = new JLabel(Integer.toString(this.records[7]));
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setBounds(328, 240, 89, 23);
		add(label_7);
		
		JLabel label_8 = new JLabel(Integer.toString(this.records[8]));
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setBounds(467, 240, 89, 23);
		add(label_8);
		
		JLabel label_9 = new JLabel(Integer.toString(this.records[9]));
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setBounds(606, 240, 89, 23);
		add(label_9);
		
		JLabel label_10 = new JLabel(Integer.toString(this.records[10]));
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setBounds(50, 345, 89, 23);
		add(label_10);
		
		JLabel label_11 = new JLabel(Integer.toString(this.records[11]));
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setBounds(189, 345, 89, 23);
		add(label_11);
		
		JLabel label_12 = new JLabel(Integer.toString(this.records[12]));
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setBounds(328, 345, 89, 23);
		add(label_12);
		
		JLabel label_13 = new JLabel(Integer.toString(this.records[13]));
		label_13.setHorizontalAlignment(SwingConstants.CENTER);
		label_13.setBounds(467, 345, 89, 23);
		add(label_13);
		
		JLabel label_14 = new JLabel(Integer.toString(this.records[14]));
		label_14.setHorizontalAlignment(SwingConstants.CENTER);
		label_14.setBounds(606, 345, 89, 23);
		add(label_14);
		
		JLabel label_16 = new JLabel(Integer.toString(this.records[15]));
		label_16.setHorizontalAlignment(SwingConstants.CENTER);
		label_16.setBounds(50, 458, 89, 23);
		add(label_16);
		
		JLabel label_17 = new JLabel(Integer.toString(this.records[16]));
		label_17.setHorizontalAlignment(SwingConstants.CENTER);
		label_17.setBounds(189, 458, 89, 23);
		add(label_17);
		
		JLabel label_18 = new JLabel(Integer.toString(this.records[17]));
		label_18.setHorizontalAlignment(SwingConstants.CENTER);
		label_18.setBounds(328, 458, 89, 23);
		add(label_18);
		
		JLabel label_19 = new JLabel(Integer.toString(this.records[18]));
		label_19.setHorizontalAlignment(SwingConstants.CENTER);
		label_19.setBounds(467, 458, 89, 23);
		add(label_19);
		
		JLabel label_20 = new JLabel(Integer.toString(this.records[19]));
		label_20.setHorizontalAlignment(SwingConstants.CENTER);
		label_20.setBounds(606, 458, 89, 23);
		add(label_20);
		
		
		btnExit.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent beta){
				new ExitLevelSelectController(LevelSelectView.this.app).exitLevelSelect();
			}
		});
		
		for(int i=1; i <= 20; i++){
			if(level_number >= i){
				buttons[i-1].setEnabled(true);
			}
		}
		
		for(int i = 1; i <=20; i++){
			buttons[i-1].addActionListener(new LevelSelectButtonAction(this.app, i));
		}
	}
}
