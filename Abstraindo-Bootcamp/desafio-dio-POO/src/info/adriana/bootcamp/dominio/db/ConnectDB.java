package info.adriana.bootcamp.dominio.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectDB {

    public Connection conexao;

    public ConnectDB() {
        try{

            final String URL = "jdbc:mysql://localhost:3306/bootcamp_dio";
            final String USUARIO = "root";
            final String SENHA = "root";

            this.conexao = DriverManager.getConnection(URL, USUARIO, SENHA);

            System.out.println("Conexão feita com sucesso");

        } catch (SQLException erro){
            System.out.println("Ao tentar conectar tive o seguinte erro: " + erro.getMessage());
        }
    }

    public void fecharConexao() {
        try{
            this.conexao.close();
        } catch(SQLException erro){
            System.out.println("Ao fechar a conexão aconteceu o seguinte: " + erro.getMessage());
        }

    }
}
