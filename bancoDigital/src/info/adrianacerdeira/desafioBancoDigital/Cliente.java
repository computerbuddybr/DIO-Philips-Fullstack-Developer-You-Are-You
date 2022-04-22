package info.adrianacerdeira.desafioBancoDigital;

public class Cliente {

    protected String nome;
    protected String cpf;


    public Cliente(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "\nCliente: " + nome +
                " CPF: " + cpf + "\n";
    }
}
