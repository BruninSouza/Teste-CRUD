package dao;

import java.util.ArrayList;
import java.util.List;
import model.Produto;
import util.FileManager;

public class ProdutoDAO {
	private static final String ARQUIVO = "produtos.dat";
    private List<Produto> produtos;
    
    public ProdutoDAO() {
        produtos = FileManager.loadFromFile(ARQUIVO);
    }
    
    private int getProximoId() {
        int maiorId = 0;
        for (Produto p : produtos) {
            if (p.getId() > maiorId) {
                maiorId = p.getId();
            }
        }
        return maiorId + 1;
    }
    
    public void adicionarProduto(Produto p) {
        int novoId = getProximoId();
        
        Produto produtoComId = new Produto(p.getNome(), p.getPreco(), p.getQuantidade());
        
        produtoComId.setId(novoId);
        
        produtos.add(produtoComId);
        FileManager.saveToFile(produtos, ARQUIVO);
        System.out.println("Produto adicionado com sucesso! ID: " + novoId);
    }
    
    public List<Produto> listarProdutos() {
        return new ArrayList<>(produtos);
    }
    
    public boolean buscarProdutoPorId(int id) {
        return produtos.stream().anyMatch(p -> p.getId() == id);
    }
    
    public Produto getProdutoPorId(int id) {
        for (Produto p : produtos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
    
    public void atualizarProduto(Produto produtoAtualizado) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getId() == produtoAtualizado.getId()) {
                produtos.set(i, produtoAtualizado);
                FileManager.saveToFile(produtos, ARQUIVO);
                System.out.println("Produto atualizado com sucesso!");
                return;
            }
        }
        System.out.println("Produto não encontrado!");
    }
    
    public void removerProduto(int id) {
        if (produtos.removeIf(p -> p.getId() == id)) {
            FileManager.saveToFile(produtos, ARQUIVO);
            System.out.println("Produto removido com sucesso!");
        } else {
            System.out.println("Produto não encontrado!");
        }
    }
}