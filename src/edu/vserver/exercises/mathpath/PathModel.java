package edu.vserver.exercises.mathpath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class PathModel {

	private final ArrayList<Integer> list;

	private final int min, max, amountOfOptions;
	private final boolean correctAnswerIsGenerated;
	private int correctAnswer = 0;

	private static Random rnd = new Random();

	/*
	 * @.pre amountOfOptions > 0
	 */
	public PathModel(int min, int max, int amountOfOptions,
			boolean correctAnswerIsGenerated, int inputAnswer) {
		list = new ArrayList<Integer>();
		this.min = min;
		this.max = max;
		this.amountOfOptions = amountOfOptions;
		this.correctAnswerIsGenerated = correctAnswerIsGenerated;

		if (correctAnswerIsGenerated) {
			generateAnswers();
		} else {
			correctAnswer = inputAnswer;
			generateAnswers();
		}

	}

	private void generateAnswers() {
		if (correctAnswer == 0) {
			correctAnswer = rnd.nextInt(max - min + 1) + min;
		}

		list.add(correctAnswer);
		generateWrongAnswers(correctAnswer);

		Collections.shuffle(list);
	}

	private void generateWrongAnswers(int correctAnswer) {

		while (list.size() < amountOfOptions) {
			int wrongAnswer = rnd.nextInt(max - min + 1) + min;
			if (wrongAnswer != correctAnswer) {
				list.add(wrongAnswer);
			}
		}
	}

	public int getOption(int i) {
		return list.get(i);
	}

	public int getLength() {
		return list.size();
	}

	public int getCorrectAnswer() {
		return correctAnswer;
	}

	public void generateNewAnswers() {
		list.clear();

		generateAnswers();
	}

	public void resetCorrectAnswer() {
		if (correctAnswerIsGenerated == true) {
			correctAnswer = 0;
		}
	}

}
