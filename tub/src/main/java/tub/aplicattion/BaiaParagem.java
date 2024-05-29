package tub.aplicattion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BaiaParagem extends Coima {
    public BaiaParagem() {
        super();
    }

    public BaiaParagem(int idCoima, double preco, Matricula matricula, Rota rota) {
        super(idCoima, preco, matricula, rota);
    }

    @Override
    public void insert() throws SQLException {
        super.insert();
        String sql = "INSERT INTO BaiaParagem (idCoima) VALUES (?)";
        try (Connection conn = DatabaseConfig.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, this.getIdCoima());
            pstmt.executeUpdate();
        }
    }

    public static BaiaParagem getById(int idCoima) throws SQLException {
        Coima coima = Coima.getById(idCoima);
        if (coima != null) {
            return new BaiaParagem(coima.getIdCoima(), coima.getPreco(), coima.getMatricula(), coima.getRota());
        }
        return null;
    }
}

