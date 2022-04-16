/**
* title: Wall.java
* description: Creates a Wall 
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
* Wall.java
*
* Purpose and Description:
* The purpose of this class is to createa a wall in a location. This class does this by implementing the roomSite interface's 
* abstract method to enter a room and configrues it to make the player hit a wall if they do. 
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
* Wall.java
* 
* Class Variables:
* None.
*  
* Constructors:
* None.
* 
* Methods:
* Enter: this method allows the player to head in a given direction and get feedback that they have hit a wall if there
* is no door set for that direction. 
* 
* 
* Test Plan:
* All testing was done in the control class.
*
* CODE:
* 
*/

// Wall uses abstract method from roomSite to trigger a hit a wall error when the player goes into a wall. 
public class Wall implements roomSite{
	public void enter(MainCharacter p) {
		System.out.print("\nOuch, I hit a wall!");
	}
	
}



