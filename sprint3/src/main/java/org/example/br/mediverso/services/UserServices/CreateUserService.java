package org.example.br.mediverso.services.UserServices;

import org.example.br.mediverso.DAO.ConnectionService;
import org.example.br.mediverso.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateUserService {
    private final ConnectionService connectionService;

    public CreateUserService() {
        this.connectionService = new ConnectionService();
    }

    public void createUser(User user) {
        String query = "INSERT INTO tbUser (nome, email, senha, professor, ativo) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = connectionService.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getSenha());
            stmt.setBoolean(4, user.isProfessor());
            stmt.setBoolean(5, user.isAtivo());
            stmt.executeUpdate();
            System.out.println("Usuario criado com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao criar usuario: " + e.getMessage());
        }
    }
}
