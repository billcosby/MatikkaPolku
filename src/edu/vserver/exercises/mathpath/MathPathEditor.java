package edu.vserver.exercises.mathpath;

import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;

import edu.vserver.exercises.model.Editor;
import edu.vserver.exercises.model.EditorMaterialManager;
import edu.vserver.exercises.model.ExerciseException;
import edu.vserver.exercises.model.ExerciseSaveListener;
import edu.vserver.exercises.model.GeneralExerciseInfoEditor;
import edu.vserver.exercises.model.ResourceGiver;

public class MathPathEditor extends VerticalLayout implements
        Editor<MathPathExerciseData> {

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
        // TODO Auto-generated method stub

        doLayout();
    }

    @Override
    public void registerSaveListener(
            ExerciseSaveListener<MathPathExerciseData> listener) {
        // TODO Auto-generated method stub

    }

    private void doLayout() {
        addComponent(new Button("ADSDASD"));
    }

}
