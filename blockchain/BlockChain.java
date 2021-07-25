
package blockchain;

import blockchain.transacao.PagamentoExterno;
import blockchain.transacao.PagamentoParcelado;
import blockchain.transacao.TransacaoMultiplaOrigem;
import blockchain.transacao.Transacao;
import blockchain.transacao.TransacaoMultiploDestino;
import blockchain.transacao.TransacaoSimples;
import java.util.ArrayList;
import java.util.List;

public class BlockChain {

    public static void main(String[] args) {
        //Criando os usuarios 
        
        Usuario u1 = new Usuario("Leonardo",1,"111.111.111-11");
        u1.mostrarDados();
        Usuario u2 = new Usuario("Daniel",2,"222.222.222-22");
        u2.mostrarDados();
        Usuario u3 = new Usuario("Andre",3,"333.333.333-33" );
        u3.mostrarDados();
        Usuario u4 = new Usuario("Pablo",4,"444.444.444-44");
        
        System.out.println("");
        
        //Exibindo as carteiras antes das transferencias
        Carteira c1 = new Carteira(u1);
        Carteira c2 = new Carteira(u2);
        Carteira c3 = new Carteira(u3);
        Carteira c4 = new Carteira(u4);
        
        System.out.println("");
        
        //Criando os vetoresCarteira e Valores
        List<Carteira> vetorCarteira = new ArrayList<Carteira>();
        vetorCarteira.add(c1);
        vetorCarteira.add(c2);
        vetorCarteira.add(c3);
        
        List<Double> vetorValores = new ArrayList<Double>();
        vetorValores.add(20.50);
        vetorValores.add(40.00);
        vetorValores.add(17.00);
               
        // Mostrando Saldo antes das transações
        c1.mostrarSaldo();
        c2.mostrarSaldo();
        c3.mostrarSaldo();
        c4.mostrarSaldo();
        
        System.out.println("");
        
        // Começando as transações
        Transacao t1 = new TransacaoSimples(20,c1,c2);
        Transacao t2 = new TransacaoSimples(200,c3,c2);
        Transacao t3 = new TransacaoSimples(20,c3,c1);
        Transacao t4 = new TransacaoMultiplaOrigem(vetorCarteira, vetorValores, c4);
        Transacao t5 = new PagamentoParcelado(100, c4, c1, 5);
        Transacao t6 = new PagamentoExterno(1000,c2);
        Transacao t7 = new TransacaoMultiploDestino(vetorCarteira, vetorValores, c2);
       

        System.out.println("");
        
        // Mostrando Saldo após as transações
        c1.mostrarSaldo();
        c2.mostrarSaldo();
        c3.mostrarSaldo();
        c4.mostrarSaldo();
       
        System.out.println("");
    }
    
}

