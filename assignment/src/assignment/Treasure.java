package assignment;

import java.util.Random;

public class Treasure {
	
	//Generate random Coordinates for treasure
	Random rand = new Random();
	public int x = rand.nextInt((10 - 1) + 1) + 1;
	public int y = rand.nextInt((10 - 1) + 1) + 1;
	
	
}
