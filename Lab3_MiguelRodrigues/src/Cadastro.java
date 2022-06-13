
public class Cadastro {
	private String nome;
	private String sobreNome;
	private String telefone;
	
	public Cadastro(String nome, String sobreNome, String telefone) {
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.telefone = telefone;
	}
	
	public String getNome() {
		return this.nome;
	}
	public String getSobreNome() {
		return this.sobreNome;
	}
	public String getTelefone() {
		return this.telefone;
	}
}
