package info.adrianacerdeira.desafioBancoDigital;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

abstract public class Conta {

    private int agencia;
    private int numeroConta;

    //Para questões de histórico das transações
    private double saldoIncial;
    protected double saldo;
    private Cliente cliente;
    private BancoExterno banco;
    private List<Transacao> transacoes = new ArrayList<>();

    protected String tipoConta;


    public Conta(int numeroConta, int agencia, double saldoInicial, Cliente cliente, String tipoConta) {
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldoIncial = saldoInicial;
        this.saldo = saldoInicial;
        this.cliente = cliente;
        this.tipoConta = tipoConta;
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
     * @param identificador
     */
    protected void transferenciaExterna(double valor, TiposTransacao tipo, BancoExterno banco, String identificador) {

        Transacao transacao = new Transacao(valor, this, tipo, identificador);



        transacoes.add(transacao);
    }

    /**
     * Tranferências dentro do próprio banco
     * @param valor
     * @param outraConta
     */
    protected void transferenciaInterna(double valor, Conta outraConta) {

        String identificadorEstaConta = "Transferência para conta: " + outraConta;
        Transacao transacao = new Transacao(valor, this, TiposTransacao.DECRECIMO, identificadorEstaConta);

        String identificadorOutraConta = "Transferência de conta: " + this;

        Transacao transacaoOutraConta = new Transacao(valor, outraConta, TiposTransacao.ACRECIMO, identificadorOutraConta);

        this.transacoes.add(transacao);
        outraConta.transacoes.add(transacaoOutraConta);
    }

    /**
     * Fazendo uma transferência para outro Banco
     * @param valor
     * @param banco
     */
    public void transferirParaOutroBanco(double valor, BancoExterno banco){
        String identificador = "Tranferência para " + banco;
        this.transferenciaExterna(valor, TiposTransacao.DECRECIMO, banco, identificador);
    }

    /**
     * Recebendo uma transferência de Outro Banco
     * @param valor
     * @param banco
     */
    public void traferenciaDeOutroBanco(double valor, BancoExterno banco){
        String identificador = "Transferência de " + banco;
        this.transferenciaExterna(valor, TiposTransacao.ACRECIMO, banco, identificador);
    }

    /**
     * Tranferindo dinheiro para uma conta deste banco
     * @param valor
     * @param outraConta
     */
    public void tranferirParaEsteBanco(double valor, Conta outraConta){
        this.transferenciaInterna(valor, outraConta);

    }


    /**
     * Para mostrar o histórico de transações
     */
    public void extrato() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss");
        String dataEHora = formato.format(LocalDateTime.now());
        System.out.println("/*****/");
        System.out.println(this.cliente);
        System.out.println("/*****/");
        System.out.println("Extrato da conta " + tipoConta + " " + this.numeroConta + " da agência: " + this.agencia + " no dia " + dataEHora + ":");
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

    /**
     * Para poder ser usado no detalhamento do extrato
     * @return
     */
    @Override
    public String toString() {
        return  cliente + " " +
                tipoConta +
                " Agencia: " + agencia +
                " Conta: " + numeroConta;
    }
}
