package levelbuilder.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import levelbuilder.entities.Square;


public class SquareView {
	/** Coordinates of the square view object. */
	int row, col;

	/** Square being represented in the view. */
	protected Square square;

	/** Spacing between components. */
	public static int spacing = 5;

	/** Size of the drawn square. */
	public static int size = 45;

	private Graphics2D g2;

	private static final long serialVersionUID = 1L;
	protected Color highlight;

	/**
	 * SquareView constructor that creates a square view object with an x and y
	 * coordinate with respect to board view.
	 * 
	 * @param x
	 *            , x-coordinate or column.
	 * @param y
	 *            , y-coordinate or row.
	 */
	public SquareView(int row, int col, Square square) {
		this.row = row;
		this.col = col;
		this.square = square;
		setupColors();

	}

	/**
	 * Draws a rectangle with respect to given coordinates.
	 * 
	 * @param g
	 *            , graphic.
	 * @param boardX
	 * @param boardY
	 */
	
	public void paintComponent(Graphics g, int boardX, int boardY) {
		Graphics2D g2 = (Graphics2D) g;
		
		Color temp = g2.getColor();
		g2.setColor(highlight);
		g2.fillRect(col * (size + spacing) + boardX, row * (size + spacing) + boardY, size, size);
		g2.setColor(Color.black);
		if (square.getActive() && (!square.isEmpty())){
			String s = Integer.toString(square.getTile().getValue()); 
			g2.setFont(new Font("Arial", Font.BOLD, 20));
			g2.drawString(s, col*(size + spacing) + boardX - 4 + size/2, row*(size + spacing) + boardY + 4 + size/2);
			String m = Integer.toString(square.getTile().getMultiplier()); 
			g2.setFont(new Font("Arial", Font.BOLD, 11));
			g2.drawString("x"+m, col*(size + spacing) + boardX + 7 + size/2, row*(size + spacing) + boardY + 16 + size/2);
		}
		g2.setColor(temp);

	}

	public void setupColors() {
		if (!square.getActive()){
		System.out.println("inactive: " + this.row + this.col);
		}
		else if(square.getBucket()){
			System.out.println("bucket: " + this.row + this.col);
		}
		else if (square.getActive()){
			System.out.println("active: " + this.row + this.col + " score: " + this.square.getTile().getValue());
		}
		if (!square.getActive()){
			highlight = (Color.white);
		}
		else if (square.getBucket()){
			highlight = (Color.orange);
		}
		else{
		switch (square.getTile().getValue()) {
		case 1:
			highlight = (new Color(242, 121, 238));
			break;
		case 2:
			highlight = (new Color(252, 227, 0));
			break;
		case 3:
			highlight = (new Color(0, 219, 20));
			break;
		case 4:
			highlight = (new Color(214, 139, 0));
			break;
		case 5:
			highlight = (new Color(114, 0, 191));
			break;
		case 6:
			highlight = (Color.red);
			break;
		default:
			highlight = (Color.white);
		}
		/*if (!square.getActive()){
			highlight = (Color.black);
		}
		else if (square.getBucket()){
			highlight = (Color.green);
		}*/
		}
	}

	public void setBackground(Color colorChange) {
		this.highlight = colorChange;

	}

	public Color getBackground() {
		return highlight;
	}

	/** Returns the square associated with the view. */
	public Square getSquare() {
		return this.square;
	}

}
