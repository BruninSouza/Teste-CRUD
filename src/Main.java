import java.util.List;
import java.util.Scanner;

import dao.ProdutoDAO;
import model.Produto;

public class Main {
	private static ProdutoDAO produtoDAO = new ProdutoDAO();
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int opcao;

		do {
			System.out.println("\n--- SISTEMA DE GERENCIAMENTO DE PRODUTOS ---");
			System.out.println("1. Adicionar Produto");
			System.out.println("2. Listar Produtos");
			System.out.println("3. Buscar Produto por ID");
			System.out.println("4. Atualizar Produto");
			System.out.println("5. Remover Produto");
			System.out.println("0. Sair");
			System.out.print("Escolha uma opção: ");

			opcao = scanner.nextInt();
			scanner.nextLine();

			switch (opcao) {
			case 1:
				adicionarProduto();
				break;
			case 2:
				listarProdutos();
				break;
			case 3:
				buscarProdutoPorId();
				break;
			case 4:
				atualizarProduto();
				break;
			case 5:
				removerProduto();
				break;
			case 0:
				System.out.println("Saindo do sistema...");
				break;
			default:
				System.out.println("Opção inválida!");
			}
		} while (opcao != 0);

		scanner.close();
	}

	private static void adicionarProduto() {
	    System.out.println("\n--- ADICIONAR PRODUTO ---");
	    
	    System.out.print("Nome: ");
	    String nome = scanner.nextLine();
	    
	    System.out.print("Preço: ");
	    double preco = scanner.nextDouble();
	    
	    System.out.print("Quantidade: ");
	    int quantidade = scanner.nextInt();
	    scanner.nextLine();
	    
	    Produto novoProduto = new Produto(nome, preco, quantidade);
	    produtoDAO.adicionarProduto(novoProduto);
	}

	private static void extracted(Produto novoProduto) {
		produtoDAO.adicionarProduto(novoProduto);
	}

	private static void listarProdutos() {
		System.out.println("\n--- LISTA DE PRODUTOS ---");
		List<Produto> produtos = produtoDAO.listarProdutos();

		if (produtos.isEmpty()) {
			System.out.println("Nenhum produto cadastrado!");
		} else {
			for (Produto p : produtos) {
				System.out.println(p);
			}
		}
	}

	private static void buscarProdutoPorId() {
		System.out.println("\n--- BUSCAR PRODUTO POR ID ---");
		System.out.print("Digite o ID: ");
		int id = scanner.nextInt();

		Produto p = produtoDAO.getProdutoPorId(id);
		if (p != null) {
			System.out.println(p);
		} else {
			System.out.println("Produto não encontrado!");
		}
	}

	private static void atualizarProduto() {
		System.out.println("\n--- ATUALIZAR PRODUTO ---");
		System.out.print("Digite o ID do produto a ser atualizado: ");
		int id = scanner.nextInt();
		scanner.nextLine();

		Produto p = produtoDAO.getProdutoPorId(id);
		if (p == null) {
			System.out.println("Produto não encontrado!");
			return;
		}

		System.out.println("Produto encontrado: " + p);
		System.out.println("\nDigite os novos dados:");

		System.out.print("Nome (" + p.getNome() + "): ");
		String nome = scanner.nextLine();
		if (!nome.isEmpty()) {
			p.setNome(nome);
		}

		System.out.print("Preço (" + p.getPreco() + "): ");
		String precoStr = scanner.nextLine();
		if (!precoStr.isEmpty()) {
			p.setPreco(Double.parseDouble(precoStr));
		}

		System.out.print("Quantidade (" + p.getQuantidade() + "): ");
		String quantidadeStr = scanner.nextLine();
		if (!quantidadeStr.isEmpty()) {
			p.setQuantidade(Integer.parseInt(quantidadeStr));
		}

		produtoDAO.atualizarProduto(p);
	}

	private static void removerProduto() {
		System.out.println("\n--- REMOVER PRODUTO ---");
		System.out.print("Digite o ID do produto a ser removido: ");
		int id = scanner.nextInt();

		produtoDAO.removerProduto(id);
	}
}