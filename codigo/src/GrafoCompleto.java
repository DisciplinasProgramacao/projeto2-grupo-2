public class GrafoCompleto extends Grafo{
    private int ordem;

    public GrafoCompleto(String nome, int ordem) {
        super(nome);
        this.ordem = ordem;

        //adiciona vertices
        for(int i = 1; i <= this.ordem; i++) {
        addVertice(i);    
        }

        //adiciona arestas
        for(int i = 1; i <= this.ordem; i++) {
            for(int j = (i+1); j <= this.ordem; j++) {
                addAresta(i, j);
            }
        }
    }

    public boolean completo() {
    
    }

    public Aresta existeAresta(int verticeA, int verticeB) {

    }

    public Vertice existeVertice(int idVertice) {

    }

    public boolean eureliano() {

    }

    public GrafoCompleto subGrafo(Lista verticesLista) {

    }
}
