package binarysearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BinarySearchTest {

	@Test
	void test() {
		int[] nums = {1, 2, 4, 6, 199, 230};
		assertEquals(5, BinarySearch.binarySearch(nums, 230));
	}
	
	@Test
	void test2() {
		int[] nums = {1, 2, 4, 6, 199, 230};
		assertEquals(5, BinarySearch.binarySearch(nums, 230));
	}
	
	@Test
	void test3() {
		int[] nums = {1, 2, 4, 6, 199, 230};
		assertEquals(-1, BinarySearch.binarySearch(nums, 231));
	}
	
	@Test
	void test4() {
		int[] nums = {1, 2, 4, 6, 199, 230};
		assertEquals(-1, BinarySearch.binarySearch(nums, 0));
	}
	
	@Test
	void test5() {
		int[] nums = {1, 2, 4, 6, 199, 230};
		assertEquals(1, BinarySearch.binarySearch(nums, 2));
	}
	
	@Test
	void test6() {
		int[] nums = {};
		assertEquals(-1, BinarySearch.binarySearch(nums, 2));
	}
	
	@Test
	void test7() {
		int[] nums = {-1, -2, 4, 6, 199, 230};
		assertEquals(-1, BinarySearch.binarySearch(nums, 2));
	}
}

// 0 1 2 3 4 5 
// ^


