package assignment;
import java.util.*;

public class Game {
	
	Grid grid = new Grid();
	Player player = new Player();
	Treasure treasure = new Treasure();
	Scanner entry = new Scanner(System.in);
	String direction;
	int distance;
	int storySection = 1;
	
	//Creates the story text
	public void generateStoryText(int i) {
		
		switch(i) {
		case 1: System.out.println("Welcome to Barren more, the worst text based RPG of all time"); 
				System.out.println("Type enter to begin"); 
				this.generateScanner(storySection);
				break;
		case 2: System.out.println("You start in the centre of a 10 * 10 grid");
				System.out.println("The treasure is in a random position inside this grid"); 
				storySection +=1;
				this.generateStoryText(storySection);
				break;
		case 3: System.out.println("Enter a direction to travel: up, left, right or down"); //story section is 3 at this point 
				this.generateScanner(storySection);
				break;
		case 4: System.out.println("Enter a number with the amount of squares you want to travel across"); 
				this.generateScanner(storySection); 
				break;
		case 5: System.out.print("the horizontal distance between you and the treasure is: "); 
				int[] values = grid.findDistance(player, treasure);
				System.out.println(values[0]);
				System.out.print("The vertical distance between you and the treasure is: ");
				System.out.println(values[1]);
				
				System.out.print("The closest distance(in grid squares) between you and the treasure is: ");
				double location = grid.calculateExactDistance(player, treasure);
				System.out.println(location);
				
				boolean winCheck = this.checkForWin();
				if(winCheck == false) {
					storySection = 3;
					this.generateStoryText(storySection);
				}
				break;
		}
		this.generateScanner(i);
	}
	
	//creates the scanner entry lines for the user
	public void generateScanner(int i) {
		String enteredValue = "";
		switch(i) {
		case 1: enteredValue = entry.nextLine(); break;
		case 3: direction = entry.nextLine(); 
				storySection +=1; 
				this.generateStoryText(storySection); 
				break; //story section is 4 after executing this line
		case 4: distance = Integer.parseInt(entry.nextLine()); 
				storySection +=1; 
				player.moveDirection(direction, distance);
				this.generateStoryText(storySection); 
				break; // story section is 5 after execution.
				
		}
		
		switch(enteredValue) {
		case "enter":  storySection +=1; generateStoryText(storySection);
						break;
		
		}
		
	}
	
	//Checks to see if the player coordinates are the same as the treasure coordinates
	public boolean checkForWin() {
		if(player.x == treasure.x && player.y == treasure.y) {
			System.out.println("Congratulations, you have found the treasure.");
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		
		Game test = new Game();
		test.generateStoryText(1);
		
	}
}

