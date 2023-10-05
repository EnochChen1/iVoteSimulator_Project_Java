package iVoteSimulator;

import java.util.ArrayList;

public class SingleChoice implements Question {
	private ArrayList<String> answerBank = new ArrayList<String>();
	public void configureCandidateAnswer() {
			answerBank.add("1. Right");
			answerBank.add("2. Wrong");
	}
	
	public ArrayList<String> getAnswerBank() {
		return answerBank;
	}
}
