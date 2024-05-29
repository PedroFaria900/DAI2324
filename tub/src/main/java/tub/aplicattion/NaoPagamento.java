package tub.aplicattion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NaoPagamento extends Coima {
    public NaoPagamento() {
        super();
    }

    public NaoPagamento(int idCoima, double preco, Matricula matricula, Rota rota) {
        super(idCoima, preco, matricula, rota);
    }

    @Override
    public void insert() throws SQLException {
        super.insert();
        String sql = "INSERT INTO NaoPagamento (idCoima) VALUES (?)";
        try (Connection conn = DatabaseConfig.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, this.getIdCoima());
            pstmt.executeUpdate();
        }
    }

    public static NaoPagamento getById(int idCoima) throws SQLException {
        Coima coima = Coima.getById(idCoima);
        if (coima != null) {
            return new NaoPagamento(coima.getIdCoima(), coima.getPreco(), coima.getMatricula(), coima.getRota());
        }
        return null;
    }
}

