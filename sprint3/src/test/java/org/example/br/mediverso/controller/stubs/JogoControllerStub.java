package org.example.br.mediverso.controller.stubs;

import static org.junit.jupiter.api.Assertions.*;

import org.example.br.mediverso.controllers.JogoController;
import org.example.br.mediverso.models.Jogo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class JogoControllerStub extends JogoController {
    private final List<Jogo> jogos = new ArrayList<>();

    public void addJogo(Jogo jogo) {
        jogos.add(jogo);
    }

    @Override
    public List<Jogo> getAllJogos() {
        return jogos;
    }

    @Override
    public Jogo getJogoById(int id) {
        for (Jogo jogo : jogos) {
            if (jogo.getId() == id) {
                return jogo;
            }
        }
        return null;
    }
}