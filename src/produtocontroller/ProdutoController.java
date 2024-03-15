package produtocontroller;

import java.util.ArrayList;
import model.Produto;
import repository.ProdutoRepository;

public class ProdutoController implements ProdutoRepository {

	public ArrayList<Produto> listaDeProdutos = new ArrayList<Produto>();

	@Override
	public void cadastrarProduto(Produto produto) {
		listaDeProdutos.add(produto);
		System.out.println("\n O produto " + produto.getNome() + " foi cadastrado com sucesso!");

	}

	@Override
	public void listarProdutos() {
		for (var produto : listaDeProdutos) {
			produto.visualizar();
		}

	}

	@Override
	public void atualizarProdutos(Produto produto) {
		var buscarProduto = buscarNaLista(produto.getNome());

		if (buscarProduto != null) {
			listaDeProdutos.set(listaDeProdutos.indexOf(buscarProduto), produto);
			System.out.println("\nO produto com o nome: " + produto.getNome() + " foi atualizado!");
		} else {
			System.out.println("\nO produto com o nome: " + produto.getNome() + " não foi encontrado!");
		}

	}

	@Override
	public void deletarProdutos(String nome) {
		var produto = buscarNaLista(nome);
		if (produto != null) {
			if (listaDeProdutos.remove(produto) == true) {
				System.out.println("O produto : " + nome + " foi deletado com sucesso!");
			} else {
				System.out.println("O produto : " + nome + " não foi encontrado! Tente novamente");
			}
		}

	}

	public Produto buscarNaLista(String nome) {
		for (var produto : listaDeProdutos) {
			if (produto.getNome().equals(nome))
				return produto;
		}

		return null;
	}

}
