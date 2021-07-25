
package blockchain.transacao;
import blockchain.Carteira;
import java.util.Calendar;
import java.util.List;

public class TransacaoSimples  extends Transacao{
    public TransacaoSimples(double valorTotal,Carteira origem, Carteira destino){
        super(valorTotal, origem, destino);
        this.concluida = atualizaCarteira();
        this.data = Calendar.getInstance();    
    }

}
    

       