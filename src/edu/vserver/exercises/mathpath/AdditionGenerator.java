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
		int slicedResult = 1;
		int slicerSum = 0;

		// String equation = "" + slicer + " + " + (result - slicer);

		String equation = "";

		for (int i = 1; i < amountOfNumbers; i++) {

			slicer = rnd.nextInt(result - 1) + slicedResult;
			slicerSum += slicer;
			if (i == amountOfNumbers - 1) {
				equation += slicer + " + " + (result - slicerSum);
			} else {
				equation += slicer + " + ";
			}

			slicedResult = slicer;
		}
		return equation;
	}

}
