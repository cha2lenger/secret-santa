/**
 * 
 */
package org.secretsanta;

import java.util.Random;

/**
 * The most simple out of two assignments generators. With certain level of randomness it creates one single loop of assignments 
 * that covers all of the participants passed in. Loop of assignments is essentially a graph-like data structure where participants are vertices, 
 * assignments are directed edges between vertices.  
 * 
 * @author Vladimir Orlov
 *
 */
public class SingleLoopSecretSantaGenerator extends AbstractSecretSantaGenerator
		implements SecretSantaGenerator {
	
	/**
	 * Random integer generator to use.
	 */
	final Random random;
	
	/**
	 * Default constructor.
	 */
	public SingleLoopSecretSantaGenerator() {
		this.random = new Random();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String[] doGenerateAssignments(String[] participants) {
		final int firstFromIndex = 0;
		
		int toIndexesAvailSize = participants.length - 1;
		final int[] toIndexesAvail  = new int[toIndexesAvailSize];
		for(int i = 1, j = 0; i < participants.length; i++, j++) { // O(n)
			toIndexesAvail[j] = i;
		}
		
		int nextFromIdx = firstFromIndex;
		final String[] assignments = new String[participants.length];
		while(toIndexesAvailSize > 0) { // O(n)
			final int nextRandomIndexPos = this.random.nextInt(toIndexesAvailSize);
			final int nextToIndex =  toIndexesAvail[nextRandomIndexPos];
			
			toIndexesAvailSize--;
			swap(toIndexesAvail, nextRandomIndexPos, toIndexesAvailSize);
			
			assignments[nextFromIdx] = participants[nextToIndex];
			nextFromIdx = nextToIndex;
		}
		
		assignments[nextFromIdx] = participants[firstFromIndex];
		
		return assignments;
	}
	
	/**
	 * Swaps elements of the array.
	 * 
	 * @param array - array to swap elements for.
	 * @param i - index of the first element to swap.
	 * @param j - index of the second element to swap.
	 */
	private static void swap(final int[] array, final int i, final int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}