package org.example.br.mediverso.controllers;

import org.example.br.mediverso.services.TurmaUserService.GetUsersByTurmaId;

import java.util.List;

public class TurmaUserController {

    private final GetUsersByTurmaId getUsersByTurmaIdService;

    public TurmaUserController() {
        this.getUsersByTurmaIdService = new GetUsersByTurmaId();
    }

    public void getUsersByTurmaId(int turmaId) {
        List<Integer> userIds = getUsersByTurmaIdService.getUsersByTurmaId(turmaId);

        if (!userIds.isEmpty()) {
            System.out.println("Usuários encontrados na turma com ID " + turmaId + ":");
            for (Integer userId : userIds) {
                System.out.println("User ID: " + userId);
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
