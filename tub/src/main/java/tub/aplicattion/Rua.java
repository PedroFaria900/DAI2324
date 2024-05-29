package tub.aplicattion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Rua {
    private String nome;
    private int lug;
    private int lugOcup;
    private ArrayList<Estacionamento> estacionamentos;

    public Rua() {
    }

    public Rua(String nome, int lug, int lugOcup) {
        this.nome = nome;
        this.lug = lug;
        this.lugOcup = lugOcup;
        this.estacionamentos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getLug() {
        return lug;
    }

    public void setLug(int lug) {
        this.lug = lug;
    }

    public int getLugOcup() {
        return lugOcup;
    }

    public void setLugOcup(int lugOcup) {
        this.lugOcup = lugOcup;
    }

    public ArrayList<Estacionamento> getEstacionamentos() {
        return estacionamentos;
    }

    public void setEstacionamentos(ArrayList<Estacionamento> estacionamentos) {
        this.estacionamentos = estacionamentos;
    }

    public void insert() throws SQLException {
        String sql = "INSERT INTO Rua (nome, lug, lugOcup) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConfig.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, this.nome);
            pstmt.setInt(2, this.lug);
            pstmt.setInt(3, this.lugOcup);
            pstmt.executeUpdate();
        }
    }

    public static Rua getByNome(String nome) throws SQLException {
        String sql = "SELECT * FROM Rua WHERE nome = ?";
        Rua rua = null;
        try (Connection conn = DatabaseConfig.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nome);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                rua = new Rua();
                rua.setNome(rs.getString("nome"));
                rua.setLug(rs.getInt("lug"));
                rua.setLugOcup(rs.getInt("lugOcup"));
                rua.estacionamentos = new ArrayList<>();
                // Preencher a lista de estacionamentos
                String estSql = "SELECT * FROM Estacionamento WHERE nomeRua = ?";
                try (PreparedStatement estPstmt = conn.prepareStatement(estSql)) {
                    estPstmt.setString(1, nome);
                    ResultSet estRs = estPstmt.executeQuery();
                    while (estRs.next()) {
                        Estacionamento est = Estacionamento.getById(estRs.getInt("idEstacionamento"));
                        rua.estacionamentos.add(est);
                    }
                }
            }
        }
        return rua;
    }
}