package iVoteSimulator;
import java.util.HashMap;
import java.util.List;

public class VotingService {
	private HashMap<String, Integer> Submissions = new HashMap<String, Integer>();
	private HashMap<String, String> uniqueIDSubmissions = new HashMap<String, String>();
	private SingleChoice singleChoice = new SingleChoice();
	private MultipleChoice multipleChoice = new MultipleChoice();
	private String questionType = "";
	
	public void setQuestionType(String type) {
		questionType = type;
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
	
	public String getQuestionType() {
		return questionType;
	}
	
	public void acceptStudentAnswers(List<String> studentAnswers) {
		for(int i = 0; i < studentAnswers.size(); i++) {
			Submissions.merge(studentAnswers.get(i), 1, Integer::sum);
		}
	}
}
