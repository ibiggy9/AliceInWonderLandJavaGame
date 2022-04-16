
/**
* title: MainCharacter.java
* description: Creates the main character
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
* MainCharacter.java
*
* Purpose and Description:
* The purpose of this class is to make the mainCharacter. This class creates a variety of data structures, variables and booleans that hold the
* data on the character and has methods to change those attributes. 
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
* MainCharacter.java
* 
* Class Variables:
* myloc: stores the location of the character
* itemInventory: creates an inventory with a limit of 5. 
* hunger: creates an integer to represent the hunger level of the character
* thirst: creates an integer to represent the thirst level of the character
* moveCountHunger: an integer to track the number of moves taken since a character last ate.
* moveCountThirst: an integer to track the number of moves taken since the character last drank. 
* moveCount: an integer to track how many times the player has moved in total. 
* isAlive: flag to determined if the character is alive. 
* moved: flag to determine if the location has changed to adjust the moveCounts. 
*  
* Constructors:
* Door() = Sets the original location and destination location. 
* 
* Methods:
* checkItemInventory(): check item inventory of the player
* checkHealth(): check health of the player
* checkTreasure(): check treasure of the player
* setLoc(); set the new location of the player
* getDescription(): get the description of the location the player is in. 
* getLoc(): get the location the player is currently in 
* setMoveCount(): set the move count
* setHunger(): eat method - reduce hunger
* setThirst(): drink method -reduce thirst
* setLife(): kill character
* pickup(): pick up new item
* go(): go in a direction.
* 
* 
* Test Plan:
* All testing was done in the control class.
*
* CODE:
* 
*/
public class MainCharacter {
	// create class variables and instances
	Location myloc;
	Inventory itemInventory = new Inventory(6);
	Integer hunger = 0;
	Integer thirst = 0;
	Integer treasure = 0;
	Integer moveCountHunger = 0;
	Integer moveCountThirst = 0;
	Integer moveCount = 0;
	Boolean isAlive = true;
	Boolean moved = false;
	
	
	MainCharacter(){
		
	}
	
	// Check inventory method that is used by control 
	public void checkItemInventory() {
		System.out.printf("You have %d items in your inventory\n", itemInventory.inv.size());
		System.out.println("Here are the items in your inventory");
		itemInventory.showInventory();
		
	}
	// Check the players health that is used by control 
	public void checkHealth() {
		// display the characters health in different ways depending on how extreme the need for food or water is. 
		System.out.printf("Your hunger is %d", hunger);
		if (hunger < 5) {
			System.out.println("...You aren't really hungry");
		} else if (hunger >= 5 && hunger <= 7) {
			System.out.println("...You are starting to get quite hungry");
		} else if (hunger >= 7 && hunger <= 10) {
			System.out.println("...You are starving. If your hunger reaches 10 you will perish and have to restart the game");
		}
		
		System.out.printf("Your thirst is %d", thirst);
		if (thirst < 5) {;
		System.out.println("...You aren't really thirsty");
		} else if (thirst >= 5 && thirst <= 7) {
			System.out.println("...You are starting to get quite thirsty");
		} else if (thirst >= 7 && thirst <= 10) {
			System.out.println("...You are parched. If your thirst reaches 10 you will perish and have to restart the game");
		}
 		
	}
	// Check how many points you have in the game. 
	public void checkTreasure() {
		System.out.printf("Your treasure is worth %d points.", treasure);
		System.out.println("Remember that you must get to a treasure value of 10 to win");
	}
	
	// change players location and update the move count. 
	public void setLoc(Location loc) {
		myloc = loc;
		myloc.visitCount ++;
		setMoveCount();
		
	}
	
	//Get the descriptions of the room the player is currently in. If they have visited before then display the short description. 
	public void getDescriptions() {
		if (!myloc.hasBeenVisited) {
			System.out.print(myloc.longDescription);
			myloc.hasBeenVisited = true;
		} else {
			System.out.print(myloc.shortDescription);
			
		}
		
		
	}

	// Get current location
	public void getLoc() {
		System.out.printf("\nYour current location is: %s\n", myloc.name);
	
	}
	
	//update hunger, thirst and move count at different rates as the player moves throughout the map. 
	public void setMoveCount() {
		moveCount ++;
		moveCountHunger ++;
		moveCountThirst ++;
		
		hunger = moveCountHunger/2;
		thirst = moveCountThirst;
			
	
		
		if(hunger == 10) {
			setLife();
		}
		if(thirst == 10) {
			setLife();
		}
	}
	
	//Reduce hunger once a player eats
	public void setHunger(Item food) {
			hunger = 0;
			moveCountHunger = 0;
			if (hunger < 0) {
				hunger = 0;
			}
			
			
		}
	
	// Set thirst
	public void setThirst(Item drink) {
			thirst = 0;
			moveCountThirst = 0;
			if (thirst < 0) {
				thirst = 0;
			}
		}
		
	
	// A method that triggers the end of the game. 
	public void setLife() {
		if(isAlive == true) {
			isAlive = false;
		} else if (isAlive == false) {
			isAlive = true;
		}
		
		if(isAlive == false && hunger == 10) {
			System.out.println("You have starved to death. Game over.");
			System.exit(0);
		}
		
		if(isAlive == false && thirst == 10) {
			System.out.println("You have died of thirst. Game over.");
			System.exit(0);
		}
		if(isAlive == false) {
			System.exit(0);
		}
	}
	
	//filter a picked up item to the right inventory. 
	public void pickup(Item i) {
		Boolean played = false;
		
		if(i.isTreasure) {
			treasure ++;
		} else {
			if(itemInventory.inv.contains(i)){
				i.itemCount ++;
			} else {
				itemInventory.inv.add(i);	
			}
		} if(treasure == 10 && played == false) {
			System.out.println("Congratulations, you have accumulated 10 pieces of treasure! You must present this to the court in order to escape which is just past the queens house!");
			played = true;
		}
		
	
	}
	
	
	public void go(int direction) throws InterruptedException {
		
		myloc.exit(direction, this);
	}
	


}
