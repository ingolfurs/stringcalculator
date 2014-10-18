package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
//import org.junit.Rules.ExpextedException;

public class CalculatorTest {

	public static void main(String args[]) {
		org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
	}

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}	

	@Test
	public void testMultipleNumbers(){
		assertEquals(55, Calculator.add("1,2,3,4,5,6,7,8,9,10"));
	}

	@Test
	public void testNewLinesSeperators(){
		assertEquals(15, Calculator.add("1\n2,3\n4\n5"));
	}

	@Test
	public void testDifferentDelimiter(){
		assertEquals(3, Calculator.add("//;\n1;2"));
	}

	@Test
	public void testNegativeNumbers() {
		try {
			Calculator.add("-1,2");
			fail("No exception thrown");
		}
		catch (RuntimeException e) {
			assertEquals("Negatives not allowed: -1", e.getMessage());
		}
		try {
			Calculator.add("2,-4,3,-5");
			fail("No exception thrown");
		}
		catch (RuntimeException e) {
			assertEquals("Negatives not allowed: -4, -5", e.getMessage());
		}
	}

	@Test
	public void testIgnoreNumbersBiggerThan1000(){
		assertEquals(2, Calculator.add("1000,2"));
	}

}
