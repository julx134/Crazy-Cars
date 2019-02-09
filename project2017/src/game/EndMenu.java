package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class EndMenu extends GameObject implements KeyListener {
	boolean done = false;
	BufferedImage img;

	// constructor
	public EndMenu() {
		// names this JPanel EndMenu
		super("EndMenu");
		// allows the frame to look for Key presses
		Main.frame.addKeyListener(this);
		// ends the loop
		Main.running = false;

		// loads the image -- for use on .jar file
		loadImage("/images/CarsWallpaper.jpg");
	}

	// loads the image inside the JPanel so it can used in the .jar file
	public void loadImage(String str) {
		try {
			// sets file into BufferedImage
			BufferedImage imgOne = ImageIO.read(PlayerCar.class.getResource(str));
			// calls resize method to resize image
			img = imageResize(imgOne, 1000, 1000);
			// draw the image
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// any thing that is drawn to the Panel is coded here
	@Override
	public void paintComponent(Graphics g) {

		// draws the background image
		g.drawImage(img, 0, 0, null);

		// end game credits
		g.setColor(Color.BLACK);
		g.setFont(new Font("Monospaced", Font.BOLD, 20));
		g.drawString("Your Final Score is: " + (int) Collision.score, 50, 400);
		g.drawString("Thanks For Playing!", 50, 450);
		g.drawString("Press SpaceBar to Exit", 50, 500);

	}

	// JPanel runs code whenever a key is pressed
	@Override
	public void keyPressed(KeyEvent e) {
		// when player presses spacebar
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			System.exit(0);
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

	// JPanel runs code whenever a certain key is released
	@Override
	public void keyReleased(KeyEvent e) {
	}

	// do nothing
	@Override
	public void keyTyped(KeyEvent arg0) {
	}

}
