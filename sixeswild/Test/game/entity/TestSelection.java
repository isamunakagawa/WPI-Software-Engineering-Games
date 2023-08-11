package game.entity;

import game.entity.Selection;
import game.entity.Tile;
import junit.framework.TestCase;

public class TestSelection extends TestCase {
	Selection testSelection;
	protected void setUp() throws Exception {
		super.setUp();
		testSelection = new Selection();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	public void testCase1 (){
		assertTrue(testSelection.getTiles().isEmpty());
		Tile tile = new Tile(1,1);
		Tile tile2 = new Tile(1,1);
		Tile tile3 = new Tile(1,2);
		Tile tile4 = new Tile(1,3);
		Tile tile5 = new Tile(1,2);
		Tile tile6 = new Tile(1,1);
		testSelection.addTile(tile);
		assertFalse(testSelection.getTiles().isEmpty());
		
		assertEquals(1,testSelection.sumTiles());
		
		testSelection.addTile(tile2);
		testSelection.addTile(tile3);
		testSelection.addTile(tile4);
		testSelection.addTile(tile5);
		testSelection.addTile(tile6);
		assertTrue(testSelection.checkForSix());
		assertEquals(720, testSelection.calculateScore());
		
		testSelection.clearCollection();
		assertTrue(testSelection.getTiles().isEmpty());
		
		
	}
}
