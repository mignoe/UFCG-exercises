package vetor;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VetorTest {
	private Vetor vetor;
	private Aluno aluno1;
	private Aluno aluno2;
	private Aluno aluno3;
	private Aluno aluno4;
	
	private ComparatorMaximo comparatorMaximo;
	private ComparatorMinimo comparatorMinimo;
	
	@Before
	public void setUp() {
		this.vetor = new Vetor<Aluno>(10);
		this.aluno1 = new Aluno("a", 10);
		this.aluno2 = new Aluno("b", 10);
		this.aluno3 = new Aluno("c", 9);
		this.aluno4 = new Aluno("d", 8);
		
		this.comparatorMaximo = new ComparatorMaximo();
		this.comparatorMinimo= new ComparatorMinimo();
		
		this.vetor.setComparadorMaximo(comparatorMaximo);
		this.vetor.setComparadorMinimo(comparatorMinimo);
		
		this.vetor.inserir(aluno1);
		this.vetor.inserir(aluno2);
		this.vetor.inserir(aluno3);
		this.vetor.inserir(aluno4);
	}
	
	@Test
	public void testMaximo() {
		assertEquals(this.aluno1, this.vetor.maximo());
	}
	
	@Test
	public void testMinimo() {
		assertEquals(this.aluno1, this.vetor.maximo());
	}
	
	@Test
	public void testMinimoEmVazio() {
		Vetor<Aluno> vetor2 = new Vetor<Aluno>(10);
		vetor2.setComparadorMaximo(comparatorMaximo);
		vetor2.setComparadorMinimo(comparatorMinimo);
		
		assertEquals(null, vetor2.minimo());
	}
	
	@Test
	public void testMaximoEmVazio() {
		Vetor<Aluno> vetor2 = new Vetor<Aluno>(10);
		vetor2.setComparadorMaximo(comparatorMaximo);
		vetor2.setComparadorMinimo(comparatorMinimo);
		
		assertEquals(null, vetor2.maximo());
	}
}
