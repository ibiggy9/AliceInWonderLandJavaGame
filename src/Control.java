/**
* title: Control.java
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
* Control.java
*
* Purpose and Description:
* The purpose of this class is to bring all the other elements of the game together to where the user input is processed and key events, and user actions take place. 
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
* Control.java
* 
* Class Variables:
* r : an instance of randomizer class to feed into the keyEvents method to generate random characters and items.
* thePlayer: an instance of the MainCharacter class.
* game: an instance of the init class.
* action: a variable that stores the action that was assigned if there was a match between the users input and an action in the game. 
* item: a variable that stores the action that was assigned if there was a match between the users input and an item in the game.
* character: a variable that stores the character detected in the user input. 
* isfound: flag to determine if an item or action was found in the list of all items and actions
* moved: a flag to signify if the character changed locations
* flip: a switch for general use. 
* worked: a flag to declare if a method worked. 
* 
* 
*  
* Constructors:
* Control() default constructor
* 
* Methods:
* convertDirection(): converts the users inputed direction command to an integer. Returns that integer. 
* convertAction(): converts the users input to the relevant method using switch structure. 
* pickup(): picks up an item if it is in the room that player is in 
* eat(): eats an item if it is in the players inventory and is food
* drink(): drinks an item if it is in the players inventory and is water.
* checkHealth(): check health status
* checkTreasure(): check points in the game
* help(): displays help menu
* error(): displays an error caused by user input. 
* look():  look at what is in a room
* isValid(): checks if the users input matches actions and items in the game. if yes, then it passes the input to convertAction
* startAdventure(): runs all init methods to create the game
* handleCommands(): takes and parses the users input
* keyEvent(): houses all key events that happen as the user moves throughout the game and makes choices. 
* 
* Test Plan:
* Since this class implements the entire game and makes it playable, all testing occurred here.
* There were three components to testing all the elements of the game in this class:
* 1) Taking user input & parsing to run the corresponding methods correctly without error.
* 2) The functioning of the keyEvents during gameplay.
* 
* 
* For each of these three test components, there is a unique test approach so I will go through each one by one:
* 1) Taking user input. 
* 
* Success criteria:
* - All keywords in the help menu work as described. 
* - The program can take upper or lower case
* - The program throw the right error depending on the input
* 
* Test Case #1: All keywords in the help menu work as described. 
* Commands tested:
* for commands:
* - Grab, take, eat, drink, drop
* 
* I tested:
* - If they told the user that they were valid but needed to be paired with an item name to work if entered alone. 
* - If they entered these keywords with a valid item, did they run the right method and did that method work. 
* - If they entered those keywords with invalid items did the program throw the right error:
* 
* Specific tests:
* Test 1:
* Inputs:
* Grab
* 
* Expected output:
* This is a valid keyword, but it must be paired with an item name in your inventory or in the room.
* For example: Take water or eat apple.
* 
* Actual output:
* Matched - tested by running
* 
* Test 2:
* Inputs: 
* Grab water - when water is not an available item 
* 
* Expected output:
* There is no item with that name in this room.
* 
* Actual output:
* Matched - tested by running
* 
* Test 3: 
* Input:
* Garb water
*
* 
* Expected output:
* Sorry I don't recognize that term. 
* 
* Actual output:
* Matched - tested by running
*
* 
* Test 4: 
* Input: 
* Grab Water - when water is available
* 
* Expected results:
* You picked up the water.
* 
* Actual results:
* Matched- confirmed by running the program.
* 
* 
* REPEATED FOR ALL COMMANDS WITH IDENTICALLY SUCCESSFUL RESULTS
* 
* For Commands:
* - inventory, health, quit, look, points, help
*
*I tested: 
* - if the user entered these commands correctly 
* - If the user paired these terms with items
* - If the user paired these terms with other commands
* - if the user made a spelling error. 
*
*Specific Tests:
*Test 1:
*Inputs:
*inventory && i && invent
*
*Expected Outputs:
*You have nothing in your inventory.
*
*Actual Outputs
*Matched - tested by running
*
*Test 2:
*Inputs:
*treasure inventory
*
*Expected Outputs:
*You have nothing in your inventory
*
*Actual Outputs
*Matched - tested by running
*
*Test 3:
*Inputs:
*grab inventory
*
*Expected Output:
*You have nothing in your inventory
*
*Actual Outputs
*Matched - tested by running
*
*Test 4:
*Inputs:
*intory
*
*Expected Outputs:
*Sorry, I don't recognize that term.
*
*Actual Outputs
*Matched - tested by running
*
*REPEATED THIS ACROSS ALL COMMANDS WITH PERFECT RESULTS. S
*
*2) Testing key events
* 
*I tested:
*- That going to each respective room triggered the right event 
*- That the character and items regenerated randomly 
*- That the items that trigger events in fact do trigger events. 
*
*Test 1: 
*Input:
*Move player into hall and go west or east
*
*Expected Output:
*There is a door here but it is locked! 
*
*Actual:
*Matched
*
*Test 2: 
*Input:
*Move player to hall and eat cake go west and east
*
*Expected result:
*You eat the cake and grow temporarily to be 30 feet tall and unlock the door to the west...After opening the door, you shrink back to regular size.
*
*The doors to the west suddenly unlocked...
*
*Go West:
*You go through a door that takes you to a place called:
*Beach
*You are standing at a beach with rolling waves coming in from the sea. The rabbit sits on the sand smiling with gratitude.
*
*Go East:
**There is a door here but it is locked! 
*
*Actual:
*Matched.
*
*REPEATED FOR ALL ROOMS AND ALL ROOM EVENTS. THIS WORKED. 
*
*Test 3:
*Input:
*Go to the dark forest, darkness, woods, and rain forest and move between rooms. 
*
*Expected Result:
*Items regenerate in each room as you leave and come back. 
*
*Actual: 
*Matched expectations. 
*
* CODE:
* 
*/

import java.util.*;

public class Control{
	//Default constructor
	Control() {
	}
	//Create new instances of randomizer, mainCharact and init.
	//Create all class variables
	Randomizer r = new Randomizer();
	MainCharacter thePlayer = new MainCharacter();
	Init game = new Init();
	String action;
	String item;
	String character;
	Boolean isFound = false;
	Boolean moved;
	Boolean flip = false;
	Boolean worked = false;
	Boolean hasDarts;
	Boolean hasGold;
	
	// This method converts the user input to an integer and returns that integer for the purposes of heading in a direction. 
	private int convertDirection(String input) {
		//Create method variables.
		String d = input;
		//Set the direction variable to a default value.
		int theDirection = 9999;
		//Switch structure to convert the inputs to an integer. 
		switch(d) {
		case "north" :case "n":case "N": theDirection = 0;break;
	    case "south" :case "s":case "S": theDirection = 1;break;
		case "east" :case "e" :case "E": theDirection = 2;break;
		case "west" :case "w":case "W": theDirection = 3;break;
		
		}
		moved = true;
		
		return theDirection; 
	}
	
	// Convert the user input to an action method. 
	private void convertAction(String action) throws InterruptedException {
		String a = action; 
		switch (a) {
		//Action + Item Commands
		case "take" : pickUp(); break;
		case "grab" : pickUp(); break;
		case "drop" : drop(); break;
		case "eat" : eat(); break;
		case "drink": drink(); break;
		case "look": look(); break;
		case "inventory": checkInventory(); break;
		case "health": checkHealth(); break;
		case "help": help(); break;
		case "points": checkTreasure(); break;
		
		}
	}

	
	//Pick up method to pick up items.
	public void pickUp() {
		//loop through the items in the room. 
		ArrayList<Item> tempList = new ArrayList<>();
		for (Item i : thePlayer.myloc.RoomItemInv.inv) {
			//If the item variable, which is assigned in the handleCommands method matches with an item in the current room of the 
			//player, then add the item to the player's inventory using the pickUp method in the MainCharacter class.
			if(item == i.name) {
				if(i.itemCount > 1) {
					i.itemCount --;
					thePlayer.pickup(i);
					isFound = true;
					System.out.println("\nYou picked up the " + item + ".");
					tempList.add(i);
					
				} else {
					System.out.println("\nYou picked up the " + item + ".");
					thePlayer.pickup(i);
					isFound = true;
				}
			} else {
				tempList.add(i);
			}
		}
		// The above sets the room item inventory that does not include the picked up item to a templist then below makes that equal to the room's
		// inventory. 
		thePlayer.myloc.RoomItemInv.inv = tempList;
		
		if(!isFound) {
			System.out.println("\nThere is no item with that name in this room.");
		}
		isFound = false;
	}
	
	//A method to eat food in the game.
	public void eat () {
		//Check if the player's inventory contains any of the two food items in the game.
		if(thePlayer.itemInventory.inv.contains(game.apple) || thePlayer.itemInventory.inv.contains(game.cakeEatMe)) {
		System.out.println("\nYou ate some food, reducing your hunger.");
		}
		//create temp list to hold items not matching search in for loop. 
		ArrayList<Item> tempList = new ArrayList<>();
		//Loop through the players inventory 
		for(Item i : thePlayer.itemInventory.inv) {
			// if the item assigned in handleCommands is found then reduce hunger 
			if(i.name == item) {
				if(i.itemCount > 1) {
					i.itemCount -- ;	
					thePlayer.setHunger(i);
					worked = true;
					thePlayer.itemInventory.usedItems.add(i);
					tempList.add(i);
				} else {
				thePlayer.setHunger(i);
				thePlayer.itemInventory.usedItems.add(i);
				worked = true;
				}
				
			} else {
				//for each item not found, add it to the temp list
				tempList.add(i);
				
			}
		}
		//Set the temp list to the players inventory to update it. 
		thePlayer.itemInventory.inv = tempList;
		//set error 
		if(!thePlayer.itemInventory.inv.contains(game.apple)) {
			if(!worked) {
				System.out.println("You cannot eat any food, you don't have any in your inventory");
				
			}
			worked = false;
			}
	}

	
	//Method to drink water
	public void drink() {
		// Follows the same logic as the eat method with everything being set for water. 
		if(thePlayer.itemInventory.inv.contains(game.water)) {
		System.out.println("\nYou drank some water, reducing your thirst.");
		}
		ArrayList<Item> tempList = new ArrayList<>();
		for(Item i : thePlayer.itemInventory.inv) {
			if(i.name == item) {
				if(i.itemCount > 1) {
					i.itemCount --;	
					thePlayer.setThirst(i);
					worked = true;
					thePlayer.itemInventory.usedItems.add(i);
					tempList.add(i);
				} else {
				thePlayer.setThirst(i);
				worked = true;
				}
				
			} else {
				tempList.add(i);
				
				
				
			}
		}
		thePlayer.itemInventory.inv = tempList;
		if(!thePlayer.itemInventory.inv.contains(game.water)) {
		if(!worked) {
			System.out.println("You cannot drink any water, you don't have any in your inventory");
			
		}
		worked = false;
		}
		
	}
		
	//Method to drop any item in the game.
	public void drop() {
		//Set Method variables
		Item correct = null;
		ArrayList<Item> tempList = new ArrayList<>();
		//Loop through the character inventory
		for (Item i : thePlayer.itemInventory.inv) {
			//if item passed in handleCommand matches an item in inventory, then drop it. 
			if(item == i.name) {
				correct = i;
				worked = true;
				thePlayer.itemInventory.inv = tempList;
				// if the item is in the hall, then save it there, else, delete it. 
					if(thePlayer.myloc.name == "Hall") {
						game.hall.RoomItemInv.addItem(i);
						System.out.println("You dropped " + i.name +". It is now stored in the hall for safe keeping. You can find it here later.");
					} else {
						
					}
				}
				 else { 
					 //Add all items that dont match to the templist to save the inventory. 
					tempList.add(i);
					thePlayer.itemInventory.inv = tempList;
		}
			}
		if(!worked) {
			System.out.println("Cannot drop item, it is not in your inventory");
		}
		worked = false;
	}
	
	//Check health status
	public void checkHealth() {
		thePlayer.checkHealth();
	}
	
	//Check inventory status
	public void checkInventory() {
		thePlayer.itemInventory.showInventory();
	}
	
	//Check treasure
	public void checkTreasure() {
		System.out.println("\nYou have the following amount of treasure:");
		System.out.println(thePlayer.treasure);
	}
	
	//help Menu
	public void help() {
		System.out.println("**********************************************");
		System.out.println("HELP MENU:");
		System.out.println("**********************************************");
		
		System.out.println("AVAILABLE COMMANDS:"
				+ "\nDirections: North, South, East, West"
				+ "\nTake <item name>: Pick up any item in a room"
				+ "\nGrab <item name>: Same function as take"
				+ "\nEat <food name>: Eat a piece of food to keep your hunger down. "
				+ "\nDrink <drink name>: Drink something to keep your hunger down"
				+ "\nDrop: drop an item in the room you're currently in. You can carry 4 types of items in unlimited quanities. The hall is the safe storage area where you can store items. If you drop items anywhere else, they will be gone forever."
				+ "\nLook: Check to see what items and characters are in a room."
				+"\nQuit: Quits the game"
				+ "\n\nSTATUS CHECKS:"
				+ "\nInventory: Displays the items in your inventory."
				+ "\nHealth: Displays your health status."
				+ "\nPoints: Displays how many pieces of treasure you have acquired.");
	}
	
	//Error Menu
	public void error() {
		System.out.println("Sorry, I don't recognize that term.");
	
	}

	//Look at what is in a room. 
	public void look() {
		if(thePlayer.myloc.RoomItemInv.inv.size() == 0 || thePlayer.myloc.RoomItemInv.inv.contains(game.placeHolder) ) {
			System.out.println("\nThere are no items in this room.");
		}
		else {
		System.out.println("\nYou look for items in " + thePlayer.myloc.name + " and find...");
		for(Item item : thePlayer.myloc.RoomItemInv.inv) {
			System.out.println(item.name);
			}	
			}
		if(thePlayer.myloc.CharacterInv.character.size() > 0 && !thePlayer.myloc.CharacterInv.character.contains(game.empty)) {
		System.out.println("\nYou also look for characters:");
		for(Character c: thePlayer.myloc.CharacterInv.character) {
			System.out.println(c.name);
		}
		} else {
			System.out.println("\nThere are no characters in this room.");
		}
		
		
	}
	
	//Check whether user input matches items and actions
	public void isValid(String action, String items) throws InterruptedException{
		//set method vars
		Boolean found = false;
		//loop through list of strings of all items and actions
		for(Item item : game.allItems) {
			for(Action act : game.allActions) {
				//check if the inventory contains an item and doesnt contain grab or take. 
				if (thePlayer.itemInventory.inv.contains(item) && !act.equals(game.take) && !act.equals(game.grab)) {
					if(item.name == items && act.name == action) {
						// loop through all valid actions
						for(Action a : item.validActions) {
							// if valid action is found then run convertAction passing through that action. 
							if(a.name == action) {
								found = true;
								convertAction(action);
							} 
								
						}
							
						} 
					
					} else if(item.name == items && act.name == action) {
							for(Action a : item.validActions) {
								if(a.name == action) {
									found = true;
									convertAction(action);
								} 
						
					}
				} 
					
				}
					}
	}
			
	
	//Method to initiate the game. 
	public void startAdventure() throws InterruptedException{
		//Create Alice
		game.setActions();
		game.setCharacter();
		game.setDoors();
		game.setItem();
		game.setLongDescriptions();
		game.setShortDescriptions();
		game.setNames();
		game.addToArrayList();
		game.introduction();
		thePlayer.setLoc(game.river);
		handleCommands();
		
		}

	//A method to handle user input.
	public void handleCommands() throws InterruptedException {
		//open scanner
		Scanner keyboard = new Scanner(System.in);
		String inputString;
		Boolean recognized = false;
		
		//infinite while loop to take user input. 
		while (true) {
			//set recognized variable to false which will tell us whether the search is recognized for the purposes of error reporting. 
			recognized = false;	 
			keyEvent();
			
			
			
		
		int direction = 9;
		System.out.println("\n");
		// set user input to variable and convert it to lower case
		inputString = keyboard.nextLine().toLowerCase();
		
		if(inputString.equals("grab") || inputString.equals("take") || inputString.equals("eat") || inputString.equals("drink") || inputString.equals("drop")) {
			recognized = true;
			System.out.println("\nThis is a valid keyword, but it must be paired with an item name in your inventory or in the room."
					+ "\nFor example: Take water or eat apple.");
		}
		
		//parse user input with empty space characters.
		String[] arrayOfInput = inputString.split(" ");
		
		//loop through each word in user input
		for (String a : arrayOfInput) {
			
			
			//check if the input includes direction indicators. 
			if(a.contains("north") || a.contains("south") || a.contains("east") || a.contains("west") || a.equals("e") || a.equals("n") || a.equals("s") || a.equals("w")) {
				direction = convertDirection(a);
				thePlayer.go(direction);
				recognized = true;
			
			// if user input is look then pass to convertAction.
			} else if(a.contains("look") || a.equals("l") ) {
		 		convertAction(a);
		 		recognized = true;
		 		
		 	//if it includes anything to do with inventory, pass to convertaction. 	
		    } else if( a.equals("i") || a.equals("invent") || a.equals("inventory")) {
		    	String conversion = "inventory";
		    	convertAction(conversion);
		    	recognized = true;
		    }
		    			
			}
		// run for loop through a list of all actions and all items 
		for(String act : game.accActions) {
			for(String ite : game.accItems) {
				//if user input matches anything in these two lists, assign the class variables to that so other methods can use it. 
				if (inputString.contains(ite) && inputString.contains(act)) {
					item = ite;
					action = act;
					// Check if valid
					isValid(action, item);
					recognized = true;
					
				} 
				
			}
		}
		// loop through all actions that do not require an item
		for(Action actions : game.noItemActions) {
			if(inputString.contains(actions.name)) {
				//if match then pass to convert action. 
				action = actions.name;
				recognized = true;
				convertAction(action);
			}
		}
		
		
		
		//assign any characters in the game to a class variable 
		for(Character c : thePlayer.myloc.CharacterInv.character) {
			if(inputString.contains(c.name)) {
				character = c.name;
			}
		}
			//quit options
			if(inputString.equals("quit") ) {
				System.out.println("Quitting the game. Bye.");
				recognized = true;
				System.exit(0);
			}
			//if the input is not recognized, call error method. 
			if(!recognized) {
				error();
			}
	
		}
	
}
	//A method that handles all key events in the game.
	public void keyEvent() throws InterruptedException {
		//Create ArrayLists. 
		ArrayList<Item> tempList = new ArrayList<>();
		ArrayList<Character> tempCharList = new ArrayList<>();
		
		if(thePlayer.itemInventory.inv.contains(game.blowdart)) {
			hasDarts = true;
			
		} else {
			hasDarts = false;
		}
		
		if(thePlayer.itemInventory.inv.contains(game.foolsGold)) {
			hasGold = true;
		} else {
			hasGold = false;
		}
		
		//First condition -  if the player is in the hall and visit count is 1 and the player doesnt have the golden key. 
		if(thePlayer.myloc.name == "Hall" && game.hall.visitCount == 1 && !thePlayer.itemInventory.usedItems.contains(game.goldenKey)) {
			// lock all doors in the hall
			game.toBeach.lock();
			game.toRabbit.lock();
			
			// if the white rabbit is in the room, then run its dialogue;
			for(Character c : thePlayer.myloc.CharacterInv.character) {
				if(c.name == "White Rabbit") {
					System.out.println(c.dialogue);
				}
			}
		}
		
		//loop through used items list, if the cake hasn't been eaten then print out this specific message and add to visit count then unlock the door
		for(Item i : thePlayer.itemInventory.usedItems) {
			if(i == game.cakeEatMe && flip == false) {
				if(thePlayer.myloc.name.equals("Hall")) {
					System.out.println("\nYou eat the cake and grow temporarily to be 30 feet tall and unlock the door to the west..."
							+ "\n\nAfter opening the door, you shrink back to regular size.");
					flip = true;
					game.hall.visitCount ++;
					game.toBeach.unlock();
					game.toRabbit.unlock();
					System.out.println("\nThe doors to the west suddenly unlocked...");
				} else {
					System.out.println("\nA smiling cat walks by and whispers that a door near the hall just unlocked because a full stomach makes for new opportunities in Wonderland.");
					flip = true;
					game.hall.visitCount ++;
					game.toBeach.unlock();
					game.toRabbit.unlock();
					System.out.println("\nThe doors to the west suddenly unlocked...");
				}
					
				}
			}
		
		//if hunger or thirst gets too high, print this message
		if(thePlayer.hunger > 7) {
			System.out.println("\nWarning: You are getting extemely hungry.");
			
		} if(thePlayer.thirst > 7) {
			System.out.println("\nWarning: You are getting extremely thirsty.");
		}
		
		//if the inventory contains the golden key
		if(thePlayer.itemInventory.inv.contains(game.goldenKey)) {
			// loop through the players inventory
				for(Item i : thePlayer.itemInventory.inv) {
					//add to used items.
					if(i.name == game.goldenKey.name) {
						thePlayer.itemInventory.usedItems.add(i);
					} else {
						tempList.add(i);
					}
					//reset inventory without the key
					thePlayer.itemInventory.inv = tempList;
				
				}
				System.out.println("\nYou try the key on both doors. It opens the door to the east. Suddenly the key disappears...");
				game.toRabbit.unlock();
			

			// Add fools gold.
		} else if(thePlayer.myloc == game.hall && game.hall.visitCount == 2 && !game.hall.RoomItemInv.inv.contains(game.foolsGold)) {
			thePlayer.myloc.RoomItemInv.addItem(game.foolsGold);
		}
			
			else if(thePlayer.myloc == game.beach && thePlayer.treasure == 1) {
			// add items if you help the rabbit. 
			System.out.println("\nThe white rabbit thanks you for helping it and gives you food, water and 1 piece of treasure!");
			thePlayer.pickup(game.treasure);
			thePlayer.pickup(game.apple);
			thePlayer.pickup(game.water);
			thePlayer.pickup(game.water);
			game.toRabbit.unlock();
			System.out.println("\nYou can eat or drink any time to reset your thirst and hunger. Remember, to keep an eye on your health by typing 'health'.");
		
			//if in the rabbit house run scene
		} else if(thePlayer.myloc == game.rabbitHouse && thePlayer.myloc.visitCount == 1) {
			System.out.println("\nThe White Rabbit turns to you and says: ");
			System.out.println("\nI have two more pieces of gold for you if you can go in the woods and find a vial of clear liquid. It was taken from me.");
		
			//if the player has explored the rest area add the sapphire crown.
		} else if(game.beach.visitCount == 1 && game.restArea.visitCount == 1 && !game.beach.RoomItemInv.inv.contains(game.sapphireCrown)) {
			game.beach.RoomItemInv.addItem(game.sapphireCrown);
			//scene where the player contends with the thief and has the chance to get a vial. 
		} else if(thePlayer.myloc == game.woods && thePlayer.myloc.visitCount == 1 && !thePlayer.itemInventory.inv.contains(game.vial)) {
			while(thePlayer.myloc == game.woods && thePlayer.myloc.visitCount == 1) {
			//open scanner
			Scanner s = new Scanner(System.in);
			System.out.println("\nYou see a shadowy character hiding in a bush...");
			Thread.sleep(1000);
			System.out.println("\nHe jumps out at you and has a knife!");
			System.out.println("\nThe thief says 'give me all your treasure or I will kill you!'");
			// If player has defensive item then prompt to see if user wants to use it 
			if(thePlayer.itemInventory.inv.contains(game.foolsGold)) {
				System.out.println("\nYou have fools gold in your bag... would you like to try to give that to the thief? ");
				String answer = s.nextLine();
				if(answer.contains("y")) {
					// remove fools gold
					if(game.foolsGold.itemCount > 1) {
						game.foolsGold.itemCount --;
						
					} else {
						thePlayer.itemInventory.inv.remove(game.foolsGold);
					}
					//gain vial
					System.out.println("\nThe thief is pleasantly surprised by your compliance and he feels bad... He gives you a small vial with clear liquid as consolation.");
					thePlayer.pickup(game.vial);
					break;
					
					//if you don't have defensive item then trade your treasure or perish. 
				} else if(answer.contains("n")) {
					System.out.println("\nGive the thief all your treasure?");
					String answer2 = s.nextLine();
					if (answer2.contains("y")){
						thePlayer.treasure = 0;
						System.out.println("\nThe thief is pleasantly surprised by your compliance and he feels bad... He gives you a small vial with clear liquid as consolation.");
						thePlayer.pickup(game.vial);
						break;
						 
					} else if(answer2.contains("n")) {
						System.out.println("\nThe thief has attacked and killed you.");
						thePlayer.setLife();	
						break;
					}
				
			} 
			
		} else {
			//if you don't have defensive item then trade your treasure or perish.
			System.out.println("\nGive the thief all your treasure?");
			String answer2 = s.nextLine().toLowerCase();
			if (answer2.contains("y")){
				thePlayer.treasure = 0;
				System.out.println("\nThe thief is pleasantly surprised by your compliance and he feels bad... He gives you a small vial with clear liquid as consolation.");
				thePlayer.pickup(game.vial);
				break;
				
			} else if(answer2.contains("n")) {
				System.out.println("\nThe thief has attacked and killed you.");
				thePlayer.setLife();	
				System.exit(0);
				break;
			} else {
				System.out.println("\nInvalid input, try again.");
				keyEvent();
			}
			
		}
			s.close();
} 
  //if the player is in the rabbit house and has the vial then get 2 pieces of gold. 	
} else if(thePlayer.myloc == game.rabbitHouse && thePlayer.itemInventory.inv.contains(game.vial)) {
			System.out.println("\nThe white rabbit sees that you have the vial and is ecstatic!!");
			System.out.println("\nIt gives you the promised 2 pieces of gold.");
			thePlayer.treasure += 2;
			System.out.println("\nRemember, to escape wonderland, you must get 10 pieces of gold and bring it to the courthouse of this world beyond the Queen's House");
			System.out.println("I've heard that there are great riches to be found deep in the forest...");
			System.out.println("Be careful though, the forest can be very dark and dangerous. With great risk comes great reward.");
			System.out.println("Take this with you to protect yourself...");
			System.out.println("The White Rabbit gave you one blow dart");
			thePlayer.pickup(game.blowdart);
			thePlayer.itemInventory.inv.remove(game.vial);
		
		
			
 // If the play is in the queens house check for sapphire crown 		
} else if(thePlayer.myloc == game.queensHouse) {
		if(!thePlayer.itemInventory.inv.contains(game.sapphireCrown)) {
			System.out.println("\nA guard says: 'The Queen will not permit you to enter unless you find her Sapphire Crown...");
			System.out.println("*********************************************************************");
			System.out.println("You have been returned to the rain forest.");
			System.out.println("*********************************************************************");
			// Set Player Location
			thePlayer.myloc = game.rainForest;
		} else {
			System.out.println("A guard says: 'Great, I see you have the Queen's crown! Please enter!");
			System.out.println("You enter the queens house...");
			System.out.println("The Queen greets you and says 'Welcome to my castle! Let me give you some food and drink!");
			System.out.println("The food and drink restores your health.");
			System.out.println("The Queen continues: 'Beyond my castle is the courthouse of Wonderland. You must bring the members of the court 10 pieces of treasure to earn your way back to real world. Once you enter the courthouse there is no leaving. Head south if you wish to proceed.'");
			thePlayer.thirst = 0;
			thePlayer.hunger = 0;
		
		}
		
// If in darkness, run the unique ogre attack scene 
} else if(thePlayer.myloc == game.darkness && game.darkness.visitCount == 1){
	thePlayer.myloc.CharacterInv.addChar(game.ogre);
	//Set the booleans correctly depending on the items in the inventory.
	if(hasDarts) {
		for(Character c : thePlayer.myloc.CharacterInv.character) {
			c.ogreAttack(thePlayer, hasDarts);
			drop(game.blowdart);
		}
	} 	
	
	// If the players location is in the dangerous areas, produce random characters and random items. 
} else if(thePlayer.myloc == game.woods ||thePlayer.myloc == game.darkForest || thePlayer.myloc == game.rainForest) {
		ArrayList<Item> tempList2 = new ArrayList<>();
		ArrayList<Character> tempListChar = new ArrayList<>();
		// only run if the player has moved, not if they check their status in any way or their inventory or look. 
		if(moved) {
			//if the room is empty then re-randomize character generation
			if(thePlayer.myloc.CharacterInv.character.isEmpty() || thePlayer.myloc.CharacterInv.character.contains(game.empty)) {
			thePlayer.myloc.CharacterInv.character = tempListChar;
			r.randomChar(game.ogre, game.thief, game.empty, game.empty);
			thePlayer.myloc.CharacterInv.addChar(r.ranChar);
		
		}
			//if the room has no items then re-randomize making it very likely that you will encounter treasure. 
		if(thePlayer.myloc.RoomItemInv.inv.isEmpty() || !thePlayer.myloc.RoomItemInv.inv.contains(game.treasure) ) {
			thePlayer.myloc.RoomItemInv.inv = tempList2;
			r.randomItem(game.foolsGold, game.blowdart, game.placeHolder, game.treasure, game.treasure, game.treasure);
			thePlayer.myloc.RoomItemInv.addItem(r.ranItem);
		} 

		
		//if the room has an ogre or thief in it, automatically attack the player and present different attacks depending on what the player has in inventory. 
		if(thePlayer.myloc.CharacterInv.character.contains(game.ogre) || thePlayer.myloc.CharacterInv.character.contains(game.thief)) {
			for(Character c : thePlayer.myloc.CharacterInv.character) {
				
					if(c == game.ogre) {
						// run attack with all booleans selected. 
						c.attack(thePlayer, hasGold, hasDarts, c);
						// if the attack was successful and the player had to defend using the item, then remove the item from the players inventory. 
						if(c.success) {
							drop(game.blowdart);
						}
						
					} else if(c == game.thief) {
						c.attack(thePlayer, hasGold, hasDarts, c);
						if(c.success) {
							drop(game.foolsGold);
						}	
					}
					if(!c.isDefeated) {
						 tempCharList.add(c);
					 } 
				} 
		}
			 
			 thePlayer.myloc.CharacterInv.character = tempCharList;
			 
			
			
		// set moved to false to trigger it again. 
		moved = false;
		}
		
	// if the player makes it to the courthouse, announce that they won.
} else if(thePlayer.myloc == game.courthouse){
	if(thePlayer.treasure >= 10) {
		System.out.println("\nCongrats, you made it to the end of the game with 10 pieces of treasure.");
		System.out.println("**************************************************************************");
		System.out.println("YOU WIN");
		System.out.println("**************************************************************************");
		System.exit(0);
		
	} else {
		System.out.println("\nYou made it to the the courthouse. The judge asks you if you have your treasure to escape this world. You do not. The house of cards attack you and you die.");
		System.out.println("**************************************************************************");
		System.out.println("GAME OVER");
		System.out.println("**************************************************************************");
		System.exit(0);
	}
	
	
}
}
}
