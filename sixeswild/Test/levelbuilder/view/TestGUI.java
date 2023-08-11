package levelbuilder.view;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import levelbuilder.entities.Board;
import levelbuilder.entities.Level;
import levelbuilder.entities.Mode;
import levelbuilder.entities.Mode.gameMode;
import levelbuilder.entities.Square;
import levelbuilder.entities.Tile;
import levelbuilder.view.LevelBuilderView;
import levelbuilder.view.SplashScreenView;

import javax.swing.JFrame;

import junit.framework.TestCase;

/**
 * 
 * @author Isamu Nakagawa
 *
 */

public class TestGUI extends TestCase {

	public void testGUI() {

		Application app = new Application();

		assertTrue(app.getAppFrame() instanceof JFrame);
		assertTrue(app.getNewLevelBuilderView() instanceof LevelBuilderView);
		assertTrue(app.getLevelBuilderView() instanceof LevelBuilderView);

		assertTrue(app.getNewSplashScreenView() instanceof SplashScreenView);
		assertTrue(app.getSplashScreenView() instanceof SplashScreenView);
		int countdown = 0;
		int goalscore[] = { 2, 2, 2, 2 };
		int multProb[] = { 2, 2, 2};
		int valProb[] = { 2, 2, 2, 2, 2 };
		Level lv = new Level(new Board(), new Mode(gameMode.PUZZLE, countdown),
				goalscore);

		assertTrue(app.getNewLevelView(app.getLevelBuilderView().getLevel()) instanceof LevelView);
		assertTrue(app.getLevelView() instanceof LevelView);

		try {
			Robot robot = new Robot();

			robot.keyPress(KeyEvent.VK_NUMPAD1);
			robot.keyRelease(KeyEvent.VK_NUMPAD1);
			
		} catch (AWTException e) {
			e.printStackTrace();
		}
		
		Square s = new Square(0, 0);
		Tile t = new Tile(1, 1);
		s.setTile(t);
		SquareView squareView = new SquareView(0, 0, s);
		squareView.getBackground();
		squareView.getSquare();
		squareView.getBackground();
		squareView.setupColors();

	}

}
