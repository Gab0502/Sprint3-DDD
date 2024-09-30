package org.example.br.mediverso.controllers;

import org.example.br.mediverso.models.User;
import org.example.br.mediverso.services.UserServices.CreateUserService;
import org.example.br.mediverso.services.UserServices.GetUserById;
import org.example.br.mediverso.services.UserServices.GetUsers;

import java.util.List;

public class UserController {

    private final CreateUserService createUserService;
    private final GetUsers getUsersService;
    private final GetUserById getUserByIdService;

    public UserController() {
        this.createUserService = new CreateUserService();
        this.getUsersService = new GetUsers();
        this.getUserByIdService = new GetUserById();
    }

    public void createUser(String nome, String email, String senha) {
        User user = new User();
        user.setNome(nome);
        user.setEmail(email);
        user.setSenha(senha);

        createUserService.createUser(user);
        System.out.println("Usuário criado com sucesso.");
    }

    public List<User> getAllUsers() {
        List<User> users = getUsersService.getAllUsers();

        for (User user : users) {
            System.out.println("ID: " + user.getId());
            System.out.println("Nome: " + user.getNome());
            System.out.println("Email: " + user.getEmail());
            System.out.println("-----------------------------");
        }
        return users;
    }

    public User getUserById(int id) {
        User user = getUserByIdService.getUserById(id);

        if (user == null) {
            System.out.println("Usuário não encontrado.");
        }
        return user;
    }

    public static void main(String[] args) {
        UserController controller = new UserController();

        controller.createUser("João Silva", "joao@example.com", "senha123");

        controller.getAllUsers();

        controller.getUserById(1);
    }
}
