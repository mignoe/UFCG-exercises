package agenda;

import java.util.Arrays;

/**
 * Uma agenda que mantém uma lista de contatos com posições. Podem existir 100 contatos. 
 * 
 * @author nazareno e Miguel de Oliveira Rodrigues
 *
 */
public class Agenda {
	
	private static final int TAMANHO_AGENDA = 100;
	private static final int TAMANHO_FAVORITOS = 10;
	
	/**
	 * Representa os contatos cadastrados.
	 * tipo Array de Contato.
	 */
	private Contato[] contatos;

	/**
	 * Representa os contatos favoritados.
	 * tipo Array de Contato.
	 */
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
	
	/**
	 * Lista todos os contatos favoritados.
	 * 
	 * @return Array com os favoritos.
	 */
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
		if (ehFavorito(posicao)) {
			return "❤️ " + this.contatos[posicao];
		}else {
			return this.contatos[posicao].toString();
		}
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
	
	/**
	 * Verifica se o contato com nome e sobrenome inseridos já existe.
	 * 
	 * @param nome
	 * @param sobrenome
	 * @return true se já existe, false caso contrário.
	 */
	public boolean contatoJaCadastrado(String nome, String sobrenome) {
		String contato = nome + " " + sobrenome;
		boolean contatoJaCadastrado = Arrays.asList(getContatos()).contains(contato);
		
		return contatoJaCadastrado;
	}
	
	/**
	 * Adiciona contato à lista de favoritos.
	 * 
	 * @param contato Posição do contato.
	 * @param posicao A qual o contato será inserido nos favoritos.
	 */
	public void adicionaFavorito(int contato, int posicao) {
		favoritos[posicao] = contatos[contato];
	}
	
	/**
	 * Verifica se o contato é um contato favoritado.
	 * 
	 * @param contato Posição do contato no array de contatos.
	 * @return true se é um favorito, false caso contrário.
	 */
	public boolean ehFavorito(int contato) {
		return Arrays.asList(favoritos).contains(contatos[contato]);
	}
	
	/**
	 * Adiciona tag(String) ao(s) contato(s).
	 * 
	 * @param contatos Array com as posições dos contatos.
	 * @param tag Tag a ser adicionada em contatos.
	 * @param posicaoTag Qual a posição a tag deve ocupar nos contatos.
	 */
	public void adicionaTag(int[] contatos, String tag, int posicaoTag) {
		for (int contato : contatos) {
			this.contatos[contato].addTag(tag, posicaoTag);
		}
	}
	
	/**
	 * Remove contato da array de contatos.
	 * 
	 * @param contatos Posição dos contatos na array de contatos.
	 */
	public void removeContatos(int[] contatos) {
		for (int contato : contatos) {
			// Removendo contato dos favoritos;
			if (ehFavorito(contato)) {
				int index = Arrays.asList(this.favoritos).indexOf(this.contatos[contato]);
				this.favoritos[index] = null;
			}
			
			this.contatos[contato] = null;			
		}
	}
}
