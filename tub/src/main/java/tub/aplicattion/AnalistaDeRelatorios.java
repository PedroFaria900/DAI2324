package tub.aplicattion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AnalistaDeRelatorios extends Utilizador {
    public AnalistaDeRelatorios() {
        super();
    }

    public AnalistaDeRelatorios(String nome, int numero, String pass) {
        super(nome, numero, pass);
    }

    @Override
    public void insert() throws SQLException {
        super.insert();
        String sql = "INSERT INTO AnalistaDeRelatorios (numero) VALUES (?)";
        try (Connection conn = DatabaseConfig.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, this.getNumero());
            pstmt.executeUpdate();
        }
    }

    public static AnalistaDeRelatorios getByNumero(int numero) throws SQLException {
        Utilizador user = Utilizador.getByNumero(numero);
        if (user != null) {
            return new AnalistaDeRelatorios(user.getNome(), user.getNumero(), user.getPass());
        }
        return null;
    }
}
