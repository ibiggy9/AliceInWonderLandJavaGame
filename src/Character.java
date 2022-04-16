/**
* title: Character.java
* description: Creates a character
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
* Character.java
*
* Purpose and Description:
* The purpose of this class is to create a character for the game and manage the randomness of attack
* outcomes. It does this by first setting the name of the character and setting whether it is one of the evil types of characeters 
* (ogre or thief) and if it has a dialogue. If it is an evil character there is a method that manages the outcome of the attack of that 
* character. 
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
* Character.java
* 
* Class Variables:
* name: sets the name of the character
* dialogue: sets the dialogue of a character if it has one
* CharacterBag: an ArrayList that enables a character to hold an item
* attacks: holds the possible outcomes of an attack in a string
* retaliation: holds the possible outcomes of the maincharacters response to an evil character's attack
* retaliation2: holds the possible outcomes of the maincharacters response to an evil character's attack
* isDefeated: flag to determine if the evil character was defeated
* isThief: flag to signify that this character is type thief
* isOgre: flag to signify that this character is type ogre. 
* success: flag to signify that an attack was successful. 
*  
* Constructors:
* character(string name): Sets the name of the character.
* 
* Methods:
* setName(): sets the name of the character
* setIsThief(): setter for isThief flag. 
* setIsOgre(): setter for isOgre flag. 
* setDialogue(): setter for dialogue
* attack(): method to manage the attack of a character
* ogreAttack(): method for unique attack of the ogre in the darkness location which is the highest risk attack in the game.
* 
* 
* Test Plan: 
* All testing was done in the control class.
*
* CODE:
* 
*/

import java.util.*;

public class Character {
	//Create Class Variables
	String name;
	String dialogue;
	ArrayList<Item> CharacterBag = new ArrayList<>();
	ArrayList<String> attacks = new ArrayList<>();
	ArrayList<String> retaliation = new ArrayList<>();
	ArrayList<String> retaliation2 = new ArrayList<>();
	Boolean isDefeated = false;
	Boolean isThief = false;
	Boolean isOgre = false;
	Boolean success;
	
	//Default Constructor
	Character(){
		
	}
	
	//Constructor that takes in a name of the character
	Character(String name){
		
		this.name = name;
	}
	
	//Setter for character name
	public void setName(String name) {
		this.name = name;
		
	}
	//Setter for if the character is a thief.
	public void setIsThief(Boolean tf) {
		isThief = tf;
	}
	
	//Setter for if the character is an ogre. 
	public void setIsOgre(Boolean tf) {
		isOgre = tf;
	}
	//Setter for a dialogue of the character. 
	public void setDialogue(String dialogue) {
		this.dialogue = dialogue;
	}
	
	//Method to manage the randomness of an attack.
	public void attack(MainCharacter p, Boolean hasFools, Boolean hasDarts, Character c) throws InterruptedException {
		//Create new random instance and add all potential outcomes to the attack ArrayList and pick the answer. 
		Random ran = new Random();
		attacks.add("The attack failed");
		attacks.add("The attack succeeded");
		attacks.add("The attack succeeded");
		attacks.add("The attack succeeded");
		String result = attacks.get(ran.nextInt(attacks.size()));
		
		
		// if the character is a thief conditional...
		if(this.isThief) {
			//Output the attack to the console
			System.out.println("\nThe Thief is trying to steal all your gold!!!");
			System.out.println("...");
			Thread.sleep(1000);
			//If the outcome is a failed attack..
			if(result == "The attack failed") {
				//Print result
				System.out.println(result);
				//Set success to false;
				success = false;
				//If the main character has fools gold and the attack is successful.
			} else if(hasFools = true){
				//set success to true indicating that the attack worked. 
				success = true;
				//output to console. 
				System.out.println("You attempt to trick the thief with your fools gold....");
				retaliation.add("The fools gold tricked him and he left you alone!");
				retaliation.add("The fools gold tricked him and he left you alone!");
				retaliation.add("The fools gold tricked him and he left you alone!");
				retaliation.add("The fools gold didn't trick him and he stole all your treasure!");
				// Sleep for dramatic effect. 
				Thread.sleep(1000);
				// Set random outcome for the mainCharacters retort. 
				String resultFools = retaliation.get(ran.nextInt(retaliation.size()));
				//Print the result of the random choice. 
				System.out.println(resultFools);
				//if successful, then set defeated to true. 
				if(resultFools == "The fools gold tricked him and he left you alone!") {
					isDefeated = true;
				} else {
					//else the character loses all treasure. 
					System.out.println("You lost all your treasure!");
					p.treasure = 0;
					success = false;
				}
				
			} else if(hasFools = false) {
				//if the character has no fools gold to defend themself and the attack was successful, then the player loses all their treasure.
				System.out.println("You lost all your treasure!");
				p.treasure = 0;
			}
			//If the character is an ogre...
		} else if(this.isOgre) {
			// Print to console. 
			System.out.println("\nThe oger swings his hammer at you!");
			// Pause for dramatic effect.
			Thread.sleep(1000);
			//if attack failed condition. 
			if(result == "The attack failed") {
				//print outcome.
				System.out.println(result);
				// Set success to false. 
				success = false;
			} else if(hasDarts = true) {
				//if the player has darts to defend themself...
				success = true;
				//try to shoot the dart print out. 
				System.out.println("You attempt to shoot your dart at the ogre...");
				Thread.sleep(1000);
				//add all outcomes to arraylist.
				retaliation2.add("The dart missed!");
				retaliation2.add("Your dart hit succesfully and the ogre fell asleep.");
				retaliation2.add("Your dart hit succesfully and the ogre fell asleep.");
				retaliation2.add("Your dart hit succesfully and the ogre fell asleep.");
				//select random result
				String resultDarts = retaliation2.get(ran.nextInt(retaliation2.size()));
				//Print result.
				System.out.println(resultDarts);
				//The set is defeated. 
				if(resultDarts == "Your dart hit succesfully and the ogre fell asleep.") {
					isDefeated = true;
				} else {
					System.out.println("You were hit by the hammer and have died");
					p.setLife();
				}
			} else {
				System.out.println("You were hit by the hammer and have died");
				p.setLife();
				
			}
			
			}
			
		}
	
	//This method is used for the ogre attack that specifically takes place in the location "darkness"
	public void ogreAttack(MainCharacter p, Boolean hasDarts) throws InterruptedException {
		if(!isDefeated) {
		System.out.println("The oger swings his hammer at you!");
		//if has darts, then defeat it 100% of the time else, perish. 
		if(hasDarts) {
			System.out.println("You attempt to shoot your dart at the ogre...");
			Thread.sleep(1000);
			System.out.println("Your dart hit succesfully and the ogre fell asleep.");
			isDefeated = true;
			// If not then the character perishes. 
		} else {
			System.out.println("You had no items to defend yourself. You were hit by the hammer and have died");
			p.setLife();
		}
		
	} else {
	
	}
	
	}
}
	
	


