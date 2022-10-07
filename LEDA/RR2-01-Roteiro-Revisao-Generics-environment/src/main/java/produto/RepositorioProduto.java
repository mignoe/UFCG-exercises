package produto;

public interface RepositorioProduto<T extends Produto> {
    public boolean existe(int codigo);

    public void inserir(T produto);

    public void atualizar(T produto);

    public void remover(int codigo);

    public Produto procurar(int codigo);
}
