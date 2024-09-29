package org.example.br.mediverso.controllers;

import org.example.br.mediverso.models.AuthContext;
import org.example.br.mediverso.services.AuthContextService.LoginService;

public class AuthContextController {
    private final LoginService LoginService;

    // Construtor para inicializar o AuthService
    public AuthContextController() {
        this.LoginService = new LoginService();
    }

    // Método para realizar o login
    public AuthContext login(String email, String senha) {
        AuthContext authContext = LoginService.login(email, senha);

        // Verifica se a autenticação foi bem-sucedida
        if (authContext != null) {
            System.out.println("Login realizado com sucesso.");
            System.out.println("Nome: " + authContext.getNome());
            System.out.println("Email: " + authContext.getEmail());
            System.out.println("Professor: " + (authContext.isProfessor() ? "Sim" : "Não"));
        } else {
            System.out.println("Falha no login: e-mail ou senha incorretos.");
        }

        return authContext;
    }

    // Método main para testar o login
    public static void main(String[] args) {
        AuthContextController authController = new AuthContextController();

        // Testando o login com credenciais de exemplo
        String email = "professor@example.com";
        String senha = "password123";

        // Chamando o método login
        authController.login(email, senha);
    }
}
