package blockchain;

import java.util.Calendar;


public class Carteira {
    private Usuario usuario;
    private double saldo;
    private Calendar dataAtualizacao;
    
    // Método Construtor
    public Carteira(Usuario usuario) {
        this.usuario = usuario;
        this.saldo = 100;
        this.dataAtualizacao = null;
    }
    
    // Métodos Especiais

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Calendar getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Calendar dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
    
    // Métodos 
    
    public boolean credita(double valor){   //COLOCAR DINHEIRO
            this.setSaldo(this.getSaldo() + valor);
            return true;
        }
    
    public boolean debita(double valor){ // RETIRAR DINHEIRO
        if (valor > this.getSaldo()){ 
            System.out.println("------ Saldo Insuficiente ------");
            return false;
        }else{
            this.setSaldo(this.getSaldo() - valor);
            return true;
        }
      }
    
    public void mostrarSaldo(){
        System.out.println("Usuario: " + this.getUsuario().getNome());
        System.out.println("Seu saldo é de: " + this.getSaldo() + " EC");
    }
    
}
