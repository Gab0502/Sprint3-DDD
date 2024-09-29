package org.example.br.mediverso.services.EntregaServices;

import org.example.br.mediverso.DAO.ConnectionService;
import org.example.br.mediverso.models.Entrega;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateEntregaService {
    private final ConnectionService connectionService;

    public CreateEntregaService() {
        this.connectionService = new ConnectionService();
    }

    public void createEntrega(Entrega entrega) {
        String query = "INSERT INTO tbEntregas (tarefaId, placarId) VALUES (?, ?);";
        try (Connection connection = connectionService.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, entrega.getTarefaId());
            stmt.setInt(2, entrega.getPlacarId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao criar usuario: " + e.getMessage());
        }
    }
}
