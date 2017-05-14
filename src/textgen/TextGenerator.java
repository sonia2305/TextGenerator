package textgen;

public interface TextGenerator {
	
	/**
	 * Trains a paragraph of text and creates
	 * the guide for generating related texts
	 * @param trainingData
	 */
	public void train(String trainingData);
	
	/**
	 * Based on the training data, generates related texts
	 * after the startWord and go on for <numberOfTexts> many times
	 * @param startWord TODO
	 * @param numberOfText
	 */
	public void generate(String startWord, int numberOfTexts);
	
	/**
	 * Re-train data afresh
	 * @param trainingData
	 */
	public void retrain(String trainingData);

}
