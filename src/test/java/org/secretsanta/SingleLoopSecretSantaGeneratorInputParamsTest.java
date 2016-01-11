/**
 * 
 */
package org.secretsanta;

/**
 * Tests input parameters of {@link SingleLoopSecretSantaGenerator} implementation of {@link SecretSantaGenerator}.
 * 
 * @author  Vladimir Orlov
 *
 */
public class SingleLoopSecretSantaGeneratorInputParamsTest extends AbstractSecretSantaGeneratorInputParamsTest {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected SecretSantaGenerator getSecretSantaGenerator() {
		return new SingleLoopSecretSantaGenerator();
	}
}