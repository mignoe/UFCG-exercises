package agenda;

/**
 * Classe que representa cada contato
 * 
 * @author Miguel de Oliveira Rodrigues
 *
 */
public class Contato {
	/**
	 * Representa o nome do contato.
	 */
	private String nome;
	/**
	 * Representa o sobrenome do contato.
	 */
	private String sobrenome;
	private String telefone;
	private String[] tags = new String[5];
	
	/**
	 * Constrói um contato a partir de seu nome, sobrenome e telefone.
	 * Todo contato começa sem tags.
	 * 
	 * @param nome Não deve receber String vazia.
	 * @param sobrenome Opcional.
	 * @param telefone Não deve receber String vazia.
	 */
	public Contato(String nome, String sobrenome, String telefone) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
	}
	
	/**
	 * Retorna apenas o nome e o sobrenome do contato.
	 * 
	 * @return Nome completo.
	 */
	public String getNomeCompleto() {
		return (this.nome + " " + this.sobrenome).trim();
	}
	
	/**
	 * Retorna String do telefone de contato.
	 * 
	 * @return Telefone - sem padrão definido.
	 */
	public String getTelefone() {
		return this.telefone;
	}
	
	/**
	 * Adiciona tag, representada por String.
	 * Cada contato possuí 5 tags.
	 * A posição da tag dita em que ordem ela será impressa em relação as
	 * outras.
	 * 
	 * @param tag 
	 * @param posicao Posicao da tag.
	 */
	public void addTag(String tag, int posicao) {
		this.tags[posicao] = tag;
	}
	
	/**
	 * Retorna,em ordem, as tags do contato. 
	 * 
	 * @return tags, ou vazio
	 */
	private String getTags() {
		String tags = "";
		for (String tag : this.tags) {
			if (tag != null) {
				tags += tag + " ";
			}
		}
		
		return tags.trim();
	}
	
	/**
	 * Cria representação em String no formato:
	 * >nome sobrenome
	 * >telefone
	 * >tags
	 *
	 * Onde o contato pode, ou não, ter tags. Caso não tenha, é impresso
	 * apenas as linhas de nome completo e telefone.
	 * 
	 *   @return String
	 */
	public String toString() {
		String stringContato = 	this.nome + " " + this.sobrenome + "\n" + 
								this.telefone;
		
		if (!this.getTags().equals("")) {
			stringContato += "\n" + this.getTags();
		}
		
		return stringContato;
	}
	/**
	 * Verifica igualdade entre dois contatos.
	 * Dois contatos são e iguais se, e somente se, o nome e sobrenome de
	 * ambos forem iguais.
	 * @param contato Contato a ser igualado.
	 * @return true se iguais, false caso contrário.
	 */
	public boolean equals(Contato contato) {
		return this.nome.equals(contato.nome) && this.sobrenome.equals(contato.sobrenome);
	}
}
