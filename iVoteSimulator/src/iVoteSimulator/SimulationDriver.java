package iVoteSimulator;

public class SimulationDriver {
	public static void main(String [] args) {
		MultipleChoice question = new MultipleChoice();
		question.setCandidateAnswer();
		question.displayAnswerBank();
	}
}
