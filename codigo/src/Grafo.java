
/**
 * Classe básica para um Grafo simples
 */
public abstract class Grafo {

    public String nome;
    protected ABB<Vertice> vertices;

    /**
     * Construtor. Cria um grafo vazio com capacidade para MAX_VERTICES
     */
    public Grafo(String nome) {
        this.nome = nome;
        this.vertices = new ABB<>();
    }

    public Vertice existeVertice(int vert) {
        return this.vertices.find(vert);
    }

    /**
     * (Precisa testar)
     * 
     * @param verticeA
     * @param verticeB
     * @return
     */
    public Aresta existeAresta(int verticeA, int verticeB) {
        Vertice saida = this.existeVertice(verticeA);
        return saida.existeAresta(verticeB);
    }

    /**
     * Verifica se este é um grafo completo.
     * 
     * @return TRUE para grafo completo, FALSE caso contrário
     */
    public boolean completo() {
        Vertice[] vert = new Vertice[vertices.size()];
        vertices.allElements(vert);

        for (int i = 1; i < vert.length; i++) {
            if (vert[i].grau() != (vertices.size() - 1)) {
                return false;
            }
        }
        return true;
    }

    public abstract Grafo subGrafo(Lista<Vertice> vertices) throws CloneNotSupportedException;

    public boolean eureliano() {
        return false;
    }

    public boolean caminhoEureliano() {
        return false;
    }

    public int tamanho() {
        Vertice[] vert = new Vertice[vertices.size()];
        vertices.allElements(vert);

        int qtdeArestas = 0;

        for (int i = 0; i < vert.length; i++) {
            qtdeArestas += vert[i].grau();
        }

        return ordem() + qtdeArestas;
    }

    public int ordem() {
        return this.vertices.size();
    }

    public void buscaEmProfundidade(Vertice vert) {

        Vertice[] vertice = new Vertice[vertices.size()];
        vertices.allElements(vertice);

        vert.visitar();

        Aresta arestaExistente = null;

        for (int i = 0; i < vertice.length; i++) {

            arestaExistente = existeAresta(vert.getId(), vertice[i].getId());

            if (arestaExistente != null && !arestaExistente.visitada()) {
                arestaExistente.visitar();
                buscaEmProfundidade(vertice[i]);
                System.out.println("vertice: " + vert.getId());
            }
        }
    }

    public Boolean caminhoEntreVertices(Vertice vert1, Vertice vert2) {
        Vertice[] vertice = new Vertice[vertices.size()];
        vertices.allElements(vertice);

        Aresta arestaExistente = null;

        for (int i = 0; i < vertice.length; i++) {
            arestaExistente = existeAresta(vert1.getId(), vertice[i].getId());

            if (vert2.getId() == vertice[i].getId())
                return true;

            if (arestaExistente != null && !arestaExistente.visitada() && !vertice[i].visitado()) {        
                arestaExistente.visitar();
                System.out.println(vertice[i]);
                caminhoEntreVertices(vertice[i], vert2);
            }
        }
        return false;
    }

}
