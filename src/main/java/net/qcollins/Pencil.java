package net.qcollins;

public class Pencil {
	private Paper paper;
	private int durability;

	public Pencil(int durability, Paper paper) {
		this.durability = durability;
		this.paper = paper;
	}

	public void write(String words) {
		char[] characters = words.toCharArray();
		for(char character : characters) {
			reduceDurability(character);
			if(durability > 0) {
				paper.record(character);
			}
			else {
				paper.record(' ');
			}
		}
		
		
	}

	private void reduceDurability(char character) {
		if(Character.isWhitespace(character)) {}
		else if(Character.isUpperCase(character)) {
			durability = durability - 2;
		}
		else {
			durability--;
		}
	}
		
	

	public int getDurability() {
		return durability;
	}

}
