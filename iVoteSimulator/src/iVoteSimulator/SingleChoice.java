package iVoteSimulator;

public class SingleChoice implements Question {
	String answerBank[] = new String[2];
	
	public String[] setCandidateAnswer() {
		answerBank[0] = "1";
		answerBank[1] = "2";

		return answerBank;
	}
}
