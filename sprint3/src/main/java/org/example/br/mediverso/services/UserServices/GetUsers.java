package org.example.br.mediverso.services.UserServices;

import org.example.br.mediverso.DAO.ConnectionService;
import org.example.br.mediverso.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetUsers {
    private final ConnectionService connectionService;

    public GetUsers() {
        this.connectionService = new ConnectionService();
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM tbUser";

        try (Connection connection = connectionService.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setNome(rs.getString("nome"));
                user.setEmail(rs.getString("email"));
                user.setSenha(rs.getString("senha"));
                user.setProfessor(rs.getBoolean("professor"));
                user.setAtivo(rs.getBoolean("ativo"));
                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println("Erro em buscar usuarios: " + e.getMessage());
        }

        return users;
    }
}

