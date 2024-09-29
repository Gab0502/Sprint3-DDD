package org.example.br.mediverso.services.EntregaServices;

import org.example.br.mediverso.DAO.ConnectionService;
import org.example.br.mediverso.models.Entrega;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetEntregas {
    private final ConnectionService connectionService;

    public GetEntregas() {
        this.connectionService = new ConnectionService();
    }

    public List<Entrega> getAllEntregas() {
        List<Entrega> Entrega = new ArrayList<>();
        String query = "SELECT * FROM tbEntregas";

        try (Connection connection = connectionService.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Entrega entrega = new Entrega();
                entrega.setId(rs.getInt("id"));
                entrega.setTarefaId(rs.getInt("tarefaId"));
                entrega.setPlacarId(rs.getInt(  "placarId"));
                Entrega.add(entrega);
            }
        } catch (SQLException e) {
            System.out.println("Erro em buscar entregas: " + e.getMessage());
        }

        return Entrega;
    }
}

