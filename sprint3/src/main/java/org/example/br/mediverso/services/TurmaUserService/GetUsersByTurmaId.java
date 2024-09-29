package org.example.br.mediverso.services.TurmaUserService;

import org.example.br.mediverso.DAO.ConnectionService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetUsersByTurmaId {
    private final ConnectionService connectionService;

    public GetUsersByTurmaId() {
        this.connectionService = new ConnectionService();
    }

    public List<Integer> getUsersByTurmaId(int turmaId) {
        List<Integer> userIds = new ArrayList<>();
        String query = "SELECT UserId FROM tbTurmaUser WHERE turmaId = ?";
        try (Connection connection = connectionService.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, turmaId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                userIds.add(rs.getInt("UserId"));
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving users for turma: " + e.getMessage());
        }
        return userIds;
    }
}
