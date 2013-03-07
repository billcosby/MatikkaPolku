package edu.vserver.exercises.mathpath;

import java.util.Random;

public class AdditionGenerator implements ArithmeticsInterface {

	private final int amountOfNumbers;

	public AdditionGenerator(int amountOfNumbers) {

		this.amountOfNumbers = amountOfNumbers;

	}

	@Override
	public String calculate(int result) {

		String equation = "";

		int oldSlicer = 0;

		for (int i = 0; i < amountOfNumbers; i++) {

			int slicer = getRandomSlicerBetween(oldSlicer, result);

			if (i == amountOfNumbers - 1) {
				equation = equation + (result - oldSlicer);
			} else {
				equation = equation + (slicer - oldSlicer) + " + ";
			}

			oldSlicer = slicer;

		}
		return equation;
	}

	private int getRandomSlicerBetween(int min, int max) {
		Random rnd = new Random();

		// go around the problem of negative n in nextInt(n)
		if (max - min - 2 < 1) {
			return min + 1;
		}

		int result = rnd.nextInt(max - min - 2) + min + 1;

		if (result - min >= max - result) {
			result = max - result + min;
		}

		return result;
	}

}
