package org.example.br.mediverso.controllers;

import org.example.br.mediverso.models.Placar;
import org.example.br.mediverso.services.PlacarService.CreatePlacarService;
import org.example.br.mediverso.services.PlacarService.GetPlacar;
import org.example.br.mediverso.services.PlacarService.GetPlacarById;
import org.example.br.mediverso.services.PlacarService.GetPlacarByAlunoId;

import java.util.List;

public class PlacarController {

    private final CreatePlacarService createPlacarService;
    private final GetPlacar getPlacarService;
    private final GetPlacarById getPlacarByIdService;
    private final GetPlacarByAlunoId getPlacarByAlunoId;

    // Construtor para inicializar os serviços
    public PlacarController() {
        this.createPlacarService = new CreatePlacarService();
        this.getPlacarService = new GetPlacar();
        this.getPlacarByIdService = new GetPlacarById();
        this.getPlacarByAlunoId = new GetPlacarByAlunoId();
    }

    // Método para criar um novo placar
    public void createPlacar(int userId, int jogoId, int pontuacao, String replayPath) {
        Placar placar = new Placar();
        placar.setUserId(userId);
        placar.setJogoId(jogoId);
        placar.setPontuacao(pontuacao);
        placar.setReplayPath(replayPath);

        createPlacarService.createPlacar(placar);
        System.out.println("Placar criado com sucesso.");
    }

    // Método para obter todos os placares
    public List<Placar> getAllPlacares() {
        List<Placar> placares = getPlacarService.getPlacar();

        for (Placar placar : placares) {
            System.out.println("ID: " + placar.getId());
            System.out.println("UserId: " + placar.getUserId());
            System.out.println("JogoId: " + placar.getJogoId());
            System.out.println("Pontuação: " + placar.getPontuacao());
            System.out.println("Replay Path: " + placar.getReplayPath());
            System.out.println("-----------------------------");
        }
        return placares;
    }

    // Método para obter um placar por ID
    public Placar getPlacarById(int id) {
        Placar placar = getPlacarByIdService.getPlacarById(id);

        if (placar != null) {
            System.out.println("ID: " + placar.getId());
            System.out.println("UserId: " + placar.getUserId());
            System.out.println("JogoId: " + placar.getJogoId());
            System.out.println("Pontuação: " + placar.getPontuacao());
            System.out.println("Replay Path: " + placar.getReplayPath());
        } else {
            System.out.println("Placar não encontrado.");
        }
        return placar;
    }

    public List<Placar> getPlacarByUserId(int userId) {
        List<Placar> placares = getPlacarByAlunoId.getPlacarByAlunoid(userId); // Chamando o método que retorna uma lista

        if (placares.isEmpty()) {
            System.out.println("Nenhuma pontuação registrada.");
        }

        return placares; // Retorna a lista de placares
    }

    public static void main(String[] args) {
        PlacarController controller = new PlacarController();

        controller.createPlacar(1, 1, 150, "path/to/replay1");

        controller.getAllPlacares();

        controller.getPlacarById(1);

        controller.getPlacarByUserId(1);
    }
}
