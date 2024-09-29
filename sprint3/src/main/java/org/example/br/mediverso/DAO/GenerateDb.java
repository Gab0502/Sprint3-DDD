package org.example.br.mediverso.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GenerateDb {

    private final ConnectionService connectionService;

    public GenerateDb() {
        this.connectionService = new ConnectionService();
    }

    public void createDatabase() {
        try (Connection connection = connectionService.getConnection();
             Statement stmt = connection.createStatement()) {

            if (!tableExists(connection, "tbUser")) {
                String createUserTable = "CREATE TABLE tbUser (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "nome TEXT NOT NULL," +
                        "email TEXT NOT NULL," +
                        "senha TEXT NOT NULL," +
                        "professor BOOLEAN," +
                        "ativo BOOLEAN);";
                stmt.execute(createUserTable);
                System.out.println("Table tbUser created.");
            }

            if (!tableExists(connection, "tbTurma")) {
                String createTurmaTable = "CREATE TABLE tbTurma (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "nome TEXT NOT NULL," +
                        "ativo BOOLEAN);";
                stmt.execute(createTurmaTable);
                System.out.println("Table tbTurma created.");
            }

            if (!tableExists(connection, "tbTurmaUser")) {
                String createTurmaUserTable = "CREATE TABLE tbTurmaUser (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "turmaId INTEGER," +
                        "UserId INTEGER," +
                        "FOREIGN KEY (turmaId) REFERENCES tbTurma(id)," +
                        "FOREIGN KEY (userId) REFERENCES tbUser(id));";
                stmt.execute(createTurmaUserTable);
                System.out.println("Table tbTurmaUser created.");
            }
            if (!tableExists(connection, "tbJogos")) {
                String createJogosTable = "CREATE TABLE tbJogos (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "nome TEXT NOT NULL," +
                        "pontuacaoMax INTEGER NOT NULL);";
                stmt.execute(createJogosTable);
                System.out.println("Table tbJogos created.");
            }

            if (!tableExists(connection, "tbPlacar")) {
                String createPlacarTable = "CREATE TABLE tbPlacar (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "userId INTEGER NOT NULL," +
                        "jogoId INTEGER NOT NULL," +
                        "pontuacao INTEGER NOT NULL," +
                        "replayPath TEXT," +
                        "FOREIGN KEY (userId) REFERENCES tbUser(id)," +
                        "FOREIGN KEY (jogoId) REFERENCES tbJogos(id));";
                ;
                stmt.execute(createPlacarTable);
                System.out.println("Table tbPlacar created.");
            }

            if (!tableExists(connection, "tbTarefas")) {
                String createTarefasTable = "CREATE TABLE tbTarefas (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "nome TEXT NOT NULL," +
                        "jogoId INTEGER NOT NULL," +
                        "turmaId INTEGER NOT NULL," +
                        "FOREIGN KEY (turmaId) REFERENCES tbTurma(id)," +
                        "FOREIGN KEY (jogoId) REFERENCES tbJogos(id));"
                        ;
                stmt.execute(createTarefasTable);
                System.out.println("Table tbTarefas created.");
            }

            if (!tableExists(connection, "tbEntregas")) {
                String createEntregasTable = "CREATE TABLE tbEntregas (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "tarefaId INTEGER NOT NULL," +
                        "placarId INTEGER NOT NULL," +
                        "FOREIGN KEY (tarefaId) REFERENCES tbTarefas(id)," +
                        "FOREIGN KEY (placarId) REFERENCES tbPlacar(id));";
                stmt.execute(createEntregasTable);
                System.out.println("Table tbEntregas created.");
            }


            // Check for initial data in tbUser
            if (!hasData(connection, "tbUser")) {
                insertInitialData(connection);
            } else {
                System.out.println("tbUser already has data, no need to insert initial data.");
            }

        } catch (SQLException e) {
            System.out.println("Error creating database or tables: " + e.getMessage());
        }
    }

    private boolean tableExists(Connection connection, String tableName) {
        String query = "SELECT name FROM sqlite_master WHERE type='table' AND name='" + tableName + "';";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            return rs.next(); // If there's a result, the table exists
        } catch (SQLException e) {
            System.out.println("Error checking existence of table " + tableName + ": " + e.getMessage());
        }
        return false;
    }

    private boolean hasData(Connection connection, String tableName) {
        String query = "SELECT COUNT(*) FROM " + tableName;
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            System.out.println("Error checking data in " + tableName + ": " + e.getMessage());
        }
        return false;
    }

    private void insertInitialData(Connection connection) {
        // Inserindo usuários fictícios
        String insertUsersQuery = "INSERT INTO tbUser (nome, email, senha, professor, ativo) VALUES " +
                "('Professor João Silva', 'professor.joao@example.com', 'senha123', true, true), " +
                "('Ana Oliveira', 'ana.oliveira@example.com', 'senha123', false, true), " +
                "('Carlos Pereira', 'carlos.pereira@example.com', 'senha123', false, true), " +
                "('Fernanda Souza', 'fernanda.souza@example.com', 'senha123', false, true), " +
                "('Lucas Almeida', 'lucas.almeida@example.com', 'senha123', false, true), " +
                "('Mariana Costa', 'mariana.costa@example.com', 'senha123', false, true);";

        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(insertUsersQuery);
            System.out.println("Usuários iniciais inseridos em tbUser.");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir usuários iniciais em tbUser: " + e.getMessage());
        }

        // Inserindo uma turma fictícia
        String insertTurmaQuery = "INSERT INTO tbTurma (nome, ativo) VALUES " +
                "('Turma de Laparoscopia', true);";

        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(insertTurmaQuery);
            System.out.println("Turma inicial inserida em tbTurma.");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir turma inicial em tbTurma: " + e.getMessage());
        }

        // Vinculando todos os usuários à turma
        String linkUsersToTurmaQuery = "INSERT INTO tbTurmaUser (turmaId, UserId) VALUES " +
                "(1, 1), " + // Professor João Silva
                "(1, 2), " + // Ana Oliveira
                "(1, 3), " + // Carlos Pereira
                "(1, 4), " + // Fernanda Souza
                "(1, 5), " + // Lucas Almeida
                "(1, 6);";   // Mariana Costa

        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(linkUsersToTurmaQuery);
            System.out.println("Usuários vinculados à turma em tbTurmaUser.");
        } catch (SQLException e) {
            System.out.println("Erro ao vincular usuários à turma em tbTurmaUser: " + e.getMessage());
        }

        // Inserindo jogos fictícios relacionados a laparoscopia
        String insertJogosQuery = "INSERT INTO tbJogos (nome, pontuacaoMax) VALUES " +
                "('Simulação Laparoscopia: Apêndice', 100), " +
                "('Simulação Laparoscopia: Colecistectomia', 120), " +
                "('Simulação Laparoscopia: Herniorrafia', 90);";

        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(insertJogosQuery);
            System.out.println("Jogos iniciais inseridos em tbJogos.");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir jogos iniciais em tbJogos: " + e.getMessage());
        }
    }


}
