package org.example;

import org.example.br.mediverso.DAO.GenerateDb;
import org.example.br.mediverso.models.AuthContext;
import org.example.br.mediverso.pages.AlunoPage;
import org.example.br.mediverso.pages.LoginPage;
import org.example.br.mediverso.pages.ProfessorPage;

public class Main {
    public static void main(String[] args) {
        GenerateDb generateDatabase = new GenerateDb();
        generateDatabase.createDatabase();

        LoginPage loginPage = new LoginPage();
        AuthContext authContext = loginPage.showLoginScreen();

        ProfessorPage professorPage = new ProfessorPage();
        AlunoPage alunoPage = new AlunoPage(authContext);

        if (authContext != null) {
            System.out.println("Usuário logado: " + authContext.getNome());

            if (authContext.isProfessor()) {
                professorPage.showProfessorScreen();
            } else {
                alunoPage.showAlunoScreen();
            }
        } else {
            System.out.println("Falha no login. Encerrando o programa.");
        }
    }
}
