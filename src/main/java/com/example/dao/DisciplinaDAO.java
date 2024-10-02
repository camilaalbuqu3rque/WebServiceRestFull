package com.example.dao;

import com.example.model.Disciplina;
import com.example.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DisciplinaDAO {

    // Método para listar todas as disciplinas
    public List<Disciplina> listarDisciplinas() {
        List<Disciplina> disciplinas = new ArrayList<>();
        String sql = "SELECT * FROM disciplinas";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Disciplina disciplina = new Disciplina();
                disciplina.setId(rs.getInt("id"));
                disciplina.setNome(rs.getString("nome"));
                disciplina.setDescricao(rs.getString("descricao"));
                disciplinas.add(disciplina);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return disciplinas;
    }

    // Método para procurar uma disciplina pela chave primária (ID)
    public Disciplina procurarDisciplina(int id) {
        Disciplina disciplina = null;
        String sql = "SELECT * FROM disciplinas WHERE id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                disciplina = new Disciplina();
                disciplina.setId(rs.getInt("id"));
                disciplina.setNome(rs.getString("nome"));
                disciplina.setDescricao(rs.getString("descricao"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return disciplina;
    }

    // Método para inserir uma nova disciplina
    public void inserirDisciplina(Disciplina disciplina) {
        String sql = "INSERT INTO disciplinas (nome, descricao) VALUES (?, ?)";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, disciplina.getNome());
            stmt.setString(2, disciplina.getDescricao());
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para alterar uma disciplina pela chave primária (ID)
    public void alterarDisciplina(Disciplina disciplina) {
        String sql = "UPDATE disciplinas SET nome = ?, descricao = ? WHERE id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, disciplina.getNome());
            stmt.setString(2, disciplina.getDescricao());
            stmt.setInt(3, disciplina.getId());
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para excluir uma disciplina pela chave primária (ID)
    public void excluirDisciplina(int id) {
        String sql = "DELETE FROM disciplinas WHERE id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}