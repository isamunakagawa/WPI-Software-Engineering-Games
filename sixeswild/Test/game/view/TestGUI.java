package game.view;

import javax.swing.JFrame;

import junit.framework.TestCase;

/**
 * 
 * @author Isamu Nakagawa
 *
 */

public class TestGUI extends TestCase {

	public void testGUI(){
		GameViewApplication game = new GameViewApplication();
		
		assertTrue( game.getAppFrame() instanceof JFrame);
		assertTrue( game.getLevelSelectView() instanceof LevelSelectView);
		assertTrue( game.getSplashScreenView() instanceof SplashScreenView);
		assertTrue( game.getLevelView() instanceof LevelView);
		assertTrue( game.getBoardView() instanceof BoardView);
	}
}
