package tub.aplicattion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Fiscal {
    private String ruaFiscalizar;
    private ArrayList<Coima> coimasAtribuidas;

    public Fiscal() {
    }

    public Fiscal(String ruaFiscalizar) {
        this.ruaFiscalizar = ruaFiscalizar;
        this.coimasAtribuidas = new ArrayList<>();
    }

    public String getRuaFiscalizar() {
        return ruaFiscalizar;
    }

    public void setRuaFiscalizar(String ruaFiscalizar) {
        this.ruaFiscalizar = ruaFiscalizar;
    }

    public List<Coima> getCoimasAtribuidas() {
        return coimasAtribuidas;
    }

    public void setCoimasAtribuidas(ArrayList<Coima> coimasAtribuidas) {
        this.coimasAtribuidas = coimasAtribuidas;
    }

    public void insert() throws SQLException {
        String sql = "INSERT INTO Fiscal (ruaFiscalizar) VALUES (?)";
        try (Connection conn = DatabaseConfig.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, this.ruaFiscalizar);
            pstmt.executeUpdate();
        }
    }

    public static Fiscal getByRua(String ruaFiscalizar) throws SQLException {
        String sql = "SELECT * FROM Fiscal WHERE ruaFiscalizar = ?";
        Fiscal fiscal = null;
        try (Connection conn = DatabaseConfig.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, ruaFiscalizar);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                fiscal = new Fiscal();
                fiscal.setRuaFiscalizar(rs.getString("ruaFiscalizar"));
                fiscal.coimasAtribuidas = new ArrayList<>();
                // Preencher a lista de coimas atribuídas
                String coimaSql = "SELECT * FROM Coima WHERE ruaFiscalizar = ?";
                try (PreparedStatement coimaPstmt = conn.prepareStatement(coimaSql)) {
                    coimaPstmt.setString(1, ruaFiscalizar);
                    ResultSet coimaRs = coimaPstmt.executeQuery();
                    while (coimaRs.next()) {
                        Coima coima = Coima.getById(coimaRs.getInt("idCoima"));
                        fiscal.coimasAtribuidas.add(coima);
                    }
                }
            }
        }
        return fiscal;
    }
}