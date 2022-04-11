package info.adriana.bootcamp.dominio.model;

import info.adriana.bootcamp.dominio.db.DBConnect;
import info.adriana.bootcamp.dominio.db.DBConnectAzure;
import info.adriana.bootcamp.dominio.db.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Classe que será estendida pelas classes de DB para fazer as ações de DB
 */
public class DBContent {
    protected DBConnection db;
    protected ResultSet resultado;

    /**
     * Construtor vai iniciar uma nova conexão com a DB
     */
    DBContent(String whichDB){
        if(whichDB.equals("mysql")){
            this.db = new DBConnect();
        } else if(whichDB.equals("azure")) {
            this.db = new DBConnectAzure();
        }

    }

    /**
     * Para poder fechar a conexão à DB
     */
    protected void fecharConexao(){
        this.db.fecharConexao();
    }


    protected Boolean create(){
        //TODO:Vai criar uma nova entrada e retornar se deu certo ou não

        return true;
    }

    /**
     * Para ler todos os registros de uma tabela e inserí-los na propriedade resultado
     * @param table
     * @return
     */
    protected Boolean readAll(String table){
        ResultSet resultado;
        try {
            String sql = "SELECT * FROM ?;";
            PreparedStatement stmt = db.conexao.prepareStatement(sql);
            stmt.setString(1, table);
            this.resultado = stmt.executeQuery(sql);
            return true;

        } catch(SQLException erro){
            System.out.println("Ao tentar ver todos os registros tivemos o problema: " + erro.getMessage());
            return false;
        }


    }

    /**
     * Para ler todos as colunas de um registro específico de uma tabela e inserí-los na propriedade resultado
     * @param table
     * @param identifier
     * @param identifierID
     * @return
     */
    protected Boolean readOnde(String table, String identifier, String identifierID){

        ResultSet resultado;
        try {
            String sql = "SELECT * FROM ? WHERE ? LIKE ?;";
            PreparedStatement stmt = db.conexao.prepareStatement(sql);
            stmt.setString(1, table);
            stmt.setString(2, identifier);
            stmt.setString(3, identifierID);
            this.resultado = stmt.executeQuery(sql);
            return true;

        } catch(SQLException erro){
            System.out.println("Ao tentar ver um registro tivemos o problema: " + erro.getMessage());
            return false;
        }
    }

    /**
     * Para atualizar um registro de uma tabela
     * @param table
     * @param column
     * @param newValue
     * @param identifier
     * @param identifierID
     * @return
     */
    protected Boolean update(String table, String column, String newValue, String identifier, String identifierID){

        try {
            String sql = "UPDATE ? SET ?=?  WHERE ? LIKE ?;";
            PreparedStatement stmt = db.conexao.prepareStatement(sql);
            stmt.setString(1, table);
            stmt.setString(2, column);
            stmt.setString(3, newValue);
            stmt.setString(4, identifier);
            stmt.setString(5, identifierID);
            stmt.execute();
            if(stmt.executeUpdate() > 0){
                return true;
            } else {
                throw new SQLException("A base não atualizou, checar porque");
            }


        } catch(SQLException erro){
            System.out.println("Ao tentar atualizar tivemos o problema: " + erro.getMessage());
            return false;
        }

    }

    /**
     * Para apagar um registro de uma tabela
     * @param table
     * @param identifier
     * @param identifierID
     * @return
     */
    protected Boolean delete(String table, String identifier, String identifierID){

        try {
            String sql = "DELETE FROM ? WHERE ? LIKE ?;";
            PreparedStatement stmt = db.conexao.prepareStatement(sql);
            stmt.setString(1, table);
            stmt.setString(2, identifier);
            stmt.setString(3, identifierID);
            stmt.execute();
            if(stmt.executeUpdate() > 0){
                return true;
            } else {
                throw new SQLException("O registro não apagou, checar porque");
            }


        } catch(SQLException erro){
            System.out.println("Ao tentar apagar tivemos o problema: " + erro.getMessage());
            return false;
        }

    }

    /**
     * Procura os cursos dependendo do id do dev e devolve todas as informações
     * @param id
     * @return
     */
    protected Boolean procurarCursosDoDev(int id){
        ResultSet resultado;
        try {
            String sql = "SELECT * FROM devs_has_cursos  INNER JOIN devs on devs_has_cursos.fk_cod_dev = devs.pk_cod_dev INNER JOIN cursos on cursos.pk_cod_curso=devs_has_cursos.fk_cod_curso WHERE devs.pk_cod_dev=?;";
            PreparedStatement stmt = db.conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            this.resultado = stmt.executeQuery(sql);
            return true;

        } catch(SQLException erro){
            System.out.println("Ao tentar ver um registro tivemos o problema: " + erro.getMessage());
            return false;
        }
    }

    /**
     * Procura os bootcamps dependendo do id do dev e devolve todas as informações
     * @param id
     * @return
     */
    protected Boolean procurarBootcampsDoDev(int id){
        ResultSet resultado;
        try {
            String sql = "SELECT * FROM devs_has_bootcamps  INNER JOIN devs on devs_has_bootcamps.fk_cod_dev = devs.pk_cod_dev INNER JOIN bootcamps on bootcamps.pk_cod_bootcamp=devs_has_bootcamps.fk_cod_bootcamp WHERE devs.pk_cod_dev=?;";
            PreparedStatement stmt = db.conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            this.resultado = stmt.executeQuery(sql);
            return true;

        } catch(SQLException erro){
            System.out.println("Ao tentar ver um registro tivemos o problema: " + erro.getMessage());
            return false;
        }
    }

    /**
     * Procura as mentorias dependendo do id do dev e devolve todas as informações
     * @param id
     * @return
     */
    protected Boolean procurarMentoriasDoDev(int id){
        ResultSet resultado;
        try {
            String sql = "SELECT * FROM devs_has_mentorias  INNER JOIN devs on devs_has_mentorias.fk_cod_dev = devs.pk_cod_dev INNER JOIN mentorias on mentorias.pk_cod_mentoria=devs_has_mentorias.fk_cod_mentoria WHERE devs.pk_cod_dev=?;";
            PreparedStatement stmt = db.conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            this.resultado = stmt.executeQuery(sql);
            return true;

        } catch(SQLException erro){
            System.out.println("Ao tentar ver um registro tivemos o problema: " + erro.getMessage());
            return false;
        }
    }

    /**
     * Procura os devs de um certo Bootcamp
     * @param id
     * @return
     */
    protected Boolean procurarDevsDeBootcamp(int id){
        ResultSet resultado;
        try {
            String sql = "SELECT * FROM devs_has_bootcamps  INNER JOIN bootcamps on devs_has_bootcamps.fk_cod_bootcamp = bootcamps.pk_cod_bootcamp INNER JOIN devs on devs.pk_cod_dev=devs_has_bootcamps.fk_cod_dev WHERE bootcamps.pk_cod_bootcamp=?;";
            PreparedStatement stmt = db.conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            this.resultado = stmt.executeQuery(sql);
            return true;

        } catch(SQLException erro){
            System.out.println("Ao tentar ver um registro tivemos o problema: " + erro.getMessage());
            return false;
        }
    }

    /**
     * Procura os cursos de um certo Bootcamp
     * @param id
     * @return
     */
    protected Boolean procurarCursosDeBootcamp(int id){
        ResultSet resultado;
        try {
            String sql = "SELECT * FROM bootcamps_has_cursos  INNER JOIN bootcamps on bootcamps_has_cursos.fk_cod_bootcamp = bootcamps.pk_cod_bootcamp INNER JOIN cursos on cursos.pk_cod_curso=bootcamps_has_cursos.fk_cod_curso WHERE bootcamps.pk_cod_bootcamp=?;";
            PreparedStatement stmt = db.conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            this.resultado = stmt.executeQuery(sql);
            return true;

        } catch(SQLException erro){
            System.out.println("Ao tentar ver um registro tivemos o problema: " + erro.getMessage());
            return false;
        }
    }
    /**
     * Procura os mentorias de um certo Bootcamp
     * @param id
     * @return
     */
    protected Boolean procurarMentoriasDeBootcamp(int id){
        ResultSet resultado;
        try {
            String sql = "SELECT * FROM bootcamps_has_mentorias  INNER JOIN bootcamps on bootcamps_has_mentorias.fk_cod_bootcamp = bootcamps.pk_cod_bootcamp INNER JOIN mentorias on mentorias.pk_cod_mentoria=bootcamps_has_mentorias.fk_cod_mentoria WHERE bootcamps.pk_cod_bootcamp=?;";
            PreparedStatement stmt = db.conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            this.resultado = stmt.executeQuery(sql);
            return true;

        } catch(SQLException erro){
            System.out.println("Ao tentar ver um registro tivemos o problema: " + erro.getMessage());
            return false;
        }
    }

}
