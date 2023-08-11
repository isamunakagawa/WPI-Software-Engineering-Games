package levelbuilder.view;

import game.controller.ExitLevelController;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

import levelbuilder.controller.ExitPreviewController;
import levelbuilder.entities.Board;
import levelbuilder.entities.Level;
import levelbuilder.entities.Mode;
import levelbuilder.entities.Mode.gameMode;

public class LevelView extends JPanel{
	/** The application.*/
	private Application app;
	
	/** Score label for a level.*/
	protected JLabel lblScore;
	protected JLabel lblCountdown;
	
	/** BoardView that renders the board.*/
	protected BoardView boardView;
	
	/** The information contained in level is used to render for 
	 * levelView.*/
	protected Level level;
	
	protected Board board;
	
	/** Score progress bar.*/
	protected JProgressBar progressBar;
	
	/** Goal score labels.*/
	protected JLabel[] goalLabels = new JLabel[3];
	
	/**
	 * LevelView constructor creates a level boundary object
	 * that displays various visual components.
	 * @param app, game application
	 */
	public LevelView(Level level, Application app){
		
		super();
		this.level = level;
		this.app = app;
		this.setBounds(0, 0, 750, 666);
		
		// create temporary objects
		//this.board = new Board();
		//board.initialize();
		//this.level = new Level(board, new Mode(gameMode.PUZZLE, 10), new int[100]);
		//this.level = level;
		//level.setBoard(board);
		if (this.level.getMode().isRelease()){
			this.level.getBoard().getTileGen().setTileProb(5, 0);
			this.level.getBoard().initialize();
		}
		else{
			this.level.getBoard().initialize();
		}
		
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
		//btnRemove.addActionListener(new RemoveButtonAction(this.level, this));
		this.add(btnRemove);
		btnRemove.setEnabled(false);
		
		JButton btnReset = new JButton("");
		btnReset.setBounds(523, 11, 54, 50);
		//btnReset.setIcon(new ImageIcon(GameViewApplication.class.getResource("/com/sun/javafx/scene/web/skin/Redo_16x16_JFX.png")));
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 10));
		//btnReset.addActionListener(new ResetButtonAction(this.level,this));
		this.add(btnReset);
		btnReset.setEnabled(false);
		
		//MoveController mc = new MoveController(this.level, this);
		//mc.register();
		this.add(boardView); // board view
		
		JButton btnSwappowerup = new JButton("");
		btnSwappowerup.setBounds(643, 11, 54, 50);
		//btnSwappowerup.setIcon(new ImageIcon(GameViewApplication.class.getResource("/com/sun/javafx/scene/control/skin/modena/HTMLEditor-Copy.png")));
		btnSwappowerup.setFont(new Font("Tahoma", Font.PLAIN, 10));
		//btnSwappowerup.addActionListener(new SwapBoardAction(this.level,this, mc));
		this.add(btnSwappowerup);
		btnSwappowerup.setEnabled(false);
		
		lblScore = new JLabel("SCORE");
		lblScore.setBounds(18, 141, 125, 66);
		lblScore.setFont(new Font("Tahoma", Font.PLAIN, 30));
		this.add(lblScore);
		
		/*ScoreController sc = new ScoreController(this, this.level);
		sc.update();*/
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setBounds(18, 11, 125, 50);
		this.add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent beta){
				new ExitPreviewController(LevelView.this.app).exitPreview();
			}
		});
		
		lblCountdown = new JLabel("COUNTDOWN");
		lblCountdown.setBounds(18, 64, 185, 66);
		lblCountdown.setFont(new Font("Tahoma", Font.PLAIN, 30));
		this.add(lblCountdown);
		
		JLabel lblLevel = new JLabel("LEVEL " +Integer.toString(1) +"/ "+ this.level.getMode().getType());
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
		
		JLabel lblScoreLabel = new JLabel("New label");
		lblScoreLabel.setBounds(18, 117, 125, 14);
		lblScoreLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		if (this.level.getMode().isLightning()){
			if (this.level.getMode().getCountdown() > 1){
				lblScoreLabel.setText(this.level.getMode().getCountdown() + " seconds");
			}
			else{
				lblScoreLabel.setText(this.level.getMode().getCountdown() + " second");
			}
		}
		else{
			if (this.level.getMode().getCountdown() > 1){
				lblScoreLabel.setText(this.level.getMode().getCountdown() + " moves");
			}
			else{
				lblScoreLabel.setText(this.level.getMode().getCountdown() + " move");
			}
		}
		add(lblScoreLabel);
		
		JLabel lblGoalScore1 = new JLabel("");
		lblGoalScore1.setBounds(20, 617, 120, 14);
		lblGoalScore1.setVisible(true);
		lblGoalScore1.setText("" + level.getGoalScore(0));
		add(lblGoalScore1);
		
		JLabel lblGoalScore2 = new JLabel("");
		lblGoalScore2.setBounds(20, 216, 120, 14);
		lblGoalScore2.setVisible(true);
		lblGoalScore2.setText("" + level.getGoalScore(1));
		add(lblGoalScore2);
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
	
	public void setCountdown(int countdown) {
		lblCountdown.setText(new Integer(countdown).toString());
		repaint();
	}
}
