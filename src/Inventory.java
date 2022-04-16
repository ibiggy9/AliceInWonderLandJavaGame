/**
* title: Inventory.java
* description: Creates a Inventory 
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
* Inventory.java
*
* Purpose and Description:
* The purpose of this class is to create an inventory 
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
* Inventory
* 
* Class Variables:
* character = an arraylist that stores character. 
* inv =  an arraylist that stores an item
* usedItems = an arraylist that stores items you have used
* limit = an integer that stores the limit of the size of an inventory. 
* 
* Constructors:
* Inventory() = Sets the original location and destination location. 
* 
* Methods:
* addChar(): adds a character to the character inventory
* removeChar(): removes a character from an inventory.
* addItem(): Adds item to an inventory
* removeItem(): Removes item from an inventory
* showInventory(): Shows what is in an item inventory
* checkisfull(): Checks if an inventory is full. 
* 
* Test Plan:
*  All testing was done in the control class.
*
* CODE:
* 
*/
import java.util.*;

public class Inventory {
	// Set class variables
	ArrayList<Character> character = new ArrayList<Character>();
	ArrayList<Item> inv = new ArrayList<Item>();
	ArrayList<Item> usedItems = new ArrayList<>();
	Integer limit = 10;
	
	
	// create the constructor 
	Inventory(Integer size){
		limit = size;
	}
	// add character to a character inventory 
	public void addChar(Character c) {
		character.add(c);
	}
	
	
	// remove character from an inventory
	public void removeChar(Character c) {
		character.remove(c);
	}
	
	
	//add item to an item inventory
	public void addItem(Item i) {
		// check if it is full
		if(checkIsFull()) {
			System.out.println(checkIsFull());
		} else {
			inv.add(i);
			
		}
		
	}
	
	//show inventory
	public void showInventory() {
		// check if it is empty 
		if(inv.size() == 0) {
			System.out.println("You have nothing in your inventory");
		} else {
		//loop through inventroy and print results with item counts. 
		System.out.println("This is what you have in your inventory:");
		for(Item item : inv) {
			if(item.itemCount > 1) {
				System.out.println(item.name + " x " + item.itemCount);
			}else {
			System.out.println(item.name);
		}
		}
	}
	}
	
	//Remove item from inventory. 
	public void removeItem(Item i) {
		inv.remove(i);
		
	}
	
	//Check if the inventory is full
	public boolean checkIsFull() {
		//if inventory size has reached the limit defined in the constructor, then return full. 
		if(inv.size() == limit) {
			System.out.println("Inventory is full. Either go back to the hall to stash items or drop items with drop command");
			return true;
		} else {
			return false;
		}
	}
	
	
}
