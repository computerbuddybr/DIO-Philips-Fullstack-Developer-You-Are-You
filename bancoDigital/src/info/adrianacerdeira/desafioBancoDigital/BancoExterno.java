package info.adrianacerdeira.desafioBancoDigital;

public class BancoExterno {
    protected String nomeBanco;
    protected int codigoBanco;
    protected int agencia;
    protected int conta;

    public BancoExterno(String nomeBanco, int codigoBanco, int agencia, int conta) {
        this.nomeBanco = nomeBanco;
        this.codigoBanco = codigoBanco;
        this.agencia = agencia;
        this.conta = conta;
    }

    public String getNomeBanco() {
        return nomeBanco;
    }

    public int getCodigoBanco() {
        return codigoBanco;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getConta() {
        return conta;
    }

    @Override
    public String toString() {
        return "Banco: " + nomeBanco +
                " Código: " + codigoBanco +
                " Agência: " + agencia +
                " Conta: " + conta;
    }
}
