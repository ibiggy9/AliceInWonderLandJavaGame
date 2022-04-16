/**
* title: Item.java
* description: Creates an Item
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
* Item.java
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
* Item.java
* 
* Class Variables:
* wasUsed: flag to declare whether this was used.
* validActions: an ArrayList to store a set of actions that are valid for this item.
* isTreasure: flag to declare if this item is treasure
* name: name of the item
* itemCount: count of the number of items the player has.
*
*  
* Constructors:
* Door() = Sets the original location and destination location. 
* 
* Methods:
* setValidAction(): setter for valid actions
* setName(): setter for name
* setTreasure(): setter for isTreasure.
* 
* 
* Test Plan:
* All testing was done in the control class.
*
* CODE:
* 
*/
import java.util.*;

public class Item {	
	//Set the class variables...
	Boolean wasUsed = false;
	ArrayList<Action> validActions = new ArrayList<Action>();	
	Boolean isTreasure = false;
	String name;
	Integer itemCount = 1;
	
	//default constructor
	Item(){
		
	}

	//Add valid actions
	public void setValidActions(Action ... a) {
		for(Action i : a) {
		validActions.add(i);
		}
	}
	
	//Set the name of the action
	public void setName(String name) {
		this.name = name;
	}
	
	//Set if it is treasure.
	public void setTreasure(Boolean tf) {
		isTreasure = tf;
	}
	
	

}
