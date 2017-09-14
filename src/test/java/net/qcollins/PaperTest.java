package net.qcollins;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class PaperTest {
	
	Pencil pencil;
	Paper paper;
	
	@Before
	public void setup() {
		paper = new Paper();
		pencil = new Pencil(paper);
	}
	
	@Test
	public void whenPencilWriteMethodIsCalledStringIsRecordedOnPaper() {
		pencil.write("hello");
		Assert.assertEquals("hello", paper.getWords());
	}
}
