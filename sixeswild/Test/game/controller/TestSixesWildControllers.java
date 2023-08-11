package game.controller;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.MouseEvent;

import game.entity.Board;
import game.entity.Level;
import game.entity.LightningTimer;
import game.entity.Mode;
import game.entity.Square;
import game.entity.Tile;
import game.entity.TileGenerator;
import game.entity.Mode.gameMode;
import game.view.GameViewApplication;
import game.view.LevelView;
import junit.framework.TestCase;


public class TestSixesWildControllers extends SWTestCase {
	
	protected GameViewApplication gameWindow;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		gameWindow = new GameViewApplication();
		gameWindow.getAppFrame().setVisible(true);
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testExitLevelController() {
		
		assertTrue(gameWindow.getAppFrame().getComponentCount() == 1);

		ExitLevelController exitLevelController = new ExitLevelController(gameWindow);
		exitLevelController.exitLevel();
		
	}
	
	public void testExitLevelSelectController() {
		
		ExitLevelSelectController exitLevelSelectController = new ExitLevelSelectController(gameWindow);
		exitLevelSelectController.exitLevelSelect();
		
	}
	
	public void testMoveController() {
		
		MouseEvent press = this.createPressed(gameWindow.getLevelView().getBoardView(), 10, 10);
		
		int countdown = 0;
		int goalscore[] = {2,2,2,2,2,2};
		int multProb[] = {2,2,2};
		int valProb[] = {2,2,2,2,2,2};
		Level lv = new Level(new Board(new TileGenerator(multProb, valProb )), new Mode(gameMode.PUZZLE, 1), goalscore);
		MoveController mc = new MoveController(lv, gameWindow.getLevelView(), gameWindow);
		mc.mousePressed(press);
		
		assertTrue(mc.squareCol == 0);
		assertTrue(mc.squareRow == 0);
		
		press = this.createPressed(gameWindow.getLevelView().getBoardView(), 50, 50);
		mc.mousePressed(press);
		
		assertTrue(mc.squareCol == 1);
		assertTrue(mc.squareRow == 1);
		
		assertTrue(mc.bv.getSquare(1, 1) == mc.currentSquare);
		
		MouseEvent release = this.createReleased(gameWindow.getLevelView().getBoardView(), 20, 20);
		mc.mouseDragged(release);
		
		release = this.createReleased(gameWindow.getLevelView().getBoardView(), 40, 40);
		mc.mouseDragged(release);
		
		MouseEvent dragged = this.createPressed(gameWindow.getLevelView().getBoardView(), 20, 20);
		mc.mousePressed(dragged);
		dragged = this.createPressed(gameWindow.getLevelView().getBoardView(), 20, 35);
		mc.mousePressed(dragged);
		dragged = this.createPressed(gameWindow.getLevelView().getBoardView(), 20, 45);
		mc.mousePressed(dragged);
		dragged = this.createPressed(gameWindow.getLevelView().getBoardView(), 20, 35);
		mc.mousePressed(dragged);
		dragged = this.createPressed(gameWindow.getLevelView().getBoardView(), 35, 35);
		mc.mousePressed(dragged);
		dragged = this.createReleased(gameWindow.getLevelView().getBoardView(), 35, 45);
		mc.mousePressed(dragged);
		
		
		press = this.createPressed(gameWindow.getLevelView().getBoardView(), -100, -100);
		mc.mousePressed(press);
		press = this.createPressed(gameWindow.getLevelView().getBoardView(), 10, 10);
		mc.mousePressed(press);
		release = this.createReleased(gameWindow.getLevelView().getBoardView(), -20, -20);
		mc.mouseReleased(release);
		
		
		
		
	}
	
	public void testPuzzleMove() {
		
		MouseEvent press = this.createPressed(gameWindow.getLevelView().getBoardView(), 10, 10);
		
		int countdown = 0;
		int goalscore[] = {2,2,2,2,2,2};
		int multProb[] = {2,2,2};
		int valProb[] = {2,2,2,2,2,2};
		Level lv = new Level(new Board(new TileGenerator(multProb, valProb )), new Mode(gameMode.PUZZLE, 1), goalscore);
		MoveController mc = new MoveController(lv, gameWindow.getLevelView(), gameWindow);
		mc.mousePressed(press);
		
		assertTrue(mc.puzzleMove.selection.getTiles().get(0) == mc.currentSquare.getTile());
		
	}
	
	public void testProgressBarController() {
	
		int countdown = 0;
		int goalscore[] = {2,2,2,2,2,2};
		int multProb[] = {2,2,2};
		int valProb[] = {2,2,2,2,2,2};
		Level lv = new Level(new Board(new TileGenerator(multProb, valProb )), new Mode(gameMode.PUZZLE, 1), goalscore);
		
		ProgressBarController progressBarController = new ProgressBarController(lv, gameWindow.getLevelView());
		
		lv.increaseScore(2000);
		progressBarController.updateBar();
		
		assertTrue(gameWindow.getLevelView().getGoalScoreLabels()[2].isVisible());
		
	}
	
	public void testSwapTilePowerUp() {
		
		MouseEvent press = this.createPressed(gameWindow.getLevelView().getBoardView(), 10, 10);
		
		int countdown = 0;
		int goalscore[] = {2,2,2,2,2,2};
		int multProb[] = {2,2,2};
		int valProb[] = {2,2,2,2,2,2};
		Level lv = new Level(new Board(new TileGenerator(multProb, valProb )), new Mode(gameMode.PUZZLE, 1), goalscore);
		MoveController mc = new MoveController(lv, gameWindow.getLevelView(), gameWindow);
		mc.mousePressed(press);
		
		Square sq1 = mc.currentSquare;
		
		SwapPowerUp swapPowerUp = new SwapPowerUp(mc.currentSquare);
		
		press = this.createPressed(gameWindow.getLevelView().getBoardView(), 10, 10);
		mc.mousePressed(press);
		
		Square sq2 = mc.currentSquare;
		swapPowerUp.squareToSwap(sq2);
		
		swapPowerUp.swap();
		
		press = this.createPressed(gameWindow.getLevelView().getBoardView(), 10, 10);
		mc.mousePressed(press);
		
		assertEquals(mc.currentSquare, sq2);
		
	}
	
	public void testRemoveTilePowerUp() {
		
		MouseEvent press = this.createPressed(gameWindow.getLevelView().getBoardView(), 10, 10);
		
		int countdown = 0;
		int goalscore[] = {2,2,2,2,2,2};
		int multProb[] = {2,2,2};
		int valProb[] = {2,2,2,2,2,2};
		Level lv = new Level(new Board(new TileGenerator(multProb, valProb )), new Mode(gameMode.PUZZLE, 1), goalscore);
		MoveController mc = new MoveController(lv, gameWindow.getLevelView(), gameWindow);
		mc.mousePressed(press);
		
		Square sq1 = mc.currentSquare;
		assertTrue(mc.currentSquare.equals(sq1));
		
		RemoveTilePowerUp removeTilePowerUp = new RemoveTilePowerUp(lv, gameWindow.getLevelView().getBoardView(), mc.currentSquare);
		removeTilePowerUp.RemovePowerUp();
		
		assertFalse(lv.isRemoveActive());
		
	}
	
	public void testRemoveButtonAction() {
		
		int countdown = 0;
		int goalscore[] = {2,2,2,2,2,2};
		int multProb[] = {2,2,2};
		int valProb[] = {2,2,2,2,2,2};
		Level lv = new Level(new Board(new TileGenerator(multProb, valProb )), new Mode(gameMode.PUZZLE, 1), goalscore);

		RemoveButtonAction removeButtonAction = new RemoveButtonAction(lv, gameWindow.getLevelView());
		
	}
	
	public void testShufflePowerUp() {
		
		int countdown = 0;
		int goalscore[] = {2,2,2,2,2,2};
		int multProb[] = {2,2,2};
		int valProb[] = {2,2,2,2,2,2};
		Level lv = new Level(new Board(new TileGenerator(multProb, valProb )), new Mode(gameMode.PUZZLE, 1), goalscore);
		MoveController mc = new MoveController(lv, gameWindow.getLevelView(), gameWindow);
		
		countdown = lv.getMode().getCountdown();
		
		ShuffleBoardPowerUp shuffleBoardPowerUp = new ShuffleBoardPowerUp(lv, gameWindow.getLevelView());
		shuffleBoardPowerUp.ShuffleBoard();
		
		assertTrue( (countdown - 1) == lv.getMode().getCountdown());
		
	}
	
	public void testLightningTimerController() {
		
		int countdown = 1;
		LightningTimerController lightningTimerController = new LightningTimerController(countdown, gameWindow.getLevelView());
		assertEquals(countdown, lightningTimerController.countdown);
		
	}
	
	public void testSplashScreenToLevelController() {
	
		SplashScreenToLevelController screenToLevelController = new SplashScreenToLevelController(gameWindow);
		screenToLevelController.switchView(1);
		
		assertFalse(gameWindow.getSplashScreenView().isVisible());
		
	}
	
	public void testSplashScreenToLevelSelectController() {
		
		SplashScreenToLevelSelectController screenToLevelController = new SplashScreenToLevelSelectController(gameWindow);
		
		gameWindow.getLevelSelectView().setVisible(false);
		assertEquals(false, gameWindow.getLevelSelectView().isVisible());
		screenToLevelController.switchPanels();
		assertEquals(true, gameWindow.getLevelSelectView().isVisible());

	}
	
	public void testScoreController() {
	
		
		int countdown = 0;
		int goalscore[] = {2,2,2,2,2,2};
		int multProb[] = {2,2,2};
		int valProb[] = {2,2,2,2,2,2};
		Level lv = new Level(new Board(new TileGenerator(multProb, valProb )), new Mode(gameMode.PUZZLE, 1), goalscore);
		
		lv.increaseScore(10);
		assertEquals(10, lv.getScore());
		
		ScoreController scoreController = new ScoreController(gameWindow.getLevelView(), lv );
		scoreController.update();
		
		int score = Integer.parseInt(gameWindow.getLevelView().getScoreLabel().getText());
		assertEquals(10, score);
	
	}
	
	public void testLoadController() {
		
		LoadController loadController = new LoadController();
		
	}
	
	public void testCompleteEliminationController() {
		
		int countdown = 0;
		int goalscore[] = {2,2,2,2,2,2};
		int multProb[] = {2,2,2};
		int valProb[] = {2,2,2,2,2,2};
		Level lv = new Level(new Board(new TileGenerator(multProb, valProb )), new Mode(gameMode.PUZZLE, 1), goalscore);
		
		CompleteEliminationController completeEliminationController = new CompleteEliminationController(lv, gameWindow);
		
	}
	
	public void testCompletePuzzleController() {
		
		int countdown = 0;
		int goalscore[] = {2,2,2,2,2,2};
		int multProb[] = {2,2,2};
		int valProb[] = {2,2,2,2,2,2};
		Level lv = new Level(new Board(new TileGenerator(multProb, valProb )), new Mode(gameMode.PUZZLE, 1), goalscore);
		
		CompletePuzzleController completePuzzleController = new CompletePuzzleController(gameWindow.getLevelView(), lv, gameWindow);
		
	}
	
	public void testRecordsController() {
		
		RecordsController recordsController = new RecordsController();
		
	}

	public void testGravity() {
		int countdown = 0;
		int i;
		int goalscore[] = {2,2,2,2,2,2};
		int multProb[] = {2,2,2};
		int valProb[] = {2,2,2,2,2,2};
		Square currentSq;
		Level lv = new Level(new Board(1, new TileGenerator(multProb, valProb)), new Mode(gameMode.PUZZLE, 1), goalscore);
		
		Square beginningSq = lv.getBoard().getSquare(8, 2);
		
		assertEquals(1,beginningSq.getTile().getValue());
		for (i = 0; i<6; i++) {
			assertEquals(1,lv.getBoard().getSquare(8, i+2).getTile().getValue());
		}
		PuzzleMove pz = new PuzzleMove(beginningSq.getTile(), beginningSq);
		
		for (i = 0; i<6; i++) {
			currentSq = lv.getBoard().getSquare(8, i+2);
			pz.addToSqSelection(currentSq);
			pz.addToSelection(currentSq.getTile());
		}
		
		GravityUpdateMove gum = new GravityUpdateMove(lv.getBoard(), pz.selection);
		gum.gravity();
		assertEquals(2,lv.getBoard().getSquare(8, 2).getTile().getValue());

		for (i = 0; i<6; i++) {
			assertEquals(2,lv.getBoard().getSquare(8, i+2).getTile().getValue());
		}
	}
	
	public void testVertGravity() {
		int countdown = 0;
		int i;
		int goalscore[] = {2,2,2,2,2,2};
		int multProb[] = {2,2,2};
		int valProb[] = {2,2,2,2,2,2};
		Square currentSq;
		Level lv = new Level(new Board(1, new TileGenerator(multProb, valProb)), new Mode(gameMode.PUZZLE, 1), goalscore);
		
		Square beginningSq = lv.getBoard().getSquare(8, 2);
		PuzzleMove pz = new PuzzleMove(beginningSq.getTile(), beginningSq);
		
		for (i = 7; i>4; i--) {
			currentSq = lv.getBoard().getSquare(i, 2);
			pz.addToSqSelection(currentSq);
			pz.addToSelection(currentSq.getTile());
		}
		
		assertTrue(pz.selection.checkForSix());
		
		GravityUpdateMove gum = new GravityUpdateMove(lv.getBoard(), pz.selection);
		gum.gravity();
		
		assertEquals(1, lv.getBoard().getSquare(8, 2).getTile().getValue());
	}
}
