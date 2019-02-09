package game;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class EnemyCar extends ObjectDraw {
	
	// variables to be used for the car
	public int height = 75;
	public int width = 50;
	public Color color;

	// constructor
	public EnemyCar(int x, int y, int speedY,Color color) {
		// borrows the values from parent class
		super(x, y, speedY);
		this.color = color;

	}

	public void getColor(int type) {

	}

	// draws enemy cars description/method
	public void draw(Graphics g) {
		/*
		 * arrays for the windshield polygons has to be inside the draw function because
		 * relative location has not been initialized
		 */
		int[] xPoints = { x + 5, x + width - 5, x + width - 10, x + 10 };
		int[] yPoints = { y + 25, y + 25, y + 35, y + 35 };

		int[] xPointsTwo = { x + 2, x + 7, x + 7, x + 2 };
		int[] yPointsTwo = { y + 27, y + 35, y + 50, y + 52 };

		int[] xPointsThree = { x + width - 2, x + width - 7, x + width - 7, x + width - 2 };
		int[] yPointsThree = { y + 27, y + 35, y + 50, y + 52 };
		
		int[] xPointsFour = { x + width - 10, x + 10, x + 5, x + width - 5, };
		int[] yPointsFour = { y + 50, y + 50, y + 60, y + 60 };

		// draws the wheels
		g.setColor(Color.BLACK);
		// right wheels
		g.fillRect(x + 43, y + 50, 10, 20);
		g.fillRect(x + 43, y + 5, 10, 20);
		// left wheels
		g.fillRect(x - 3, y + 50, 10, 20);
		g.fillRect(x - 3, y + 5, 10, 20);
		// draws the car
		g.setColor(color);
		g.fillRect(x, y, width, height);
		//draws outline
		g.setColor(Color.BLACK);
		g.drawRect(x, y, width, height);
		// draws the windshields
		g.setColor(new Color(102, 194, 255));
		g.fillPolygon(xPoints, yPoints, 4);
		g.fillPolygon(xPointsTwo, yPointsTwo, 4);
		g.fillPolygon(xPointsThree, yPointsThree, 4);
		g.fillPolygon(xPointsFour, yPointsFour, 4);
		//draws outline
		g.setColor(Color.BLACK);
		g.drawPolygon(xPoints, yPoints, 4);
		g.drawPolygon(xPointsTwo, yPointsTwo, 4);
		g.drawPolygon(xPointsThree, yPointsThree, 4);
		g.drawPolygon(xPointsFour, yPointsFour, 4);
	}

	// method that draws an imaginary rectangle around the cars
	public Rectangle getBounds() {
		// used in Collision class
		return new Rectangle(x, y, width, height);
	}
}
