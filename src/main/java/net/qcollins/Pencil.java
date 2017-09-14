package net.qcollins;

public class Pencil {
	private Paper paper;
	private int durability;
	private int initialDurability;
	private int length;
	private static int eraserDurability;

	public Pencil(int durability, Paper paper, int length, int eraserDurability) {
		this.durability = durability;
		initialDurability = durability;
		this.paper = paper;
		this.length = length;
		Pencil.eraserDurability = eraserDurability;
	}

	public void write(String words) {
		char[] characters = words.toCharArray();
		for (char character : characters) {
			reduceDurability(character);
			if (durability > 0) {
				paper.record(character);
			} else {
				paper.record(' ');
			}
		}

	}

	private void reduceDurability(char character) {
		if (Character.isWhitespace(character)) {
		} else if (Character.isUpperCase(character)) {
			durability = durability - 2;
		} else {
			durability--;
		}
	}

	public int getDurability() {
		return durability;
	}
	
	public static int getEraserDurability() {
		return eraserDurability;
	}

	public void sharpen() {
		if (length > 0) {
			length--;
			durability = initialDurability;
		}
	}

	public int getLength() {
		return length;
	}

	public void erase(String stringToRemove) {
		paper.remove(stringToRemove);
		
	}

	public static void reduceEraserDurability() {
		eraserDurability--;
	}

}
