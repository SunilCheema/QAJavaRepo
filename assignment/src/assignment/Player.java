package assignment;


public class Player {
	public int x = 5;
	public int y = 5;
	
	//Changes x and y based on input parameters 
	public void moveDirection(String direction, int steps) {
		switch(direction) {
		case "right": this.x += steps; break;
		case "left": this.x-= steps; break;
		case "up": this.y += steps; break;
		case "down": this.y -= steps; break;
		}
		
	}
}
