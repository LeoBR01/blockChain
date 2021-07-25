
package blockchain.transacao;

import blockchain.Carteira;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class PagamentoParcelado extends Transacao {
    private int numeroParcelas;
    private List<Double> valorParcelas;
    private List<Calendar> datasParcelas;

    public PagamentoParcelado(double valorTotal, Carteira origem, Carteira destino,int numeroParcelas) {
        super(valorTotal, origem, destino);
        this.numeroParcelas = numeroParcelas;
        this.datasParcelas = new ArrayList<Calendar>();
        this.valorParcelas = new ArrayList<Double>();
        this.gerarBoleto();
        this.gerarValores();
        this.concluida = atualizaCarteiraParcelado();
       
    }
    
    private void gerarBoleto(){
        Calendar c = Calendar.getInstance();
        for(int i = 0 ; i < this.numeroParcelas; i++){
            Calendar cloneC = (Calendar) c.clone();
            datasParcelas.add(cloneC);
            c.add(Calendar.MONTH,1);
        }
        } 

    private void gerarValores(){
       double parcelas = this.getValorTotal()/this.numeroParcelas;
       for (int i =0; i < this.numeroParcelas ; i++){
           valorParcelas.add(this.valorTotal/this.numeroParcelas);
       }
    }
    
    
    private boolean atualizaCarteiraParcelado(){
        if (this.getOrigem().getSaldo() >= this.valorTotal){
            for (int i = 0 ; i < this.numeroParcelas ; i++){
                this.setData(this.getDatasParcelas().get(i));
                valorTotal = this.valorParcelas.get(i);
                atualizaCarteira();
            }
        }else{
            System.out.println("Saldo insuficiente para pagamento");
        }
        return false;
    }
    
    public int getNumeroParcelas() {
        return numeroParcelas;
    }

    public void setNumeroParcelas(int numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }

    public List<Double> getValorParcelas() {
        return valorParcelas;
    }

    public void setValorParcelas(List<Double> valorParcelas) {
        this.valorParcelas = valorParcelas;
    }

    public List<Calendar> getDatasParcelas() {
        return datasParcelas;
    }

    public void setDatasParcelas(List<Calendar> datasParcelas) {
        this.datasParcelas = datasParcelas;
    }
    
   
}
