package org.example.br.mediverso.controllers;

import org.example.br.mediverso.models.Turma;
import org.example.br.mediverso.services.TurmaService.GetTurmaById;

public class TurmaController {

    private final GetTurmaById getTurmaByIdService;

    public TurmaController() {
        this.getTurmaByIdService = new GetTurmaById();
    }

    // Método para chamar o serviço e exibir os dados da turma
    public void getTurmaById(int turmaId) {
        Turma turma = getTurmaByIdService.getTurmaById(turmaId);

        if (turma != null) {
            System.out.println("Turma encontrada:");
            System.out.println("ID: " + turma.getId());
            System.out.println("Nome: " + turma.getNome());
            // Adicione outras informações conforme necessário
        } else {
            System.out.println("Turma não encontrada com o ID: " + turmaId);
        }
    }

    public static void main(String[] args) {
        TurmaController controller = new TurmaController();
        controller.getTurmaById(1);
    }
}
