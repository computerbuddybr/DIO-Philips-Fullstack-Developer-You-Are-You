package info.adrianacerdeira.desafioBancoDigital;

public class Poupanca extends Conta{
    private double interesse = 11.75d;




    public Poupanca(int numeroConta, int agencia, double saldoInicial, Cliente cliente) {
        super(numeroConta, agencia, saldoInicial, cliente, "Conta Poupança");
    }

    /**
     * Ao contrário da Conta Corrente a poupança tem rendimentos. Então seria algo implementado somente nestá classe.
     */
    public String calcularRendimento(){
        this.saldo = this.saldo + (this.saldo*interesse/100);
        return "\n\\***************\\\nApós a aplicação do rendimento anual o saldo ficou em: R$" + String.format("%.2f", this.saldo) + "\n\\***************\\\n";
    }

}
