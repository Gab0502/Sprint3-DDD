package org.example.br.mediverso.pages;

import org.example.br.mediverso.controllers.JogoController;
import org.example.br.mediverso.controllers.PlacarController; // Importando o PlacarController
import org.example.br.mediverso.controllers.TurmaUserController;
import org.example.br.mediverso.models.Jogo;
import org.example.br.mediverso.models.Placar;
import org.example.br.mediverso.models.AuthContext;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class AlunoPage {

    private final JogoController jogoController;
    private final PlacarController placarController;
    private final AuthContext authContext;
    private boolean loggedIn;


    public AlunoPage(AuthContext authContext) {
        this.jogoController = new JogoController();
        this.placarController = new PlacarController();
        this.authContext = authContext;
        this.loggedIn = true;

    }

    public void showAlunoScreen() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo à página do Aluno MEDIVERSO, " + authContext.getNome() + "!");
        while (loggedIn) {
            System.out.println("\n--- Menu Principal ---");
            System.out.println("1. Jogar Simulação");
            System.out.println("2. Ver Minhas Pontuações");
            System.out.println("3. Logout");

            System.out.print("\nEscolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    jogarSimulacao();
                    break;
                case 2:
                    verPontuacoes();
                    break;
                case 3:
                    logout();
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    break;
            }
        }
    }

    public void jogarSimulacao() {
        Scanner scanner = new Scanner(System.in);

        List<Jogo> jogos = jogoController.getAllJogos();
        if (jogos.isEmpty()) {
            System.out.println("Nenhum jogo disponível no momento.");
            return;
        }

        System.out.println("\n--- Jogos Disponíveis ---");
        for (int i = 0; i < jogos.size(); i++) {
            System.out.println((i + 1) + ". " + jogos.get(i).getNome() + " pontuação maxima " + jogos.get(i).getPontuacaoMax());
        }

        System.out.print("\nEscolha o número do jogo que deseja jogar: ");
        int escolhaJogo = scanner.nextInt();

        if (escolhaJogo < 1 || escolhaJogo > jogos.size()) {
            System.out.println("Escolha inválida. Por favor, escolha um número de jogo válido.");
            return;
        }

        Jogo jogoEscolhido = jogos.get(escolhaJogo - 1);

        System.out.print("Insira a pontuação obtida no jogo: ");
        int pontuacao = scanner.nextInt();

        if (pontuacao > jogoEscolhido.getPontuacaoMax()) {
            System.out.println("Pontuação inválida! A pontuação máxima para este jogo é " + jogoEscolhido.getPontuacaoMax() + ".");
            return;
        }

        String replayPath = "videos/replays/" + UUID.randomUUID().toString() + ".mp4";
        System.out.println("Replay gerado em: " + replayPath);

        placarController.createPlacar(authContext.getUserId(), jogoEscolhido.getId(), pontuacao, replayPath);

        System.out.println("\nJogo jogado com sucesso!");
        System.out.println("Pontuação salva: " + pontuacao);
        System.out.println("Replay salvo em: " + replayPath);
    }

    public void verPontuacoes() {
        List<Placar> placares = placarController.getPlacarByUserId(authContext.getUserId());

        if (placares.isEmpty()) {
            System.out.println("Nenhuma pontuação registrada para o usuário.");
        } else {
            System.out.println("\n--- Pontuações Registradas ---");
            for (Placar placar : placares) {
                Jogo jogo = jogoController.getJogoById(placar.getJogoId());

                System.out.println("Jogo: " + jogo.getNome());
                System.out.println("Pontuação: " + placar.getPontuacao());
                System.out.println("Replay Path: " + placar.getReplayPath());
                System.out.println("-----------------------------");
            }
        }
    }
    public void logout() {
        System.out.println("Logout efetuado com sucesso. Até a próxima, " + authContext.getNome() + "!");
        loggedIn = false;
    }
}
