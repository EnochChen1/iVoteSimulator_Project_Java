package iVoteSimulator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.List;
import java.util.Map;

public class VotingService {
	private HashMap<String, Integer> Submissions = new HashMap<String, Integer>();
	private HashMap<String, String> uniqueIDSubmissions = new HashMap<String, String>();
	private SingleChoice singleChoice = new SingleChoice();
	private MultipleChoice multipleChoice = new MultipleChoice();
	private String questionType = "";
	
	public void setQuestionType(String type) { //This updates the Submissions HashMap with the correct keys 
		questionType = type; //depending on whether it is Single Choice or Multiple Choice
		if(type.equals("Single")) {
			singleChoice.configureCandidateAnswer();
			for(int i = 0; i < singleChoice.getAnswerBank().size(); i++) {
				Submissions.put(singleChoice.getAnswerBank().get(i),0);
			}
		}
		else if(type.equals("Multiple")) {
			multipleChoice.configureCandidateAnswer();
			for(int i = 0; i < multipleChoice.getAnswerBank().size(); i++) {
				Submissions.put(multipleChoice.getAnswerBank().get(i),0);
			}
		}
	}
	
	public void displaySubmissions() {
		for (String i : Submissions.keySet()) {
			  System.out.println(i + " : " + Submissions.get(i));
			}
	}
	
	public void displayStudentSubmissions() {
		ArrayList<String> sortedStudentSubmissions =
				new ArrayList<String>(uniqueIDSubmissions.keySet());
		Collections.sort(sortedStudentSubmissions);
		for (String i: sortedStudentSubmissions) 
            System.out.println("ID "+i + 
                   " : " + uniqueIDSubmissions.get(i));  
	}
	
	public String getQuestionType() {
		return questionType;
	}
	
	public void acceptStudentAnswers(List<String> studentAnswers, String studentID) {
		String studentList = "";
		for(int i = 0; i < studentAnswers.size(); i++) {
			studentList += studentAnswers.get(i)+",";
		}
		
		studentList = studentList.substring(0, studentList.length()-1);
		if(uniqueIDSubmissions.containsKey(studentID)) {
			System.out.println(studentID+" has submitted more than once");
		}
		uniqueIDSubmissions.put(studentID, studentList);
	}
	
	public void mergeStudentAnswers() {
		for(String i: uniqueIDSubmissions.keySet()) {
			String [] tokens = uniqueIDSubmissions.get(String.valueOf(i)).split(",");
			for(int f = 0; f < tokens.length; f++) {
				Submissions.merge(tokens[f], 1, Integer::sum);
			}
		}
	}
}
