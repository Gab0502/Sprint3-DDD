package org.example.br.mediverso.services.PlacarService;

import org.example.br.mediverso.DAO.ConnectionService;
import org.example.br.mediverso.models.Placar;
import org.example.br.mediverso.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetPlacar {
    private final ConnectionService connectionService;

    public GetPlacar() {
        this.connectionService = new ConnectionService();
    }

    public List<Placar> getPlacar() {
        List<Placar> placarFull = new ArrayList<>();
        String query = "SELECT * FROM tbPlacar";

        try (Connection connection = connectionService.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Placar placar = new Placar();
                placar.setId(rs.getInt("id"));
                placar.setPontuacao(rs.getInt("pontuacao"));
                placar.setJogoId(rs.getInt("jogoId"));
                placar.setUserId(rs.getInt("userId"));
                placar.setReplayPath(rs.getString("replayPath"));
                placarFull.add(placar);
            }
        } catch (SQLException e) {
            System.out.println("Erro em buscar jogos: " + e.getMessage());
        }

        return placarFull;
    }
}

