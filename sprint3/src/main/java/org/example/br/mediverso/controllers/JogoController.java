package org.example.br.mediverso.controllers;

import org.example.br.mediverso.models.Jogo;
import org.example.br.mediverso.services.JogoServices.GetJogos;
import org.example.br.mediverso.services.JogoServices.GetJogosById;

import java.util.List;

public class JogoController {

    private final GetJogos getAllJogosService;
    private final GetJogosById getJogoByIdService;

    public JogoController() {
        this.getAllJogosService = new GetJogos();
        this.getJogoByIdService = new GetJogosById();
    }

    // Método para buscar todos os jogos
    public List<Jogo> getAllJogos() {
        System.out.println("=== Listar todos os Jogos ===");
        List<Jogo> jogos = getAllJogosService.getAllJogos();

        if (jogos.isEmpty()) {
            System.out.println("Nenhum jogo encontrado.");
        }
        return jogos;
    }

    // Método para buscar um jogo por ID
    public Jogo getJogoById(int id) {
        Jogo jogo = getJogoByIdService.getJogoById(id);

        if (jogo != null) {
            return jogo;
        } else {
            System.out.println("Jogo não encontrado.");
            return null;
        }
    }

    public static void main(String[] args) {
        JogoController controller = new JogoController();

        controller.getAllJogos();

        controller.getJogoById(1);
    }
}
