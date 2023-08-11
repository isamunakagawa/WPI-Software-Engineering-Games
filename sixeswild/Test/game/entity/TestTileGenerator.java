package game.entity;


import junit.framework.TestCase;

public class TestTileGenerator extends TestCase {

	public void testTileGenerator(){
		int multProb[] = {0,0,1};
		int valProb[] = {0,0,0,0,0,1};
		
		TileGenerator tileGen = new TileGenerator(multProb, valProb);
		
		Tile tile = tileGen.makeNewTile();
		
		assertEquals(6, tile.getValue());
		assertEquals(3, tile.getMultiplier());
	}
}
