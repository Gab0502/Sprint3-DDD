package org.example.br.mediverso.controller.stubs;

import org.example.br.mediverso.controllers.TurmaController;
import org.example.br.mediverso.models.Turma;

import java.util.ArrayList;
import java.util.List;

public class TurmaControllerStub extends TurmaController {
    private final List<Turma> turmas = new ArrayList<>();

    public void addTurma(Turma turma) {
        turmas.add(turma);
    }

    @Override
    public void getTurmaById(int turmaId) {
        for (Turma turma : turmas) {
            if (turma.getId() == turmaId) {
                System.out.println("Turma encontrada:");
                System.out.println("ID: " + turma.getId());
                System.out.println("Nome: " + turma.getNome());
                return;
            }
        }
        System.out.println("Turma não encontrada com o ID: " + turmaId);
    }

    @Override
    public Turma getTurmaByProfessorId(int professorId) {
        for (Turma turma : turmas) {
            if (turma.getProfessorId() == professorId) {
                System.out.println("Turma encontrada:");
                System.out.println("ID: " + turma.getId());
                System.out.println("Nome: " + turma.getNome());
                return turma;
            }
        }
        System.out.println("Turma não encontrada com o ID: " + professorId);
        return null;
    }
}