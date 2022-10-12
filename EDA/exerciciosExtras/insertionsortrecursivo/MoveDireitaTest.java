package insertionsortrecursivo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class MoveDireitaTest {

	@Test
	void test() {
		int[] nums = {1, 2, 3, 4, 0};
		int[] result = {1, 0, 2, 3, 4};
		
		InsertionSortRecursivo.empurraParaDireita(4, nums, 1);
		
		assertEquals(Arrays.toString(result), Arrays.toString(nums));
		
	}
	
	@Test
	void test2() {
		int[] nums = {1, 2, 3, 4, 0};
		int[] result = {0, 1, 2, 3, 4};
		
		InsertionSortRecursivo.empurraParaDireita(4, nums, 0);
		
		assertEquals(Arrays.toString(result), Arrays.toString(nums));
		
	}
	
}
