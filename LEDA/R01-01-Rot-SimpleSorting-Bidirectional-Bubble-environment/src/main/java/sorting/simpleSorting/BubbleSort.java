package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * The bubble sort algorithm iterates over the array multiple times, pushing big
 * elements to the right by swapping adjacent elements, until the array is
 * sorted.
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		// TODO Auto-generated method stub
		boolean swapped = true;
		int interated = 0;
		do {
			swapped = false;
			for (int i = 0; i < rightIndex - interated; i++) {
				if (array[i].compareTo(array[i + 1]) > 0)
					Util.swap(array, i, i + 1);
				swapped = true;
			}
			interated++;
		} while (swapped);
		
	}
}
