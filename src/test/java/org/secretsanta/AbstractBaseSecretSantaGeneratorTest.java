/**
 * 
 */
package org.secretsanta;

import org.junit.Before;

/**
 * Base test class for Secret Santa Generators. 
 * 
 * @author  Vladimir Orlov
 *
 */
public abstract class AbstractBaseSecretSantaGeneratorTest {
	
	/** Secret Santa generator to test. */
	protected SecretSantaGenerator ssGeneratorToTest;
	
	/**
	 * Initializes Secret Santa Generator to test.
	 */
	@Before
	public void setupSecretSantaGenerator() {
		this.ssGeneratorToTest = getSecretSantaGenerator();
	}
	
	/**
	 * Provides specific instance of Secret Santa Generator to test.
	 * 
	 * @return Secret Santa Generator to test.
	 */
	protected abstract SecretSantaGenerator getSecretSantaGenerator();
}