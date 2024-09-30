package org.example.br.mediverso.controllers;

import org.example.br.mediverso.models.User;
import org.example.br.mediverso.services.TurmaUserService.GetUsersByTurmaId;

import java.util.List;

public class TurmaUserController {

    private final GetUsersByTurmaId getUsersByTurmaIdService;
    private final UserController userController;

    public TurmaUserController() {
        this.getUsersByTurmaIdService = new GetUsersByTurmaId();
        this.userController = new UserController(); // Supondo que este serviço exista para buscar usuários
    }

    public void getUsersByTurmaId(int turmaId) {
        List<Integer> userIds = getUsersByTurmaIdService.getUsersByTurmaId(turmaId);

        if (!userIds.isEmpty()) {
            System.out.println("Usuários encontrados na turma com ID " + turmaId + ":");
            for (Integer userId : userIds) {
                // Busca os detalhes do usuário pelo ID
                User user = userController.getUserById(userId);
                if (user != null) {
                    System.out.println("User ID: " + user.getId());
                    System.out.println("Nome: " + user.getNome());
                    System.out.println("Email: " + user.getEmail());
                    System.out.println("----------------------------");
                } else {
                    System.out.println("Nenhum detalhe encontrado para o usuário com ID: " + userId);
                }
            }
        } else {
            System.out.println("Nenhum usuário encontrado para a turma com ID: " + turmaId);
        }
    }
    public static void main(String[] args) {
        TurmaUserController controller = new TurmaUserController();
        controller.getUsersByTurmaId(1);
    }
}
