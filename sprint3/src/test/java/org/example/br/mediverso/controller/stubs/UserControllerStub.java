package org.example.br.mediverso.controllers;

import org.example.br.mediverso.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserControllerStub extends UserController {

    private final List<User> users;

    public UserControllerStub() {
        this.users = new ArrayList<>();
        this.users.add(createUserStub(1, "João Silva", "joao@example.com", "senha123"));
        this.users.add(createUserStub(2, "Maria Oliveira", "maria@example.com", "senha456"));
    }

    @Override
    public void createUser(String nome, String email, String senha) {
        User user = new User();
        user.setNome(nome);
        user.setEmail(email);
        user.setSenha(senha);
        user.setId(users.size() + 1); // Simulando incremento de ID
        users.add(user);
        System.out.println("Usuário criado com sucesso.");
    }

    @Override
    public List<User> getAllUsers() {
        for (User user : users) {
            System.out.println("ID: " + user.getId());
            System.out.println("Nome: " + user.getNome());
            System.out.println("Email: " + user.getEmail());
            System.out.println("-----------------------------");
        }
        return users;
    }

    @Override
    public User getUserById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        System.out.println("Usuário não encontrado.");
        return null;
    }

    private User createUserStub(int id, String nome, String email, String senha) {
        User user = new User();
        user.setId(id);
        user.setNome(nome);
        user.setEmail(email);
        user.setSenha(senha);
        return user;
    }
}