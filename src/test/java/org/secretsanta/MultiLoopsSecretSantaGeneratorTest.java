/**
 * 
 */
package org.secretsanta;

/**
 * Tests assignments generation of {@link MultiLoopsSecretSantaGenerator} implementation of {@link SecretSantaGenerator}.
 * 
 * @author  Vladimir Orlov
 *
 */
public class MultiLoopsSecretSantaGeneratorTest extends AbstractSecretSantaGeneratorTest {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected SecretSantaGenerator getSecretSantaGenerator() {
		return new MultiLoopsSecretSantaGenerator();
	}
}