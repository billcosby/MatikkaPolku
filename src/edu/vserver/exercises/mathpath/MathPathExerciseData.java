package edu.vserver.exercises.mathpath;

import edu.vserver.exercises.model.ExerciseData;

public class MathPathExerciseData implements ExerciseData {

	private int amountOfOptions;
	private int min;
	private int max;
	
	public MathPathExerciseData(int min, int max, int amountOfOptions) {
		this.amountOfOptions = amountOfOptions;
		this.min = min;
		this.max = max;
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

    

}
