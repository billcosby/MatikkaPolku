package edu.vserver.exercises.mathpath;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import edu.vserver.exercises.helpers.SaveListenerHelper;
import edu.vserver.exercises.model.Editor;
import edu.vserver.exercises.model.EditorMaterialManager;
import edu.vserver.exercises.model.ExerciseException;
import edu.vserver.exercises.model.ExerciseSaveListener;
import edu.vserver.exercises.model.GeneralExerciseInfoEditor;
import edu.vserver.exercises.model.ResourceGiver;

public class MathPathEditor extends VerticalLayout implements
		Editor<MathPathExerciseData> {

	private Button save;
	private TextField amountOfOptionsField;
	private TextField minField;
	private TextField maxField;
	private TextField pathLengthField;
	private CheckBox generateRandomAnsw;
	private boolean isRandomGenerated;
	private TextField inputAnswer;

	private final SaveListenerHelper<MathPathExerciseData> saveListeners = new SaveListenerHelper<MathPathExerciseData>();

	@Override
	public Component getView() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public void initialize(ResourceGiver localizer,
			MathPathExerciseData oldData,
			GeneralExerciseInfoEditor genExerInfoEditor,
			EditorMaterialManager materialManager) throws ExerciseException {

		isRandomGenerated = false;
		doLayout();
		if (oldData != null) {
			setDefaultData(oldData);
		}
	}
	

	private void setDefaultData(MathPathExerciseData oldData) {
		amountOfOptionsField.setValue(oldData.getAmountOfOptions() + "");
		minField.setValue(oldData.getMin() + "");
		maxField.setValue(oldData.getMax() + "");

		pathLengthField.setValue(oldData.getPathLength() + "");

	}

	@Override
	public void registerSaveListener(
			ExerciseSaveListener<MathPathExerciseData> listener) {
		saveListeners.registerListener(listener);

	}

	private void doLayout() {

		save = new Button("Save");

		amountOfOptionsField = new TextField("Amount of options presented");
		minField = new TextField("Minimum value");
		maxField = new TextField("Maximum value");
		pathLengthField = new TextField("Path length");
		generateRandomAnsw = new CheckBox("Generate random answers");
		inputAnswer = new TextField("Value of answer");

		save.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				saveListeners.informListeners(getCurrentExercise());
			}

		});

		generateRandomAnsw.setImmediate(true);
		generateRandomAnsw.addValueChangeListener(new ValueChangeListener() {

			@Override
			public void valueChange(ValueChangeEvent event) {
				if (isRandomGenerated != true) {
					isRandomGenerated = true;
					// todo: clear input
					inputAnswer.setValue("");
					inputAnswer.setEnabled(false);
				} else {
					isRandomGenerated = false;
					inputAnswer.setEnabled(true);
				}
			}
		});

		addComponent(amountOfOptionsField);
		addComponent(minField);
		addComponent(maxField);
		addComponent(pathLengthField);
		addComponent(generateRandomAnsw);
		addComponent(inputAnswer);

		addComponent(save);

	}

	private MathPathExerciseData getCurrentExercise() {

		return new MathPathExerciseData(Integer.parseInt(minField.getValue()),
				Integer.parseInt(maxField.getValue()),
				Integer.parseInt(amountOfOptionsField.getValue()),
				Integer.parseInt(pathLengthField.getValue()),
				isRandomGenerated, inputAnswer.getValue().equals("") ? 0
						: Integer.parseInt(inputAnswer.getValue()));
	}
}
