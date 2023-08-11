package game.entity;

import game.entity.Mode;
import game.entity.Mode.gameMode;
import junit.framework.TestCase;

public class TestMode extends TestCase {
	
	Mode mode1;
	Mode mode2;
	Mode mode3;
	Mode mode4;
	protected void setUp() throws Exception {
		super.setUp();
		mode1 = new Mode(gameMode.PUZZLE,0);
		mode2 = new Mode(gameMode.LIGHTNING,0);
		mode3 = new Mode(gameMode.ELIMINATION,0);
		mode4 = new Mode(gameMode.RELEASE,0);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	public void testCase1 () {
		assertTrue(mode1.isPuzzle());
		assertFalse(mode1.isElimination());
		
		assertTrue(mode2.isLightning());
		assertFalse(mode2.isElimination());
		
		assertTrue(mode3.isElimination());
		assertFalse(mode3.isPuzzle());
		
		assertTrue(mode4.isRelease());
		assertFalse(mode4.isLightning());
		assertFalse(mode1.isRelease());
	}
	
	public void testCase2 () {
		mode1.decrement();
		mode2.decrement();
		mode3.decrement();
		mode4.decrement();
		
		assertEquals(0,mode1.getCountdown());
		assertEquals(0,mode2.getCountdown());
		assertEquals(0,mode3.getCountdown());
		assertEquals(0,mode4.getCountdown());
	}
}
