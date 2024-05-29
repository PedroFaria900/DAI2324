package tub.aplicattion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Autocarro {
    private int idAutocarro;
    private int idCamera;

    public Autocarro() {
    }

    public Autocarro(int idAutocarro, int idCamera) {
        this.idAutocarro = idAutocarro;
        this.idCamera = idCamera;
    }

    public int getIdAutocarro() {
        return idAutocarro;
    }

    public void setIdAutocarro(int idAutocarro) {
        this.idAutocarro = idAutocarro;
    }

    public int getIdCamera() {
        return idCamera;
    }

    public void setIdCamera(int idCamera) {
        this.idCamera = idCamera;
    }

    public void insert() throws SQLException {
        String sql = "INSERT INTO Autocarro (idAutocarro, idCamera) VALUES (?, ?)";
        try (Connection conn = DatabaseConfig.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, this.idAutocarro);
            pstmt.setInt(2, this.idCamera);
            pstmt.executeUpdate();
        }
    }

    public static Autocarro getById(int idAutocarro) throws SQLException {
        String sql = "SELECT * FROM Autocarro WHERE idAutocarro = ?";
        Autocarro autocarro = null;
        try (Connection conn = DatabaseConfig.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idAutocarro);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                autocarro = new Autocarro();
                autocarro.setIdAutocarro(rs.getInt("idAutocarro"));
                autocarro.setIdCamera(rs.getInt("idCamera"));
            }
        }
        return autocarro;
    }
}
