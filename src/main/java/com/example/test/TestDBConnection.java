package com.example.test;

import com.example.util.DBConnection;

import java.sql.Connection;

public class TestDBConnection {
    public static void main(String[] args) {
        // Obter a conexão usando a classe DBConnection
        Connection conn = DBConnection.getConnection();

        // Verificar se a conexão foi estabelecida com sucesso
        if (conn != null) {
            System.out.println("Conexão estabelecida com sucesso!");
        } else {
            System.out.println("Falha ao conectar.");
        }
    }
}