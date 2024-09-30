package org.example.br.mediverso.controller.stubs;

import org.example.br.mediverso.controllers.PlacarController;
import org.example.br.mediverso.models.Placar;

import java.util.ArrayList;
import java.util.List;

public class PlacarControllerStub extends PlacarController {
    private final List<Placar> placares = new ArrayList<>();

    public void addPlacar(Placar placar) {
        placares.add(placar);
    }

    @Override
    public List<Placar> getAllPlacares() {
        return placares;
    }

    @Override
    public Placar getPlacarById(int id) {
        for (Placar placar : placares) {
            if (placar.getId() == id) {
                return placar;
            }
        }
        return null;
    }

    @Override
    public List<Placar> getPlacarByUserId(int userId) {
        List<Placar> result = new ArrayList<>();
        for (Placar placar : placares) {
            if (placar.getUserId() == userId) {
                result.add(placar);
            }
        }
        return result;
    }
}
