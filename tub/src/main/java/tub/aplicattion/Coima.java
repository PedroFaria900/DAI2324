package tub.aplicattion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Coima {
    private int idCoima;
    private double preco;
    private Matricula matricula;
    private Rota rota;

    public Coima() {
    }

    public Coima(int idCoima, double preco, Matricula matricula, Rota rota) {
        this.idCoima = idCoima;
        this.preco = preco;
        this.matricula = matricula;
        this.rota = rota;
    }

    public int getIdCoima() {
        return idCoima;
    }

    public void setIdCoima(int idCoima) {
        this.idCoima = idCoima;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public Rota getRota() {
        return rota;
    }

    public void setRota(Rota rota) {
        this.rota = rota;
    }

    public void insert() throws SQLException {
        String sql = "INSERT INTO Coima (preco, matricula, rota) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConfig.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, this.preco);
            pstmt.setString(3, this.matricula.getMatricula());
            pstmt.setInt(4, this.rota.getIdRota());
            pstmt.executeUpdate();
        }
    }

    public static Coima getById(int idCoima) throws SQLException {
        String sql = "SELECT * FROM Coima WHERE idCoima = ?";
        Coima coima = null;
        try (Connection conn = DatabaseConfig.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idCoima);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                coima = new Coima();
                coima.setIdCoima(rs.getInt("idCoima"));
                coima.setPreco(rs.getDouble("preco"));
                coima.setMatricula(Matricula.getByMatricula(rs.getString("matricula")));
                coima.setRota(Rota.getById(rs.getInt("rota")));
            }
        }
        return coima;
    }
}
