package menu;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Menu_principal {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int option, codigo_produto;

		while (true) {

			System.out.println("             Bem vindo a Maven Eletrônicos           ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Cadastrar Produto                    ");
			System.out.println("            2 - Listar Os produtos cadastrados       ");
			System.out.println("            3 - Atualizar um produto cadastrado      ");
			System.out.println("            4 - Deletar um produto cadastrado        ");
			System.out.println("            5 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("Digite a opção desejada:                             ");

			try {
				option = input.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!");
				input.nextLine();
				option = 0;
			}

			if (option == 5) {
				System.out.println("\nMaven Agradece a preferência!");
				input.close();
				System.exit(0);
			}

			switch (option) {
			case 1:
				System.out.println("\n Cadastrar Produto");
				System.out.println("Digite o código do produto: ");
				codigo_produto = input.nextInt();
				break;

			case 2:
				System.out.println("\n Listar todos os produtos");

				break;
			case 3:
				System.out.println("\n Atualizar um produto cadastrado");
				System.out.println("Digite o código do produto: ");
				codigo_produto = input.nextInt();
				break;
			case 4:
				System.out.println("\n Deletar um produto cadastrado");
				System.out.println("Digite o código do produto: ");
				codigo_produto = input.nextInt();
				break;
			default:
				System.out.println("\nOpção Inválida");
				break;
			}

		}
	}
}
