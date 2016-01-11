/**
 * 
 */
package org.secretsanta;

import java.util.Arrays;
import java.util.Random;

/**
 * This implementation is capable to create multiple loops of assignments. Loop of assignments 
 * is essentially a graph-like data structure where participants are vertices, 
 * assignments are directed edges between vertices. There is one caveat though we have to address properly: 
 * the single participant assigned to itself is also a terminal form of so-called loop of assignments. And we have to avoid such situation.  
 * 
 * @author Vladimir Orlov
 *
 */
public class MultiLoopsSecretSantaGenerator extends AbstractSecretSantaGenerator
		implements SecretSantaGenerator {

	/**
	 * Random integer generator to use.
	 */
	final Random random;
	
	/**
	 * Default constructor.
	 */
	public MultiLoopsSecretSantaGenerator() {
		this.random = new Random();
	}	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String[] doGenerateAssignments(String[] participants) {
		final String[] assignments = new String[participants.length];
		
		final String[] assignmentsAvail = Arrays.copyOf(participants, participants.length); // O(n)
		int assignmentsAvailSize = participants.length;
		
		// do all the assignments except first two participants
		for (int i = 2; i < participants.length; i++) { // O(n)
			final int assignmentAvailPos = findAssignmentPosition(participants[i], assignmentsAvail, assignmentsAvailSize);
			assignments[i] = assignmentsAvail[assignmentAvailPos];
			
			assignmentsAvailSize--;
			swap(assignmentsAvail, assignmentAvailPos, assignmentsAvailSize);
		}
		
		// handle the last two assignments separately in order to avoid 
		// the last remaining participant assignment to him/herself situation
		if(participants[0].equals(assignmentsAvail[0]) || participants[1].equals(assignmentsAvail[1])) {
			assignments[0] = assignmentsAvail[1];
			assignments[1] = assignmentsAvail[0];
		} else {
			assignments[0] = assignmentsAvail[0];
			assignments[1] = assignmentsAvail[1];
		}

		return assignments;
	}
	
	/**
	 * Finds assignment position for the given participant in array of assignments available explicitly limited by size.
	 *  
	 * @param participant - participant to find assignment position for.
	 * @param assignmentsAvail - array of available assignments to find position of assignment in.
	 * @param assignmentsAvailSize - explicit limitation of the array of available assignments.
	 * @return assignment position for the given participant in array of assignments. 
	 */
	private int findAssignmentPosition(final String participant, final String[] assignmentsAvail, final int assignmentsAvailSize) {
		int assignmentPos = this.random.nextInt(assignmentsAvailSize);
		
		// try to select assignment randomly
		if(!(participant.equals(assignmentsAvail[assignmentPos]))) {
			// if it is different than participant - use it
			return assignmentPos;
		}
		
		// otherwise - make a second step to find assignment that does not match the participant passed in
		return (assignmentPos + 1 + this.random.nextInt(assignmentsAvailSize - 1)) % assignmentsAvailSize; 
	}
	
	/**
	 * Swaps elements of the array.
	 * 
	 * @param array - array to swap elements for.
	 * @param i - index of the first element to swap.
	 * @param j - index of the second element to swap.
	 */
	private static void swap(final String[] array, final int i, final int j) {
		String temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}