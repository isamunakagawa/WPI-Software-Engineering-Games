package game.entity;

import game.entity.Board;
import game.entity.Level;
import game.entity.Mode;
import game.entity.Mode.gameMode;
import junit.framework.TestCase;

public class TestLevel extends TestCase {
	
	Level level;
	Board board;
	int goals[];
	Mode mode;
	TileGenerator tileGen;
	protected void setUp() throws Exception {
		super.setUp();
		int multProb[] = {2,2,2};
		int valProb[] = {2,2,2,2,2,2};
		tileGen = new TileGenerator(multProb, valProb);
		board = new Board(1, tileGen);
		goals = new int[3];
		mode = new Mode(gameMode.PUZZLE, 1);
		level = new Level(board, mode, goals);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testCaseSimple() {
		level.increaseScore(50);
		assertEquals(50, level.getScore());
		
		int countdown = level.getMode().getCountdown();
		level.useResetMove();
		assertEquals(countdown - 1, level.getMode().getCountdown());
		
	}
	public void testGoalsMet() {
		goals[0] = 30;
		goals[1] = 40;
		goals[2] = 90;
		level.increaseScore(31);
		assertEquals(1,level.goalsMet());
		
		level.increaseScore(21);
		assertEquals(2,level.goalsMet());
		
		level.increaseScore(40);
		assertEquals(3,level.goalsMet());
		
		level.resetScore();
		assertEquals(0,level.getScore());
		
		level.increaseScore(-30);
		assertEquals(0,level.getScore());
		
		assertEquals(0,level.goalsMet());
	}
	
	public void testRemovePower() {
		level.useRemoveMove();
		assertEquals(0, level.getRemoveNum());
		level.useRemoveMove();
		assertEquals(0, level.getRemoveNum());
		
		level.incrementRemove();
		assertEquals(1, level.getRemoveNum());
	}
	
	public void testSwapPower() {
		level.useSwapMove();
		assertEquals(0, level.getSwapNum());
		level.useSwapMove();
		assertEquals(0, level.getSwapNum());
		
		level.incrementSwap();
		assertEquals(1, level.getSwapNum());
	}
			
}
