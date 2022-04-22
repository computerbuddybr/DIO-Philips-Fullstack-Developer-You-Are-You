package info.adrianacerdeira.desafioBancoDigital;

public class Corrente extends Conta {
    public final String TIPO_CONTA = "Corrente";

    public Corrente(int numeroConta, int agencia, double saldoInicial, Cliente cliente) {
        super(numeroConta, agencia, saldoInicial, cliente);
    }

}
