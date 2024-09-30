package org.example.br.mediverso.controllers;

import org.example.br.mediverso.models.Turma;
import org.example.br.mediverso.services.TurmaService.GetTurmaById;
import org.example.br.mediverso.services.TurmaService.GetTurmaByProfessorId;

public class TurmaController {

    private final GetTurmaById getTurmaByIdService;
    private final GetTurmaByProfessorId getTurmaByProfessorid;


    public TurmaController() {
        this.getTurmaByIdService = new GetTurmaById();
        this.getTurmaByProfessorid = new GetTurmaByProfessorId();

    }

    public void getTurmaById(int turmaId) {
        Turma turma = getTurmaByIdService.getTurmaById(turmaId);

        if (turma != null) {
            System.out.println("Turma encontrada:");
            System.out.println("ID: " + turma.getId());
            System.out.println("Nome: " + turma.getNome());
        } else {
            System.out.println("Turma não encontrada com o ID: " + turmaId);
        }
    }

    public Turma getTurmaByProfessorId(int professorId) {
        Turma turma = getTurmaByProfessorid.getTurmaByProfessorId(professorId);

        if (turma != null) {
            System.out.println("Turma encontrada:");
            System.out.println("ID: " + turma.getId());
            System.out.println("Nome: " + turma.getNome());
            return turma;

        } else {
            System.out.println("Turma não encontrada com o ID: " + professorId);
            return null;
        }
    }

    public static void main(String[] args) {
        TurmaController controller = new TurmaController();
        controller.getTurmaById(1);
        controller.getTurmaByProfessorId(1);
    }
}
