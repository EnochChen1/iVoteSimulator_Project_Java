package iVoteSimulator;

import java.util.ArrayList;

public class MultipleChoice implements Question {
	private ArrayList<String> answerBank = new ArrayList<String>();
	public void configureCandidateAnswer() { 
		//I made the answer banks for the two classes different
		//So that it would be more obvious what it is
			answerBank.add("A"); 
			answerBank.add("B");
			answerBank.add("C");
			answerBank.add("D");
	}
	public ArrayList<String> getAnswerBank() {
		return answerBank;
	}
	
	
	
	
}
