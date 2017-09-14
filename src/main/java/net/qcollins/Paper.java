package net.qcollins;

public class Paper {

	private String words = "";

	public void record(char character) {
		this.words = this.words + character;
	}
	
	public void remove(String stringToRemove) {
		int indexOfWordToRemove = words.lastIndexOf(stringToRemove);
		if(indexOfWordToRemove > -1) {
			StringBuilder builder = new StringBuilder();
			builder.append(words.substring(0, indexOfWordToRemove));
			for(int i = 0; i < stringToRemove.length(); i++) {
				builder.append(" ");
			}
			builder.append(words.substring(indexOfWordToRemove + stringToRemove.length()));
			words = builder.toString();
		}
	}

	public String getWords() {
		return words;
	}

}
