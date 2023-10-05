package iVoteSimulator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SimulationDriver {
	public static void main(String [] args) {
		VotingService votes = new VotingService();
		String questionType = "";
		Random rand = new Random();
		int singleOrMultiple = rand.nextInt(2);
		if(singleOrMultiple == 0) {
			questionType = "Single";
		}
		else if(singleOrMultiple == 1) {
			questionType = "Multiple";
		}
	
		votes.setQuestionType(questionType);
		
		int generateStudentNumber = rand.nextInt(40);
		System.out.println("The number of students generates is "+generateStudentNumber);
		for(int i = 0; i < generateStudentNumber; i++) {
			Student student = new Student();
			String ID = String.valueOf(i);
			student.setID(ID);
			votes.acceptStudentAnswers(student.submitAnswer(questionType));
			
		}
		votes.displaySubmissions();
	}
}
