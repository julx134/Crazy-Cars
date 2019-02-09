package game;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameFunction {
	// creates objects list for the classes that will be used
	public static List<Asphalt> asphalts = new ArrayList<Asphalt>();
	public static List<Vegetation> vegetations = new ArrayList<Vegetation>();
	public static List<EnemyCar> enemyCars = new ArrayList<EnemyCar>();

	// Random object for use on xPos and yPos of trees/bush
	Random rand = new Random();

	// the speed of the game
	public int gameSpeed = 25;
	// difficulty of the game corresponds with how many enemyCars
	public int numCars = 8;

	// constructor that initialize classes and objects for the game
	public GameFunction() {

		/*
		 * initialize object of type Asphalt into list using nest for loop
		 * 
		 */
		// outer stripes
		// outer loop runs through the row of the stripes
		for (int x = 1; x <= 2; x++) {
			// inner loop runs through the col of the the stripes
			for (int y = 1; y <= 4; y++) {
				// if statements for visual effect (left and rightside)
				if (x == 1) {
					asphalts.add(new Asphalt(250 * x - 25, y * (-300), 30, gameSpeed - 10));
				} else if (x == 2) {
					asphalts.add(new Asphalt(250 * (x + 1) - 25, y * (-300), 30, gameSpeed - 10));
				}
			}
		}

		// inner stripes
		// outer loop runs through the row of the stripes
		for (int x = 1; x <= 1; x++) {
			// inner loop runs through the col of the the stripes
			for (int y = 1; y <= 8; y++) {
				asphalts.add(new Asphalt(250 * (x + 1) - 10, y * (-300), 10, 70, gameSpeed - 10));
			}
		}

		/*
		 * initialize object of type Vegetation into list using nested for loop
		 */
		// outer loop runs through the row of the vegetation
		for (int x = 1; x <= 2; x++) {
			// inner loop runs through the col of the the vegetation
			for (int y = 1; y <= 1; y++) {
				// if statements for visual effect (left and right side)
				// left side
				if (x == 1) {
					// Random variable for random trees/bushes
					int n1 = rand.nextInt(150) + 50;
					// first tree
					vegetations.add(new Vegetation(150 * x - n1, y * (-200), gameSpeed, 1));

					// Random variable for random trees/bushes
					int n2 = rand.nextInt(150) + 50;
					// second tree
					vegetations.add(new Vegetation(150 * x - n2, y * (-400), gameSpeed, 2));

					// Random variable for random trees/bushes
					int n3 = rand.nextInt(150) + 50;
					// bush
					vegetations.add(new Vegetation(150 * x - n3, y * (-400), gameSpeed, 3));
				}
				// right side
				else if (x == 2) {
					// Random variable for random trees/bushes
					int n1 = rand.nextInt(175) + 75;
					// first tree
					vegetations.add(new Vegetation(350 * x + n1, y * (-200), gameSpeed, 1));

					// Random variable for random trees/bushes
					int n2 = rand.nextInt(175) + 75;
					// second tree
					vegetations.add(new Vegetation(350 * x + n2, y * (-400), gameSpeed, 2));

					// Random variable for random trees/bushes
					int n3 = rand.nextInt(175) + 75;
					// bush
					vegetations.add(new Vegetation(350 * x + n3, y * (-400), gameSpeed, 3));
				}
			}
		}

		/*
		 * initialize object of type EnemyCar into list using loop
		 */
		for (int x = 0; x < numCars; x++) {
			/*
			 * Randomizes the spawn of enemy cars
			 */
			// inside the bracket is the max value and the value to add is minimum
			int xPos = rand.nextInt(530) + 200;
			// inside the bracket is the max value and the value to add is minimum
			int y = rand.nextInt(900) + 600;
			// sets the positive value into a negative value (so it is above the border)
			int yPos = -(Math.abs(y));
			// for random colors
			float r = rand.nextFloat();
			float g = rand.nextFloat();
			float b = rand.nextFloat();

			// enemy cars
			enemyCars.add(new EnemyCar(xPos, yPos, 5, new Color(r, g, b)));
		}
	}

	// method that draws the classes and objects for the game
	// any thing that is drawn to the Panel is coded here
	public void drawGame(Graphics g) {
		// background
		Graphics2D g2 = (Graphics2D) g;
		// creates a gradient paint
		GradientPaint background = new GradientPaint(0.0f, 0.0f, Color.GRAY, 1, 1000, Color.BLACK);
		// use that paint and set it as background
		g2.setPaint(background);
		g2.fillRect(0, 0, 1000, 1000);

		// draws all the Asphalt instances in the list to add to JPanel
		for (Asphalt p : GameFunction.asphalts) {
			p.draw(g);
		}
		// draws all the Vegetation instances in the list to add to JPanel
		for (Vegetation v : GameFunction.vegetations) {
			v.draw(g);
		}
		// draws all the EnemyCar instances in the list to add to JPanel
		for (EnemyCar e : GameFunction.enemyCars) {
			e.draw(g);
		}
	}

	// method that will update the position of the objects
	public void updateGame(double delta) {
		// runs through all the Asphalt objects in List
		for (Asphalt p : GameFunction.asphalts) {
			// resets when image goes past the bottom border
			if (p.y > (1000 - p.size))
				p.y = (-250);

			// so y changes speed for stripes
			p.y += (p.speedY * delta);
		}

		// runs through all the Vegetation objects in List
		for (Vegetation v : GameFunction.vegetations) {
			// resets when image goes past the bottom border
			if (v.y > 1200)
				v.y = (-200);

			// so y changes speed for vegetations
			v.y += (v.speedY * delta);
		}

		// runs through all the EnemyCar objects in List
		for (EnemyCar e : GameFunction.enemyCars) {
			int checkX = 0;
			int checkY = 0;

			// when cars go past the border
			if (e.y > 1200) {
				/*
				 * Randomizes the spawn of enemy cars
				 */
				// inside the bracket is the max value and the value to add is minimum
				int xPos = rand.nextInt(530) + 200;
				// inside the bracket is the max value and the value to add is minimum
				int y = rand.nextInt(900) + 600;
				// sets the positive value into a negative value (so it is above the border)
				int yPos = -(Math.abs(y));

				/*
				 * so that cars do not overlap
				 */
				// checks boundary around previous x position and current position
				if (Math.abs(checkX - xPos) <= 30 || Math.abs(xPos - checkX) <= 30) {
					xPos += 50;

				}
				// checks boundary around previous y position and current position
				if (Math.abs(checkY - yPos) <= 30 || Math.abs(yPos - checkY) <= 30) {
					yPos += 100;

				}
				// sets the new position
				e.x = xPos;
				e.y = yPos;
				// stores previous x and y value to be checked
				checkX = xPos;
				checkY = yPos;
			}
			// so that the enemyCars move
			e.y += (e.speedY * delta);
		}

	}

	// returns the objects contained in this instance of the list
	public static List<EnemyCar> getEnemyCarBounds() {
		return enemyCars;
	}

}
