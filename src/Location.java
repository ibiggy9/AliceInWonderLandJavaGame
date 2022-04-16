/**
* title: Location.java
* description: Creates a room
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
* Location.java
*
* Purpose and Description:
* Creates a room that can hold items and characters and is connected to doors and built out of walls made 
* from the wall interface. 
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
* Location.java
* 
* Class Variables:
* shortDescription: stores short description of the location
* longDescription: stores the long description of the location
* name: stores the name of the location
* visitCount: an integer that stores the number of times the player has been in the room. 
* RoomItemInv: an inventory that stores the items in this room
* CharacterInv: an inventory that stores all characters in the room. 
* hasBeenVisited: a flag to say if the room has been visited at lease once.
*  
* Constructors:
* Location(): a constructor that implements room site through assigning the 4 sides of a room to the wall class
* 
* Methods:
* setSide(): sets the side of a room to something other than a wall
* enter(): sets the character location to this room. 
* setName(): sets the name of the location
* getDesc(): gets the descritpion of this location
* setShortDesc(): sets the short description of the room
* setLongDesc(): sets the long description of the ropm.
* addChar(): adds a character to this location
* removeChar(): removes a character from this location
* exit(): leaves this room.
* isEmpty(): checks if this room is empty from a character and item perspective. 
* 
* 
* Test Plan:
*  All testing was done in the control class.
*
* CODE:
* 
*/

public class Location implements roomSite{
	//Set class variables
	public String shortDescription;
	public String longDescription;
	public String name;
	Integer visitCount = 0;
	
	private roomSite[] side = new roomSite[4];
	Inventory RoomItemInv = new Inventory(100);
	Inventory CharacterInv = new Inventory(100);
	Boolean hasBeenVisited = false;
	
	//Create Constructor
	Location(){
		side[0] = new Wall();
		side[1] = new Wall();
		side[2] = new Wall();
		side[3] = new Wall();
	}
	
	// Setter to set a wall to a door. 
	public void setSide(int direction, roomSite m) {
		side[direction] = m;
	}
	
	//enter - the final method that moves a player once they have exited a room. 
	public void enter(MainCharacter p) {
		p.setLoc(this);
		
		
	}
	
	//Set the name of the room
	public void setName(String name) {
		this.name = name;
	}
	
	//Get the description of the room depending on whether it has been visited before.
	public void getDesc() {
		if(this.name == "river") {
			System.out.println("\n" + longDescription);
		} else if(!hasBeenVisited) {
		System.out.println("\n" + longDescription);
		} else if (hasBeenVisited) {
			System.out.println("\n" + shortDescription);
		}
		
		System.out.println(longDescription);
	}
	
	//Set short description
	public void setShortDesc(String description) {
		shortDescription = description;
		
	}
	//Set long description
	public void setLongDesc(String description) {
		longDescription = description;
	}
	
	//Add character to a room
	public void addChar(Character c) {
		CharacterInv.character.add(c);
		
	}
	
	//Exit a room. 
	public void exit(int direction, MainCharacter p) {
		side[direction].enter(p);
	}
	
	//check if room isEmpty
	public Boolean isEmpty() {
		if(RoomItemInv.inv.size()== 0) {
			return true;
		} else {
			return false;
		}
	}
	

}
