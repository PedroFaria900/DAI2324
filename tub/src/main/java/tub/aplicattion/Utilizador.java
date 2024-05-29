package tub.aplicattion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Utilizador {
    private String nome;
    private int numero;
    private String pass;

    public Utilizador() {
    }

    public Utilizador(String nome, int numero, String pass) {
        this.nome = nome;
        this.numero = numero;
        this.pass = pass;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void insert() throws SQLException {
        String sql = "INSERT INTO Utilizador (nome, numero, pass) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConfig.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, this.nome);
            pstmt.setInt(2, this.numero);
            pstmt.setString(3, this.pass);
            pstmt.executeUpdate();
        }
    }

    public static Utilizador getByNumero(int numero) throws SQLException {
        String sql = "SELECT * FROM Utilizador WHERE numero = ?";
        Utilizador utilizador = null;
        try (Connection conn = DatabaseConfig.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, numero);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                utilizador = new Utilizador();
                utilizador.setNome(rs.getString("nome"));
                utilizador.setNumero(rs.getInt("numero"));
                utilizador.setPass(rs.getString("pass"));
            }
        }
        return utilizador;
    }
}