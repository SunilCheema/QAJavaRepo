package assignment;
import java.util.*;
import static java.lang.Math.sqrt;

public class Grid {
	
	
	//finds the horizontal and vertical distance between player and treasure and returns the results in an array
	public int[] findDistance(Player player, Treasure treasure) {
		
		int[] result = new int[2];
		int xDistance = player.x - treasure.x;
		int yDistance = player.y - treasure.y;
		
		if(xDistance < 0) {
			xDistance = xDistance *  -1;
		}
		
		if(yDistance < 0) {
			yDistance = yDistance * -1;
		}
		
		result[0] = xDistance;
		result[1] = yDistance;
		
		return result;
	}
	
	//calculates hypotenuse between treasure and player
	public double calculateExactDistance(Player player, Treasure treasure) {
		int[] array = this.findDistance(player, treasure);
		int xDistance = array[0];
		int yDistance = array[1];
		int aSquared = (xDistance * xDistance); 
		int bSquared = (yDistance * yDistance);
		int cSquared = aSquared + bSquared;
		double result = sqrt(cSquared); 
		
		return result;
		
	}
	
}
