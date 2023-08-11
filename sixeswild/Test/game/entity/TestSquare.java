package game.entity;

import game.entity.Square;
import game.entity.Tile;
import junit.framework.TestCase;

import junit.framework.TestCase;

public class TestSquare extends TestCase {
	
		Square testSquare;
		protected void setUp() throws Exception {
			super.setUp();
			testSquare = new Square(1,1);
		}

		protected void tearDown() throws Exception {
			super.tearDown();
		}
		public void testSimple() {
			assertEquals(true, testSquare.isEmpty());
			
			Tile testTile = new Tile(1,1);
			
			assertEquals(null, testSquare.getTile());
			
			testSquare.setTile(testTile);
			
			assertEquals(testTile, testSquare.getTile());
			
			testSquare.destroyTile();
			
			assertEquals(null, testSquare.getTile());
			
		}
}
