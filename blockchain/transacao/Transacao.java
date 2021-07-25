
package blockchain.transacao;

import blockchain.Carteira;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public abstract class Transacao {
    protected double valorTotal;
    protected Calendar data;
    protected Carteira origem;
    protected Carteira destino;
    protected boolean concluida;

    public Transacao(double valorTotal, Carteira origem, Carteira destino) {
        this.valorTotal = valorTotal;
        this.origem = origem;
        this.destino = destino;
        this.concluida = true;
        this.data = Calendar.getInstance();
        System.out.println("\n--------"+ this.getClass().getName().replace(this.getClass().getPackageName() + ".", " ") + " -------- ");
    }
    
    //Metodos Abstratos
    
    public String toString(){
        return ("Transferencia de " + this.getOrigem().getUsuario().getNome() + " para " + this.getDestino().getUsuario().getNome() 
                + " no valor de " + this.getValorTotal() +" EC "+ " na data de " + this.data.getTime());
    }
    
    
    protected boolean atualizaCarteira(){
        this.setOrigem(origem);
        if (this.getOrigem().getSaldo() >= valorTotal){
          this.getOrigem().debita(valorTotal);
          this.getDestino().credita(valorTotal);
          this.setValorTotal(valorTotal);
          this.setConcluida(true);
          System.out.println(this.toString());
      } else{
          System.out.println("----------------Saldo Insuficiente----------------");
          this.setConcluida(false);
      }
        return true;
      }
        
    // Métodos Especiais
    public double getValorTotal() {   
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public Carteira getOrigem() {
        return origem;
    }

    public void setOrigem(Carteira origem) {
        this.origem = origem;
    }

    public Carteira getDestino() {
        return destino;
    }

    public void setDestino(Carteira destino) {
        this.destino = destino;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }
                
    
}
