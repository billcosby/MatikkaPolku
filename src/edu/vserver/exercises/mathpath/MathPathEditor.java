package edu.vserver.exercises.mathpath;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import edu.vserver.exercises.helpers.SaveListenerHelper;
import edu.vserver.exercises.helpers.TestingExecutionSettings;
import edu.vserver.exercises.model.Editor;
import edu.vserver.exercises.model.EditorMaterialManager;
import edu.vserver.exercises.model.ExerciseException;
import edu.vserver.exercises.model.ExerciseSaveListener;
import edu.vserver.exercises.model.GeneralExerciseInfoEditor;
import edu.vserver.exercises.model.ResourceGiver;
import edu.vserver.exercises.template.TemplateExecutor;
import edu.vserver.standardutils.StandardUIConstants;

public class MathPathEditor extends VerticalLayout implements
		Editor<MathPathExerciseData> {

	private Button save;
	private TextField amountOfOptionsField;
	private TextField minField;
	private TextField maxField;
	private TextField pathLengthField;

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

		doLayout();
		if (oldData != null) {
			setDefaultData(oldData);
		}
	}

	private void setDefaultData(MathPathExerciseData oldData) {
		amountOfOptionsField.setValue(oldData.getAmountOfOptions() + "");
		minField.setValue(oldData.getMin() + "");
		maxField.setValue(oldData.getMax() + "");
		pathLengthField.setValue(oldData.getPathLength() +"");
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

		save.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				saveListeners.informListeners(getCurrentExercise());
			}

		});


		addComponent(amountOfOptionsField);
		addComponent(minField);
		addComponent(maxField);
		addComponent(pathLengthField);
		addComponent(save);
	}

	private MathPathExerciseData getCurrentExercise() {
		return new MathPathExerciseData(Integer.parseInt(minField.getValue()),
				Integer.parseInt(maxField.getValue()),
				Integer.parseInt(amountOfOptionsField.getValue()),
				Integer.parseInt(pathLengthField.getValue()));
	}
}
