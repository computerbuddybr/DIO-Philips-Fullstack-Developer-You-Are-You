import info.adrianacerdeira.desafioBancoDigital.*;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        //Criação de cliente, conta e bancos dummies para teste
        Cliente cliente = new Cliente("Adriana Cerdeira", "222.333.444-55");
        Corrente contaCorrente = new Corrente(3545, 5589, 15000d, cliente);

        Poupanca contaPoupanca = new Poupanca(3545, 5589, 150000d, cliente);


        BancoExterno bancoExterno1 = new BancoExterno("Itaú", 341, 2222, 5555);
        BancoExterno bancoExterno2 = new BancoExterno("Bradesco", 237, 4444, 8888);

        //Operações dummies para teste
        contaCorrente.sacar(550.50d);
        contaCorrente.depositar(1000.00d);
        contaCorrente.transferirPara(50d, bancoExterno1);
        contaCorrente.traferenciaDe(2548.28d, bancoExterno2);
        contaCorrente.extrato();


        contaPoupanca.sacar(1985.50d);
        contaPoupanca.depositar(20000.00d);
        contaPoupanca.transferirPara(500d, bancoExterno1);
        contaPoupanca.traferenciaDe(2548.28d, bancoExterno2);
        contaPoupanca.extrato();
        //Aplicando o rendimento anual
        System.out.println(contaPoupanca.calcularRendimento());

    }
}
