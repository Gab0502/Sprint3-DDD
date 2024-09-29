package org.example.br.mediverso.models;

public class Entrega {
    private int id;
    private int tarefaId;
    private int placarId;

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getTarefaId() { return tarefaId; }
    public void setTarefaId(int tarefaId) { this.tarefaId = tarefaId; }

    public int getPlacarId() { return placarId; }
    public void setPlacarId(int placarId) { this.placarId = placarId; }
}
