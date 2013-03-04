package edu.vserver.exercises.mathpath;

import java.util.Random;

public class AdditionGenerator implements ArithmeticsInterface {

	private final int amountOfNumbers;

	public AdditionGenerator(int amountOfNumbers) {

		this.amountOfNumbers = amountOfNumbers;

	}

	@Override
	public String calculate(int result) {

		Random rnd = new Random();

//		int slicer;
//		int slicedResult = 0;
//		int slicerSum = 0;

		// String equation = "" + slicer + " + " + (result - slicer);

		String equation = "";
		
		int oldSlicer = 0;

		for (int i = 0; i < amountOfNumbers; i++) {

			int slicer = getRandomSlicerBetween(oldSlicer, result);
			
			//slicedSum = slicer;
			
			if (i == amountOfNumbers - 1) {
				equation = equation + (result - oldSlicer);
			} else {
				equation = equation + (slicer - oldSlicer) + " + ";
			}
			
			oldSlicer = slicer;
			
			/*
			 * slicer = rnd.nextInt(result - slicedResult - 1) + slicedResult +
			 * 1; slicerSum += slicer - slicedResult;
			 * 
			 * if (i == amountOfNumbers - 1) { equation += slicer + " + " +
			 * (result - slicerSum); } else { equation += slicer + " + "; }
			 * 
			 * slicedResult = slicer;
			 */
		}
		return equation;
	}

	private int getRandomSlicerBetween(int min, int max) {
		Random rnd = new Random();
		
		// go around the problem of negative n in nextInt(n)
		if (max-min-2 < 1) {
			return min + 1;
		}
		
		int result = rnd.nextInt(max-min-2) + min + 1 ;
		
		if (result - min >= max - result) {
			result = max - result + min;
		}
		
		return result;
	}

}
