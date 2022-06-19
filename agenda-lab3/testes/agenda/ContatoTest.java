package agenda;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
 
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ContatoTest {
	
	private Contato contatoBase;
	
	@BeforeEach
    void preparaContatos() {
        this.contatoBase = new Contato("Miguel", "Rodrigues", "555-5551");
    }
	
	@Test
	void testNomeCompleto() {
		  String msg = "Esperando obter o nome completo";
	      assertEquals( "Miguel Rodrigues", this.contatoBase.getNomeCompleto(), msg);
	}
	
	@Test
	void testEquals() {
		String msg = "Esperando obter true, independente da diferença no telefone.";
		Contato contatoASerComparado = new Contato("Miguel", "Rodrigues", "83-99000-0000");
		assertEquals( this.contatoBase.equals(contatoASerComparado), true, msg);
	}
	
	@Test
	void testNotEquals() {
		String msg = "Esperando obter o nome completo";
		Contato contatoASerComparado = new Contato("Marcos", "Rodrigo", "555-5551");
		assertEquals( this.contatoBase.equals(contatoASerComparado), false, msg);
	}
	
	@Test
	void testToString() {
		String msg = "Esperando retornar nome completo e telefone em duas linhas";
		String retornoEsperado = 	"Miguel Rodrigues\n" +
						"555-5551";
		assertEquals(this.contatoBase.toString(), retornoEsperado, msg);
	}

	@Test
	void testToStringSemSobrenome() {
		Contato contatoSemSobrenome = new Contato("Miguel", "", "(00) 00000-0000");
		String msg = "Esperando retornar o primeiro nome e telefone em duas linhas";
		String retornoEsperado = 	"Miguel \n" + 
						"(00) 00000-0000";
		assertEquals(contatoSemSobrenome.toString(), retornoEsperado, msg);
	}
	
	@Test
	void testTags() {
		String msg = "Esperando retornar \"ufcg\" na última linha";
		contatoBase.addTag("ufcg", 1);
		assertEquals(this.contatoBase.toString(), "Miguel Rodrigues\n555-5551\nufcg", msg);
	}
	
	@Test
	void testTagsLowestPossiblePosition() {
		this.contatoBase.addTag("ufcg", 0);
		String retornoEsperado = 	"Miguel Rodrigues\n" +
						"555-5551\n" +
						"ufcg";
		assertEquals(this.contatoBase.toString(), retornoEsperado);
	}
	
	@Test
	void testTagsBiggestPossiblePosition() {
		this.contatoBase.addTag("ufcg", 0);
		String retornoEsperado = "Miguel Rodrigues\n555-5551\nufcg";
		assertEquals(this.contatoBase.toString(), retornoEsperado);
	}
	
	@Test
	void testTagsLowerThanLimitPosition() {
		assertThrows(IndexOutOfBoundsException.class, () -> {
			this.contatoBase.addTag("ufcg", -1);
		});
	}
	
	@Test
	void testTagsBiggerThanLimitPosition() {
		assertThrows(IndexOutOfBoundsException.class, () -> {
			this.contatoBase.addTag("ufcg", 5);
		});
	}
	
	@Test
	void testTagsOrderSystem() {
		this.contatoBase.addTag("ufcg", 0);
		this.contatoBase.addTag("ccc", 2);
		this.contatoBase.addTag("pet", 4);
		this.contatoBase.addTag("caesi", 3);
		this.contatoBase.addTag("elas", 1);
		String retornoEsperado = 	"Miguel Rodrigues\n" +
									"555-5551\n" +
									"ufcg elas ccc caesi pet";
		assertEquals(this.contatoBase.toString(), retornoEsperado);
	}

	@Test
	void testTagsReplacementSystem() {
		this.contatoBase.addTag("ufcg", 0);
		this.contatoBase.addTag("ccc", 0);
		String retornoEsperado = 	"Miguel Rodrigues\n" +
									"555-5551\n" +
									"ccc";
		assertEquals(this.contatoBase.toString(), retornoEsperado);
	}
}
