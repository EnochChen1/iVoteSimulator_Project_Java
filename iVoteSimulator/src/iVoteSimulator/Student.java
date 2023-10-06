package iVoteSimulator;

import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Student { // 
	private String uniqueID;
	
	public void setID(String exampleID) { //set ID, used when generating Students
		uniqueID = exampleID;
	}
	
	public String getID() {//used when figuring out which student
		return uniqueID;
	}
	
	public List<String> submitAnswer(String questionType) {
		//submit answers to voting service
		List<String> answer = new ArrayList<>();
		Random rand = new Random(); //depending on questionType
		//,answers are chosen at random
		if(questionType.equals("Single")) {
			int rightOrWrong = rand.nextInt(2);
			if(rightOrWrong == 0) {
				answer.add("1. Right");
			}
			else if(rightOrWrong == 1) {
				answer.add("2. Wrong");
			}
		}
		//for Single, you can only choose one, thus 50% chance 1.Right,
		//50% chance 2.Wrong
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
			
			//for multiple choice, all 4 have an equal chance of being chosen
			answer = new ArrayList<>(multiple.keySet());
			//used to make sure answer will be in alphabetical order
			Collections.sort(answer);
		}
		
		return answer;
	}
}
