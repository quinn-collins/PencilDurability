package net.qcollins;

public class Paper {
	
	private String words = "";

	public void record(String words) {
		this.words = this.words + words;
	}
	
	public String getWords() {
		return words;
	}

}
