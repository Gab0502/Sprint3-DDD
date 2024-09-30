package org.example.br.mediverso.controller;

import org.example.br.mediverso.controller.stubs.PlacarControllerStub;
import org.example.br.mediverso.models.Placar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PlacarControllerTest {
    private PlacarControllerStub placarController;

    @BeforeEach
    void setUp() {
        placarController = new PlacarControllerStub();
    }

    @Test
    void testGetAllPlacares_Empty() {
        List<Placar> placares = placarController.getAllPlacares();
        assertTrue(((List<?>) placares).isEmpty());
    }

    @Test
    void testGetAllPlacares_WithData() {
        Placar placar1 = new Placar();
        placar1.setId(1);
        placar1.setUserId(1);
        placar1.setJogoId(1);
        placar1.setPontuacao(150);
        placar1.setReplayPath("path/to/replay1");

        placarController.addPlacar(placar1);

        List<Placar> placares = placarController.getAllPlacares();
        assertEquals(1, placares.size());
        assertEquals("path/to/replay1", placares.get(0).getReplayPath());
    }

    @Test
    void testGetPlacarById_Success() {
        Placar placar1 = new Placar();
        placar1.setId(1);
        placar1.setUserId(1);
        placar1.setJogoId(1);
        placar1.setPontuacao(150);
        placar1.setReplayPath("path/to/replay1");

        placarController.addPlacar(placar1);

        Placar placar = placarController.getPlacarById(1);
        assertNotNull(placar);
        assertEquals(150, placar.getPontuacao());
    }

    @Test
    void testGetPlacarById_Failure() {
        Placar placar = placarController.getPlacarById(99);
        assertNull(placar);
    }

    @Test
    void testGetPlacarByUserId_Empty() {
        List<Placar> placares = placarController.getPlacarByUserId(1);
        assertTrue(placares.isEmpty());
    }

    @Test
    void testGetPlacarByUserId_WithData() {
        Placar placar1 = new Placar();
        placar1.setId(1);
        placar1.setUserId(1);
        placar1.setJogoId(1);
        placar1.setPontuacao(150);
        placar1.setReplayPath("path/to/replay1");

        placarController.addPlacar(placar1);

        List<Placar> placares = placarController.getPlacarByUserId(1);
        assertEquals(1, placares.size());
        assertEquals(placar1.getId(), placares.get(0).getId());
    }
}