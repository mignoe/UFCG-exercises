package recursao;

import static org.junit.Assert.*;

import org.junit.Test;

public class TesteRecursoes {
	
	@Test
	public void test() {
		assertEquals(10, MetodosRecursivos.calcularSomaArray(new int[] {1, 2, 3, 4}));
	}
	
	@Test
	public void test2() {
		assertEquals(87, MetodosRecursivos.calcularSomaArray(new int[] {30, 22, 31, 4}));
	}

}
