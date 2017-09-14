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
		pencil = new Pencil(20, paper, 1);
	}
	
	@Test
	public void whenPencilWriteMethodIsCalledStringIsRecordedOnPaper() {
		pencil.write("hello");
		Assert.assertEquals("hello", paper.getWords());
	}
	
	@Test
	public void whenPencilWritesTwiceTheNewStringIsAppendedToThePaper() {
		pencil.write("She sells ");
		pencil.write("sea shells");
		Assert.assertEquals("She sells sea shells", paper.getWords());
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
	
	@Test
	public void writingUpperCaseLettersExpendsPencilDurabilityByTwo() {
		pencil.write("ABC");
		Assert.assertEquals(14, pencil.getDurability());
	}
	
	@Test
	public void writingOneUpperCaseLetterAndTwoLowerCaseLettersWillReduceDurabilityByFour() {
		pencil.write("Abc");
		Assert.assertEquals(16, pencil.getDurability());
	}
	
	@Test
	public void writingSpacesWillNotExpendAnyDurability() {
		pencil.write("   ");
		Assert.assertEquals(20, pencil.getDurability());
	}
	
	@Test
	public void writingALowerCaseCharacterThenASpaceThenALowerCaseLetterWillReduceDurabilityByTwo() {
		pencil.write("a c");
		Assert.assertEquals(18, pencil.getDurability());
	}
	
	@Test
	public void writingNewLinesWillNotExpendAnyDurability() {
		pencil.write("\n");
		Assert.assertEquals(20, pencil.getDurability());
	}
	
	@Test
	public void pencilWillWriteOnlySpacesWhenOutOfDurability() {
		pencil.write("twentycharactershere");
		pencil.write("spaces");
		Assert.assertEquals("twentycharactersher       ", paper.getWords());
	}
	
	@Test
	public void pencilCanBeSharpenedToRegainOriginalDurability() {
		pencil.write("some text");
		pencil.sharpen();
		Assert.assertEquals(20, pencil.getDurability());
	}
	
	@Test
	public void pencilWillContinueToWriteCharactersAfterItsLostItsDurabilityAndBeenSharpenedAgain() {
		pencil.write("twentycharactershere");
		pencil.sharpen();
		pencil.write("test");
		Assert.assertEquals("twentycharactersher test", paper.getWords());
	}
	
	@Test
	public void whenYouSharpenAPencilItsLengthIsReducedByOne() {
		pencil.sharpen();
		Assert.assertEquals(0, pencil.getLength());
	}
	
	@Test
	public void pencilCanNotBeANegativeLength() {
		pencil.sharpen();
		pencil.sharpen();
		Assert.assertEquals(0, pencil.getLength());
	}
	
	@Test
	public void whenPencilHasZeroLengthSharpeningItWillNoLongerRestoreDurability() {
		pencil.sharpen();
		pencil.write("text");
		pencil.sharpen();
		Assert.assertEquals(16, pencil.getDurability());
	}
}
