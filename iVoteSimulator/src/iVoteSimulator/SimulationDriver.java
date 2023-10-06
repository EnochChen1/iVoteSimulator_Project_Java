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
			System.out.println("This question is Single-Choice: ");
		}
		else if(singleOrMultiple == 1) {
			questionType = "Multiple";
			System.out.println("This question is Multiple-Choice: ");

		}
	
		votes.setQuestionType(questionType);
		
		int generateStudentNumber = rand.nextInt(100);
		System.out.println("The number of students generated is "+generateStudentNumber);
		for(int i = 0; i < generateStudentNumber; i++) {
			Student student = new Student();
			int generateStudentID = rand.nextInt(1000);
			String ID = String.valueOf(generateStudentID);
			if(generateStudentID > 0 && generateStudentID < 100) {
				ID = "0"+ID;
				if(generateStudentID > 0 && generateStudentID < 10) {
					ID = "0"+ID;
				}
			}
			student.setID(ID);
			votes.acceptStudentAnswers(student.submitAnswer(questionType), student.getID());
		}
		votes.mergeStudentAnswers();
		votes.displaySubmissions();
		votes.displayStudentSubmissions();
	}
}
