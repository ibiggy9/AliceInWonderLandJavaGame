/**
* title: Init.java
* description: Creates the gamespace
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
* Init.java
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
* Init.java
* 
* Class Variables:
* accActions: a list to store all action names for the purposes of parsing user input in control class
* noItemActions:  a list of actions that do not require items to run
* accItems: a list of strings to store all item names for the purpose of parsing user input in control class
* allItems: a list of all items. 
* allActions: a list of all actions. 
* locDescriptions: an array of location descriptions
* actName: an array of action names
* charName: an array of character names.
* itemName: an array of ItemNames. 
* 
*  
* Constructors:
* Door() = Sets the original location and destination location. 
* 
* Methods:
* addtoArrayList(): this method adds all items and actions to arraylists 
* setNames(): This method sets the name of the locations
* 
* setDoors(): this method sets up all doors in the game
* setShortDescriptions(): sets short descriptions of all locations
* setLongDescriptions(): sets long descriptions of all locations
* setItem(): sets all attributes of items
* setCharacter(): sets all character attributes
* setActions(): set action attributes for the game. 
* introduction(): a method to run the introduction to the game. 
* 
* 
* Test Plan:
* All testing was done in the control class.
*
* CODE:
* 
*/
import java.util.*;
import java.io.*;

class Init {
	// default constructor 
	Init(){
	}
	
	//class data structures
	ArrayList<String> accActions = new ArrayList<>();
	ArrayList<Action> noItemActions = new ArrayList<>();
	ArrayList<String> accItems = new ArrayList<>();
	ArrayList<Item> allItems = new ArrayList<>();
	ArrayList<Action> allActions = new ArrayList<>();
	
	String[] locDescriptions = new String[100];
	String[] actName = new String[100];
	String[] charName = new String [100];
	String[] itemName = new String[100];
	
	//Make Rooms 
	Location river = new Location();
	Location hall = new Location();
	Location beach = new Location();
	Location rabbitHouse = new Location();
	Location restArea = new Location();
	Location woods = new Location();
	Location darkForest = new Location();
	Location darkness = new Location();
	Location rainForest = new Location();
	Location queensHouse = new Location();
	Location courthouse = new Location();
	
	//Create Doors
	Door rabbitHole = new Door(river, hall);
	Door toBeach = new Door(hall, beach);
	Door toHall = new Door(beach, hall);
	Door toRabbit = new Door(hall, rabbitHouse);
	Door toHallR = new Door(rabbitHouse, beach);
	Door toWoods = new Door(rabbitHouse, woods);
	Door toDarkW = new Door(woods, darkForest);
	Door toRabbitW = new Door(woods, rabbitHouse);
	Door toWoodsD = new Door(darkForest, woods);
	Door toRestD = new Door(darkForest, restArea);
	Door toBeachR = new Door(restArea, beach);
	Door toRain = new Door(darkForest, rainForest);
	Door toQueens = new Door(rainForest, queensHouse);
	Door toCourt = new Door(queensHouse, courthouse);
	Door toDarkness = new Door(darkForest, darkness);
	Door andBack = new Door(darkness, darkForest);
	Door toDark = new Door(restArea, darkForest);
	Door toDarkFromRain = new Door(rainForest, darkForest);
	Door toRainFromQueens = new Door(queensHouse, rainForest);
	Door toHallFromRab = new Door(rabbitHouse, hall);
	Door toDarkFromDarker = new Door(darkness, darkForest);
	Door toBeachFromRest = new Door(restArea, beach);
	
	//Create Items 
	Item goldenKey = new Item();
	Item cakeEatMe = new Item();
	Item vial = new Item();
	Item treasure = new Item();
	Item apple = new Item();
	Item water = new Item();
	Item sapphireCrown = new Item();
	Item placeHolder = new Item();
	
	//Malicious Character Defense Items:
	Item foolsGold = new Item(); 
	Item blowdart = new Item();
	
	//Create Actions
	Action take = new Action();
	Action grab = new Action();
	Action drop = new Action();
	Action eat = new Action();
	Action drink = new Action();
	
	//No Item Actions
	Action checkInv = new Action();
	Action help = new Action();
	Action checkHealth = new Action();
	Action checkTreasure = new Action();
	
	
	//Create Characters
	Character whiteRabbit = new Character();
	Character queen = new Character();
	Character cards = new Character();
	Character empty = new Character();
	
	//Malicious Characters
	Character ogre = new Character();
	Character thief = new Character();

	//Add Actions and items to arrayList
	public void addToArrayList() {
		accActions.add(take.name);
		accActions.add(grab.name);
		accActions.add(drop.name);
		accActions.add(eat.name);
		accActions.add(drink.name);
		
		accItems.add(goldenKey.name);
		accItems.add(cakeEatMe.name);
		accItems.add(vial.name);
		accItems.add(treasure.name);
		accItems.add(blowdart.name);
		accItems.add(water.name);
		accItems.add(apple.name);
		accItems.add(foolsGold.name);
		accItems.add(placeHolder.name);
		accItems.add(sapphireCrown.name);
	}
	
	//Connect doors to rooms
	public void setDoors() {
		//River
		river.setSide(1, rabbitHole);
		
		
		//Hall
		hall.setSide(3, toBeach);
		hall.setSide(2, toRabbit);
		
		//Beach
		beach.setSide(2, toHall);
		
		//Rabbit House
		rabbitHouse.setSide(1, toWoods);
		rabbitHouse.setSide(3, toHallFromRab);
		
		//Woods
		woods.setSide(3, toDarkW);
		woods.setSide(0, toRabbitW);
		
		//Darkness
		darkness.setSide(1, toDarkFromDarker);
		
		//Dark forest
		darkForest.setSide(0, toDarkness);
		darkForest.setSide(1, toRain);
		darkForest.setSide(2, toWoodsD);
		darkForest.setSide(3, toRestD);
		
		//Rest Area
		restArea.setSide(2, toDark);
		restArea.setSide(0, toBeachFromRest);
		
		//RainForest
		rainForest.setSide(2, toQueens);
		rainForest.setSide(0, toDarkFromRain);
		

		//Queens house
		queensHouse.setSide(3, toRainFromQueens);
		queensHouse.setSide(1, toCourt);
		
		
	}
	// set names of locations
	public void setNames() {
		river.setName("River");
		hall.setName("Hall");
		beach.setName("Beach");
		rabbitHouse.setName("Rabbit House");
		restArea.setName("Rest Area");
		woods.setName("Woods");
		darkness.setName("Darkness");
		darkForest.setName("Dark Forest");
		rainForest.setName("Rain Forest");
		queensHouse.setName("Queens House");
		courthouse.setName("Courthouse");
	}
	
	// set short descriptions of locations
	public void setShortDescriptions() {
		// open and loop through text file containing the descriptions. 
		int counter = 0;
		try {
		File file = new File("textFiles/locations/shortDes");
		Scanner scan = new Scanner(file);
		scan.useDelimiter("\n");		
		while (scan.hasNextLine()){
			String desc = scan.next();
			
			if (scan.hasNext()) {
				locDescriptions[counter] = desc;
				counter ++;
			
			} else {
				break;
			}
		
		}
		// add each item to the location. 
		river.setShortDesc(locDescriptions[0]);
		hall.setShortDesc(locDescriptions[1]);
		beach.setShortDesc(locDescriptions[2]);
		rabbitHouse.setShortDesc(locDescriptions[3]);
		restArea.setShortDesc(locDescriptions[4]);
		woods.setShortDesc(locDescriptions[5]);
		darkForest.setShortDesc(locDescriptions[6]);
		darkness.setShortDesc(locDescriptions[7]);
		rainForest.setShortDesc(locDescriptions[8]);
		queensHouse.setShortDesc(locDescriptions[9]);
		courthouse.setShortDesc(locDescriptions[10]);

		
		// close scanner. 
		scan.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}
		// set long descriptions for the locations 
	public void setLongDescriptions() {
		int counter = 0;
		
		try {
		File file = new File("textFiles/locations/longDes");
		Scanner scan = new Scanner(file);
		scan.useDelimiter("\n");		
		while (scan.hasNextLine()){
			String desc = scan.next();
			if (scan.hasNext()) {
				locDescriptions[counter] = desc;
				counter ++;
			} else {
				break;
			}
		
		}
		river.setLongDesc(locDescriptions[0]);
		hall.setLongDesc(locDescriptions[1]);
		beach.setLongDesc(locDescriptions[2]);
		rabbitHouse.setLongDesc(locDescriptions[3]);
		restArea.setLongDesc(locDescriptions[4]);
		woods.setLongDesc(locDescriptions[5]);
		darkForest.setLongDesc(locDescriptions[6]);
		darkness.setLongDesc(locDescriptions[7]);
		rainForest.setLongDesc(locDescriptions[8]);
		queensHouse.setLongDesc(locDescriptions[9]);
		courthouse.setLongDesc(locDescriptions[10]);

		
		scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	//set item attributes 
	public void setItem() {
		int counter = 0;
		try {
		File file = new File("textFiles/items/itemNames");
		Scanner scan = new Scanner(file);
		scan.useDelimiter("\n");		
		while (scan.hasNextLine()){
			String desc = scan.next();
			if (scan.hasNext()) {
				itemName[counter] = desc;
				counter ++;
			} else {
				break;
			}
		
		}
		//Set Name
		goldenKey.setName(itemName[0]);
		cakeEatMe.setName(itemName[1]);
		vial.setName(itemName[2]);
		treasure.setName(itemName[3]);
		apple.setName(itemName[4]);
		water.setName(itemName[5]);
		foolsGold.setName(itemName[6]);
		blowdart.setName(itemName[7]);
		sapphireCrown.setName(itemName[8]);
		placeHolder.setName(itemName[9]);
		
		treasure.setTreasure(true);
	
		//Set Valid Actions
		goldenKey.setValidActions(grab, drop, take);
		cakeEatMe.setValidActions(eat, drop, take, grab);
		vial.setValidActions(drop, drink, take, grab);
		treasure.setValidActions(take, grab);
		apple.setValidActions(eat, take, grab, drop);
		water.setValidActions(drink, take, grab, drop);
		blowdart.setValidActions(take, grab, drop);
		foolsGold.setValidActions(take, grab, drop);
		sapphireCrown.setValidActions(take, drop, grab);
		
		//add to list of all items
		allItems.add(goldenKey);
		allItems.add(cakeEatMe);
		allItems.add(vial);
		allItems.add(treasure);
		allItems.add(apple);
		allItems.add(water);
		allItems.add(foolsGold);
		allItems.add(placeHolder);	
		allItems.add(blowdart);
		allItems.add(sapphireCrown);
		
		// Add items to location in the game. 
		//Beach
		beach.RoomItemInv.addItem(apple);
		
		//Hall
		hall.RoomItemInv.addItem(goldenKey);
		hall.RoomItemInv.addItem(cakeEatMe);
		hall.RoomItemInv.addItem(treasure);
		hall.RoomItemInv.addItem(water);
		
		//Rabbit House 
		rabbitHouse.RoomItemInv.addItem(foolsGold);
		
		//Rest Area
		restArea.RoomItemInv.addItem(apple);
		restArea.RoomItemInv.addItem(water);
		restArea.RoomItemInv.addItem(water);
		
		//Darkness 
		darkness.RoomItemInv.addItem(treasure);
		darkness.RoomItemInv.addItem(treasure);
		darkness.RoomItemInv.addItem(treasure);
		
		//Rain Forest
		rainForest.RoomItemInv.addItem(water);
		
		scan.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	// Set up characters
	public void setCharacter() {
		int counter = 0;
		try {
		File file = new File("textFiles/characters/charNames");
		Scanner scan = new Scanner(file);
		scan.useDelimiter("\n");		
		while (scan.hasNextLine()){
			String desc = scan.next();
			
			if (scan.hasNext()) {
				charName[counter] = desc;
				counter ++;
			} else {
				break;
			}
		
		}
		// set flags on the ogre and thief
		ogre.setIsOgre(true);
		thief.setIsThief(true);
		
		//Set Names
		whiteRabbit.setName(charName[0]);
		thief.setName(charName[1].toString());
		queen.setName(charName[2]);
		cards.setName(charName[3]);
		empty.setName(charName[4].toString());
		ogre.setName(charName[5].toString());
		
		whiteRabbit.setDialogue("You see the White Rabbit again. It says that it is trying to get to the beach but it can't reach the door handle as it is 30 feet above the door. Perhaps you can help if you could reach the handle...");
		
		//Set Character Item inventory:
		//White Rabbit
		whiteRabbit.CharacterBag.add(treasure);
		whiteRabbit.CharacterBag.add(apple);
		whiteRabbit.CharacterBag.add(water);
		
		// Thief
		thief.CharacterBag.add(vial);
		
		
		scan.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
	}
	// Set actions attributes
	public void setActions(){
		// read file
		int counter = 0;
		try {
		File file = new File("textFiles/actions/actionNames");
		Scanner scan = new Scanner(file);
		scan.useDelimiter("\n");		
		while (scan.hasNextLine()){
			String desc = scan.next();
			
			if (scan.hasNext()) {
				actName[counter] = desc;
				counter ++;
			} else {
				break;
			}
		
		}
		// Set name 
		take.setName(actName[0]);
		grab.setName(actName[1]);
		drop.setName(actName[2]);
		eat.setName(actName[3]);
		drink.setName(actName[4]);
		checkInv.setName(actName[5]);
		help.setName(actName[6]);
		checkHealth.setName(actName[7]);
		checkTreasure.setName(actName[8]);
		
		// add to list of all actions
		allActions.add(take);
		allActions.add(grab);
		allActions.add(drop);
		allActions.add(eat);
		allActions.add(drink);
		
		
		noItemActions.add(help);
		noItemActions.add(checkHealth);
		noItemActions.add(checkTreasure);
		
	
		scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	// Introduction to the game. 
	public void introduction() {
		System.out.println("Welcome to this interpretation of Alice in Wonderland!\n"
				+ "In this game, you are playing as Alice and you are about to enter the wonderful world of Wonderland."
				+ "Your goal is to escape this world through collecting 10 pieces of treasure and presenting it to "
				+ "the judge in the Courthouse. Be careful though, if you come to the judge without 10 pieces of "
				+ "treasure, he will sentence you to life in Wonderland.\n");
		
		System.out.println("Treasure is scattered across Wonderland in the various locations you will find yourself in."
				+ " Some of the characters you will meet have treasure that they will give you if you help them out. This world is"
				+ " also filled with villans and monsters that could threaten you throughout your journey. Thieves will attempt to steal your"
				+ " treasure and ogres will threaten your life. There are items that can help you defeat these villans if you look for them.\n");
		
		System.out.println("You will also need to watch your health. You can die of thirst or starvation in this world so its important that you keep fed and hydrated.\n");
		
		System.out.println("If at any time you get stuck, type help to get a list of possible commands.");
		
		System.out.println("Good luck.\n\n");
		
		System.out.println("**********************************************");
		System.out.println("OPENING SCENE:");
		System.out.println("**********************************************");
		
		System.out.println("You are sitting on the side of a river. All the sudden, a White Rabbit runs by saying that it is going to be late. He dives down a hole by the river...\nHead south to follow it down the hole...");
	
	}
}

