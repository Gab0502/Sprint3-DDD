package org.example.br.mediverso.controller;

import org.example.br.mediverso.controller.stubs.EntregaControllerStub;
import org.example.br.mediverso.controllers.EntregaController;
import org.example.br.mediverso.models.Entrega;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EntregaControllerTest {
    private EntregaController entregaController;

    @BeforeEach
    void setUp() {
        // Inicializa o controlador com o stub
        entregaController = new EntregaControllerStub();
    }

    @Test
    void testCreateEntrega() {
        entregaController.createEntrega(1, 101); // Testa a criação de uma entrega
        // Verifica que a entrega foi criada
        assertEquals(1, entregaController.listAllEntregas().size());
    }

    @Test
    void testGetEntregaById_Success() {
        entregaController.createEntrega(1, 101); // Cria uma entrega para testar
        Entrega entrega = entregaController.getEntregaById(1);
        assertNotNull(entrega); // Espera que a entrega seja encontrada
        assertEquals(1, entrega.getId()); // Verifica o ID da entrega
        assertEquals(1, entrega.getTarefaId());
        assertEquals(101, entrega.getPlacarId());
    }

    @Test
    void testGetEntregaById_Failure() {
        Entrega entrega = entregaController.getEntregaById(2);
        assertNull(entrega);
    }

    @Test
    void testListAllEntregas() {
        entregaController.createEntrega(1, 101);
        List<Entrega> entregas = entregaController.listAllEntregas();
        assertFalse(entregas.isEmpty());
        assertEquals(1, entregas.size());
    }
}