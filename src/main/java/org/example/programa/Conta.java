package org.example.programa;

import org.example.utilitarios.Utils;

public class Conta {

    private static int contadorDeContas = 1;

    private int numeroConta;
    private Pessoa pessoa;
    private Double saldo = 0.0;

    public Conta(Pessoa pessoa) {
        this.numeroConta = contadorDeContas;
        this.pessoa = pessoa;
        contadorDeContas++;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String toString(){
        return "\nNúmero da Conta: " + this.getNumeroConta() +
        "\nNome: " + this.pessoa.getNome() +
        "\nCpf: " + this.pessoa.getCpf() +
        "\nEmail: " + this.pessoa.getEmail() +
        "\nSaldo: " + Utils.doubleToString(this.getSaldo()) +
        "\n";
    }

    public void depositar(Double valor){
        if (valor > 0){
            setSaldo(getSaldo() + valor);
            System.out.println("Seu deposito foi realizado com sucesso!");
        }else {
            System.out.println("Não é possivel concluir o deposito!");
        }
    }

    public void sacar(Double valor){
        if (valor > 0 && this.getSaldo() >= valor){
            setSaldo(getSaldo() - valor);
            System.out.println("O seu saque foi realizado, parabéns!");
        }else {
            System.out.println("Não foi possivel concluir o saque, tente novamente!");
        }
    }

    public void tranferir(Conta contaParaDeposito, double valor){
        if (valor > 0 && this.getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);

            contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
            System.out.println("A sua transferência foi realizada, parabéns!");
        }else {
            System.out.println("Não foi possivel concluir a transferência, tente novamente!");
        }
    }
}
