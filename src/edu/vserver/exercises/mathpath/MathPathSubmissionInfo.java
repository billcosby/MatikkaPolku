package edu.vserver.exercises.mathpath;

import edu.vserver.exercises.model.SubmissionInfo;

public class MathPathSubmissionInfo implements SubmissionInfo {

	private int correctAnswers;
	private int wrongAnswers;
	
	public MathPathSubmissionInfo(int correctAnswers, int wrongAnswers) {
		this.correctAnswers = correctAnswers;
		this.wrongAnswers = wrongAnswers;
		
	}
	
	public int getCorrectAnswers() {
		return correctAnswers;
	}
	
	public int getWrongAnswers() {
		return wrongAnswers;
	}
	
	
	
    @Override
    public int getCorrespondingRevision() {
        // TODO Auto-generated method stub
        return 0;
    }

}
