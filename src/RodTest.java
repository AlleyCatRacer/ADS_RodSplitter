import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RodTest
{
	private Rod rod;
	
	@BeforeEach void setUp()
	{
		rod = new Rod();
	}
	
	@Test void bruteForceTest()
	{
		assertEquals(0, rod.bruteForceCut(0));
		assertEquals(1, rod.bruteForceCut(1));
		assertEquals(5, rod.bruteForceCut(2));
		assertEquals(8, rod.bruteForceCut(3));
		assertEquals(10, rod.bruteForceCut(4));
		assertEquals(13, rod.bruteForceCut(5));
		assertEquals(17, rod.bruteForceCut(6));
		assertEquals(18, rod.bruteForceCut(7));
		assertEquals(22, rod.bruteForceCut(8));
		assertEquals(25, rod.bruteForceCut(9));
		assertEquals(30, rod.bruteForceCut(10));
	}
	
	@Test void recursiveCutTest()
	{
		assertEquals(0, rod.recursiveCut(0));
		assertEquals(1, rod.recursiveCut(1));
		assertEquals(5, rod.recursiveCut(2));
		assertEquals(8, rod.recursiveCut(3));
		assertEquals(10, rod.recursiveCut(4));
		assertEquals(13, rod.recursiveCut(5));
		assertEquals(17, rod.recursiveCut(6));
		assertEquals(18, rod.recursiveCut(7));
		assertEquals(22, rod.recursiveCut(8));
		assertEquals(25, rod.recursiveCut(9));
		assertEquals(30, rod.recursiveCut(10));
	}
	
	@Test void dynamicCutTestWithoutMapping()
	{
		// Each should print once
		assertEquals(0, rod.dynamicCut(0));
		System.out.println("---------------------------------------");
		assertEquals(1, rod.dynamicCut(1));
		System.out.println("---------------------------------------");
		assertEquals(5, rod.dynamicCut(2));
		System.out.println("---------------------------------------");
		assertEquals(8, rod.dynamicCut(3));
		System.out.println("---------------------------------------");
		assertEquals(10, rod.dynamicCut(4));
		System.out.println("---------------------------------------");
		assertEquals(13, rod.dynamicCut(5));
		System.out.println("---------------------------------------");
		assertEquals(17, rod.dynamicCut(6));
		System.out.println("---------------------------------------");
		assertEquals(18, rod.dynamicCut(7));
		System.out.println("---------------------------------------");
		assertEquals(22, rod.dynamicCut(8));
		System.out.println("---------------------------------------");
		assertEquals(25, rod.dynamicCut(9));
		System.out.println("---------------------------------------");
		assertEquals(30, rod.dynamicCut(10));
		System.out.println("---------------------------------------");
	}
	
	@Test void dynamicCutTestWithPartialMapping3None1None6()
	{
		// Prints 3 times
		rod.dynamicCut(3);
		System.out.println("---------------------------------------");
		
		// Shouldn't print
		assertEquals(8, rod.dynamicCut(3));
		System.out.println("---------------------------------------");
		
		// Should print once because 3 is the highest it has mapped, so it needs one more recursive call
		assertEquals(10, rod.dynamicCut(4));
		System.out.println("---------------------------------------");
		
		// Shouldn't print
		assertEquals(5, rod.dynamicCut(2));
		System.out.println("---------------------------------------");
		
		// Should print 6 times because 10 - 6 = 4
		assertEquals(30, rod.dynamicCut(10));
		System.out.println("---------------------------------------");
	}
}
