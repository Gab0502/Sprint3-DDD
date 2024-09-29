package org.example.br.mediverso.services.UserServices;

import org.example.br.mediverso.DAO.ConnectionService;
import org.example.br.mediverso.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetUserById {
    private final ConnectionService connectionService;

    public GetUserById() {
        this.connectionService = new ConnectionService();
    }

    public User getUserById(int id) {
        User user = null;
        String query = "SELECT * FROM tbUser WHERE id = ?";
        try (Connection connection = connectionService.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setNome(rs.getString("nome"));
                user.setEmail(rs.getString("email"));
                user.setSenha(rs.getString("senha"));
                user.setProfessor(rs.getBoolean("professor"));
                user.setAtivo(rs.getBoolean("ativo"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar Usuario: " + e.getMessage());
        }
        return user;
    }
}
