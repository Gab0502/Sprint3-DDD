package org.example.br.mediverso.controller.stubs;

import org.example.br.mediverso.controllers.EntregaController;
import org.example.br.mediverso.models.Entrega;

import java.util.ArrayList;
import java.util.List;

public class EntregaControllerStub extends EntregaController {
    private final List<Entrega> entregas = new ArrayList<>();

    @Override
    public void createEntrega(int tarefaId, int placarId) {
        Entrega entrega = new Entrega();
        entrega.setId(entregas.size() + 1);
        entrega.setTarefaId(tarefaId);
        entrega.setPlacarId(placarId);
        entregas.add(entrega);
    }

    @Override
    public Entrega getEntregaById(int id) {
        for (Entrega entrega : entregas) {
            if (entrega.getId() == id) {
                return entrega;
            }
        }
        return null;
    }

    @Override
    public List<Entrega> listAllEntregas() {
        return entregas;
    }
}