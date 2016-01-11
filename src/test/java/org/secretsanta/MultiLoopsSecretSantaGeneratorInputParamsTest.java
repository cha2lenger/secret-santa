/**
 * 
 */
package org.secretsanta;

/**
 * Tests input parameters of {@link MultiLoopsSecretSantaGenerator} implementation of {@link SecretSantaGenerator}.
 * 
 * @author  Vladimir Orlov
 *
 */
public class MultiLoopsSecretSantaGeneratorInputParamsTest extends AbstractSecretSantaGeneratorInputParamsTest {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected SecretSantaGenerator getSecretSantaGenerator() {
		return new MultiLoopsSecretSantaGenerator();
	}
}