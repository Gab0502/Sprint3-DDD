package org.example.br.mediverso.pages;

import org.example.br.mediverso.controllers.JogoController;
import org.example.br.mediverso.controllers.PlacarController;
import org.example.br.mediverso.controllers.TurmaController;
import org.example.br.mediverso.controllers.TurmaUserController;
import org.example.br.mediverso.models.AuthContext;
import org.example.br.mediverso.models.Jogo;
import org.example.br.mediverso.models.Placar;
import org.example.br.mediverso.models.Turma;
import org.example.br.mediverso.models.User;
import org.example.br.mediverso.services.TurmaService.GetTurmaById;
import org.example.br.mediverso.services.TurmaService.GetTurmaByProfessorId;
import org.example.br.mediverso.services.TurmaUserService.GetUsersByTurmaId;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class ProfessorPage {
    private final JogoController jogoController;
    private final PlacarController placarController;
    private final AuthContext authContext;
    private final TurmaController turmaController;
    private final TurmaUserController turmaUserController;
    private boolean loggedIn;



    public ProfessorPage(AuthContext authContext) {
        this.jogoController = new JogoController();
        this.placarController = new PlacarController();
        this.turmaController = new TurmaController();
        this.turmaUserController = new TurmaUserController();
        this.authContext = authContext;
        this.loggedIn = true;
    }

    public void showProfessorScreen() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo à página do Professor MEDIVERSO, " + authContext.getNome() + "!");
        while (loggedIn) {
            System.out.println("\n--- Menu Principal ---");
            System.out.println("1. Jogar Simulação");
            System.out.println("2. Ver Minhas Pontuações");
            System.out.println("3. Ver Turmas e Alunos");
            System.out.println("4. Logout");

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
                    verTurmasEAlunos(); // Chama o método para ver turmas e alunos
                    break;
                case 4:
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

    public void verTurmasEAlunos() {
        Scanner scanner = new Scanner(System.in);

        // Obter turmas do professor
        Turma turmas = turmaController.getTurmaByProfessorId(authContext.getUserId());
        if (turmas == null) {
            System.out.println("Nenhuma turma encontrada para o professor com ID: " + authContext.getUserId());
            return;
        }

        System.out.println("\n--- Turma ---");
            System.out.println("Turma ID: " + turmas.getId());
            System.out.println("Nome: " + turmas.getNome());

            // Obter usuários na turma
            turmaUserController.getUsersByTurmaId(turmas.getId());

                System.out.print("Digite o ID do aluno para ver suas pontuações (ou 0 para voltar): ");
                int alunoId = scanner.nextInt();
                if (alunoId != 0) {
                    verPontuacoesAluno(alunoId);

        }
    }


    public void verPontuacoesAluno(int alunoId) {
        List<Placar> placares = placarController.getPlacarByUserId(alunoId);

        if (placares.isEmpty()) {
            System.out.println("Nenhuma pontuação registrada para o aluno com ID: " + alunoId);
        } else {
            System.out.println("\n--- Pontuações Registradas para o Aluno ID: " + alunoId + " ---");
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
