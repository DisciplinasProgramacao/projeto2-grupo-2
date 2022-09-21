public class GrafoNaoPonderado extends GrafoMutavel {

    public GrafoNaoPonderado(String nome) {
        super(nome);
    }

    public boolean addAresta(int origem, int destino) {
        return false;
    }

    public GrafoNaoPonderado subGrafo(Lista<Vertice> vertices) {
        return null;
    }

}
