package info.adrianacerdeira.desafioBancoDigital;

public class Poupanca extends Conta{

    public final String TIPO_CONTA = "Poupança";


    public Poupanca(int numeroConta, int agencia, double saldoInicial, Cliente cliente) {
        super(numeroConta, agencia, saldoInicial, cliente);
    }

}
