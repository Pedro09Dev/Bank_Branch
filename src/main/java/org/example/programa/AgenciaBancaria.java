package org.example.programa;

import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaBancaria {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;

    public static void main(String[] args) {
        contasBancarias = new ArrayList<Conta>();
        operacoes();
    }

    public static void operacoes(){
        System.out.println("-------------------------------------------");
        System.out.println("--------------BR AGÊNCIA PG.US-------------");
        System.out.println("-------------------------------------------");
        System.out.println("***** Selecione abaixo uma operação!! *****");
        System.out.println("-------------------------------------------");
        System.out.println("|   Tecle 1 =  Criar conta   |");
        System.out.println("|   Tecle 2 =  Depositar     |");
        System.out.println("|   Tecle 3 =  Sacar         |");
        System.out.println("|   Tecle 4 =  Transferir    |");
        System.out.println("|   Tecle 5 =  Listar        |");
        System.out.println("|   Tecle 6 =  Encerrar      |");

        int operacao = sc.nextInt();

        switch (operacao) {
            case 1:
                criarConta();
                break;
            case 2:
                depositar();
                break;
            case 3:
                sacar();
                break;
            case 4:
                transferir();
                break;
            case 5:
                listarContas();
                break;

            case 6:
                System.out.println("Encerrando o banco, te espero na próxima!");
                System.exit(0);

            default:
                System.out.println("Esta opção é invalida, tente novamente!");
                operacoes();
                break;

        }

    }

    public static void criarConta(){

        System.out.println("\nNome: ");
        String nome = sc.next();

        System.out.println("\nCpf: ");
        String cpf = sc.next();

        System.out.println("\nEmail: ");
        String email = sc.next();

        Pessoa pessoa = new Pessoa(nome, cpf, email);

        Conta conta = new Conta(pessoa);

        contasBancarias.add(conta);
        System.out.println("Sua conta foi registrada! Seja bem vindo!");

        operacoes();
    }

    private static Conta encontrarConta(int numeroConta){
        Conta conta = null;
        if (contasBancarias.size() > 0){
            for (Conta c: contasBancarias){
                if (c.getNumeroConta() == numeroConta){
                    conta = c;
                }
            }
        }
        return conta;
    }

    public static void depositar(){
        System.out.println("Número da conta: ");
        int numeroConta = sc.nextInt();

        Conta conta = encontrarConta(numeroConta);

        if (conta != null){
            System.out.println("Qual valor o Sr.(a) deseja depositar: ");
            double valorDeposito = sc.nextDouble();
            conta.depositar(valorDeposito);
            System.out.println("O seu valor foi concluido, até breve!");
        }else {
            System.out.println("Valor não foi concluido, pois a conta não foi localizada!");
        }
        operacoes();

    }

    public static void sacar(){
        System.out.println("Número da conta: ");
        int numeroConta = sc.nextInt();

        Conta conta = encontrarConta(numeroConta);

        if (conta != null){
            System.out.println("Qual valor o Sr.(a) deseja sacar: ");
            double valorSacar = sc.nextDouble();
            conta.sacar(valorSacar);
            System.out.println("O seu saque foi concluido, até breve!");
        }else {
            System.out.println("O seu saque não foi concluido, pois a conta não foi localizada!");
        }
        operacoes();
    }

    public static void transferir(){
        System.out.println("Conta(Número) do remetente: ");
        int numeroContaRemetente = sc.nextInt();

        Conta contaRemetente = encontrarConta(numeroContaRemetente);

        if (contaRemetente != null){
            System.out.println("Conta(Número) do destinatário: ");
            int numeroContaDestinatario = sc.nextInt();

            Conta contaDestinatario = encontrarConta(numeroContaDestinatario);

            if (contaDestinatario != null){
                System.out.println("Qual valor o Sr(a). deseja depositar: ");
                double valor = sc.nextDouble();

                contaRemetente.tranferir(contaDestinatario, valor);
            }else {
                System.out.println("A conta para transferência do deposito não foi localizada :(");
            }
        }else {
            System.out.println("A conta para a transferência não foi localizada :(");
        }
        operacoes();
    }

    public static void listarContas(){
        if (contasBancarias.size() > 0){
            for (Conta conta: contasBancarias){
                System.out.println(conta);
            }
        }else {
            System.out.println("Não foi possivel localizar as contas cadastradas!!");
        }
        operacoes();
    }
}

