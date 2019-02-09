package game;

import javax.swing.JPanel;

//GmaeObject parent class
public class GameObject extends JPanel {
	
	private String name;
	//sets the name of the gameObject -- will be used as title for the JPanel subclass
	public GameObject(String name) {
		this.name = name;
	}
	
	//Debugging - GameObject called at Main needs an update method
	public void update(double delta) {
		
	}
	//method that will get the name of the class
	//used in Main class when switching JPanels
	public String getName() {
		return name;
	}
	
}
