package levelbuilder.control;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;

import junit.framework.TestCase;
import levelbuilder.controller.*;
import levelbuilder.entities.Board;
import levelbuilder.entities.Level;
import levelbuilder.entities.Mode;
import levelbuilder.entities.Mode.gameMode;
import levelbuilder.view.Application;

/**
 * 
 * @author Isamu Nakagawa
 *
 */

public class TestSixesWildControllers extends SWTestCase {
	
	protected Application gameWindow;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		gameWindow = new Application();
		gameWindow.getAppFrame().setVisible(true);
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testExitButtonController() {
		
		ExitButtonController exitButtonController = new ExitButtonController(gameWindow);
		exitButtonController.exitView();
		assertTrue(gameWindow.getSplashScreenView().isVisible());
		
	}
	
	public void testPanelSwitchingController() {
		
		PanelSwitchingController panelSwitchingController = new PanelSwitchingController(gameWindow);
		panelSwitchingController.switchViews();
		assertFalse(gameWindow.getSplashScreenView().isVisible());
		
	}
	
	public void testSelectGameTypeController() {
		
		String s;
		SelectGameTypeController selectGameTypeController = new SelectGameTypeController(gameWindow.getLevelBuilderView());
		
		selectGameTypeController.selectType("Puzzle");
		s = gameWindow.getLevelBuilderView().getlblVariable().getText();
		assertEquals(s, "moves");
		
		selectGameTypeController.selectType("Lightning");
		s = gameWindow.getLevelBuilderView().getlblVariable().getText();
		assertEquals(s, "seconds");
		
		selectGameTypeController.selectType("Release");
		s = gameWindow.getLevelBuilderView().getlblVariable().getText();
		assertEquals(s, "moves");
		
		selectGameTypeController.selectType("Elimination");
		s = gameWindow.getLevelBuilderView().getlblVariable().getText();
		assertEquals(s, "moves");
		
	}
	
	public void testBucketController() {
		
		int countdown = 0;
		int goalscore[] = {2,2,2,2,2,2};
		int multProb[] = {2,2,2};
		int valProb[] = {2,2,2,2,2,2};
		Level lv = new Level(new Board(), new Mode(gameMode.PUZZLE, countdown), goalscore);

		
		BucketController bucketController = new BucketController(lv, gameWindow.getLevelBuilderView());
		bucketController.updateBucket(0, true);
		
	}
	
	public void testCountdownController() {
		
		int countdown = 0;
		int goalscore[] = {2,2,2,2,2,2};
		int multProb[] = {2,2,2};
		int valProb[] = {2,2,2,2,2,2};
		Level lv = new Level(new Board(), new Mode(gameMode.PUZZLE, countdown), goalscore);
		
		CountdownController countdownController = new CountdownController(lv, gameWindow);
		countdownController.updateCountdown(1, 0);
		assertEquals(1, lv.getMode().getCountdown());
		countdownController.undo();
		
	}
	
	public void testEditController() {
		
		EditController editController = new EditController() {
			
			@Override
			public void undo() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void redo() {
				// TODO Auto-generated method stub
				
			}
		};
		
	}
	
	public void testExitPreviewController() {
		
		ExitPreviewController exitPreviewController = new ExitPreviewController(gameWindow);
		//exitPreviewController.exitPreview();
		//assertTrue(gameWindow.getLevelBuilderView().isVisible());
		
	}
	
	public void testLoadController() {
		
		int countdown = 0;
		int goalscore[] = {2,2,2,2,2,2};
		int multProb[] = {2,2,2};
		int valProb[] = {2,2,2,2,2,2};
		Level lv = new Level(new Board(), new Mode(gameMode.PUZZLE, countdown), goalscore);

		
		LoadController loadController = new LoadController(lv);
		assertFalse(loadController.loadLevel("null"));
	}
	
	public void testModeController() {
		
		int countdown = 0;
		int goalscore[] = {2,2,2,2,2,2};
		int multProb[] = {2,2,2};
		int valProb[] = {2,2,2,2,2,2};
		Level lv = new Level(new Board(), new Mode(gameMode.PUZZLE, countdown), goalscore);

		
		ModeController modeController = new ModeController(lv, gameWindow);
		modeController.updateMode("Puzzle", "Puzzle");
		
		modeController.undo();
		modeController.redo();
		
	}
	
	public void testPreviewController() {
		
		int countdown = 0;
		int goalscore[] = {2,2,2,2,2,2};
		int multProb[] = {2,2,2};
		int valProb[] = {2,2,2,2,2,2};
		Level lv = new Level(new Board(), new Mode(gameMode.PUZZLE, countdown), goalscore);

		PreviewController previewController = new PreviewController(lv, gameWindow);
		//previewController.previewLevel();
		
	}
	
	public void testSaveController() {
		
		int countdown = 0;
		int goalscore[] = {2,2,2,2,2,2};
		int multProb[] = {2,2,2};
		int valProb[] = {2,2,2,2,2,2};
		Level lv = new Level(new Board(), new Mode(gameMode.PUZZLE, countdown), goalscore);
		
		SaveController saveController = new SaveController(lv);
		saveController.saveLevel("test");
		saveController.setProps();
		saveController.gatherValues();
		
	}
	
	public void testScoreController() {
		
		int countdown = 0;
		int goalscore[] = {2,2,2,2,2,2};
		int multProb[] = {2,2,2};
		int valProb[] = {2,2,2,2,2,2};
		Level lv = new Level(new Board(), new Mode(gameMode.PUZZLE, countdown), goalscore);
		
		ScoreController scoreController = new ScoreController(lv, gameWindow.getLevelBuilderView());
		int s = lv.getScore();
		scoreController.updateScore(1);
		assertEquals(lv.getScore(), s+1);
		scoreController.updateGoalScore(1, 1, 1);
		assertEquals(lv.getGoalScore(1), 2);
		
		scoreController.undo();
		scoreController.redo();
		
	}
	
	public void testUnusableController() {
		
		int countdown = 0;
		int goalscore[] = {2,2,2,2,2,2};
		int multProb[] = {2,2,2};
		int valProb[] = {2,2,2,2,2,2};
		Level lv = new Level(new Board(), new Mode(gameMode.PUZZLE, countdown), goalscore);
		
		SelectUnusableController selectUnusableController = new SelectUnusableController(lv, gameWindow);
		selectUnusableController.makeUnusable(0, 0, true);
		assertEquals(selectUnusableController.getI(), 0);
		assertEquals(selectUnusableController.getJ(), 0);
		
	}
	
	public void testTileGeneratorController() {
		
		int countdown = 0;
		int goalscore[] = {2,2,2,2,2,2};
		int multProb[] = {2,2,2};
		int valProb[] = {2,2,2,2,2,2};
		Level lv = new Level(new Board(), new Mode(gameMode.PUZZLE, countdown), goalscore);
		
		TileGeneratorController tileGeneratorController = new TileGeneratorController(lv, gameWindow);
		tileGeneratorController.createTileQueue();
		
	}
	
	public void testProbabilityController() {
		
		int countdown = 0;
		int goalscore[] = {2,2,2,2,2,2};
		int multProb[] = {2,2,2};
		int valProb[] = {2,2,2,2,2,2};
		Level lv = new Level(new Board(), new Mode(gameMode.PUZZLE, countdown), goalscore);

		TileProbabilityController tileProbabilityController = new TileProbabilityController(lv, gameWindow.getLevelBuilderView());
		
		tileProbabilityController.updateProbability(1, 2, 2);
		assertEquals(tileProbabilityController.getIndex(), 1);
		assertEquals(tileProbabilityController.getProb(), 2);
		assertEquals(tileProbabilityController.getPreProb(), 2);
		
		tileProbabilityController.undo();
		tileProbabilityController.redo();
		
	}
	
	public void testTextFieldAdapter() {
		
		JTextField jText = new JTextField();
		TextFieldAdapter testFieldAdapter = new TextFieldAdapter(gameWindow, jText, 0);
		
		@SuppressWarnings("deprecation")
		KeyEvent e = new KeyEvent(gameWindow.getLevelBuilderView(), 0, System.currentTimeMillis(), 0, 0);
		testFieldAdapter.keyPressed(e);
		
		
	}
	
	public void testTextFieldAdapterCountdown() {
		
		JTextField jText = new JTextField();
		TextFieldAdapterCountdown textFieldAdapterCountdown = new TextFieldAdapterCountdown(gameWindow, jText);
		//textFieldAdapterCountdown.setProb();
		
		@SuppressWarnings("deprecation")
		KeyEvent e = new KeyEvent(gameWindow.getLevelBuilderView(), 0, System.currentTimeMillis(), 0, 0);
		textFieldAdapterCountdown.keyPressed(e);
		
	}
	
	
	public void testTextFieldAdapterMultProb() {
		
		JTextField jText = new JTextField();
		TextFieldAdapterMultProb textFieldAdapterMultProb = new TextFieldAdapterMultProb(gameWindow, jText, 2);
		//textFieldAdapterMultProb.setProb();
		
		@SuppressWarnings("deprecation")
		KeyEvent e = new KeyEvent(gameWindow.getLevelBuilderView(), 0, System.currentTimeMillis(), 0, 0);
		textFieldAdapterMultProb.keyPressed(e);
		
	}
	
	public void testTextFieldAdapterScore() {
		
		JTextField jText = new JTextField();
		TextFieldAdapterScore textFieldAdapterScore = new TextFieldAdapterScore(gameWindow, jText, 2);
		//textFieldAdapterScore.setProb();
		
		@SuppressWarnings("deprecation")
		KeyEvent e = new KeyEvent(gameWindow.getLevelBuilderView(), 0, System.currentTimeMillis(), 0, 0);
		textFieldAdapterScore.keyPressed(e);
		
	}
	
	
	
}
