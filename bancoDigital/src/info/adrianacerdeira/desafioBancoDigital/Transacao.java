package info.adrianacerdeira.desafioBancoDigital;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transacao {
    private final TiposTransacao TIPO;
    private final double VALOR;

    private final String SINAL;

    private final String DATA_E_HORA;

    private String identificador;



    /**
     * O construtor já vai criar a transação completa
     * @param valor
     * @param conta
     * @param tipo
     * @param identificador
     */
    public Transacao(double valor, Conta conta, TiposTransacao tipo, String identificador){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss");
        this.DATA_E_HORA = formato.format(LocalDateTime.now());
        this.VALOR = valor;
        this.TIPO = tipo;
        this.identificador = identificador;
        this.SINAL = this.realizaTransacao(conta);

    }

    /**
     * Função que vai lidar com decidir qual o tipo da transação e aplicá-la ao saldo da Conta
     * @param conta
     */
    public String realizaTransacao(Conta conta){
        if(this.TIPO == TiposTransacao.ACRECIMO){
            conta.setSaldo(conta.getSaldo() + this.VALOR);
            return "+";
        }
        if(this.TIPO == TiposTransacao.DECRECIMO){
            conta.setSaldo(conta.getSaldo() - this.VALOR);
            return "-";
        }
        return "Operação inválida";

    }


    @Override
    public String toString() {
        return DATA_E_HORA + " - " + identificador + ": " + SINAL + " R$" + String.format("%.2f",VALOR);
    }
}
