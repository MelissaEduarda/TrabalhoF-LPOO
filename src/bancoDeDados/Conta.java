package bancoDeDados;

import java.time.LocalDate;
import javax.swing.JOptionPane;

public class Conta {

    private double saldo;
    private String humano, cpf, historico = "", senha;
    private int id;
    private LocalDate data;

    public Conta(String humano, String cpf, String senha) {
        this.humano = humano;
        this.cpf = cpf;
        this.senha = senha;
    }

    public String getHumano() {
        return humano;
    }

    public void setHumano(String humano) {
        this.humano = humano;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public boolean Sacar(double saca) {
        if (saca > this.saldo) {
            JOptionPane.showMessageDialog(null, "Saque execedeu o valor máxim Saldo: R$" + this.getSaldo() + " Saque: R$" + saca, "Alerta!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        this.saldo -= saca;
        this.historico += "\nSaque concluido! R$" + saca + " foram retirados";
        return true;
    }

    public boolean Deposito(double deposito) {
        if (deposito < 0) {
            JOptionPane.showMessageDialog(null, "Valor indisponivel!", "Alerta!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        this.saldo += deposito;
        this.historico += "\nDeposito feito! R$" + deposito + " foram adicionados a conta";
        return true;
    }

    public void Transferencia(Conta a, double deposito) {
        this.Sacar(deposito);
        a.Deposito(deposito);
        this.historico += "\nTransferencia realizada com sucesso! R$" + deposito + " foram transferidos para " + a.getHumano();
        a.historico += "Transferência feita com sucesso! R$" + deposito + " foram recebidos de " + this.getHumano();
    }

    @Override
    public String toString() {
        return "Titular:" + this.getHumano() + "\nId:" + this.getId() + "\nCpf:" + this.getCpf() + "\nSaldo: R$" + this.getSaldo() + "\nData de inscrição: " + this.getData() + "\n\n";
    }
}
