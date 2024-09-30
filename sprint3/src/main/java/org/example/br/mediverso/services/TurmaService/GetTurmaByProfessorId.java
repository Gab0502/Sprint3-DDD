package org.example.br.mediverso.services.TurmaService;

import org.example.br.mediverso.DAO.ConnectionService;
import org.example.br.mediverso.models.Turma;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetTurmaByProfessorId {
    private final ConnectionService connectionService;

    public GetTurmaByProfessorId() {
        this.connectionService = new ConnectionService();
    }

    public Turma getTurmaByProfessorId(int id) {
        Turma turma = null;
        String query = "SELECT * FROM tbTurma WHERE professorId = ?";
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
            System.out.println("Erro ao buscar turma: " + e.getMessage());
        }
        return turma;
    }
}
