package repository;
import model.Produto;

public interface ProdutoRepository {
	
	//Demonstração do CRUD//
	
	public void cadastrarProduto(Produto produto);
	public void listarProdutos();
	public void atualizarProdutos(Produto produto);
	public void deletarProdutos(String nome);
	
}
