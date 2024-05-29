package tub.aplicattion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Rota {
    private int idRota;
    private int auto;

    public Rota() {
    }

    public Rota(int idRota, int auto) {
        this.idRota = idRota;
        this.auto = auto;
    }

    public int getIdRota() {
        return idRota;
    }

    public void setIdRota(int idRota) {
        this.idRota = idRota;
    }

    public int getAuto() {
        return auto;
    }

    public void setAuto(int auto) {
        this.auto = auto;
    }

    public void insert() throws SQLException {
        String sql = "INSERT INTO Rota (idRota, auto) VALUES (?, ?)";
        try (Connection conn = DatabaseConfig.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, this.idRota);
            pstmt.setInt(2, this.auto);
            pstmt.executeUpdate();
        }
    }

    public static Rota getById(int idRota) throws SQLException {
        String sql = "SELECT * FROM Rota WHERE idRota = ?";
        Rota rota = null;
        try (Connection conn = DatabaseConfig.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idRota);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                rota = new Rota();
                rota.setIdRota(rs.getInt("idRota"));
                rota.setAuto(rs.getInt("auto"));
            }
        }
        return rota;
    }
}
