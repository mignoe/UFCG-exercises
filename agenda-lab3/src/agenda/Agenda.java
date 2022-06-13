package agenda;

import java.util.Arrays;

/**
 * Uma agenda que mantém uma lista de contatos com posições. Podem existir 100 contatos. 
 * 
 * @author nazareno
 *
 */
public class Agenda {
	
	private static final int TAMANHO_AGENDA = 100;
	private static final int TAMANHO_FAVORITOS = 10;
	
	private Contato[] contatos;
	private Contato[] favoritos;

	/**
	 * Cria uma agenda.
	 */
	public Agenda() {
		this.contatos = new Contato[TAMANHO_AGENDA];
		this.favoritos = new Contato[TAMANHO_FAVORITOS];
	}
	
	/**
	 * Acessa a lista de contatos mantida.
	 * @return O array de contatos.
	 */
	public String[] getContatos() {
		String[] arrayContatos = new String[TAMANHO_AGENDA];
		for (int i = 0; i < TAMANHO_AGENDA; i++) {
			if(contatos[i] != null) { 
				arrayContatos[i] = contatos[i].getNomeCompleto();
			}
		}
		
		return arrayContatos;
	}
	
	public String[] getFavoritos() {
		String[] arrayFavoritos = new String[TAMANHO_FAVORITOS];
		for (int i = 0; i < TAMANHO_FAVORITOS; i++) {
			if(favoritos[i] != null) {
				arrayFavoritos[i] = favoritos[i].getNomeCompleto();
			}
		}
		
		return arrayFavoritos;
	}

	/**
	 * Acessa os dados de um contato específico.
	 * @param posicao Posição do contato na agenda.
	 * @return Dados do contato. Null se não há contato na posição.
	 */
	public String getContato(int posicao) {
		String contato = contatos[posicao].getNomeCompleto();
		boolean ehFavorito = Arrays.asList(getFavoritos()).contains(contato);
		if (ehFavorito) {
			contato = "❤️ " + contato;
		}
		return contato;
	}
	
	public String getTagContato(int posicao) {
		String tag = contatos[posicao].getTags();
		
		return tag;
	}
	/**
	 * Cadastra um contato em uma posição. Um cadastro em uma posição que já existe sobrescreve o anterior. 
	 * @param posicao Posição do contato.
	 * @param nome Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @param telefone Telefone do contato.
	 */
	public void cadastraContato(int posicao, String nome, String sobrenome, String telefone) {
			this.contatos[posicao] = new Contato(nome, sobrenome, telefone);
	}
	
	public boolean contatoJaExiste(String nome, String sobrenome) {
		String contato = nome + " " + sobrenome;
		boolean contatoJaExiste = Arrays.asList(getContatos()).contains(contato);
		
		return contatoJaExiste;
	}
	
	public void adicionaFavorito(int contato, int posicao) {
		favoritos[posicao] = contatos[contato];
		
	}
	public void adicionaTag(int[] contatos, String tag) {
		for (int contato : contatos) {
			this.contatos[contato].adicionarTag(tag);
		}
	}

}
