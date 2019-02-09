package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/*
 * 
 * 
 * CANNOT use inheritance because the car model is a png image while enemyCar uses java graphics.
 * 
 * 
 */

public class PlayerCar extends JPanel {
	// variables that will be used in the objects
	public int speedY, speedX, x, y, type;
	public int speed = 5;
	public int height = 100;
	public int width = 80;
	BufferedImage img;

	// constructor
	public PlayerCar(int x, int y) {
		/*
		 * initializes the variable
		 */
		this.x = x;
		this.y = y;
		this.speedX = 0;
		this.speedY = 0;

		// loads the image -- for use on .jar file
		loadImage("/images/PlayerCar.png");
	}

	// draws asphalt description/method
	public void draw(Graphics g) {
		g.drawImage(img, x, y, null);
	}

	// loads the image inside the JPanel so it can used in the .jar file
	public void loadImage(String str) {
		try {
			// sets file into BufferedImage
			BufferedImage imgOne = ImageIO.read(PlayerCar.class.getResource(str));
			// calls resize method to resize image
			img = imageResize(imgOne, width, height);
			// draw the image
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// method to resize the image with return type BufferedImage
	public BufferedImage imageResize(BufferedImage img, int newW, int newH) {
		/*
		 * code to resize Buffered image
		 */

		// transforms BufferedImage into image in order to scale
		Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
		BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = dimg.createGraphics();
		g2d.drawImage(tmp, 0, 0, null);
		g2d.dispose();
		// returns BufferedImage
		return dimg;
	}

	/*
	 * Methods for car movement
	 */

	// when car moves up
	public void up() {
		// boundaries -- so car doesnt move outside of the track
		if (y > 50) {
			speedY = -(speed);
			speedX = 0;
		} else {
			speedY = 0;
			speedX = 0;
		}
	}

	// when car moves right
	public void right() {
		// boundaries -- so car doesnt move outside of the track
		if (x < 700) {
			speedY = 0;
			speedX = (speed);
		} else {
			speedY = 0;
			speedX = 0;
		}
	}

	// when car moves left
	public void left() {
		// boundaries -- so car doesnt move outside of the track
		if (x > 190) {
			speedY = 0;
			speedX = -(speed);
		} else {
			speedY = 0;
			speedX = 0;
		}
	}

	// when car moves down
	public void down() {
		// boundaries -- so car doesnt move outside of the track
		if (y < 901) {
			speedY = speed;
			speedX = 0;
		} else {
			speedY = 0;
			speedX = 0;
		}
	}

	// method that will constantly check when car is off the road and offset it
	public void checkBound(double delta) {
		/*
		 * In case car goes off the road
		 */
		if (x <= 189) {
			speedX += (3 * delta);
		}
		if (x >= 701) {
			speedX -= (3 * delta);

		}
		if (y <= 45) {
			speedY += (3 * delta);
		}

		if (y > 950) {

			speedY -= (3 * delta);
		}
	}

	// player car update method that gives it movement
	public void playerCarUpdate(double delta) {
		// checks first if the car is within bounds of the road
		checkBound(delta);
		// makes the player 'slow down' constantly
		y++;

		// the methods called in keyPressed changes the speed(X/Y) which adds to the x/y
		// of the car
		x += (speedX * delta);
		y += (speedY * delta);

	}

	// method to draw an imaginary rect around the playerCar
	public Rectangle getBounds() {
		// used in Collision class
		return new Rectangle(x, y, width, height);
	}

}
