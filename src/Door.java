/**
* title: Door.java
* description: Creates a door 
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
* Door.java
*
* Purpose and Description:
* The purpose of this class is to create a connector between rooms so the character can navigate this 
* world and the game can lock doors between rooms. 
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
* Door.java
* 
* Class Variables:
* Origin: Sets the location the player is coming from. 
* Desination: Sets the location the player is going to. 
* Boolean isLocked: flag to set if the door is locked
*  
* Constructors:
* Door() = Sets the original location and destination location. 
* 
* Methods:
* Lock(): locks a door
* Unlock(): unlocks a door 
* enter(): Enter a room through a door. 
* 
* 
* Test Plan:
* All testing was done in the control class.
*
* CODE:
* 
*/

public class Door implements roomSite{
	// Set class variables
	Location origination;
	Location destination;
	Boolean islocked = false;
	
	//Create constructor
	Door(Location origination, Location destination){
		this.origination = origination;
		this.destination = destination;
		
	}
	
	// Setter to lock	
	public void lock() {
			islocked = true;
	}
	
	//Setter to unlock
	public void unlock() {
		
			islocked = false;
	
	}
	
	// Method to check if door is locked before entering the door. 
	public void enter(MainCharacter p) {
		if(islocked == true) {
			System.out.println("There is a door here but it is locked!");
		} else {
		p.setLoc(destination);
		System.out.print("You go through a door that takes you to a place called:\n" + destination.name + "\n");
		p.getDescriptions();
		}
	}
	
	
}
