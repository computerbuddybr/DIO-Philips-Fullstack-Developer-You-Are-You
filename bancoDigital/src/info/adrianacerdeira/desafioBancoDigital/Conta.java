package info.adrianacerdeira.desafioBancoDigital;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

abstract public class Conta {

    protected int agencia;
    protected int numeroConta;

    //Para questões de histórico das transações
    protected double saldoIncial;
    protected double saldo;
    protected Cliente cliente;
    protected BancoExterno banco;
    protected List<Transacao> transacoes = new ArrayList<>();


    public Conta(int numeroConta, int agencia, double saldoInicial, Cliente cliente) {
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldoIncial = saldoInicial;
        this.saldo = saldoInicial;
        this.cliente = cliente;
    }


    /**
     * Fazendo os saques das contas
     *
     * @param valor
     */
    protected void saque(double valor) {
        Transacao transacao = new Transacao(valor, this, TiposTransacao.DECRECIMO, "Saque");
        transacoes.add(transacao);
    }

    public void sacar(double valor) {
        this.saque(valor);
    }

    /**
     * Fazendo os depositos
     *
     * @param valor
     */
    protected void deposito(double valor) {
        Transacao transacao = new Transacao(valor, this, TiposTransacao.ACRECIMO, "Depósito");
        transacoes.add(transacao);
    }

    public void depositar(double valor) {
        this.deposito(valor);
    }

    /**
     * Fazendo transferências
     * @param valor
     * @param tipo
     * @param banco
     */
    protected void transferencia(double valor, TiposTransacao tipo, BancoExterno banco, String identificador) {

        Transacao transacao = new Transacao(valor, this, tipo, identificador);



        transacoes.add(transacao);
    }

    /**
     * Fazendo uma transferência
     * @param valor
     * @param tipo
     * @param banco
     */
    public void transferirPara(double valor, BancoExterno banco){
        String identificador = "Tranferência para " + banco;
        this.transferencia(valor, TiposTransacao.DECRECIMO, banco, identificador);
    }

    /**
     * Recebendo uma transferência
     * @param valor
     * @param tipo
     * @param banco
     */
    public void traferenciaDe(double valor, BancoExterno banco){
        String identificador = "Transferência de " + banco;
        this.transferencia(valor, TiposTransacao.ACRECIMO, banco, identificador);
    }

    /**
     * Para mostrar o histórico de transações
     */
    public void extrato() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss");
        String dataEHora = formato.format(LocalDateTime.now());
        System.out.println(this.cliente);
        System.out.println("Extrato da conta " + this.numeroConta + " da agência: " + this.agencia + " no dia " + dataEHora + ":");
        System.out.println("\\*----------*/");
        System.out.println("Saldo Inicial: R$" + String.format("%.2f", this.saldoIncial));
        System.out.println("\\*----------*/");
        for (Transacao transacao :
                this.transacoes) {
            System.out.println(transacao);
        }
        System.out.println("\\*----------*/");
        System.out.println("Saldo: R$" + String.format("%.2f", this.saldo));
        System.out.println("\\*----------*/");
    }


    //Este é a única propriedade do sistema em que deixei um Setter pela necessidade de alterá-la na classe Transação para evitar duplicação de código. Mas todas as outras busquei usar só Getters para proteger a propriedade de alterações indevidas. E mesmo assim somente onde realmente precisei usar o getter.

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

}
