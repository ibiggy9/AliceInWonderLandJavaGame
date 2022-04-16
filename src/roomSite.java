/**
* title: roomSite.java
* description: Creates a roomSite interface
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
* roomSite.java
*
* Purpose and Description:
* The purpose of this class is to create an interface that helps create walls in a location through the generation of an abstract
* method that the location and wall class can access. 
*
*
* Compiling and running instructions<
* Required: openjdk version "17" 2021-09-14
* OpenJDK Runtime Environment Temurin-17+35 (build 17+35)
* OpenJDK 64-Bit Server VM Temurin-17+35 (build 17+35, mixed mode, sharing)	
* Compile:  javac Game.java
* Compile #2: javac Init.java
* Compile #3: javac MainroomSite.java
* Run:      Game.java
*
*/
/**
*
* Classes:
*
* roomSite.java
* 
* Class Variables:
* None.
*  
* Constructors:
* none.
* 
* Methods:
* enter: abstract method used to enter a new room/wall. 
* 
* Test Plan:
* All testing was done in the control class.
*
* CODE:
* 
*/

// set up an interface to mediate the sides of the location. 
interface roomSite{	
 void enter(MainCharacter p);
		
	
	
	
	}
