package model;

public abstract class Produto {

	private String nome;
	private String descricao;
	private float preco;
	private int tipo, codigo_produto;

	public Produto(String nome, String descricao, float preco, int tipo, int codigo_produto) {

		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.tipo = tipo;
		this.codigo_produto = codigo_produto;
	}

	public int getCodigo_produto() {
		return codigo_produto;
	}

	public void setCodigo_produto(int codigo_produto) {
		this.codigo_produto = codigo_produto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public void visualizar() {
		String tipo = "";

		switch (this.tipo) {
		case 1:
			tipo = "Produto físico";
			break;
		case 2:
			tipo = "Produto Digital (Key)";
			break;
		}

		System.out.println("_____________________________________________________");
		System.out.println("          X  INFORMAÇÕES DO PRODUTO X                ");
		System.out.println("Nome do produto: " + this.nome);
		System.out.println("Preço do produto: R$" + this.preco);
		System.out.println("Descrição do produto: " + this.descricao);
		System.out.println("Tipo do produto: " + this.tipo);
		System.out.println("Codigo do produto: " + this.codigo_produto);
	}

}