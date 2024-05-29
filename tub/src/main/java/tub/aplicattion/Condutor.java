package tub.aplicattion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Condutor extends Utilizador {
    public Condutor() {
        super();
    }

    public Condutor(String nome, int numero, String pass) {
        super(nome, numero, pass);
    }

    @Override
    public void insert() throws SQLException {
        super.insert();
        String sql = "INSERT INTO Conductor (numero) VALUES (?)";
        try (Connection conn = DatabaseConfig.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, this.getNumero());
            pstmt.executeUpdate();
        }
    }

    public static Condutor getByNumero(int numero) throws SQLException {
        Utilizador user = Utilizador.getByNumero(numero);
        if (user != null) {
            return new Condutor(user.getNome(), user.getNumero(), user.getPass());
        }
        return null;
    }
}

