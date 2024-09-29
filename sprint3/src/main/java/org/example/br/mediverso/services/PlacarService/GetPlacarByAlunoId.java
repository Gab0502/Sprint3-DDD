package org.example.br.mediverso.services.PlacarService;

import org.example.br.mediverso.DAO.ConnectionService;
import org.example.br.mediverso.models.Placar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetPlacarByAlunoId {
    private final ConnectionService connectionService;

    public GetPlacarByAlunoId() {
        this.connectionService = new ConnectionService();
    }

    public List<Placar> getPlacarByAlunoid(int id) {
        List<Placar> placares = new ArrayList<>();
        String query = "SELECT * FROM tbPlacar WHERE userId = ?";
        try (Connection connection = connectionService.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Placar placar = new Placar();
                placar.setId(rs.getInt("id"));
                placar.setReplayPath(rs.getString("replayPath"));
                placar.setUserId(rs.getInt("userId"));
                placar.setJogoId(rs.getInt("jogoId"));
                placar.setPontuacao(rs.getInt("pontuacao"));
                placares.add(placar); // Adiciona cada placar à lista
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar entradas no placar: " + e.getMessage());
        }
        return placares; // Retorna a lista de placares
    }
}
