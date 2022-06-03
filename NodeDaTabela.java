
package SEMANA10;

public class NodeDaTabela {
    
    private Integer chave;
    private ListaEncadeada lista;
    
    public NodeDaTabela(){
        this.chave = -1;
        this.lista = new ListaEncadeada();

    }

    public Integer pegaChave(){
        return this.chave;
    }    

    public void mudaChave(Integer chave){
        this.chave = chave;
    }

    public ListaEncadeada pegaLista(){
        return this.lista;
    }
   
}
