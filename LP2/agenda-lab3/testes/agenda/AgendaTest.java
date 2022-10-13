package agenda;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AgendaTest {
	Agenda agenda = new Agenda();
	@BeforeEach
	void setUp() throws Exception {
		agenda.cadastraContato(0, "Miguel", "Rodrigues", "1234-5678");
	}
	
	@Test
	void testAdicionaContatoEm99() {
		String msg = "Esperando contato ser cadastrado com sucesso";
		
		agenda.cadastraContato(99, "Pedro", "Rodrigo", "1010-1010");
		String retornoEsperado = "Pedro Rodrigo\n1010-1010";
		
		assertEquals(agenda.getContato(99), retornoEsperado, msg);
	}
	
	@Test
	void testAdicionaContatoAcimaDoLimiteSuperior() {
		String msg = "Esperando contato não ser cadastrado";
				
		assertThrows(IndexOutOfBoundsException.class, () -> {
			agenda.cadastraContato(101, "Pedro", "Rodrigo", "1010-1010");
		}, msg);
	}

	@Test
	void testAdicionaContatoAbaixoDoLimiteInferior() {
		String msg = "Esperando contato não ser cadastrado";		
		
		assertThrows(IndexOutOfBoundsException.class, () -> {
			agenda.cadastraContato(-1, "Pedro", "Rodrigo", "1010-1010");
		}, msg);		
	}
	
	@Test
	void testSobrescreveContato() {
		String msg = "Esperando sobrescrever o contato";
		
		agenda.cadastraContato(0, "Rodrigues", "Miguel", "0101-0101");
		String retornoEsperado = "Rodrigues Miguel\n0101-0101";
		
		assertEquals(agenda.getContato(0), retornoEsperado, msg);
	}
	
	@Test
	void testContatoJaCadastrado() {
		String msg = "Esperando retornar que o contato já foi cadastrado (true)";
		
		assertEquals(agenda.contatoJaCadastrado("Miguel", "Rodrigues"), true, msg);
	}

	@Test
	void testContatoNaoCadastrado() {
		String msg = "Esperando retornar que o contato não foi cadastrado (false)";
		
		assertEquals(agenda.contatoJaCadastrado("Paulo", "Rodrigo"), false, msg);
	}
	
	@Test
	void testAdicionaFavorito() {
		String msg = "Esperando que contato seja favoritado com sucesso.";
		
		agenda.adicionaFavorito(0, 0);
		String retornoEsperado = "Miguel Rodrigues";
		
		assertEquals(agenda.getFavoritos()[0], retornoEsperado, msg);
	}

	@Test
	void testSobrescreveFavorito() {
		String msg = "Esperando sobrescrever favorito";
		
		agenda.adicionaFavorito(0, 0);
		agenda.cadastraContato(1, "Paulo", "Rodrigo", "2345-5432");
		agenda.adicionaFavorito(1, 0);
		String retornoEsperado = "Paulo Rodrigo";
		
		assertEquals(agenda.getFavoritos()[0], retornoEsperado, msg);
	}
	
	@Test
	void testDentroLimiteSuperiorFavorito() {
		String msg = "Esperando contato ser favoritado com sucesso.";
		
		agenda.adicionaFavorito(0, 9);
		String retornoEsperado = "Miguel Rodrigues";
		
		assertEquals(agenda.getFavoritos()[9], retornoEsperado, msg);
	}
	
	@Test
	void testEstouroLimiteSuperiorFavorito() {
		String msg = "Esperando erro indexOutOfBound";
		
		assertThrows(IndexOutOfBoundsException.class, () -> {
			agenda.adicionaFavorito(0, 10);
		}, msg);
	}

	@Test
	void testEstouroLimiteInferiorFavorito() {
		String msg = "Esperando erro indexOutOfBound";
		
		assertThrows(IndexOutOfBoundsException.class, () -> {
			agenda.adicionaFavorito(0, -1);
		}, msg);
	}
	
	@Test
	void testEhFavorito() {
		String msg = "Esperando retornar que o contato foi favoritado (true)";
		
		agenda.adicionaFavorito(0, 0);
		
		assertEquals(agenda.ehFavorito(0), true, msg);
	}
	
	@Test
	void testNaoEhFavorito() {
		String msg = "Esperando retornar que o contato não foi favoritado (false)";
		
		agenda.adicionaFavorito(0, 0);
		agenda.cadastraContato(1, "Paulo", "Rodrigo", "1010-1010");
		
		assertEquals(agenda.ehFavorito(1), false, msg);
	}

}
