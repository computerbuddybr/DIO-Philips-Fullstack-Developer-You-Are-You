package info.adriana.bootcamp.dominio.model;

import info.adriana.bootcamp.dominio.db.DBConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShowDevModel extends Dev{
    private DBConnect db;

    public ShowDevModel() {
        this.db = new DBConnect();
        this.codigo = 1;
        this.readOneDev(this.codigo);
        this.showDevInfo();

    }

    private void readOneDev(int id){
        try {
            String sql = "SELECT * FROM devs WHERE pk_cod_dev like ?;";
            PreparedStatement stmt = db.conexao.prepareStatement(sql);
            stmt.setInt(1,id);
            ResultSet resultado = stmt.executeQuery(sql);
            while(resultado.next()){
                this.codigo = resultado.getInt("pk_cod_dev");
                this.nome = resultado.getString("nome");
            }

        } catch(SQLException erro){
            System.out.println("Ao tentar ver o dev tivemos o problema: " + erro.getMessage());
        }
    }
    private void bootcampsDoDev(int cod_dev){
        List<Integer> codigos_bootcamp = new ArrayList<>();
        List<Bootcamp> bootcamps = new ArrayList<>();

        Bootcamp bootcampTemp = new Bootcamp();

        int cod_bootcamp;
        try {
            String sql = "SELECT * FROM bootcamps_has_devs WHERE fk_cod_dev like ?;";
            PreparedStatement stmt = db.conexao.prepareStatement(sql);
            stmt.setInt(1, cod_dev);
            ResultSet resultado = stmt.executeQuery(sql);
            while(resultado.next()){
                cod_bootcamp = resultado.getInt("fk_cod_bootcamp");
                codigos_bootcamp.add(cod_bootcamp);
            }

        } catch(SQLException erro){
            System.out.println("Ao tentar ver os códigos do bootcamp tivemos o problema: " + erro.getMessage());
        }
        for (Integer cod:
             codigos_bootcamp) {
            try {
                String sql = "SELECT * FROM bootcamps WHERE pk_cod_bootcamp like ?;";
                PreparedStatement stmt = db.conexao.prepareStatement(sql);
                stmt.setInt(1, cod);
                ResultSet resultado = stmt.executeQuery(sql);
                while(resultado.next()){
                    bootcampTemp.codigo = cod;
                    bootcampTemp.nome = resultado.getString("nome");
                    bootcampTemp.descricao = resultado.getString("descricao");
                    bootcampTemp.dataInicial = resultado.getString("dataInicial");
                    bootcampTemp.dataConclusao = resultado.getString("dataFinal");
                    bootcamps.add(bootcampTemp);
                }

            } catch(SQLException erro){
                System.out.println("Ao tentar ver os códigos do bootcamp tivemos o problema: " + erro.getMessage());
            }
        }
        this.bootcamps.addAll(bootcamps);
    }

    private void showDevInfo(){
        System.out.println("Nome do dev: " + this.nome);
        System.out.println("Bootcamps matriculados: ");
        for (Bootcamp boot:
             this.bootcamps) {
            System.out.println(boot.nome);
        }
    }
}
