package iVoteSimulator;

public class MultipleChoice implements Question {
	String answerBank[] = new String[4];
	
	public String[] setCandidateAnswer() {
		answerBank[0] = "A";
		answerBank[1] = "B";
		answerBank[2] = "C";
		answerBank[3] = "D";

		return answerBank;
	}
	
	
	
}
