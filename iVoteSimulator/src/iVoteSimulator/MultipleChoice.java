package iVoteSimulator;

import java.util.ArrayList;
import java.util.Scanner;
public class MultipleChoice implements Question {
	ArrayList<String> answerBank;
	public ArrayList<String> setCandidateAnswer() {
		String _continue = "";
		Scanner myObj = new Scanner(System.in);
		while(_continue != "no") {
			System.out.print("Please enter your candidate answer: ");
			String candidate = myObj.nextLine();
		}
		
		return answerBank;
	}

}
