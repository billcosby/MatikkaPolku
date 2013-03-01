package edu.vserver.exercises.mathpath;

import com.vaadin.server.Resource;

import edu.vserver.exercises.helpers.XmlEncHelper;
import edu.vserver.exercises.model.Editor;
import edu.vserver.exercises.model.ExerciseTypeDescriptor;
import edu.vserver.exercises.model.ExerciseXMLHandler;
import edu.vserver.exercises.model.ResourceGiver;
import edu.vserver.exercises.model.SubmissionStatisticsGiver;
import edu.vserver.exercises.model.SubmissionVisualizer;
import edu.vserver.standardutils.StandardIcon;

public class EmptyExerDescriptor implements
        ExerciseTypeDescriptor<MathPathExerciseData, MathPathSubmissionInfo> {

    private static final long serialVersionUID = 4587736884427608942L;

    public static final EmptyExerDescriptor INSTANCE = new EmptyExerDescriptor();

    @Override
    public EmptyExecutor newExerciseExecutor() {
        return new EmptyExecutor();
    }

    @Override
    public String getTypeName(ResourceGiver localizer) {
        return "EmptyTestExercise";
    }

    @Override
    public ExerciseXMLHandler<MathPathExerciseData> newExerciseXML() {
        // TODO Auto-generated method stub
        return MathPathXmlHandler.INSTANCE;
    }

    @Override
    public Editor<MathPathExerciseData> newExerciseEditor() {
        // TODO Auto-generated method stub
        return new MathPathEditor();
    }

    @Override
    public Class<MathPathExerciseData> getTypeDataClass() {
        // TODO Auto-generated method stub
        return MathPathExerciseData.class;
    }

    @Override
    public Class<MathPathSubmissionInfo> getSubDataClass() {
        // TODO Auto-generated method stub
        return MathPathSubmissionInfo.class;
    }

    @Override
    public SubmissionStatisticsGiver<MathPathExerciseData, MathPathSubmissionInfo> newStatisticsGiver() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SubmissionVisualizer<MathPathExerciseData, MathPathSubmissionInfo> newSubmissionVisualizer() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getTypeDescription(ResourceGiver localizer) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Resource getSmallTypeIcon() {
        return StandardIcon.EXERCISE_ICON_SMALL.getIcon();
    }

    @Override
    public Resource getMediumTypeIcon() {
        // TODO Auto-generated method stub
        return StandardIcon.EXERCISE_ICON_SMALL.getIcon();
    }

    @Override
    public Resource getLargeTypeIcon() {
        // TODO Auto-generated method stub
        return StandardIcon.EXERCISE_ICON_SMALL.getIcon();
    }

}
