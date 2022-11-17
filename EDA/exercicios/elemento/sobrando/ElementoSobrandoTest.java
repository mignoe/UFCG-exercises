package elemento.sobrando;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ElementoSobrandoTest {

	@Test
	void test() {
		int[] nums = {1, 13, 3, 4, 5};
		int[] nums2 = {1, 13, 3, 4, 5, 6};
		
		int resultado = ElementoSobrando.elementoSobrando(nums, nums2);
		
		assertEquals(6, resultado);
	}
	
	@Test
	void test2() {
		int[] nums = {1};
		int[] nums2 = {1, 3};
		
		int resultado = ElementoSobrando.elementoSobrando(nums, nums2);
		
		assertEquals(3, resultado);
	}
	
	@Test
	void test3() {
		int[] nums = {};
		int[] nums2 = {1};
		
		int resultado = ElementoSobrando.elementoSobrando(nums, nums2);
		
		assertEquals(1, resultado);
	}
	
	@Test
	void test4() {
		int[] nums = {1, 7, 6};
		int[] nums2 = {6, 4, 7, 1};
		
		int resultado = ElementoSobrando.elementoSobrando(nums, nums2);
		
		assertEquals(4, resultado);
	}
	
	@Test
	void test5() {
		int[] nums = {-10, -7, -6};
		int[] nums2 = {-10, 4, -7, -6};
		
		int resultado = ElementoSobrando.elementoSobrando(nums, nums2);
		
		assertEquals(4, resultado);
	}
	
	@Test
	void test6() {
		int[] nums = {-10, -7, -6};
		int[] nums2 = {-10, -4, -7, -6};
		
		int resultado = ElementoSobrando.elementoSobrando(nums, nums2);
		
		assertEquals(-4, resultado);
	}

}
