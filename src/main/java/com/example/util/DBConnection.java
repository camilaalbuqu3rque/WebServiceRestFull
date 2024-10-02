package com.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.io.InputStream;

public class DBConnection {

    // Método para obter a conexão com o banco de dados
    public static Connection getConnection() {
        Connection conn = null;
        try {
            // Carregar o arquivo db.properties
            InputStream input = DBConnection.class.getClassLoader().getResourceAsStream("db.properties");
            if (input == null) {
                System.out.println("Não foi possível encontrar o arquivo db.properties");
                return null;
            }

            Properties prop = new Properties();
            prop.load(input);

            // Obter os parâmetros do arquivo db.properties
            String url = prop.getProperty("db.url");
            String user = prop.getProperty("db.user");
            String password = prop.getProperty("db.password");

            // Verificar se a URL está corretamente definida
            if (url == null || url.isEmpty()) {
                throw new IllegalArgumentException("A URL do banco de dados não pode ser nula ou vazia.");
            }

            // Carregar o driver do PostgreSQL explicitamente (caso necessário)
            Class.forName("org.postgresql.Driver");

            // Estabelecer a conexão com o banco de dados
            conn = DriverManager.getConnection(url, user, password);

        } catch (Exception e) {
            e.printStackTrace();  // Imprimir o erro no console para facilitar a depuração
        }
        return conn;  // Retornar o objeto Connection
    }
}
