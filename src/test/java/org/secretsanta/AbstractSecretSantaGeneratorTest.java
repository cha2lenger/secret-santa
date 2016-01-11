package org.secretsanta;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests assignments Secret Santa Generator.
 * 
 * @author  Vladimir Orlov
 *
 */
public abstract class AbstractSecretSantaGeneratorTest extends AbstractBaseSecretSantaGeneratorTest {

	/**
	 * Test case for only two participants.
	 */
	@Test
	public void testTwoParticipants() {
		final String[] participants = new String[]{"First", "Second"};
		// considering random nature of assignments generation- try it multiple times
		for (int i = 0; i < 32; i++) {
			final String[] assignments = this.ssGeneratorToTest.generateAssignments(participants);
			this.checkAssignmentsGenerated(participants, assignments);
		}
	}
	
	/**
	 * For sake of self assignment edge case scenario detection - test three participants. 
	 */
	@Test
	public void testThreeParticipants() {
		final String[] participants = new String[]{"First", "Second", "Third"};
		// considering random nature of assignments generation- try it multiple times
		for (int i = 0; i < 32; i++) {
			final String[] assignments = this.ssGeneratorToTest.generateAssignments(participants);
			this.checkAssignmentsGenerated(participants, assignments);
		}		
	}
	
	/**
	 * Tests decent number of participants.
	 */
	@Test
	public void testManyParticipants() {
		final int size = 1024;
		final String[] participants = new String[size];
		for (int i = 0; i < size; i++) {
			participants[i] = Integer.toString(i);
		}
		// considering random nature of assignments generation- try it multiple times
		for (int i = 0; i < 32; i++) {
			final String[] assignments = this.ssGeneratorToTest.generateAssignments(participants);
			this.checkAssignmentsGenerated(participants, assignments);
		}		
	}
	
	/**
	 * Verifies the assignments generated.
	 * 
	 * @param participants - array of participants.
	 * @param assignments - array of assignments generated for participants. 
	 */
	private void checkAssignmentsGenerated( final String[] participants, final String[] assignments) {
		Assert.assertNotNull("Assignments produced are null.", assignments);
		Assert.assertEquals(String.format(
				" Size of assignments array and size of participant array are different [%1$d vs %2$d]", 
				participants.length, assignments.length), participants.length, assignments.length);
		
		final Set<String> participantsSet = new HashSet<>();
		for ( final String nextParticipant : participants) {
			participantsSet.add(nextParticipant);
		}
		
		final Set<String> assignmentsSet = new HashSet<>();
		for ( int i = 0; i < assignments.length; i++) {
			final String nextAssignment = assignments[i];
			
			Assert.assertNotNull(" One of the assignments produced is null", nextAssignment);
			Assert.assertFalse(
					String.format(" Duplicate assignment [%1$s]", nextAssignment), 
					assignmentsSet.contains(nextAssignment));
			
			final String nextParticipant = participants[i];
			Assert.assertFalse(
					String.format(" Self-assignment detected for [%1$s]", nextParticipant), 
					nextParticipant.equals(nextAssignment));
			
			Assert.assertTrue(
					String.format(" Assignment does not match any of the participants [%1$s]", nextAssignment), 
					participantsSet.contains(nextAssignment));
			
			assignmentsSet.add(nextAssignment);
		}
	}
}