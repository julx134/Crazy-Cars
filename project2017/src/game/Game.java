package game;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends GameObject implements KeyListener {
	// creates one instance of PlayerCar and GameFunction object
	static PlayerCar playerCar = new PlayerCar(470, 700);
	public static GameFunction gameFunction;
	Collision collision = new Collision();

	// constructor
	public Game() {
		// names this JPanel "Game"
		super("Game");
		// allows the frame to look for Key presses
		Main.frame.addKeyListener(this);
		// add keyListener to panel (car movement)
		addKeyListener(this);
		// debugging for keyListeners
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);

		// intialize the game
		gameFunction = new GameFunction();

	}

	// any thing that is drawn to the Panel is coded here
	@Override
	public void paintComponent(Graphics g) {
		// draw game objects
		gameFunction.drawGame(g);
		collision.draw(g);
		playerCar.draw(g);
	}

	// update or animate the objects
	@Override
	public void update(double delta) {
		// update game objects
		playerCar.playerCarUpdate(delta);
		gameFunction.updateGame(delta);
		// Collision class that will check per frame update if there is a colission
		collision.checkCollision(delta);
	}

	// JPanel runs code whenever a key is pressed
	@Override
	public void keyPressed(KeyEvent e) {
		/*
		 * the methods are under the object PlayerCar whenever that specified method is
		 * called -- change speedX or speedY accordingly
		 */

		// when the player presses the up arrow key
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			playerCar.up();
		}
		// when the player presses the up left key
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			playerCar.left();
		}
		// when the player presses the up right key
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			playerCar.right();
		}
		// when the player presses the up down key
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			playerCar.down();
			;
		}

	}

	// JPanel runs code whenever a certain key is released
	@Override
	public void keyReleased(KeyEvent e) {
		// when the player presses the up arrow key
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			playerCar.speedY = 0;
		}
		// when the player presses the up left key
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			playerCar.speedX = 0;
		}
		// when the player presses the up right key
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			playerCar.speedX = 0;
		}
		// when the player presses the up down key
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			playerCar.speedY = 0;
		}

	}

	// do nothing
	@Override
	public void keyTyped(KeyEvent arg0) {
	}

	// method to return the object drawn
	// sends this particular object to Collision class
	public static PlayerCar playerCarObject() {
		return playerCar;
	}
	
}
