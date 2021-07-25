
package blockchain.transacao;

import blockchain.Carteira;
import java.util.List;

public class TransacaoMultiplaOrigem extends Transacao {
    private List<Carteira> vetorCarteira;
    private List<Double> vetorValores;
    
    public TransacaoMultiplaOrigem(List<Carteira> vetorCarteira, List<Double> vetorValores, Carteira destino) {
        super(0 ,null , destino);
        this.vetorCarteira = vetorCarteira;
        this.vetorValores = vetorValores;
        this.concluida = atualizaCarteira(vetorValores,vetorCarteira,destino);
    }
    
    public List<Carteira> getVetorCarteira() {
        return vetorCarteira;
    }

    public void setVetorCarteira(List<Carteira> vetorCarteira) {
        this.vetorCarteira = vetorCarteira;
    }

    public List<Double> getVetorValores() {
        return vetorValores;
    }

    public void setVetorValores(List<Double> vetorValores) {
        this.vetorValores = vetorValores;
    }

    public boolean atualizaCarteira(List<Double> vetorValores, List<Carteira> vetorCarteira, Carteira destino) {
        int i;
        for (i = 0; i <  this.getVetorValores().size() ; i ++){
            this.origem = this.getVetorCarteira().get(i);
            this.valorTotal = this.getVetorValores().get(i);
            atualizaCarteira();
        }
        return true;
    }
    
    
}
