package org.example.br.mediverso.services.PlacarService;

import org.example.br.mediverso.DAO.ConnectionService;
import org.example.br.mediverso.models.Placar;
import org.example.br.mediverso.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetPlacarById {
    private final ConnectionService connectionService;

    public GetPlacarById() {
        this.connectionService = new ConnectionService();
    }

    public Placar getPlacarById(int id) {
        Placar placar = null;
        String query = "SELECT * FROM tbPlacar WHERE id = ?";
        try (Connection connection = connectionService.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                placar = new Placar();
                placar.setId(rs.getInt("id"));
                placar.setReplayPath(rs.getString("replayPath"));
                placar.setUserId(rs.getInt("userId"));
                placar.setJogoId(rs.getInt("jogoId"));
                placar.setPontuacao(rs.getInt("pontuacao"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar entrada no placar: " + e.getMessage());
        }
        return placar;
    }
}
