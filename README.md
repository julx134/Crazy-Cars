# Crazy-Cars
//Author: Jules Gammad


This Java project was made on June of 2017 within a one-month timeline as a culminating project.

It is an application of the main content learned from ICS4U. The game is built on the fundamental concepts such as OPP,
Inheritance, Classes, Lists, Methods and Graphics. Delta timer is also implemented which is not part of the curriculum but helped in
allocating more memory for the game.

Code description:

-->ObjectDraw (class): a parent class that will pass on declaration format onto subclass game objects.

-->Vegetation, Asphalt and EnemyCar[sub-class]: sub-classses from ObjectDraw which becomes a
  'blueprint' for later objets to be drawn into the game.
  
-->PlayerCar (class): user car object as a class of its own so it is independently controlled and not the enemy cars. Uses
   methods to decrease and increase speed which is then called using keyListeners in the Game class.
   
-->Collision (class): checks enemy car boundary to see if it intersects with the user's car's boundary. This class also
   has methods for health bar and collision redirection.

-->GameFunction (class): declares and initializes the sub-classes. Also have methods
  that update positions of the objects.

-->GameObject (class): a JPanel parent class that is used as a game-screen switcher via the super(name) of subclasses that is then
   passed into the Main class.

-->MainMenu [sub-class]: Main Menu screen which is what users see first. Uses keyListener to change the game screen using 
   Main.setGameObject().

-->Game [sub-class]: The main game that users actually get to play in. This class draws and updates the objects which is continuously 
   updated in the Main JFrame. It has keyListeners to move the user's car object.

-->EndMenu [sub-class]: End Menu screen that where users see their final score. Is called by the Collision class.

-->Main (class): Declares a JFrame where GameObject subclasses are passed through a method setGameObject() which adds that subclass
   into the JFrame. It also contains the method run() which is the for the gameloop that contains the delta timer.



