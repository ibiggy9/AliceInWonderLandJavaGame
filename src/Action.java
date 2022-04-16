/**
* title: Action.java
* description: Creates an Action
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
* Action.java
*
* Purpose and Description:
* Creates the ability to act within the game. 
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
* Action.java
* 
* Class Variables:
* Name: names the action
* validAction:
* Boolean isLocked:
*  
* Constructors:
* Action() = sets the name of the action
* 
* Methods:
* setName(): sets the name of the action.  
* 
* 
* Test Plan:
* All testing was done in the control class.
*
* CODE:
* 
*/

public class Action {
	//set up class variable names
	String name;
	
	
	//Constructor 
	Action(){
		
	}
	
	//Constructor 
	Action(String name){
		
		this.name = name;
	}
	
	// Set name of action
	public void setName(String name) {
		this.name = name;
		
	}
	
	
	

	
	
}
