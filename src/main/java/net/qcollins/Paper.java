package net.qcollins;

public class Paper {

	private String words = "";

	public void record(char character) {
		this.words = this.words + character;
	}
	
	public void remove(String stringToRemove) {
		int startOfWordToRemove = words.lastIndexOf(stringToRemove);
		StringBuilder builder = new StringBuilder();
		builder.append(words.substring(0, startOfWordToRemove));
		for(char character : stringToRemove.toCharArray()) {
			builder.append(" ");
		}
		builder.append(words.substring(startOfWordToRemove + stringToRemove.length()));
		words = builder.toString();
	}

	public String getWords() {
		return words;
	}

}
