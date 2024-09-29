package org.example;

import org.example.br.mediverso.DAO.GenerateDb;

public class Main {
    public static void main(String[] args) {
        GenerateDb generateDatabase = new GenerateDb();
        generateDatabase.createDatabase();
    }
}
