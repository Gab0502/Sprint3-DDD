package org.example.br.mediverso.models;

public class Tarefa {
    private int id;
    private String nome;
    private int jogoId;
    private int turmaId;

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getJogoId() { return jogoId; }
    public void setJogoId(int jogoId) { this.jogoId = jogoId; }

    public int getTurmaId() { return turmaId; }
    public void setTurmaId(int turmaId) { this.turmaId = turmaId; }
}
