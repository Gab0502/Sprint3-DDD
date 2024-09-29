package org.example.br.mediverso.services.TurmaService;

import org.example.br.mediverso.DAO.ConnectionService;
import org.example.br.mediverso.models.Turma;
import org.example.br.mediverso.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetTurmaById {
    private final ConnectionService connectionService;

    public GetTurmaById() {
        this.connectionService = new ConnectionService();
    }

    public Turma getTurmaById(int id) {
        Turma turma = null;
        String query = "SELECT * FROM tbTurma WHERE id = ?";
        try (Connection connection = connectionService.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                turma = new Turma();
                turma.setId(rs.getInt("id"));
                turma.setNome(rs.getString("nome"));
                turma.setAtivo(rs.getBoolean("ativo"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar Usuario: " + e.getMessage());
        }
        return turma;
    }
}
