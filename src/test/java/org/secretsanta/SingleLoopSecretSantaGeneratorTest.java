/**
 * 
 */
package org.secretsanta;

/**
 * Tests assignments generation of {@link SingleLoopSecretSantaGenerator} implementation of {@link SecretSantaGenerator}.
 * 
 * @author  Vladimir Orlov
 *
 */
public class SingleLoopSecretSantaGeneratorTest extends AbstractSecretSantaGeneratorTest {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected SecretSantaGenerator getSecretSantaGenerator() {
		return new SingleLoopSecretSantaGenerator();
	}
}