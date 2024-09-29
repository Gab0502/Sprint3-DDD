package org.example.br.mediverso.services.JogoServices;

import org.example.br.mediverso.DAO.ConnectionService;
import org.example.br.mediverso.models.Jogo;
import org.example.br.mediverso.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetJogosById {
    private final ConnectionService connectionService;

    public GetJogosById() {
        this.connectionService = new ConnectionService();
    }

    public Jogo getJogoById(int id) {
        Jogo jogo = null;
        String query = "SELECT * FROM tbJogos WHERE id = ?";
        try (Connection connection = connectionService.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                jogo = new Jogo();
                jogo.setId(rs.getInt("id"));
                jogo.setNome(rs.getString("nome"));
                jogo.setPontuacaoMax(rs.getInt("pontuacaoMax"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar jogo: " + e.getMessage());
        }
        return jogo;
    }
}
