package game.entity;

import game.entity.Tile;
import junit.framework.TestCase;

public class TestTile extends TestCase {
	Tile testTile;
	protected void setUp() throws Exception {
		super.setUp();
		testTile = new Tile(1,1);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	public void testSimple() {
		assertEquals(1, testTile.getMultiplier());
		assertEquals(1, testTile.getValue());
	}
	
	public void testExceptions () {
		try {
			Tile errorTile = new Tile(-1, 11);
			fail("Did not throw exception");
		} 
		catch (RuntimeException e) {
			assertEquals(e.getMessage(), "invalid score");
		}
		try {
			Tile errorTile = new Tile(11, -1);
			fail("Did not throw exception");
		} 
		catch (RuntimeException e) {
			assertEquals(e.getMessage(), "invalid multiplier");
		}
	}
	
}
