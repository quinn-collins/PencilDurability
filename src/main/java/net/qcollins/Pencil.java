package net.qcollins;

public class Pencil {
	private Paper paper;
	private int durability;

	public Pencil(int durability, Paper paper) {
		this.durability = durability;
		this.paper = paper;
	}

	public void write(String words) {
		paper.record(words);
		reduceDurability(words);
		
	}

	private void reduceDurability(String words) {
		char[] characters = words.toCharArray();
		for(char character : characters) {
			durability--;
		}
		
	}

	public int getDurability() {
		return durability;
	}

}
