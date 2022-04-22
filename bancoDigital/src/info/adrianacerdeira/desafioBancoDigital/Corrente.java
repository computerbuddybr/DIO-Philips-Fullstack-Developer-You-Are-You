package info.adrianacerdeira.desafioBancoDigital;

public class Corrente extends Conta {


    public Corrente(int numeroConta, int agencia, double saldoInicial, Cliente cliente) {
        super(numeroConta, agencia, saldoInicial, cliente, "Conta Corrente");
    }

}
