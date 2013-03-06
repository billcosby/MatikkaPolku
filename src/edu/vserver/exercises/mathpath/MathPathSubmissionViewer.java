package edu.vserver.exercises.mathpath;

import com.vaadin.ui.Component;
import com.vaadin.ui.Label;

import edu.vserver.exercises.model.ExerciseException;
import edu.vserver.exercises.model.ExerciseMaterialManager;
import edu.vserver.exercises.model.ResourceGiver;
import edu.vserver.exercises.model.SubmissionVisualizer;

public class MathPathSubmissionViewer implements
		SubmissionVisualizer<MathPathExerciseData, MathPathSubmissionInfo> {

	private MathPathExerciseData exer;
	private MathPathSubmissionInfo submInfo;

	@Override
	public void initialize(MathPathExerciseData exercise,
			MathPathSubmissionInfo dataObject, ResourceGiver localizer,
			ExerciseMaterialManager matManager) throws ExerciseException {
		exer = exercise;
		submInfo = dataObject;

	}
	
	/*private void doLayout() {
		this.addComponent(new Label("Question: " + exer.getQuestion()));
		Label answ = new Label("Answer: " + submInfo.getAnswer());
		answ.addStyleName("template-exercise-answer");
		this.addComponent(answ);
	}*/

	@Override
	public Component getView() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String exportSubmissionDataAsText() {
		// TODO Auto-generated method stub
		return null;
	}

}
