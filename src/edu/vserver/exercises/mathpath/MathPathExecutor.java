package edu.vserver.exercises.mathpath;

import com.vaadin.shared.ui.AlignmentInfo.Bits;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.ProgressIndicator;
import com.vaadin.ui.VerticalLayout;

import edu.vserver.exercises.model.ExecutionSettings;
import edu.vserver.exercises.model.ExecutionState;
import edu.vserver.exercises.model.ExecutionStateChangeListener;
import edu.vserver.exercises.model.Executor;
import edu.vserver.exercises.model.ExerciseException;
import edu.vserver.exercises.model.ExerciseMaterialManager;
import edu.vserver.exercises.model.ResourceGiver;
import edu.vserver.exercises.model.SubmissionListener;
import edu.vserver.exercises.model.SubmissionType;

public class MathPathExecutor extends VerticalLayout implements
		Executor<MathPathExerciseData, MathPathSubmissionInfo> {

	private static final long serialVersionUID = 645228793345434162L;

	private int correctAnswers;
	private int wrongAnswers;

	private PathModel path;
	private PathLayout pathLayout;
	private ArithmeticsInterface calc;

	private ProgressIndicator progressBar;
	private Label results;

	private int pathLength;

	protected void doLayout(int min, int max, int amountOfOptions,
			int pathLength) {

		path = new PathModel(min, max, amountOfOptions);
		calc = new AdditionGenerator(3);

		VerticalLayout verticalLayout = new VerticalLayout();

		this.pathLength = pathLength;
		correctAnswers = 0;
		wrongAnswers = 0;

		pathLayout = new PathLayout(this);

		results = new Label("Correct: " + correctAnswers + " Wrong: "
				+ wrongAnswers);

		generateRiddles();

		progressBar = new ProgressIndicator();
		progressBar.setIndeterminate(false);
		progressBar.setSizeFull();
		progressBar.setHeight("20px");

		verticalLayout.setWidth("90%");
		verticalLayout.addComponent(progressBar);
		verticalLayout.addComponent(pathLayout);
		verticalLayout.addComponent(results);
		this.addComponent(verticalLayout);

		// this centers the whole thing
		setComponentAlignment(verticalLayout, new Alignment(
				Bits.ALIGNMENT_VERTICAL_CENTER
						| Bits.ALIGNMENT_HORIZONTAL_CENTER));
	}

	private void updateScore() {
		results.setValue("Correct: " + correctAnswers + " Wrong: "
				+ wrongAnswers);

	}

	/*
	 * Clears the possible old options and breaks down our
	 */
	private void generateRiddles() {
		pathLayout.clearOptions();
		pathLayout.setMiddleCaption("" + path.getCorrectAnswer());
		for (int i = 0; i < path.getLength(); i++) {
			String riddle = calc.calculate(path.getOption(i));
			pathLayout.addOption(riddle);
			if (path.getCorrectAnswer() == path.getOption(i)) {
				pathLayout.setCorrectOption(riddle);
			}
		}
	}

	@Override
	public void initialize(ResourceGiver localizer,
			MathPathExerciseData exerciseData, MathPathSubmissionInfo oldSubm,
			ExerciseMaterialManager materials, ExecutionSettings execSettings)
			throws ExerciseException {
		doLayout(exerciseData.getMin(), exerciseData.getMax(),
				exerciseData.getAmountOfOptions(), exerciseData.getPathLength());

	}

	@Override
	public void registerSubmitListener(
			SubmissionListener<MathPathSubmissionInfo> submitListener) {
		// TODO Auto-generated method stub

	}

	@Override
	public Component getView() {
		return this;
	}

	@Override
	public void shutdown() {
		// TODO Auto-generated method stub

	}

	@Override
	public void askReset() {
		reset();
	}

	private void reset() {

		path.generateNewAnswers();
		generateRiddles();

		correctAnswers = 0;
		wrongAnswers = 0;

		updateScore();
	}

	@Override
	public void askSubmit(SubmissionType askedSubmType) {
		// TODO Auto-generated method stub

	}

	@Override
	public void registerExecutionStateChangeListener(
			ExecutionStateChangeListener execStateListener) {
		// TODO Auto-generated method stub

	}

	@Override
	public ExecutionState getCurrentExecutionState() {
		// TODO Auto-generated method stub
		return null;
	}

	public void handleWrongAnswer() {

		wrongAnswers++;
		updateScore();
	}

	public void handleCorrectAnswer() {
		correctAnswers++;
		updateScore();

		path.generateNewAnswers();
		generateRiddles();

		progressBar.setValue((float) correctAnswers / pathLength);

		if (correctAnswers >= pathLength) {
			pathLayout.clearOptions();
		}
	}

}
