package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

//Vegetation type class
class Vegetation extends ObjectDraw {
	// variable that will be used in the objects
	public int type;
	BufferedImage img1, img2, img3;

	// constructor
	public Vegetation(int x, int y, int speedY, int type) {
		// borrows the values from parent class
		super(x, y, speedY);
		this.type = type;

		// loads the image -- for use on .jar file
		if (type == 1) {
			loadImage("/images/TreeOne.png");
		}

		if (type == 2) {
			loadImage("/images/TreeTwo.png");
		}
		if (type == 3) {
			loadImage("/images/Bush.png");
		}

	}

	// loads the image inside the JPanel so it can used in the .jar file
	public void loadImage(String str) {
		// sets file into BufferedImage
		try {

			// if type == 1: draw the first type of tree
			if (type == 1) {
				BufferedImage imgOne = ImageIO.read(Vegetation.class.getResource(str));
				// calls resize method to resize image
				img1 = imageResize(imgOne, 130, 170);

			}
			// if type == 2: draw the second type of tree
			if (type == 2) {
				BufferedImage imgTwo = ImageIO.read(Vegetation.class.getResource(str));
				// calls resize method to resize image
				img2 = imageResize(imgTwo, 130, 170);
			}
			// if type == 3: draw bush
			if (type == 3) {
				BufferedImage imgThree = ImageIO.read(Vegetation.class.getResource(str));
				// calls resize method to resize image
				img3 = imageResize(imgThree, 100, 140);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// draws trees and bush description/method
	@Override // Override pre-existing code from the parent
	public void draw(Graphics g) {
		g.drawImage(img1, x, y, null);
		g.drawImage(img2, x, y - 300, null);
		g.drawImage(img3, x, y - 100, null);
	}

	// adds a method to resize the image with return type BufferedImage
	public BufferedImage imageResize(BufferedImage img, int newW, int newH) {
		/*
		 * code to resize Buffered image
		 */
		// transforms BufferedImage into image in order to scale
		Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
		// sets new height and width using the parameters
		BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);
		// calls graphics2D object to draw the image
		Graphics2D g2d = dimg.createGraphics();
		g2d.drawImage(tmp, 0, 0, null);
		g2d.dispose();
		// returns BufferedImage
		return dimg;
	}
}
