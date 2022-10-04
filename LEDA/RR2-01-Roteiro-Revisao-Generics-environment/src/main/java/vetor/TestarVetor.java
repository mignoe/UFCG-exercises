package vetor;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestarVetor {

	private Vetor vetor;

	@Before
	public void preparaVetor() {
		this.vetor = new Vetor<Aluno>(10);
	}

	@Test
	public void testInserir() {
		Aluno aluno = new Aluno("S", 10);
		this.vetor.inserir(aluno);
	}

	@Test
	public void testProcurar() {
		Aluno aluno = new Aluno("S", 10);
		this.vetor.inserir(aluno);
		Aluno aluno2 = new Aluno("S", 10);
		assertEquals(this.vetor.procurar(aluno2), aluno);
	}

	@Test
	public void testProcurarNull() {
		Aluno aluno = new Aluno("S", 10);
		this.vetor.inserir(aluno);
		Aluno aluno2 = new Aluno("R", 20);
		assertNull(this.vetor.procurar(aluno2));
	}

	@Test
	public void testIsNotVazio() {
		Aluno aluno = new Aluno("S", 10);
		this.vetor.inserir(aluno);

		assertFalse(this.vetor.isVazio());
	}

	@Test
	public void testIsVazio() {
		assertTrue(this.vetor.isVazio());
	}

}
