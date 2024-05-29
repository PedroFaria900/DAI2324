package tub.aplicattion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Estacionamento {
    private int idEstacionamento;
    private Matricula matricula;

    public Estacionamento() {
    }

    public Estacionamento(int idEstacionamento, Matricula matricula) {
        this.idEstacionamento = idEstacionamento;
        this.matricula = matricula;
    }

    public int getIdEstacionamento() {
        return idEstacionamento;
    }

    public void setIdEstacionamento(int idEstacionamento) {
        this.idEstacionamento = idEstacionamento;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public void insert() throws SQLException {
        String sql = "INSERT INTO Estacionamento (idEstacionamento, matricula) VALUES (?, ?)";
        try (Connection conn = DatabaseConfig.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, this.idEstacionamento);
            pstmt.setString(2, this.matricula.getMatricula());
            pstmt.executeUpdate();
        }
    }

    public static Estacionamento getById(int idEstacionamento) throws SQLException {
        String sql = "SELECT * FROM Estacionamento WHERE idEstacionamento = ?";
        Estacionamento est = null;
        try (Connection conn = DatabaseConfig.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idEstacionamento);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                est = new Estacionamento();
                est.setIdEstacionamento(rs.getInt("idEstacionamento"));
                est.setMatricula(Matricula.getByMatricula(rs.getString("matricula")));
            }
        }
        return est;
    }
}

