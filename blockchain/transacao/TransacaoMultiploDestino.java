
package blockchain.transacao;

import blockchain.Carteira;
import java.util.List;

public class TransacaoMultiploDestino extends Transacao {
    private List<Carteira> vetorCarteira;
    private List<Double> vetorValores;
    
    public TransacaoMultiploDestino(List<Carteira> vetorCarteira, List<Double> vetorValores, Carteira origem) {
        super(0 , origem , null);
        this.vetorCarteira = vetorCarteira;
        this.vetorValores = vetorValores;
        this.concluida = atualizaCarteira(vetorValores,vetorCarteira,origem);
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

    public boolean atualizaCarteira(List<Double> vetorValores, List<Carteira> vetorCarteira, Carteira origem) {
        int i;
        for (i = 0; i <  this.getVetorValores().size() ; i ++){
            this.destino = this.getVetorCarteira().get(i);
            this.valorTotal = this.getVetorValores().get(i);
            atualizaCarteira();
        }
        return true;
    }
    
    
}
