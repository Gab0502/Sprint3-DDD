package org.example.br.mediverso.models;

public class Jogo {
    private int id;
    private String nome;
    private int pontuacaoMax;

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getPontuacaoMax() { return pontuacaoMax; }
    public void setPontuacaoMax(int pontuacaoMax) { this.pontuacaoMax = pontuacaoMax; }
}
