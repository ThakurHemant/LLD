package snakeandladder;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {

	private int numberOfDice;
	private static final int min = 1;
	private static final int max = 6;
	
	public Dice(int numberOfDice) {
		this.numberOfDice = numberOfDice;
	}
	
	public int throwDice() {
		int ans = 0;
		for(int i=0;i<this.numberOfDice;i++) {
			ans += ThreadLocalRandom.current().nextInt(min, max+1);
			
		}
		return ans;
	}
}
