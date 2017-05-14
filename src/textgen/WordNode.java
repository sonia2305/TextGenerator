package textgen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordNode {

	private String wordValue;
	private List<String> nextWords;	
	
	public WordNode() {
		this.nextWords = new ArrayList<String>();
	}
	
	public WordNode(String wordValue){
		this();
		this.wordValue = wordValue;
	}

	public String getWord() {
		return wordValue;
	}
	
	public void addNextWord(String nextWord){
		this.nextWords.add(nextWord);
	}
	
	public String getNextRandomWord(){
		Random randomIndex = new Random();
		String nextRandomWord = nextWords.get(randomIndex.nextInt(nextWords.size()));
		
		return nextRandomWord;
	}
}
