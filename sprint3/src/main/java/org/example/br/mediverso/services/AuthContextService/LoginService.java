package org.example.br.mediverso.services.AuthContextService;

import org.example.br.mediverso.DAO.ConnectionService;
import org.example.br.mediverso.models.AuthContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginService {
    private final ConnectionService connectionService;

    public LoginService() {
        this.connectionService = new ConnectionService();
    }

    public AuthContext login(String email, String senha) {
        AuthContext authContext = null;
        String query = "SELECT id,nome, email, senha, professor FROM tbUser WHERE email = ? AND senha = ?";

        try (Connection connection = connectionService.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, email);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                authContext = new AuthContext();
                authContext.setUserId(rs.getInt("id"));
                authContext.setNome(rs.getString("nome"));
                authContext.setEmail(rs.getString("email"));
                authContext.setSenha(rs.getString("senha"));
                authContext.setProfessor(rs.getBoolean("professor"));
            } else {
                System.out.println("Usuário não encontrado ou senha incorreta.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao autenticar o usuário: " + e.getMessage());
        }

        return authContext;
    }
}
