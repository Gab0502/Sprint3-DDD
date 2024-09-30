package org.example.br.mediverso.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.example.br.mediverso.controller.stubs.JogoControllerStub;
import org.example.br.mediverso.models.Jogo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class JogoControllerTest {
    private JogoControllerStub jogoController;

    @BeforeEach
    void setUp() {
        jogoController = new JogoControllerStub();
    }

    @Test
    void testGetAllJogos_Empty() {
        List<Jogo> jogos = jogoController.getAllJogos();
        assertTrue(jogos.isEmpty());
    }

    @Test
    void testGetAllJogos_WithData() {
        Jogo jogo1 = new Jogo();
        jogo1.setId(1);
        jogo1.setNome("Jogo 1");

        jogoController.addJogo(jogo1);

        List<Jogo> jogos = jogoController.getAllJogos();
        assertEquals(1, jogos.size());
        assertEquals("Jogo 1", jogos.get(0).getNome());
    }

    @Test
    void testGetJogoById_Success() {
        Jogo jogo1 = new Jogo();
        jogo1.setId(1);
        jogo1.setNome("Jogo 1");

        jogoController.addJogo(jogo1);

        Jogo jogo = jogoController.getJogoById(1);
        assertNotNull(jogo);
        assertEquals("Jogo 1", jogo.getNome());
    }

    @Test
    void testGetJogoById_Failure() {
        Jogo jogo = jogoController.getJogoById(99);
        assertNull(jogo);
    }
}
