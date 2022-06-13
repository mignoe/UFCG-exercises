
public class Agenda{
	private Cadastro[] cadastros = new Cadastro[100];
	
	public void cadastrar(int posicao, String nome, String sobreNome, String telefone) {
		cadastros[posicao - 1] = new Cadastro(nome, sobreNome, telefone);
	}
	
	public Cadastro[] getContatos() {
		return this.cadastros;
	}
}
