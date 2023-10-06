package iVoteSimulator;

import java.util.ArrayList;

public class SingleChoice implements Question {
	private ArrayList<String> answerBank = new ArrayList<String>();
	public void configureCandidateAnswer() {
		//answerBank for Single Choice is 1.Right and 2. Wrong,
		// so that the difference would be more obvious
			answerBank.add("1. Right");
			answerBank.add("2. Wrong");
	}
	
	public ArrayList<String> getAnswerBank() {
		return answerBank;
	}
}
