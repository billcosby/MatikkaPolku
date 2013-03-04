package edu.vserver.exercises.mathpath;

import edu.vserver.exercises.model.ExerciseData;

public class MathPathExerciseData implements ExerciseData {

	private int amountOfOptions;
	private int min;
	private int max;
	private int pathLength;
	
	public MathPathExerciseData(int min, int max, int amountOfOptions, int pathLength) {
		this.amountOfOptions = amountOfOptions;
		this.min = min;
		this.max = max;
		this.pathLength = pathLength;
	}
	
    @Override
    public int getRevision() {
        // TODO Auto-generated method stub
        return 0;
    }

	public int getAmountOfOptions() {
		return amountOfOptions;
	}
	public int getMin(){
		return min;
	}
	public int getMax(){
		return max;
	}

	public int getPathLength() {
		return pathLength;
	}

}
