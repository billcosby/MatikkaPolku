package edu.vserver.exercises.mathpath;

import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import edu.vserver.exercises.model.ExerciseException;
import edu.vserver.exercises.model.ExerciseMaterialManager;
import edu.vserver.exercises.model.ResourceGiver;
import edu.vserver.exercises.model.SubmissionVisualizer;

public class MathPathSubmissionViewer extends VerticalLayout implements
		SubmissionVisualizer<MathPathExerciseData, MathPathSubmissionInfo> {

	private MathPathExerciseData exer;
	private MathPathSubmissionInfo submInfo;

	public MathPathSubmissionViewer() {

	}

	@Override
	public void initialize(MathPathExerciseData exercise,
			MathPathSubmissionInfo dataObject, ResourceGiver localizer,
			ExerciseMaterialManager matManager) throws ExerciseException {
		exer = exercise;
		submInfo = dataObject;
		doLayout();

	}

	private void doLayout() {

		Label correctAnsw = new Label("Amount of correct answers: "
				+ submInfo.getCorrectAnswers());
		Label wrongAnsw = new Label("Amount of wrong answers: "
				+ submInfo.getWrongAnswers());

		correctAnsw.addStyleName("mathpath-correct-answer");
		wrongAnsw.addStyleName("mathpath-wrong-answer");

		addComponent(correctAnsw);
		addComponent(wrongAnsw);
	}

	@Override
	public Component getView() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public String exportSubmissionDataAsText() {
		// TODO Auto-generated method stub
		return null;
	}

}
