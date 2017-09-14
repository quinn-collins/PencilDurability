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
		pencil = new Pencil(20, paper);
	}
	
	@Test
	public void whenPencilWriteMethodIsCalledStringIsRecordedOnPaper() {
		pencil.write("hello");
		Assert.assertEquals("hello", paper.getWords());
	}
	
	@Test
	public void whenPencilWritesTwiceTheNewStringIsAppendedToThePaper() {
		pencil.write("She sells sea shells");
		pencil.write(" down by the sea shore");
		Assert.assertEquals("She sells sea shells down by the sea shore", paper.getWords());
	}
	
	@Test
	public void writingTextExpendsPencilDurability() {
		pencil.write("this is a test");
		Assert.assertTrue(pencil.getDurability() < 20);
	}
	
	@Test
	public void writingLowerCaseLettersExpendsPencilDurabilityByOne() {
		pencil.write("abc");
		Assert.assertEquals(17, pencil.getDurability());
	}
}
