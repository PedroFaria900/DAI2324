package tub.aplicattion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {
    public static void initialize() {
        try {
            // Carregar o driver do H2 Database (ou outro banco de dados, dependendo do que você está usando)
            Class.forName("org.h2.Driver");

            // Conectar ao banco de dados (criará o banco de dados se não existir)
            Connection connection = DriverManager.getConnection("jdbc:h2:./data/sample", "sa", "");

            // Criar uma tabela de usuários
            String createTableQuery = "CREATE TABLE IF NOT EXISTS users (" +
                                      "id INT AUTO_INCREMENT PRIMARY KEY," +
                                      "username VARCHAR(255) NOT NULL," +
                                      "password VARCHAR(255) NOT NULL)";
            Statement statement = connection.createStatement();
            statement.executeUpdate(createTableQuery);

            // Inserir alguns dados de exemplo
            String insertDataQuery = "INSERT INTO users (username, password) VALUES " +
                                     "('admin', 'password'), " +
                                     "('user1', '123456'), " +
                                     "('user2', 'abcdef')";
            statement.executeUpdate(insertDataQuery);

            // Fechar a conexão
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            ErrorController.handleDatabaseInitializationError(e); // Tratamento de erro utilizando ErrorController
        }
    }
}