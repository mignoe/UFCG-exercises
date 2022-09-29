package produto;

public class RepositorioProduto implements RepositorioProdutoInterface {

	/**
	 * A estrutura (array) onde os produtos sao mantidos.
	 */
	private Produto[] produtos;

	/**
	 * A posicao do ultimo elemento inserido no array de produtos. o valor
	 * inicial é -1 para indicar que nenhum produto foi ainda guardado no array.
	 */
	private int index = -1;

	public RepositorioProduto(int size) {
		super();
		this.produtos = new Produto[size];
	}

	/**
	 * Recebe o codigo do produto e devolve o indice desse produto no array ou
	 * -1 caso ele nao se encontre no array. Esse método é util apenas na
	 * implementacao com arrays por questoes de localizacao. Outras classes que
	 * utilizam outras estruturas internas podem nao precisar desse método.
	 * 
	 * @param codigo
	 * @return
	 */
	private int procurarIndice(int codigo) {
		// TODO Implement your code here
		for (int i = 0; i < this.produtos.length; i++){
			if (this.produtos[i].getCodigo() == codigo) {
				return i;
			}
		}

		return -1;
	}

	/**
	 * Recebe o codigo e diz se tem produto com esse codigo armazenado
	 * 
	 * @param codigo
	 * @return
	 */
	public boolean existe(int codigo) {
		return this.procurarIndice(codigo) != -1; 
	}

	/**
	 * Insere um novo produto (sem se preocupar com duplicatas)
	 */
	public void inserir(Produto produto) {
		Produto[] produtosNovo = new Produto[this.produtos.length + 1];
		for (int i = 0; i < this.produtos.length; i++){
			produtosNovo[i] = this.produtos[i];
		}

		produtosNovo[this.produtos.length + 1] = produto;

		this.produtos = produtosNovo;
	}

	/**
	 * Atualiza um produto armazenado ou retorna um erro caso o produto nao
	 * esteja no array. Note que, para localizacao, o código do produto será
	 * utilizado.
	 */
	public void atualizar(Produto produto) {
		// TODO Implement your code here
		this.produtos[this.procurarIndice(produto.getCodigo())] = produto;
	}

	/**
	 * Remove produto com determinado codigo, se existir, ou entao retorna um
	 * erro, caso contrário. Note que a remoção NÃO pode deixar "buracos" no
	 * array.
	 * 
	 * @param codigo
	 */
	public void remover(int codigo) {
		// TODO Implement your code here
		int indiceRemovido = procurarIndice(codigo);
		for (int i = indiceRemovido; i < this.produtos.length - 1; i++) {
			this.produtos[i] = this.produtos[i + 1];
		}

		Produto[] produtosNovo = new Produto[this.produtos.length - 1];
		for (int i = 0; i < produtosNovo.length; i++){
			produtosNovo[i] = this.produtos[i];
		}

		this.produtos = produtosNovo;
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	/**
	 * Retorna um produto com determinado codigo ou entao um erro, caso o
	 * produto nao esteja armazenado
	 * 
	 * @param codigo
	 * @return
	 */
	public Produto procurar(int codigo) {
		return this.produtos[this.procurarIndice(codigo)];
	}
}