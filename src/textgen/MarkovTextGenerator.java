package textgen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MarkovTextGenerator implements TextGenerator{
	private final String PATTERN_WORD_DELIMITORS = "[ .,;!?\"\"]+";
	private Map<String, WordNode> trainedWords;

	public MarkovTextGenerator() {
		super();
		trainedWords = new HashMap<>();
	}

	@Override
	public void train(String trainingData) {
		WordNode aWordNode = null;
		String aWord;
		String[] allWords = getWordsFromText(trainingData);
		
		for(int index=0; index<allWords.length; index++){
			aWord = allWords[index];
			if(trainedWords.containsKey(aWord)){
				aWordNode = trainedWords.get(aWord);
			}else{
				aWordNode = new WordNode(aWord);
			}
			
			if(index < (allWords.length-1))
				aWordNode.addNextWord(allWords[index+1]);
			
			trainedWords.put(aWord,aWordNode);
		}
		
	}
	
	@Override
	public void retrain(String trainingData) {
		trainedWords = new HashMap();
		train(trainingData);
				
	}

	@Override
	public void generate(String startWord, int numberOfTexts) {
		List<String> generatedText = new ArrayList<String>();
		WordNode aWordNode = trainedWords.get(startWord);
		generatedText.add(aWordNode.getWord());
		
		String nextWord = null;		
		
		for(int countWords=1; countWords < numberOfTexts; countWords++){
			nextWord = aWordNode.getNextRandomWord();
			generatedText.add(nextWord);
			aWordNode = trainedWords.get(nextWord);			
		}
		
		printWords(generatedText);
		
	}
	
	private void printWords(List<String> generatedText){
		for(String text: generatedText)
			System.out.print(" " + text);
	}
	
	private String[] getWordsFromText(String text){
		
		String[] words = text.split(PATTERN_WORD_DELIMITORS);
		
		return words;
	}

}
