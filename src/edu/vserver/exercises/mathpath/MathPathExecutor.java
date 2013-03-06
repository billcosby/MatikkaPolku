package edu.vserver.exercises.mathpath;

import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.ProgressIndicator;
import com.vaadin.ui.VerticalLayout;

import edu.vserver.exercises.helpers.ExerciseExecutionHelper;
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

	private final ExerciseExecutionHelper<MathPathSubmissionInfo> execHelper = new ExerciseExecutionHelper<MathPathSubmissionInfo>();

	// keep track of answers
	private int correctAnswers;
	private int wrongAnswers;

	// holds the answers
	private PathModel path;

	// the component where we show the path
	private PathLayout pathLayout;

	// the "number cruncher" which generates equations from a given result
	private ArithmeticsInterface calc;

	private ProgressIndicator progressBar;
	private Label results;

	// how many correct answers is needed to complete the exercise
	private int pathLength;

	protected void doLayout(int min, int max, int amountOfOptions,
			int pathLength, boolean isRandomGenerated, int inputAnswer) {

		path = new PathModel(min, max, amountOfOptions, isRandomGenerated,
				inputAnswer);
		calc = new AdditionGenerator(3);

		this.pathLength = pathLength;
		correctAnswers = 0;
		wrongAnswers = 0;

		pathLayout = new PathLayout(this);

		results = new Label("Correct: " + correctAnswers + " Wrong: "
				+ wrongAnswers);

		generateRiddles();

		progressBar = new ProgressIndicator();
		progressBar.setIndeterminate(false);
		
		progressBar.setWidth("540px");
		//progressBar.setSizeFull();

		setWidth("540px");
		addComponent(progressBar);
		addComponent(pathLayout);
		addComponent(results);

	}

	
	private void updateScore() {
		results.setValue("Correct: " + correctAnswers + " Wrong: "
				+ wrongAnswers);
	}

	/*
	 * Clears the possible old options and creates new ones
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
				exerciseData.getAmountOfOptions(),
				exerciseData.getPathLength(),
				exerciseData.getRandomGenerated(), exerciseData.getAnswer());

	}

	@Override
	public void registerSubmitListener(
			SubmissionListener<MathPathSubmissionInfo> submitListener) {
		execHelper.registerSubmitListener(submitListener);

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
		path.resetCorrectAnswer();
		path.generateNewAnswers();
		generateRiddles();

		correctAnswers = 0;
		wrongAnswers = 0;
		progressBar.setValue(0f);

		updateScore();
	}

	@Override
	public void askSubmit(SubmissionType askedSubmType) {
		execHelper.informOnlySubmit(correctAnswers
				/ (wrongAnswers + correctAnswers), new MathPathSubmissionInfo(
				correctAnswers, wrongAnswers), askedSubmType, null);
	}

	@Override
	public void registerExecutionStateChangeListener(
			ExecutionStateChangeListener execStateListener) {
		execHelper.registerExerciseExecutionStateListener(execStateListener);

	}

	@Override
	public ExecutionState getCurrentExecutionState() {
		return execHelper.getState();
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
