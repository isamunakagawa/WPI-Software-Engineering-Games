package game.view;

import game.controller.ExitLevelController;
import game.controller.LightningTimerController;
import game.controller.LoadController;
import game.controller.MoveController;
import game.controller.RemoveButtonAction;
import game.controller.ResetButtonAction;
import game.controller.ScoreController;
import game.controller.SwapBoardAction;
import game.entity.Board;
import game.entity.Level;
import game.entity.Mode;
import game.entity.Mode.gameMode;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

/**
 * Boundary Class associated with the level view.
 * 
 * 
 * 
 *
 */

public class LevelView extends JPanel{
	/** The application.*/
	private GameViewApplication app;
	
	/** Score label for a level.*/
	protected JLabel lblScore;
	protected JLabel lblCountdown;
	protected JLabel lblLevel;
	
	/** BoardView that renders the board.*/
	protected BoardView boardView;
	
	/** The information contained in level is used to render for 
	 * levelView.*/
	protected Level level;
	
	/** Score progress bar.*/
	protected JProgressBar progressBar;
	
	/** Goal score labels.*/
	protected JLabel[] goalLabels = new JLabel[3];
	
	protected LoadController loadController;
	
	protected int level_number;
	
	/**
	 * LevelView constructor creates a level boundary object
	 * that displays various visual components.
	 * @param app, game application
	 */
	public LevelView( GameViewApplication app, int level_number){
		
		super();
		this.app = app;
		this.level_number = level_number;
		this.setBounds(0, 0, 750, 666);
		
		// create temporary objects
		loadController = new LoadController();
		String fname = level_number + ".ini"; 
		this.level = loadController.loadLevel(fname);
		this.boardView = new BoardView(0,0, level.getBoard());
		boardView.setBounds(200, 135, 545, 449);
		setLayout(null);
		
		progressBar = new JProgressBar();
		progressBar.setBounds(10, 230, 29, 387);
		progressBar.setOrientation(SwingConstants.VERTICAL);
		this.add(progressBar);
		
		JButton btnRemove = new JButton("");
		btnRemove.setBounds(583, 11, 54, 50);
		//btnRemove.setIcon(new ImageIcon(GameViewApplication.class.getResource("/com/sun/javafx/scene/web/skin/Cut_16x16_JFX.png")));
		btnRemove.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnRemove.addActionListener(new RemoveButtonAction(this.level, this));
		this.add(btnRemove);
		
		JButton btnReset = new JButton("");
		btnReset.setBounds(523, 11, 54, 50);
		//btnReset.setIcon(new ImageIcon(GameViewApplication.class.getResource("/com/sun/javafx/scene/web/skin/Redo_16x16_JFX.png")));
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnReset.addActionListener(new ResetButtonAction(this.level,this));
		this.add(btnReset);

		
		MoveController mc = new MoveController(this.level, this, this.app);
		mc.register();
		this.add(boardView); // board view
		
		
		JButton btnSwappowerup = new JButton("");
		btnSwappowerup.setBounds(643, 11, 54, 50);
		//btnSwappowerup.setIcon(new ImageIcon(GameViewApplication.class.getResource("/com/sun/javafx/scene/control/skin/modena/HTMLEditor-Copy.png")));
		btnSwappowerup.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnSwappowerup.addActionListener(new SwapBoardAction(this.level,this, mc));
		this.add(btnSwappowerup);
		
		lblScore = new JLabel("SCORE");
		lblScore.setBounds(18, 141, 125, 66);
		lblScore.setFont(new Font("Tahoma", Font.PLAIN, 30));
		this.add(lblScore);
		
		ScoreController sc = new ScoreController(this, this.level);
		sc.update();
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setBounds(18, 11, 125, 50);
		this.add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent beta){
				new ExitLevelController(LevelView.this.app).exitLevel();
			}
		});
		
		lblCountdown = new JLabel(Integer.toString(level.getMode().getCountdown()));
		lblCountdown.setBounds(18, 64, 185, 66);
		lblCountdown.setFont(new Font("Tahoma", Font.PLAIN, 30));
		this.add(lblCountdown);
		
		lblLevel = new JLabel("LEVEL " +level_number +"/ "+ this.level.getModeString());
		lblLevel.setBounds(184, 8, 317, 66);
		lblLevel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		this.add(lblLevel);
		
		JLabel lblShuffle = new JLabel("RESET/COUNTDOWN");
		lblShuffle.setBounds(523, 65, 54, 18);
		lblShuffle.setHorizontalAlignment(SwingConstants.CENTER);
		lblShuffle.setFont(new Font("Tahoma", Font.PLAIN, 10));
		this.add(lblShuffle);
		
		
		
		JLabel lblDestroy = new JLabel("DESTROY");
		lblDestroy.setBounds(583, 65, 54, 18);
		lblDestroy.setHorizontalAlignment(SwingConstants.CENTER);
		lblDestroy.setFont(new Font("Tahoma", Font.PLAIN, 10));
		this.add(lblDestroy);
		
		JLabel lblSwap = new JLabel("SWAP");
		lblSwap.setBounds(643, 65, 54, 18);
		lblSwap.setHorizontalAlignment(SwingConstants.CENTER);
		lblSwap.setFont(new Font("Tahoma", Font.PLAIN, 10));
		this.add(lblSwap);
		
		JLabel lblGoalReached = new JLabel("GOAL 1 REACHED");
		lblGoalReached.setBounds(49, 230, 120, 14);
		lblGoalReached.setVisible(false);
		add(lblGoalReached);
		goalLabels[0] = lblGoalReached;
		
		JLabel lblGoalReached_1 = new JLabel("GOAL 2 REACHED");
		lblGoalReached_1.setBounds(49, 255, 120, 14);
		lblGoalReached_1.setVisible(false);
		add(lblGoalReached_1);
		goalLabels[1] = lblGoalReached_1;
		
		JLabel lblGoalReached_2 = new JLabel("GOAL 3 REACHED");
		lblGoalReached_2.setBounds(49, 280, 120, 14);
		lblGoalReached_2.setVisible(false);
		add(lblGoalReached_2);
		goalLabels[2] = lblGoalReached_2;
		
	}
	
	/**
	 * Getter for the boardView.
	 * @return
	 */
	public BoardView getBoardView () {
		return this.boardView;
	}
	
	/**
	 * Getter for the score label.
	 * @return
	 */
	public JLabel getScoreLabel(){
		return lblScore;
	}
	
	public JLabel getLevelLabel(){
		return this.lblLevel;
	}
	
	/**
	 * Getter for the progress bar.
	 * @return
	 */
	public JProgressBar getProgressBar(){
		return this.progressBar;
	}
	
	/**
	 * Getter for the GoalScore labels.
	 * @return
	 */
	public JLabel[] getGoalScoreLabels(){
		return goalLabels;
	}
	
	
	public void decrementCountdown() {
		this.level.getMode().decrement();
		lblCountdown.setText(new Integer(this.level.getMode().getCountdown()).toString());
		repaint();
	}
	
	public int getLevelNumber(){
		return this.level_number;
	}

	public JLabel getCountdownLabel() {
		return this.lblCountdown;
	}
}
