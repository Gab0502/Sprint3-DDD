package org.example.br.mediverso.pages;

import org.example.br.mediverso.controllers.AuthContextController;
import org.example.br.mediverso.models.AuthContext;

import java.util.Scanner;

public class LoginPage {

    private final AuthContextController authController;

    public LoginPage() {
        this.authController = new AuthContextController();
    }

    public AuthContext showLoginScreen() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("----- Tela de Login -----");
        System.out.print("Digite seu e-mail: ");
        String email = scanner.nextLine();

        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();

        AuthContext authContext = authController.login(email, senha);


        return authContext;
    }
}
