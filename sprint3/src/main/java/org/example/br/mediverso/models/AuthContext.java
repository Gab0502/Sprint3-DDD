package org.example.br.mediverso.models;

public class AuthContext {
    private String nome;
    private String email;
    private String senha;
    private boolean professor;

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public boolean isProfessor() { return professor; }
    public void setProfessor(boolean professor) { this.professor = professor; }
}
