package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.List;

public class Collision {
	// imports or takes the values of the enemyCars in the List and the playerCar
	// object
	static List<EnemyCar> enemyCars = GameFunction.getEnemyCarBounds();
	static PlayerCar playerCar = Game.playerCarObject();

	public static double xDisplay = 450.0;
	public static double xHealth = 100.0;
	public static double score = 0;

	//method that checks collision
	public void checkCollision(double delta) {
		//checks to see if the car falls behind -- lose health if it does 
		if (playerCar.y >=950) {
			//4.5 ratio between xHealth and xDisplay	
			//when car collides, substract health 
			xDisplay = xDisplay - 22.5;
			xHealth = xHealth - 5;
		}
		
		
		// loops through every object in the enemyCar list
		for (EnemyCar n : Collision.enemyCars) {

			// if statement that checks for collision
			// getBounds is a method within each of the classes that draws an imaginary
			// rectangle around the objects
			if (playerCar.getBounds().intersects(n.getBounds())) { // .intersects is a java code to see if the rectangles touch
				//4.5 ratio between xHealth and xDisplay	
				//when car collides, substract health 
				xDisplay = xDisplay - 4.5;
				xHealth = xHealth - 1;
				
				//when playerCar hits enemyCar to the right
				if (playerCar.x >= n.x) {
					//change playercar speed to oposite direction
					playerCar.speedX += delta;
					//change enemycar speed to match momentum
					n.x -= 10*delta;
				
				}
				//when playerCar hits enemyCar to the right
				if (playerCar.x <= n.x + n.width) {
					//change playercar speed to oposite direction
					playerCar.speedX -= delta;
					//change enemycar speed to match momentum
					n.x += 10*delta;
					
				}
				//when playerCar hits enemyCar at the front
				if (playerCar.y >= n.y) {
					//change playercar speed to oposite direction
					playerCar.speedY -= delta;
					//change enemycar speed to match momentum
					n.y += 15*delta;
				}
				//when playerCar hits enemyCar at the back
				if (playerCar.y <= n.y + n.height) {
					//change playercar speed to oposite direction
					playerCar.speedY += delta;
					//change enemycar speed to match momentum
					n.y -= 15*delta;
				}
				
			}

		}
		if (xHealth <= 0) {
			//re-initialize game
			Main.setGameObject(new EndMenu());
		}
	}
	//draws the healthbar
	public void draw(Graphics g) {
		//shadow
		g.setColor(Color.BLACK);
		g.fillRect(10, 15, (int)xDisplay  - 2, 22);
		//healthbar
		g.setColor(new Color(135, 231, 0));
		g.fillRect(3, 5, (int)xDisplay , 20);
		//healthbar outline
		g.setColor(Color.BLACK);
		g.drawRect(3, 5, (int)xDisplay , 20);
		//percentage
		g.setColor(Color.BLACK);
		g.setFont(new Font("Monospaced", Font.BOLD, 20));
		g.drawString((int)xHealth + "%", (int)(xDisplay-40), 23);
		g.setColor(Color.WHITE);
		g.drawString("Score: " + (int)score, 10, 55);
		
		if (playerCar.y >= 910) {
			g.setColor(Color.RED);
			g.setFont(new Font("Monospaced", Font.BOLD, 50));
			g.drawString("Don't fall behind or you'll lose!", 0, 100);
		}
	}
	//method that resets the healthbar
	public static void healthReset() {
		xDisplay = 450.0;
		xHealth = 100.0;
	}
	
	
}
