package org.example.br.mediverso.controller;

import org.example.br.mediverso.controller.stubs.TurmaControllerStub;
import org.example.br.mediverso.models.Turma;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TurmaControllerTest {
    private TurmaControllerStub turmaController;

    @BeforeEach
    void setUp() {
        turmaController = new TurmaControllerStub();
    }

    @Test
    void testGetTurmaById_Success() {
        Turma turma = new Turma();
        turma.setId(1);
        turma.setNome("Turma A");
        turmaController.addTurma(turma);

        turmaController.getTurmaById(1);
    }

    @Test
    void testGetTurmaById_Failure() {
        turmaController.getTurmaById(99);
    }

    @Test
    void testGetTurmaByProfessorId_Success() {
        Turma turma = new Turma();
        turma.setId(1);
        turma.setNome("Turma A");
        turma.setProfessorId(1);
        turmaController.addTurma(turma);

        turmaController.getTurmaByProfessorId(1);
    }

    @Test
    void testGetTurmaByProfessorId_Failure() {
        turmaController.getTurmaByProfessorId(99);
    }
}