package insertion.sort.recursivo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EncontraIndiceMaiorTest {

	@Test
	void test() {
		int[] nums = {1, 2, 3, 4, 0};
		
		int indice = InsertionSortRecursivo.encontraIndiceMenor(3, nums, 0);
		
		assertEquals(-1, indice);
	}
	
	@Test
	void test2() {
		int[] nums = {2, 4, 6, 1, 3};
		
		int indice = InsertionSortRecursivo.encontraIndiceMenor(2, nums, 1);
		
		assertEquals(-1, indice);
	}
	
	@Test
	void test3() {
		int[] nums = {3, 7, 9, 11, 23, 31, 4, 0};
		
		int indice = InsertionSortRecursivo.encontraIndiceMenor(5, nums, 4);
		
		assertEquals(0, indice);
	}
	
	@Test
	void test4() {
		int[] nums = {1, 2, 4, 5, 3};
		
		int indice = InsertionSortRecursivo.encontraIndiceMenor(3, nums, 3);
		
		assertEquals(1, indice);
	}
}
