/**
 * 
 */
package org.secretsanta;

import org.junit.Test;


/**
 * Tests input parameters of Secret Santa Generator.
 * 
 * @author Vladimir Orlov
 *
 */
public abstract class AbstractSecretSantaGeneratorInputParamsTest extends AbstractBaseSecretSantaGeneratorTest {
	
	/**
	 * Test the case when null is passed in as parameter.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testNullParameter() {
		this.ssGeneratorToTest.generateAssignments(null);
	}
	
	/**
	 * Test the case when empty array is passed in as parameter.
	 */
	@Test(expected=IllegalArgumentException.class)	
	public void testEmptyArrayParameter() {
		this.ssGeneratorToTest.generateAssignments(new String[0]);
	}
	
	/**
	 * Test the case when array with single item is passed in as parameter.
	 */
	@Test(expected=IllegalArgumentException.class)	
	public void testOneItemArrayParameter() {
		this.ssGeneratorToTest.generateAssignments(new String[]{"One"});
	}	
	
	/**
	 * Test the case when array with empty string is passed in as parameter.
	 */
	@Test(expected=IllegalArgumentException.class)	
	public void testEmptyStringInArrayParameter() {
		this.ssGeneratorToTest.generateAssignments(new String[]{"One", "Two", "Three", "", "Five", "Three"});
	}	
	
	/**
	 * Test the case when array with blank string is passed in as parameter.
	 */
	@Test(expected=IllegalArgumentException.class)	
	public void testBlankStringInArrayParameter() {
		this.ssGeneratorToTest.generateAssignments(new String[]{"One", "   ", "Three", "Four", "Five", "Three"});
	}
	
	/**
	 * Test the case when array with null is passed in as parameter.
	 */
	@Test(expected=IllegalArgumentException.class)	
	public void testNullInArrayParameter() {
		this.ssGeneratorToTest.generateAssignments(new String[]{"One", "Two", "Three", null, "Five", "Three"});
	}	
	
	/**
	 * Test the case when array with duplicate strings is passed in as parameter.
	 */
	@Test(expected=IllegalArgumentException.class)	
	public void testDupsInArrayParameter() {
		this.ssGeneratorToTest.generateAssignments(new String[]{"One", "Two", "Three", "Four", "Five", "Three"});
	}	
	
	/**
	 * Test the case when array with duplicate strings (when trimmed) is passed in as parameter.
	 */
	@Test(expected=IllegalArgumentException.class)	
	public void testTrimDupsInArrayParameter() {
		this.ssGeneratorToTest.generateAssignments(new String[]{"One", "Two", "Three", "Four", "  Five\t", "Five"});
	}	
}