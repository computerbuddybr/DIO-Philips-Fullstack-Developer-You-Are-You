import info.adrianacerdeira.desafioBancoDigital.BancoExterno;
import info.adrianacerdeira.desafioBancoDigital.Cliente;
import info.adrianacerdeira.desafioBancoDigital.Corrente;
import info.adrianacerdeira.desafioBancoDigital.TiposTransacao;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        Cliente cliente = new Cliente("Adriana Cerdeira", "222.333.444-55");
        Corrente contaCorrente = new Corrente(3545, 5589, 15000d, cliente);
        BancoExterno bancoExterno1 = new BancoExterno("Itaú", 341, 2222, 5555);
        BancoExterno bancoExterno2 = new BancoExterno("Bradesco", 237, 4444, 8888);

        contaCorrente.sacar(550.50d);
        contaCorrente.depositar(1000.00d);
        contaCorrente.transferirPara(50d, bancoExterno1);
        contaCorrente.traferenciaDe(2548.28d, bancoExterno2);
        contaCorrente.extrato();

    }
}
