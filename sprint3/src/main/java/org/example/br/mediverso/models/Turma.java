package org.example.br.mediverso.models;

public class Turma {
    private int id;
    private String nome;
    private boolean ativo;
    private int professorId;

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public boolean isAtivo() { return ativo; }
    public void setAtivo(boolean ativo) { this.ativo = ativo; }

    public int getProfessorId() { return professorId; }
    public void setProfessorId(int professorId) { this.professorId = professorId; }

}
