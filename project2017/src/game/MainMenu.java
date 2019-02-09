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

public class MainMenu extends GameObject implements KeyListener {
	boolean done = false;
	BufferedImage img;

	// constructor
	public MainMenu() {
		// names the JPanel MainMenu
		super("MainMenu");
		// allows the frame to look for Key presses
		Main.frame.addKeyListener(this);
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
		g.drawImage(img, 0, 0, null);
		
		g.setColor(Color.BLACK);
		g.setFont(new Font("Monospaced", Font.BOLD, 20));
		g.drawString("Press Any Key to Start!", 50, 500);

	}

	// JPanel runs code whenever a key is pressed
	@Override
	public void keyPressed(KeyEvent e) {
		// debugging -- once a key is pressed it is repeated
		// after the first keyPressed -- do nothing
		if (done) {
			return;
		}
		// when key is pressed, set done to true
		done = true;
		// set the JPanel to game using the method
		Main.setGameObject(new Game());
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
