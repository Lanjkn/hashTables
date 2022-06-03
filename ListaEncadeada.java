package SEMANA10;

// Lista encadeada com NoDaLista alocado de forma dinâmica (AD)
public class ListaEncadeada {

    private NoDaLista primeiro;

    public ListaEncadeada() {
        this.primeiro = null;
    }

    public ListaEncadeada(NoDaLista pPrimeiro) {
        this.primeiro = pPrimeiro;
    }

    public String toString(){
        NoDaLista ptrProximo = this.primeiro;
        String str = "[";
        while (ptrProximo != null) {
            if(ptrProximo.pegaProximo() != null){
                str += ptrProximo.pegaDado() + ", ";
            } else {
                str += ptrProximo.pegaDado();
            }
            ptrProximo = ptrProximo.pegaProximo();
        }
        str += "]";
        return str;
    }

    private NoDaLista irAteFinal() {
        NoDaLista ptrProximo = this.primeiro;
        NoDaLista ultimo = null;
        while (ptrProximo != null) {
            ultimo = ptrProximo;
            ptrProximo = ptrProximo.pegaProximo();
        }
        return ultimo;
    }

    private NoDaLista irAtePenultimo() {
        NoDaLista ptrProximo = this.primeiro;
        NoDaLista ultimo = null;
        NoDaLista penultimo = null;
        while (ptrProximo != null) {
            penultimo = ultimo;
            ultimo = ptrProximo;
            ptrProximo = ptrProximo.pegaProximo();
        }
        return penultimo;
    }

    public NoDaLista encontrar(NoDaLista pNo) {
        NoDaLista ptrProximo = this.primeiro;
        while ((ptrProximo != null)
                && (! ptrProximo.pegaDado().equals(pNo.pegaDado()))) {
            ptrProximo = ptrProximo.pegaProximo();
        }
        return ptrProximo;
    }

    private NoDaLista encontrarAnteriorAoMaior(NoDaLista pNo) {
        NoDaLista ptrProximo = this.primeiro;
        NoDaLista anterior = null;
        while ((ptrProximo != null)
                && (ptrProximo.pegaDado() < pNo.pegaDado())) {
            anterior = ptrProximo;
            ptrProximo = ptrProximo.pegaProximo();
        }
        return anterior;
    }

    private NoDaLista encontrarAnterior(NoDaLista pNo) {
        NoDaLista ptrProximo = this.primeiro;
        NoDaLista anterior = null;
        while ((ptrProximo != null) && (ptrProximo.pegaDado() != pNo.pegaDado())) {
            anterior = ptrProximo;
            ptrProximo = ptrProximo.pegaProximo();
        }
        return anterior;
    }

    public void imprimir() {
        NoDaLista ptrProximo = this.primeiro;
        while (ptrProximo != null) {
            System.out.println(ptrProximo.pegaDado());
            ptrProximo = ptrProximo.pegaProximo();
        }
    }

    public boolean inserePrimeiro(Integer i) {
        NoDaLista no = new NoDaLista(i);
        boolean inserido = false;
        if (this.primeiro == null) {
            this.primeiro = no;
            inserido = true;
        } else { // percorrer a lista até o último nó
            no.setaProximo(this.primeiro);
            this.primeiro = no;
            inserido = true;
        }
        return inserido;
    }

    public boolean insereUltimo(Integer i) {
        NoDaLista no = new NoDaLista(i);
        boolean inserido = false;
        if (this.primeiro == null) {
            this.primeiro = no;
            inserido = true;
        } else { // percorrer a lista até o último nó
            NoDaLista ultimo = this.irAteFinal();
            if (ultimo != null) {
                ultimo.setaProximo(no);
                inserido = true;
            }
        }
        return inserido;
    }

    public NoDaLista removePrimeiro() {

        NoDaLista noAux = this.primeiro;

        if (this.primeiro != null) {
            this.primeiro = this.primeiro.pegaProximo();
        }
        return noAux;
    }

    public NoDaLista removeUltimo() {

        NoDaLista ultimo = null;

        if (this.primeiro == null) {
            ultimo = null;
        } else {
            if (this.primeiro.pegaProximo() == null) {
                ultimo = this.primeiro;
                this.primeiro = null;
            } else {
                NoDaLista penultimoNo = this.irAtePenultimo();
                if (penultimoNo != null) {
                    ultimo = penultimoNo.pegaProximo();
                    penultimoNo.setaProximo(null);
                }
            }
        }
        return ultimo;
    }

    public boolean insereOrdenado(Integer i) {
        NoDaLista no = new NoDaLista(i);
        NoDaLista noPosicaoAnteriorMaior = null;
        boolean inserido = false;
        noPosicaoAnteriorMaior = this.encontrarAnteriorAoMaior(no);
        if (noPosicaoAnteriorMaior == null) {
            this.inserePrimeiro(i);
            inserido = true;
        } else {
            // insere no final
            if (noPosicaoAnteriorMaior.pegaProximo() == null) {
                this.insereUltimo(i);
                inserido = true;
            } else {
                no.setaProximo(noPosicaoAnteriorMaior.pegaProximo());
                noPosicaoAnteriorMaior.setaProximo(no);
                inserido = true;
            }
        }
        return inserido;
    }

    public boolean insereDepois(NoDaLista pNo, Integer i) {
        NoDaLista no = new NoDaLista(i);
        NoDaLista noDepois = null;
        boolean inserido = false;
        if (pNo != null) {
            noDepois = this.encontrar(pNo);
        }
        if (noDepois != null) {
            no.setaProximo(noDepois.pegaProximo());
            noDepois.setaProximo(no);
            inserido = true;
        }
        return inserido;
    }

    public NoDaLista remove(NoDaLista pNo) {

        NoDaLista anterior = null;
        NoDaLista removido = null;

        if (this.primeiro == null) {
            removido = null;
        } else {
            if ((this.primeiro != null) && (this.primeiro.pegaDado() == pNo.pegaDado())) {
                removido = this.removePrimeiro();
            } else {
                if (pNo != null) {
                    anterior = this.encontrarAnterior(pNo);
                }
                if (anterior != null) {
                    if (anterior.pegaProximo() == null) {
                        removido = this.removeUltimo();
                    } else {
                        removido = anterior.pegaProximo();
                        anterior.setaProximo(anterior.pegaProximo().pegaProximo());
                        removido.setaProximo(null);
                    }
                }
            }
        }
        return removido;
    }
}
