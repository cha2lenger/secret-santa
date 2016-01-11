/**
 * 
 */
package org.secretsanta;

import java.util.HashSet;
import java.util.Set;

/**
 * Base implementation of Secret Santa strategy. Covers input parameter validation common for all kinds of Secret Santa assignment strategies.
 * 
 * @author Vladimir Orlov
 *
 */
public abstract class AbstractSecretSantaGenerator implements SecretSantaGenerator {
	
	/**
	 * {@inheritDoc}
	 */
	public String[] generateAssignments(final String[] participants) {
		// Verify that the argument passed in is valid
		if(participants == null) {
			throw new IllegalArgumentException(" Null has been passed in as required parameter [participants]");
		}
		
		if(participants.length < 2) {
			throw new IllegalArgumentException(String.format(" At least two participants should be passed in [participants-number=%1$d]", participants.length));
		}
		
		// do not accept null and blank strings as valid participant names, check for duplicate names of participants also
		final Set<String> participantNames = new HashSet<>();
		for (final String nextParticipant : participants) {
			if(nextParticipant == null) {
				throw new IllegalArgumentException(" Null has been passed in as one of the participant names.");
			}
			
			final String trimmedParticipantName = nextParticipant.trim();
			if(trimmedParticipantName.length() == 0) {
				throw new IllegalArgumentException(String.format(" Blank or empty string has been passed in as participant name [%1$s]", nextParticipant));
			}
			
			if(participantNames.contains(trimmedParticipantName)) {
				throw new IllegalArgumentException(String.format(" Duplicate name of participant [%1$s]", trimmedParticipantName));
			}
			
			participantNames.add(trimmedParticipantName);
		}
		
		// once input parameters validation is done - generate assignments
		return this.doGenerateAssignments(participants);
	}
	
	/**
	 * Do the actual generation of assignments assuming that the participants (passed in as parameter) are valid.
	 * 
	 * @param participants - participants to generate assignments for.
	 * @return matching array of assignments made.
	 */
	protected abstract String[] doGenerateAssignments(final String[] participants);
}