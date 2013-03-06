package edu.vserver.exercises.mathpath;

import java.util.Random;

public class MultiplicationGenerator implements ArithmeticsInterface {

	@Override
	public String calculate(int result) {
		
		Random rnd = new Random();
		String riddle = "";
		
		int multiplier = rnd.nextInt((int) (result/2+1)-2) +2;
		int remainder = result % multiplier;
		int multiplier2 = (result-remainder) / multiplier;
		
		riddle = multiplier + " * " + multiplier2;
		
		
		if (remainder != 0) {
			riddle = riddle + " + " + remainder;
		}
		
		
		return riddle;
	}

}
