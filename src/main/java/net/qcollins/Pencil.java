package net.qcollins;

public class Pencil {
	private Paper paper;

	public Pencil(Paper paper) {
		this.paper = paper;
	}

	public void write(String words) {
		paper.record(words);
		
	}

}
