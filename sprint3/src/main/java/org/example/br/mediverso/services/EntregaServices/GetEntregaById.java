package org.example.br.mediverso.services.EntregaServices;

import org.example.br.mediverso.DAO.ConnectionService;
import org.example.br.mediverso.models.Entrega;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetEntregaById {
    private final ConnectionService connectionService;

    public GetEntregaById() {
        this.connectionService = new ConnectionService();
    }

    public Entrega getEntregaById(int id) {
        Entrega entrega = null;
        String query = "SELECT * FROM tbEntregas WHERE id = ?";
        try (Connection connection = connectionService.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                entrega = new Entrega();
                entrega.setPlacarId(rs.getInt("placarId"));
                entrega.setTarefaId(rs.getInt("tarefaId"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar Entrega: " + e.getMessage());
        }
        return entrega;
    }
}
