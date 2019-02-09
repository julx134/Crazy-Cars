package game;

import java.awt.Color;
import java.awt.Graphics;

//Asphalt type class
class Asphalt extends ObjectDraw {

	// variables that will be used in the objects
	public int  size, sizeY;
	public Color col;

	// constructor
	public Asphalt(int x, int y, int size, int speedY) {
		/*
		 * initializes the variable
		 */
		// borrows the values from parent class
		super(x, y, speedY);
		this.col = Color.WHITE;
		this.size = size;
		this.sizeY = size * 4;
	}

	// overload -- for inner stripes
	public Asphalt(int x, int y, int size, int sizeY, int speedY) {
		/*
		 * initializes the variable
		 */
		// borrows the values from parent class
		super(x, y, speedY);
		this.col = Color.WHITE;
		this.size = size;
		this.sizeY = sizeY;
	}

	// draws asphalt description/method
	@Override
	public void draw(Graphics g) {
		// draws the stripes
		g.setColor(col);
		g.fillRect(x, y, size, sizeY);
		// draws the grass
		g.setColor(new Color(88, 190, 48));
		g.fillRect(0, 0, 200, 1000);
		g.fillRect(775, 0, 250, 1000);
		// draws the boundaries
		g.setColor(Color.WHITE);
		g.fillRect(200, 0, 5, 1000);
		g.fillRect(775, 0, 5, 1000);

	}
}