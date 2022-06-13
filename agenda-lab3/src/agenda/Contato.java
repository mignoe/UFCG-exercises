package agenda;

public class Contato {
	private String nome;
	private String sobreNome;
	private String telefone;
	private String tags;
	
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
	
	public String getTags() {
		return this.tags;
	}
	
	public void adicionarTag(String tag) {
		if (tags == null) {
			tags = "\n" + tag;
		} else {
			this.tags += " " + tag;
		}
	}
	
	public String toString() {
		String stringContato = this.nome + " " + this.sobreNome + "\n" + this.telefone + this.tags;
		
		return stringContato;
	}
}
