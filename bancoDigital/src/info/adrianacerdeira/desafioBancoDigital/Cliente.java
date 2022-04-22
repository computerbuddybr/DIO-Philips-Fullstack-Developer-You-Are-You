package info.adrianacerdeira.desafioBancoDigital;

public class Cliente {

    protected String nome;
    protected String cpf;


    public Cliente(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Cliente: " + nome +
                " CPF: " + cpf;
    }
}
