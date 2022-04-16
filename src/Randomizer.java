/**
* title: Randomizer.java
* description: Creates a Randomizer 
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
* Randomizer.java
*
* Purpose and Description:
* The purpose of this room is to randomly generate and add items and character to a given room in the game. 
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
* Randomizer.java
* 
* Class Variables:
* ranItem: a variable that stores the random choice of an item. 
* ranChar: a variable that store the random choice of a character
* randomCharacter: the arraylist that store the possible outcomes of a random character choice
* randomItem: the arraylist that stores the possible outcomes of a random item selection. 
*  
* Constructors:
* Randomizer() = Sets the original location and destination location. 
* 
* Methods:
* randomChar(): This method generates a random character choice
* randomItem(): This method gneerates a random item choice
* 
* 
* Test Plan:
* All testing was done in the control class.
*
* CODE:
* 
*/
import java.util.*;

public class Randomizer extends Init{
//This class randomizes items and characters.
	
	
	//Base constructor 
	Randomizer(){
		
	}
	
	//class instances and variables 
	Item ranItem; 
	Random ran = new Random();
	Character ranChar;
	ArrayList<Character> randomCharacter = new ArrayList<>();
	ArrayList<Item> randomItems = new ArrayList<>();
	
	//method that produces a random character in a room. 
	public void randomChar(Character ... c) {
		// loop through all arguments passed 
		for(Character c2 : c) {
			// add to arrayList
			randomCharacter.add(c2);
		}
		
		
		//Randomly choose. 
		ranChar = randomCharacter.get(ran.nextInt(randomCharacter.size()));
		
		
		
	}
	
	//method that produces a random item in a room. 

	public void randomItem(Item ... i) {
		//loop through all items passed in 
		for(Item i2 : i) {
			// add to arrayList
			randomItems.add(i2);
		}
		
		//Make random choice
		ranItem = randomItems.get(ran.nextInt(randomItems.size()));
		
	}
	
}
