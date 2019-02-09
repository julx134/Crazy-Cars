package game;

import java.awt.Graphics;

/*
 * Inheritance class that is used as a parent class for objects to be drawn
 * Used for graphics
 */
public class ObjectDraw {
	// variables that will be used in the objects
	public int speedY, x, y;
	
	
	//constructor
	ObjectDraw(int x, int y, int speedY) {
		this.x = x;
		this.y = y;
		this.speedY = speedY;
	}
	
	//method to draw
	public void draw (Graphics g) {
		/*
		 * Empty to be used for objects using @Override
		 */
	}

}
