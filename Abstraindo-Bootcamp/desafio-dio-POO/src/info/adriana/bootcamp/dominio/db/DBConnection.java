package info.adriana.bootcamp.dominio.db;

import java.sql.Connection;

abstract public class DBConnection {
    public Connection conexao;
    abstract public void fecharConexao();
}
