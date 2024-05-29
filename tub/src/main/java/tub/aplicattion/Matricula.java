package tub.aplicattion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Matricula {
    private String matricula;
    private boolean ticket;
    private String horaLimite;

    public Matricula() {
    }

    public Matricula(String matricula, boolean ticket, String horaLimite) {
        this.matricula = matricula;
        this.ticket = ticket;
        this.horaLimite = horaLimite;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public boolean isTicket() {
        return ticket;
    }

    public void setTicket(boolean ticket) {
        this.ticket = ticket;
    }

    public String getHoraLimite() {
        return horaLimite;
    }

    public void setHoraLimite(String horaLimite) {
        this.horaLimite = horaLimite;
    }

    public void insert() throws SQLException {
        String sql = "INSERT INTO Matricula (matricula, ticket, horaLimite) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConfig.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, this.matricula);
            pstmt.setBoolean(2, this.ticket);
            pstmt.setString(3, this.horaLimite);
            pstmt.executeUpdate();
        }
    }

    public static Matricula getByMatricula(String matricula) throws SQLException {
        String sql = "SELECT * FROM Matricula WHERE matricula = ?";
        Matricula m = null;
        try (Connection conn = DatabaseConfig.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, matricula);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                m = new Matricula();
                m.setMatricula(rs.getString("matricula"));
                m.setTicket(rs.getBoolean("ticket"));
                m.setHoraLimite(rs.getString("horaLimite"));
            }
        }
        return m;
    }
}

