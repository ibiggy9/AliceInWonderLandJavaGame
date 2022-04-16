
/**
* title: Game.java
* description: Initiates the game. 
* date: Dec 29 2021
* @author Ian Bigford
* @version 1.0
* @copyright 2001-2020  Ian Bigford
*/

/**
* DOCUMENTATION...
*/
/**
*
* Game.java
*
* Purpose and Description:
* 
*
*
* Compiling and running instructions<
* Required: openjdk version "17" 2021-09-14
* OpenJDK Runtime Environment Temurin-17+35 (build 17+35)
* OpenJDK 64-Bit Server VM Temurin-17+35 (build 17+35, mixed mode, sharing)	
* Compile:  javac Game.java
* Compile #2: javac Init.java
* Compile #3: javac MainCharacter.java
* Run:      Game.java
*
*/
/**
*
* Classes:
*
* Game.java
* 
*  
* Constructors:
* None
* 
* Methods:
* Main(): This method creates an instance of control and starts the game 
* 
*
* Test Plan:
* If the game works, this is functioning. Since this is the parent node of the program, there is very little testing required here. 
*
* CODE:
* 
*/

public class Game {
	public static void main(String args[]) throws InterruptedException{
	// Create instance
	Control game = new Control();
	//Runs game
	game.startAdventure();
	}
}
