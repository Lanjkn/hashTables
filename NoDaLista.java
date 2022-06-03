
package SEMANA10;

// Nó com alocação dinâmica (AD)
public class NoDaLista {
    
    private Integer dado;
    private NoDaLista proximo;
    
    public NoDaLista(){
        this.dado = null;
        this.proximo = null;
    }
    
    public NoDaLista(Integer pDado){
        this.dado = pDado;
        this.proximo = null;
    }

    public Integer pegaDado(){
        return this.dado;
    }    
    
    public NoDaLista pegaProximo(){
        return this.proximo;
    }
   
    public void setaProximo(NoDaLista pNo){
        this.proximo = pNo;
    }    
}
