/**
 * 
 */
package org.secretsanta;

/**
 * Defines the API of the Secret Santa assignment generator.
 * 
 * @author Vladimir Orlov
 *
 */
public interface SecretSantaGenerator {

	/**
	 * Generates Secret Santa assignments for the given array of participants.
	 * 
	 * @param participants list of individuals participating in the draw.
	 * @return the list of individuals paired with the participants where participants[0] is matched with assignments[0], participants[1] is matched with assignments[1], and so on.
	 */
	String[] generateAssignments(final String[] participants);
}