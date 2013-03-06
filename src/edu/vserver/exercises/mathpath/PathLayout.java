package edu.vserver.exercises.mathpath;

import java.util.ArrayList;

import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;

public class PathLayout extends AbsoluteLayout {

    private static final long serialVersionUID = 1L;
    private final ArrayList<Button> currentOptions;
    private Button correctOption;
    private MathPathExecutor executor;

   
    private final Button middleButton;

    public PathLayout(MathPathExecutor executor) {
        super();

        this.executor = executor;
        currentOptions = new ArrayList<Button>();

        this.setWidth("100%");
        this.setHeight("300px");

        middleButton = new Button("");

        
        addComponent(middleButton, "top:50%; right:50%");

    }

    public void addOption(String string) {
        Button b = new Button(string);

        // add a click listener for the new option
        b.addClickListener(new ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {

                if (event.getButton() == correctOption) {
                    handleCorrectAnswer();
                } else {
                    handleWrongAnswer(event.getButton());
                    
                }
            }

        });
        currentOptions.add(b);
        updatePositions();
    }

    private void handleWrongAnswer(Button button) {
    	button.setEnabled(false);
     	
        Notification.show("Try again!");
        executor.handleWrongAnswer();
    }

    private void handleCorrectAnswer() {
        Notification.show("Correct!");
        executor.handleCorrectAnswer();
    }

    public void removeOption(Button b) {
        removeComponent(b);
        currentOptions.remove(b);
        updatePositions();
    }

    private void updatePositions() {
        // first remove old buttons, so we can reposition (there might be a
        // better way to do it?)
        for (Button b : currentOptions) {
            removeComponent(b);
        }

        // calculate the vertical distance between buttons (in css %)
        int heightIncrement = 100 / (currentOptions.size() + 1);

        for (int i = 0; i < currentOptions.size(); i++) {
            // format the vertical alignment
            String position = "top:" + heightIncrement * (i + 1)
                    + "%; right:20%";

            addComponent(currentOptions.get(i), position);

        }
    }

    public void setCorrectOption(String riddle) {
        // find the correct option button and add a click listener to it
        for (int i = 0; i < currentOptions.size(); i++) {
            if (currentOptions.get(i).getCaption().equals(riddle)) {

                correctOption = currentOptions.get(i);

            }
        }
    }

    public void setMiddleCaption(String caption) {
        middleButton.setCaption(caption);
    }

    public void clearOptions() {
        for (Button b : currentOptions) {
            removeComponent(b);
        }
        currentOptions.clear();

    }

}
