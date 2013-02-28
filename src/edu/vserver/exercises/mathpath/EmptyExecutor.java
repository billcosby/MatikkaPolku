package edu.vserver.exercises.mathpath;

import com.vaadin.shared.ui.AlignmentInfo.Bits;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
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

public class EmptyExecutor extends VerticalLayout implements
        Executor<MathPathExerciseData, MathPathSubmissionInfo> {

    private static final long serialVersionUID = 645228793345434162L;

    private double score = 0.0;
    private PathModel path;
    private PathLayout pathLayout;
    private ArithmeticsInterface calc;

    protected void doLayout() {

        path = new PathModel(5, 15, 5);
        calc = new AdditionGenerator();

        VerticalLayout verticalLayout = new VerticalLayout();

        Button pushThis = new Button("push this");
        pathLayout = new PathLayout();

        Label label2 = new Label("t�h�n tulee alalaita");

        generateRiddles();

        pushThis.addClickListener(new Button.ClickListener() {
            private static final long serialVersionUID = 2906960442004272295L;

            @Override
            public void buttonClick(ClickEvent event) {
                path.generateNewAnswers();
                generateRiddles();
                score = 1.0;
            }
        });

        verticalLayout.setWidth("90%");

        verticalLayout.addComponent(pushThis);
        verticalLayout.addComponent(pathLayout);
        verticalLayout.addComponent(label2);

        this.addComponent(verticalLayout);

        // this centers the whole thing
        setComponentAlignment(verticalLayout, new Alignment(
                Bits.ALIGNMENT_VERTICAL_CENTER
                        | Bits.ALIGNMENT_HORIZONTAL_CENTER));
    }

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

    protected double getCorrectness() {
        return score;
    }

    @Override
    public void initialize(ResourceGiver localizer,
            MathPathExerciseData exerciseData, MathPathSubmissionInfo oldSubm,
            ExerciseMaterialManager materials, ExecutionSettings execSettings)
            throws ExerciseException {
        // TODO Auto-generated method stub

    }

    @Override
    public void registerSubmitListener(
            SubmissionListener<MathPathSubmissionInfo> submitListener) {
        // TODO Auto-generated method stub

    }

    @Override
    public Component getView() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void shutdown() {
        // TODO Auto-generated method stub

    }

    @Override
    public void askReset() {
        // TODO Auto-generated method stub

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

}
