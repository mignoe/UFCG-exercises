package agenda;

public class Contato {
	private String nome;
	private String sobreNome;
	private String telefone;
	private String[] tags = new String[5];
	
	public Contato(String nome, String sobreNome, String telefone) {
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.telefone = telefone;
	}
	
	public String getNomeCompleto() {
		return this.nome + " " + this.sobreNome;
	}
	
	public String getTelefone() {
		return this.telefone;
	}
	
	private String getTags() {
		String tags = "";
		for (String tag : this.tags) {
			if (tag != null) {
				tags += tag + " ";
			}
		}
		
		return tags;
	}
	
	public void adicionarTag(String tag, int posicao) {
		this.tags[posicao] = tag;
	}
	
	public String toString() {
		String stringContato = 	this.nome + " " + this.sobreNome + "\n" + 
								this.telefone;
		
		if (!this.getTags().equals("")) {
			stringContato += "\n" + this.getTags();
		}
		
		return stringContato;
	}
}
