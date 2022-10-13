package insertionsort;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class InsertionSortTest {

	@Test
	void test() {
		int[] nums = {5, 4, 3, 2, 1};
		int[] result = {1, 2, 3 ,4 ,5};
		
		InsertionSortCagado.insertionSort(nums);
		
		assertEquals(Arrays.toString(result), Arrays.toString(nums));
	}
	
	@Test
	void test2() {
		int[] nums = {5, 4, 4, 3, 2, 1};
		int[] result = {1, 2, 3 ,4, 4 ,5};
		
		InsertionSortCagado.insertionSort(nums);
		
		assertEquals(Arrays.toString(result), Arrays.toString(nums));
	}
	
	@Test
	void test3() {
		int[] nums = {5, 4, 4, 3, 2, 1, 10, 9, 33, 45, 45, 45, 10};
		int[] result = {1, 2, 3 ,4, 4 ,5, 9, 10, 10, 33, 45, 45, 45};
		
		InsertionSortCagado.insertionSort(nums);
		
		assertEquals(Arrays.toString(result), Arrays.toString(nums));
	}

}
