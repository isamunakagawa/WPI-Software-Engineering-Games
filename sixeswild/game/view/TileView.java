package game.view;
import game.entity.Tile;

import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * Tile views associated with a tile.
 * 
 * 
 *
 */

public class TileView {
	/** The coordinates associated with a tile.*/
	int x,y;
	
	/** The tile being represented as a tileView.*/
	protected Tile tile;
	
	/**
	 * View constructor that creates a tile view object.
	 * @param r
	 * @param c
	 */
	public TileView(int r, int c) {
		this.x = c;
		this.y = r;
	}
	
	/** Spacing between each drawn rectangle.*/
	public static int spacing = 5;
	
	/** Length and width of the rectangle.*/
	public static int size = 45;
	
	/**
	 * Paints the value of the tile with respect to
	 * the board View.
	 * @param g
	 * @param boardX
	 * @param boardY
	 * @param i
	 */
	public void paintString(Graphics g, int boardX, int boardY, int i) {
		Graphics2D g2 = (Graphics2D)g;
		/*
		switch (i){
        case 1:
            g2.setColor(Color.black);
            break;
        case 2:
            g2.setColor(Color.blue);
            break;
        case 3:
            g2.setColor(Color.green);
            break;
        case 4:
            g2.setColor(Color.red);
            break;
        case 5:
            g2.setColor(Color.yellow);
            break;
        case 6:
            g2.setColor(Color.cyan);
            break;
        default:
            g2.setColor(Color.white);
            
         	}

        String s = Integer.toString(i);
        g2.drawString(s, x*(size + spacing)+boardX + size/2, y*(size + spacing)+boardY + size/2);
        g2.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        */
		
	}
	
	/** Returns the tile associated with the view.*/
	public Tile getTile() {
		return this.tile;
	}
		
	
}
