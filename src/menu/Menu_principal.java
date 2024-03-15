package menu;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import model.ProdutoKeyDigital;
import produtocontroller.ProdutoController;
import model.ProdutoFisico;

public class Menu_principal {

	public static void main(String[] args) {

		ProdutoController produtos = new ProdutoController();
		Scanner input = new Scanner(System.in);
		int option, codigo_produto, numeroKey,tipo;
		float preco;
		String nome, descricao;

		while (true) {

			System.out.println("             Bem vindo a Maven Digitalstore          ");
			System.out.println("_____________________________________________________");
			System.out.println("                                                     ");
			System.out.println("            1 - Cadastrar Produto                    ");
			System.out.println("            2 - Listar Os produtos cadastrados       ");
			System.out.println("            3 - Atualizar um produto cadastrado      ");
			System.out.println("            4 - Deletar um produto cadastrado        ");
			System.out.println("            5 - Sair                                 ");
			System.out.println("__________________________________________________   ");
			System.out.println("               Digite a opção desejada:             ");

			try {
				option = input.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!");
				input.nextLine();
				option = 0;
			}

			if (option == 5) {
				System.out.println("\nA Maven Agradece a preferência!");
				input.close();
				sobre();
				System.exit(0);
			}

			switch (option) {
			case 1:
				System.out.println("Cadastrar um produto\n\n");
				System.out.print("Digite o nome do produto \n");
				nome = input.next();
				 input.nextLine();
				do {
					System.out.println("Digite o tipo do produto: \n 1 - Produto  \n 2 - Produto digital");
					tipo = input.nextInt();
					input.nextLine();
				} while (tipo < 1 && tipo > 2);

				System.out.print("Digite o preço do produto\n ");
				preco = input.nextFloat();
				input.nextLine();
				System.out.print("Digite a descricao do produto\n ");
				descricao = input.next();
				input.nextLine();
				
				
				switch (tipo) {

				case 1 -> {
					System.out.println("Digite o codigo do produto");
					codigo_produto = input.nextInt();
					input.nextLine();
					produtos.cadastrarProduto(new ProdutoFisico(nome, descricao, preco, tipo, codigo_produto));
				}
				case 2 -> {
					System.out.print("Digite o numero da key");
					numeroKey = input.nextInt();
					input.nextLine();
					System.out.println("Digite o codigo do produto");
					codigo_produto = input.nextInt();
					input.nextLine();
					produtos.cadastrarProduto(new ProdutoKeyDigital(nome, descricao, preco, tipo, codigo_produto, numeroKey));
				}

				}

				keyPress();
				break;

			case 2:
				System.out.println("\n Listar todos os produtos");
				produtos.listarProdutos();
				keyPress();
				break;                           
			
			
			case 3:
				System.out.print("Digite o nome do produto para atualizar");
				nome = input.next();
				var buscarProduto = produtos.buscarNaLista(nome);
				if (buscarProduto != null) {
					tipo = buscarProduto.getTipo();
					System.out.print("\nDigite a nova descricao do produto");
					descricao = input.next();
					input.nextLine();
					System.out.print("\nDigite o novo preço do produto");
					preco = input.nextFloat();
					
					switch(tipo) {
						case 1 -> {
							System.out.println("Digite o codigo do produto");
							codigo_produto = input.nextInt();
							produtos.atualizarProdutos(new ProdutoFisico(nome, descricao, preco, tipo, codigo_produto));
						}
						case 2 -> {
							System.out.print("Digite o numero da key");
							numeroKey = input.nextInt();
							System.out.println("Digite o codigo do produto");
							codigo_produto = input.nextInt();
							produtos.atualizarProdutos(new ProdutoKeyDigital(nome, descricao, preco, tipo, codigo_produto, numeroKey));
						}
						default -> {
							System.out.println("Tipo de produto inválido!");
						}
				    }
				
				} else {
					System.out.println("O produto não foi encontrado!");
				}
				
				keyPress();
			 	break;
			case 4:
				System.out.println("\n Deletar um produto cadastrado");
				System.out.println("Digite o nome do produto: ");
				nome = input.next();
				produtos.deletarProdutos(nome);
				
				keyPress();
				break;
				
			default:
				System.out.println("\nOpção Inválida");
				break;
			}

		}
	}

	public static void keyPress() {
		try {
			System.out.println("\n\nPressione Enter para continuar");
			System.in.read();
		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla diferente!\n Pressione Enter!");
		}
	}

	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: José Augusto");
		System.out.println("Generation Brasil - generation@generation.org");
		System.out.println("github.com/gutottx");
		System.out.println("*********************************************************");
	}
}
