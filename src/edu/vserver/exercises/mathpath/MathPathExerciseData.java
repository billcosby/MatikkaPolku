package edu.vserver.exercises.mathpath;

import edu.vserver.exercises.model.ExerciseData;

public class MathPathExerciseData implements ExerciseData {

	private final int amountOfOptions;
	private final int min;
	private final int max;
	private final int pathLength;
	private final boolean isRandomGenerated;
	private final int inputAnswer;

	public MathPathExerciseData(int min, int max, int amountOfOptions,
			int pathLength, boolean isRandomGenerated, int inputAnswer) {
		this.amountOfOptions = amountOfOptions;
		this.min = min;
		this.max = max;
		this.pathLength = pathLength;
		this.isRandomGenerated = isRandomGenerated;
		this.inputAnswer = inputAnswer;
	}

	@Override
	public int getRevision() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getAmountOfOptions() {
		return amountOfOptions;
	}

	public int getMin() {
		return min;
	}

	public int getMax() {
		return max;
	}

	public int getPathLength() {
		return pathLength;
	}

	public boolean getRandomGenerated() {
		return isRandomGenerated;
	}

	public int getAnswer() {
		return inputAnswer;
	}

}
