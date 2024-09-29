package org.example.br.mediverso.models;

public class Placar {
    private int id;
    private int userId;
    private int pontuacao;
    private String replayPath;
    private int jogoId;

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public int getPontuacao() { return pontuacao; }
    public void setPontuacao(int pontuacao) { this.pontuacao = pontuacao; }

    public String getReplayPath() { return replayPath; }
    public void setReplayPath(String replayPath) { this.replayPath = replayPath; }

    public int getJogoId() { return jogoId; }
    public void setJogoId(int jogoId) { this.jogoId = jogoId; }

}
