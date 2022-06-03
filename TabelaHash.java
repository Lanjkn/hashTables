
package SEMANA10;


import java.util.Random;

public class TabelaHash {
    
    private int tamanho;
    private int numeroDeColisao;
    
    private NodeDaTabela [] tabela;
    
    public TabelaHash(int tamanho){
        
        this.tamanho = tamanho;
        this.numeroDeColisao = 0;
        this.tabela = new NodeDaTabela[ this.tamanho ];
        // precisa inicializar cada elemento da tabela.
        // a fazer.

        preencheTabela(0);
    }

    public void preencheTabela(int aux){
        if (tamanho > aux){
           tabela[aux] = new NodeDaTabela();
           preencheTabela(aux+1);
        }
    }


    public void busca(int chave){
        int index = funcaoHash(chave);
        if(tabela[index].pegaChave() != chave){
            if (tabela[index].pegaLista().encontrar(new NoDaLista(chave)) != null) {
                System.out.println("O item " + chave + " existe na lista!");
                return;
            }
        }
        System.out.println("O item " + chave + " não existe na lista!");
    }


    public void insere(int chave){
        int index = funcaoHash(chave);
        if(tabela[index].pegaChave() == -1){
            tabela[index].mudaChave(chave);
        } else {
            tabela[index].pegaLista().insereOrdenado(chave);
            numeroDeColisao++;
        }


    }
    public void imprimir(){
        for(int i = 0; i < tamanho; i++){
            if(tabela[i].pegaChave() != -1){
                System.out.println("Index " + i + " :[" + tabela[i].pegaChave() + "] > "+ tabela[i].pegaLista().toString());
            }
        }
        System.out.println("Houveram " + numeroDeColisao + " Coalisões");

    }

    private static TabelaHash experimento(int tamanhoTabela, int numeroDeChave, int tamanhoMax){
        TabelaHash th = new TabelaHash(tamanhoTabela);
        Random gerador = new Random();
        for(int i = 0; i< numeroDeChave; i++){
            th.insere(gerador.nextInt(tamanhoMax));
        }
        return th;
    }

    public int funcaoHash(int chave){
        return chave % tamanho;
    }

    public static void main(String[] args) {

        TabelaHash th = null;
        int ch = 0;
        th = experimento(100, 100, 10000);
        th.imprimir();

    }    
}
