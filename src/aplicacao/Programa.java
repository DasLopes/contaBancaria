package aplicacao;

import java.util.Locale;
import java.util.Scanner;

import entidade.Conta;
import entidade.Excecao;

public class Programa {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner teclado = new Scanner(System.in);

        System.out.println("Dados da conta:");
        System.out.print("Número: ");
        int numero = teclado.nextInt();
        teclado.nextLine();
        System.out.print("Nome: ");
        String nome = teclado.nextLine();
        System.out.print("Deposito inicial: ");
        double deposito = teclado.nextDouble();
        System.out.print("Limite de saque: ");
        double limiteSaque = teclado.nextDouble();

        Conta conta = new Conta(numero, nome, deposito, limiteSaque);
        
        System.out.println();
        System.out.print("Digite um valor para saque: ");
        double saque = teclado.nextDouble();               

        try {
            conta.saque(saque);
            System.out.printf("Novo saldo: %.2f", conta.getSaldo());
        } catch (Excecao e) {
            System.out.println(e.getMessage());
        }
        teclado.close();
    }
}
