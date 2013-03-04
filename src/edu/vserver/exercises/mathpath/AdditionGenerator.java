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

		int slicer;
		int slicedResult = 0;
		int slicerSum = 0;

		// String equation = "" + slicer + " + " + (result - slicer);

		String equation = "";

		for (int i = 1; i < amountOfNumbers; i++) {

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
		int mid = (min + max) / 2;
		return mid;
	}

}
