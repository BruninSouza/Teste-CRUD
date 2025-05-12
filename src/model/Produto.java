package model;

import java.io.Serializable;

public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int id;
    private String nome;
    private double preco;
    private int quantidade;
    
    public Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }
    
    private Produto(int id, String nome, double preco, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }
    
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public double getPreco() {
        return preco;
    }
    
    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    public int getQuantidade() {
        return quantidade;
    }
    
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    @Override
    public String toString() {
        return "ID: " + id + 
               " | Nome: " + nome + 
               " | Preço: R$" + String.format("%.2f", preco) + 
               " | Quantidade: " + quantidade;
    }
}