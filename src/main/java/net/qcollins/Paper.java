package net.qcollins;

public class Paper {
	
	private String words = "";

	public void record(char character) {
		this.words = this.words + character;
	}
	
	public String getWords() {
		return words;
	}

}
