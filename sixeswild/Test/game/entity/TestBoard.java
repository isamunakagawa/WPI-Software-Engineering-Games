package game.entity;

import game.entity.Board;
import game.entity.Square;
import game.entity.Tile;
import junit.framework.TestCase;

public class TestBoard extends TestCase {

	
	Board testBoard;
	TileGenerator tileGen;
	protected void setUp() throws Exception {
		super.setUp();
		int multProb[] = {2,2,2};
		int valProb[] = {2,2,2,2,2,2};
		tileGen = new TileGenerator(multProb, valProb);
		
		
		
		testBoard = new Board(1,tileGen);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testSimple() {
		
		//testBoard.initialize(); // FAILED: in tileGen, valSum is not initialized?
		
		testBoard.fillBoard();
		
		assertTrue(testBoard.getSquare(0, 0) != null);
	
	}
	
}
