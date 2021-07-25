
package blockchain.transacao;
    
import blockchain.Carteira;


public class PagamentoExterno extends Transacao {
    
    public PagamentoExterno(double valorTotal, Carteira destino) {
        super(valorTotal, null , destino);
        this.concluida = atualizarCarteiraExterna();
    }
    
    private boolean atualizarCarteiraExterna(){
        System.out.println(toString());
        return this.getDestino().credita(valorTotal);
    }

    @Override
    public String toString() {
        return "Pagamento externo para carteira de " + this.getDestino().getUsuario().getNome() + " no valor de " + this.valorTotal + " EC";
    }
    
}
