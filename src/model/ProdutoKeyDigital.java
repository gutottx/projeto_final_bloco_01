package model;

public class ProdutoKeyDigital extends Produto {

	int numeroKey;

	public ProdutoKeyDigital(String nome, String descricao, float preco, int tipo, int codigo_produto, int numeroKey) {
		super(nome, descricao, preco, tipo,codigo_produto);
		this.numeroKey = numeroKey;
	}

	public int getNumeroKey() {
		return numeroKey;
	}

	public void setNumeroKey(int numeroKey) {
		this.numeroKey = numeroKey;
	}

	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Key digital do produto: " + this.numeroKey);
		System.out.println("*************************************************");

	}
}
