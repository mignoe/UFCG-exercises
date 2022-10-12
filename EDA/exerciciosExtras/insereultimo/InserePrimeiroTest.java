package insereultimo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import insertionsort.InsertionSortCagado;

class InserePrimeiroTest {

	@Test
	void test2() {
		int[] nums = {2, 6, 9, 11, 13, 5};
		int[] result = {2, 5, 6, 9, 11, 13};
		
		InsereUltimo.insereUltimo(nums);
		
		assertEquals(Arrays.toString(result), Arrays.toString(nums));
	}
	
	@Test
	void test3() {
		int[] nums = {1, 2, 4, 3};
		int[] result = {1, 2, 3, 4};
		
		InsereUltimo.insereUltimo(nums);
		
		assertEquals(Arrays.toString(result), Arrays.toString(nums));
	}
	
	@Test
	void test4() {
		int[] nums = {-4, -3, -2, -1};
		int[] result = {-4, -3, -2, -1};
		
		InsereUltimo.insereUltimo(nums);
		
		assertEquals(Arrays.toString(result), Arrays.toString(nums));
	}
	
	@Test
	void test5() {
		int[] nums = {1, 2, 3, 4};
		int[] result = {1,2,3,4};
		
		InsereUltimo.insereUltimo(nums);
		
		assertEquals(Arrays.toString(result), Arrays.toString(nums));
	}
}
