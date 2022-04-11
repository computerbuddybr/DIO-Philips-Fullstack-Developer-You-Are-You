package info.adriana.bootcamp.dominio.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectAzure extends DBConnection {


    public DBConnectAzure() {
        try{

            final String URL = "jdbc:sqlserver://localhost;database=boot_dio";
            final String cadeia = "Server=localhost;Database=boot_dio;Trusted_Connection=True;";
            final String USUARIO = "boot_dio";
            final String SENHA = "dio";

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
