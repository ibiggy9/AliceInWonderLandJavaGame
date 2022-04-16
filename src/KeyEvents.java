import java.util.*;

public class KeyEvents extends Control{
	Randomizer r = new Randomizer();
	public void keyEvent() throws InterruptedException {
		if(thePlayer.myloc.name == "Hall") {
			game.toBeach.lock();
			game.toRabbit.lock();
			
			for(Character c : thePlayer.myloc.CharacterInv.character) {
				if(c.name == "White Rabbit") {
					System.out.println(c.dialogue);
				}
			}
			for(Item i : thePlayer.myloc.RoomItemInv.inv) {
				if(i.name == "big cake") {
					if(i.wasUsed) {
						game.toBeach.unlock();
					}
				}
			}
			if (thePlayer.myloc.hasBeenVisited && thePlayer.treasure == 1) {
				game.hall.RoomItemInv.addItem(game.treasure);
				game.hall.RoomItemInv.addItem(game.apple);
				game.hall.RoomItemInv.addItem(game.water);
			}
			
		} else if(thePlayer.myloc.name == "Beach") {
			System.out.println("The white rabbit thanks you for saving him and gives you food, water and 1 piece of treasure!");
			thePlayer.itemInventory.addItem(game.treasure);
			thePlayer.itemInventory.addItem(game.apple);
			thePlayer.itemInventory.addItem(game.water);
			System.out.println("You can eat or drink any time to reset your thirst and hunger. Remember to keep an eye on your health by typing 'health'");
		
		} else if(thePlayer.myloc.name == "Rabbit House" && thePlayer.myloc.hasBeenVisited == false) {
			System.out.println("The White Rabbit turns to you and says ");
			System.out.println("I have two more pieces of gold for you if you can go in the woods and find a vial of clear liquid. It was taken from me'");
		
		} else if(thePlayer.myloc.name == "Woods" && thePlayer.myloc.hasBeenVisited == false) {
			while(thePlayer.myloc.name == "Woods" && thePlayer.myloc.hasBeenVisited == false) {
			Scanner s = new Scanner(System.in);
			System.out.println("You see a shadowy character hiding in a bush...");
			Thread.sleep(3000);
			System.out.println("He jumps out at you and has a knife!");
			System.out.println("The thief says 'give me all your treasure or I will kill you!'");
			if(thePlayer.itemInventory.inv.contains(game.foolsGold)) {
				System.out.println("You have fools gold in your bag... would you like to try to give that to the thief? ");
				String answer = s.nextLine();
				if(answer.contains("y")) {
					thePlayer.itemInventory.inv.remove(game.foolsGold);
					System.out.println("The thief is pleasantly surprised by your compliance and he feels bad... He gives you a small vial with clear liquid as consolation");
					thePlayer.itemInventory.addItem(game.vial);
					break;
					
				} else if(answer.contains("n")) {
					System.out.println("Give the thief all your treasure?");
					String answer2 = s.nextLine();
					if (answer2.contains("y")){
						thePlayer.treasure = 0;
						System.out.println("The thief is pleasantly surprised by your compliance and he feels bad... He gives you a small vial with clear liquid as consolation");
						thePlayer.itemInventory.addItem(game.vial);
						break;
						
					} else if(answer2.contains("n")) {
						System.out.println("The thief has attacked and killed you");
						thePlayer.setLife();	
						break;
					}
				
			} 
			
		} else {
			System.out.println("Give the thief all your treasure?");
			String answer2 = s.nextLine();
			if (answer2.contains("y")){
				thePlayer.treasure = 0;
				System.out.println("The thief is pleasantly surprised by your compliance and he feels bad... He gives you a small vial with clear liquid as consolation");
				thePlayer.itemInventory.addItem(game.vial);
				break;
				
			} else if(answer2.contains("n")) {
				System.out.println("The thief has attacked and killed you");
				thePlayer.setLife();	
				break;
			}
			
		}
			s.close();
} 
	
} else if(thePlayer.myloc.name == "Rabbit House" && thePlayer.itemInventory.inv.contains(game.vial)) {
			System.out.println("The white rabbit sees that you have the vial and is ecstatic!!");
			System.out.println("It gives you the promised 2 pieces of gold");
			thePlayer.treasure += 2;
			System.out.println("Remember to escape wonderland, you must get 10 pieces of gold and bring it to the courthouse of this world beyond the Queen's House");
			System.out.println("I've heard that there are great riches to be deep in the forest...");
			System.out.println("Be careful though, the forest can be very dark and dangerous. With great risk comes great reward");
			System.out.println("Take this with you to protect yourself...");
			System.out.println("The White Rabbit gave you one blowdart");
			thePlayer.itemInventory.addItem(game.blowdart);
		
		//NOTE I HAVE LEFT OUT ALL MENTION OF THE FOREST AND REST AREA HERE BECAUSE
		// THIS WILL BE LEFT FOR THE RANDOMIZATION PIECE. 
			
			
} else if(thePlayer.myloc.name == "Queens House") {
		if(!thePlayer.itemInventory.inv.contains(game.sapphireCrown)) {
			System.out.println("A guard says: 'The Queen will not permit you to enter unless you find her Sapphire Crown...");
			thePlayer.myloc = game.rainForest;
		} else {
			System.out.println("A guard says: 'Oh great, I see you have the Queen's crown! Please enter!");
			System.out.println("You enter the queens house...");
			System.out.println("The Queen says to you that ");
		}
		
// you still have to program the exit to the courthouse and the randomization of the forest. 		


} else if(thePlayer.myloc.name == "Woods" || thePlayer.myloc.name == "Darkness" || thePlayer.myloc.name == "Dark Forest" || thePlayer.myloc.name == "Rain Forest") {
	thePlayer.myloc.RoomItemInv.addItem(r.randomItem());
	thePlayer.myloc.addChar(r.randomChar());
}
}
}
