package org.example.br.mediverso.services.JogoServices;

import org.example.br.mediverso.DAO.ConnectionService;
import org.example.br.mediverso.models.Jogo;
import org.example.br.mediverso.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetJogos {
    private final ConnectionService connectionService;

    public GetJogos() {
        this.connectionService = new ConnectionService();
    }

    public List<Jogo> getAllJogos() {
        List<Jogo> jogos = new ArrayList<>();
        String query = "SELECT * FROM tbJogos";

        try (Connection connection = connectionService.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Jogo jogo = new Jogo();
                jogo.setId(rs.getInt("id"));
                jogo.setNome(rs.getString("nome"));
                jogo.setPontuacaoMax(rs.getInt("pontuacaoMax"));
                jogos.add(jogo);
            }
        } catch (SQLException e) {
            System.out.println("Erro em buscar jogos: " + e.getMessage());
        }

        return jogos;
    }
}

