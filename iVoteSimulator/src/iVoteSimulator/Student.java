package iVoteSimulator;

import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Student { // 
	private String uniqueID;
	
	public void setID(String exampleID) {
		uniqueID = exampleID;
	}
	
	public String getID() {
		return uniqueID;
	}
	
	public List<String> submitAnswer(String questionType) {
		List<String> answer = new ArrayList<>();
		Random rand = new Random();
		if(questionType.equals("Single")) {
			int rightOrWrong = rand.nextInt(2);
			if(rightOrWrong == 0) {
				answer.add("1. Right");
			}
			else if(rightOrWrong == 1) {
				answer.add("2. Wrong");
			}
		}
		else if(questionType.equals("Multiple")) {
			int [] multipleArray = new int[4];
			for(int i = 0; i < 4; i++) {
				multipleArray[i] = rand.nextInt(4);
			}
			
			HashMap<String, String> multiple = new HashMap<String, String>();
			for(int i = 0; i < 4; i++) {
				if(multipleArray[i] == 0) {
					multiple.put("A","0");
				}
				if(multipleArray[i] == 1) {
					multiple.put("B","0");
				}
				if(multipleArray[i] == 2) {
					multiple.put("C","0");
				}
				if(multipleArray[i] == 3) {
					multiple.put("D","0");
				}
			}
			answer = new ArrayList<>(multiple.keySet());
			Collections.sort(answer);
		}
		
		return answer;
	}
}
