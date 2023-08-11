package game.view;
import game.controller.RecordsController;

import java.awt.EventQueue;

import javax.swing.JFrame;

/**
 * Top-Level GUI Boundary class.
 * 
 * 
 */

public class GameViewApplication {
	/** The JFrame of the application.*/
	JFrame frame;
	
	/** The level view of the application.*/
	LevelView levelView;
	
	/** The splashscreen view of the application.*/
	SplashScreenView splashScreenView;
	
	/** The levelSelectView of the application.*/
	LevelSelectView levelSelectView;
	
	/** The board view of the application.*/
	BoardView boardView;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameViewApplication window = new GameViewApplication();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GameViewApplication() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 666);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Sixes Wild");
		
		/* 
		 * insert method to search through the records.ini file to find the int level_number
		 * of the next level to be played (the next level after the last recorded score)
		 * Pass this level_number in to the first LevelView
		 */
		RecordsController recordsController = new RecordsController();
		int level_number = recordsController.findCurrentLevel();
		int[] records = recordsController.getRecords();
		
		splashScreenView = new SplashScreenView(this, level_number); 
		splashScreenView.setLayout(null);
		
		levelView = new LevelView(this, level_number);
		
		frame.getContentPane().add(splashScreenView);
		levelSelectView = new LevelSelectView(this, level_number, records);
		
		this.boardView = levelView.getBoardView();
		
	}
	
	/**
	 * Getter for the JFrame. 
	 * @return
	 */
	public JFrame getAppFrame(){
		return frame;
	}
	
	/**
	 * Getter for the LevelSelectView. 
	 * @return
	 */
	public LevelSelectView getLevelSelectView(){
		return levelSelectView;
	}
	
	/**
	 * Getter for the SplashScreenView. 
	 * @return
	 */
	public SplashScreenView getSplashScreenView(){
		return splashScreenView;
	}
	
	/**
	 * Getter for the LevelView.
	 * @return
	 */
	public LevelView getLevelView(){
		return levelView;
	}
	
	/**
	 * Getter for the BoardView.
	 * @return
	 */
	public BoardView getBoardView(){
		return boardView;
	}
	
	public void setLevelView(LevelView levelView2){
		this.levelView = levelView2;
	}
	
	public void setLevelSelectView(LevelSelectView levelSelectView2){
		this.levelSelectView = levelSelectView2;
	}
}
