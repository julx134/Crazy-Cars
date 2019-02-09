package game;

import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Main {
	//variables to be used
	public static boolean running;
	private static GameObject game;
	public static JFrame frame = new JFrame();

	public static void main(String[] args) {
		// var so that the game runs if its true
		running = true;

		/*
		 * initializing JFrame
		 */
		frame.setTitle("Title");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setSize(1000, 1000);
		frame.setLocationRelativeTo(null);
		// adds a windowListener to ask user if they wish to close after click the 'X'
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				// makes a confirmDialog if user decides to close the game
				// confirmed takes the int value of 1 or 0 depending on the button pressed
				int confirmed = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the program?",
						"Exit Program Message Box", JOptionPane.YES_NO_OPTION);
				// if yes is clicked -- close the app
				if (confirmed == JOptionPane.YES_OPTION) {
					frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					System.exit(0);
				}
				// if no is clicked -- keep running the app
				else if (confirmed == JOptionPane.NO_OPTION) {
					frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
			}
		});

		// calls a method that will change JPanel depending on subclass called
		setGameObject(new MainMenu());

		// calls method to run the game
		run();
	}

	// method that takes in a gameObject class named go
	public static void setGameObject(GameObject go) {
		// if the gameObject passed in this method has the same 'label'
		if (game != null && game.getName() == go.getName()) {
			return; // do nothing
		} else {
			// if the 'title' is not the same
			// change the gameObject to whatever is passed in the parameter
			game = go;
			// adds game to the frame
			frame.add(game);
			// sets the frame to be visible
			frame.setVisible(true);
		}
	}

	// method for the game loop
	private static void run() {
		// a long containing a value in big value - nano seconds
		long lastTime = System.nanoTime();
		// frame rate or ticks of the game
		final double amountOfTicks = 60.0;
		// sets the timer per tick
		double ns = 1000000000 / amountOfTicks;
		// calculates the time passed when an action is performed
		double delta = 0; // increases only when there is a delay(lag) between actions

		long now;

		while (running) {
			// whenever method is ran, there is a time difference between action and draw
			now = System.nanoTime();
			// delta increases in value every time the game drops in frames
			delta += (now - lastTime) / ns; // when delta is a high value, increase the num of ticks
			// whenever frame is repainted -- set the last time to now
			lastTime = now;

			while (delta >= 1) {
				/*
				 * PASS THROUGH UPDATE SO MOVEMENT IS RELATIVE
				 */
				game.update(delta);
				delta--;
			}
			// repaints the frame
			game.repaint();
			//updates the score
			Collision.score += 0.000001;
		}

	}
}
