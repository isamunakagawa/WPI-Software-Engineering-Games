package levelbuilder.view;
import java.awt.EventQueue;

import javax.swing.JFrame;

import levelbuilder.controller.ActionAdapterPreview;
import levelbuilder.controller.TextFieldAdapter;
import levelbuilder.controller.LoadController;
import levelbuilder.controller.TextFieldAdapterCountdown;
import levelbuilder.controller.TextFieldAdapterMultProb;
import levelbuilder.controller.TextFieldAdapterScore;
import levelbuilder.entities.Board;
import levelbuilder.entities.Level;
import levelbuilder.entities.Mode;
import levelbuilder.entities.Mode.gameMode;

/**
 * 
 */
public class Application {

	private JFrame frame;
	private LevelBuilderView levelBuilderView;
	private SplashScreenView splashScreenView;
	private LevelView levelView;

	/**
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Application window = new Application();
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
	public Application() {
		initializeView();
		initializeModel();
		initializeController();
	}

	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initializeView() {
		frame = new JFrame();
		splashScreenView = new SplashScreenView(this);
		frame.setBounds(100, 100, 750, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		splashScreenView.setLayout(null);
		
				
		frame.getContentPane().add(splashScreenView);
		getNewLevelBuilderView();
		
	}
	
	private void initializeModel(){
		
	}
	
	private void initializeController(){
		//levelBuilderView.gettextField().addKeyListener(new KeyListener(){});
		//new TextFieldController(this.levelBuilderView, this.levelBuilderView.getLevel()).initializeTextHandler(this.levelBuilderView.gettextField());
		//levelBuilderView.gettextField().setKeyAdapter(new TextFieldAdapter(this));
		new TextFieldAdapter(this, this.levelBuilderView.gettextField(), 1); //TileProb
		new TextFieldAdapterMultProb(this, this.levelBuilderView.gettextField_6(), 1); //MultProb
		new TextFieldAdapterMultProb(this, this.levelBuilderView.gettextField_7(), 2); //MultProb
		new TextFieldAdapterMultProb(this, this.levelBuilderView.gettextField_8(), 3); //MultProb
		new TextFieldAdapterCountdown(this, this.levelBuilderView.gettextField_9()); //Countdown
		new TextFieldAdapterScore(this, this.levelBuilderView.gettextField_10(), 1); //score
		new TextFieldAdapterScore(this, this.levelBuilderView.gettextField_11(), 2); //score
		new TextFieldAdapterScore(this, this.levelBuilderView.gettextField_14(), 3); //score
		new TextFieldAdapter(this, this.levelBuilderView.gettextField_1(), 2); //TileProb
		new TextFieldAdapter(this, this.levelBuilderView.gettextField_2(), 3); //TileProb
		new TextFieldAdapter(this, this.levelBuilderView.gettextField_13(), 4); //TileProb
		new TextFieldAdapter(this, this.levelBuilderView.gettextField_15(), 5); //TileProb
		new TextFieldAdapter(this, this.levelBuilderView.gettextField_16(), 6); //TileProb
		
		new ActionAdapterPreview(this);
	}
	
	public LevelBuilderView getLevelBuilderView(){
		return levelBuilderView;
	}
	
	public LevelBuilderView getNewLevelBuilderView(){
		levelBuilderView = new LevelBuilderView(this, new Level(new Board(), new Mode(gameMode.PUZZLE, 10), new int[3]));
		return levelBuilderView;
	}
	
	public LevelBuilderView getNewLevelBuilderView(String levelNum){
		Level l = new Level(new Board(), new Mode(gameMode.PUZZLE, 10), new int[3]);
		LoadController lc = new LoadController(l);
		lc.loadLevel(levelNum + ".ini");
		levelBuilderView = new LevelBuilderView(this, l);
		return levelBuilderView;
	}
	
	public SplashScreenView getNewSplashScreenView() {
		splashScreenView = new SplashScreenView(this);
		return splashScreenView;
	}
	
	
	public SplashScreenView getSplashScreenView() {
		return splashScreenView;
	}
	
	public JFrame getAppFrame(){
		return frame;
	}
	
	public LevelView getNewLevelView(Level level){
		levelView = new LevelView(level, this);
		return levelView;
	}

	public LevelView getLevelView() {
		return levelView;
	}
}
