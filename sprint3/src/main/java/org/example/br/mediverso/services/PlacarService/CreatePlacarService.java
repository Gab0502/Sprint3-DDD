package org.example.br.mediverso.services.PlacarService;

import org.example.br.mediverso.DAO.ConnectionService;
import org.example.br.mediverso.models.Placar;
import org.example.br.mediverso.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreatePlacarService {
    private final ConnectionService connectionService;

    public CreatePlacarService() {
        this.connectionService = new ConnectionService();
    }

    public void createPlacar(Placar placar) {
        String query = "INSERT INTO tbPlacar (userId, jogoId, pontuacao, replayPath) VALUES (?, ?, ?, ?);";
        try (Connection connection = connectionService.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, placar.getUserId());
            stmt.setInt(3, placar.getJogoId());
            stmt.setInt(3, placar.getPontuacao());
            stmt.setString(4, placar.getReplayPath());
            stmt.executeUpdate();
            System.out.println("Jogo criado com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao criar jogo: " + e.getMessage());
        }
    }
}
