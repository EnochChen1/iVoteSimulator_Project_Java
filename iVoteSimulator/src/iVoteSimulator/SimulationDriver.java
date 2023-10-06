package iVoteSimulator;

import java.util.Random;

public class SimulationDriver { //This is where everything is ran
	public static void main(String [] args) { //The objects needed for the simulation
		VotingService votes = new VotingService(); 
		String questionType = "";
		Random rand = new Random();
		int singleOrMultiple = rand.nextInt(2); //variable used to choose single or multiple
		if(singleOrMultiple == 0) {// function used to choose single or multiple
			questionType = "Single";
			System.out.println("This question is Single-Choice. ");
		}
		else if(singleOrMultiple == 1) {
			questionType = "Multiple";
			System.out.println("This question is Multiple-Choice. ");

		}
		System.out.println("If there are multiple submissions by the same student,"
				+ " Student ID will be shown."); //print so professor sees that
		//submissions by the same student ID will be the latest
	
		votes.setQuestionType(questionType); //sets single or multiple in VotingService
		
		int generateStudentNumber = rand.nextInt(100); //number of students generated will be 0-99
		System.out.println("The number of students generated is "+generateStudentNumber);
		for(int i = 0; i < generateStudentNumber; i++) {
			Student student = new Student();
			int generateStudentID = rand.nextInt(1000); //IDs are from 0-999
			String ID = String.valueOf(generateStudentID);
			if(generateStudentID > 0 && generateStudentID < 100) {
				//done so that sorting is easier for me
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
