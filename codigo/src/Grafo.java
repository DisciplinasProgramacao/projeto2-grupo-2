/**
 * Classe básica para um Grafo simples
 */
public abstract class Grafo {

    public final String nome;
    protected ABB<Vertice> vertices;

    /**
     * Construtor. Cria um grafo vazio com capacidade para MAX_VERTICES
     */
    public Grafo(String nome) {
        this.nome = nome;
        qtdeArestas = 0;
        this.vertices = new ABB<>();
    }

    public Vertice existeVertice(int idVertice) {
        return this.vertices.find(idVertice);
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
        
        for (int i = 1; i < vert.length; i++){
            if(vert[i].grau() != (vertices.size()-1)) {
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
        
        for (int i = 1; i < vert.length; i++){
            qtdeArestas += vert[i].grau();
        }

        return ordem() + (qtdeArestas/2);
    }

    public int ordem() {
        return this.vertices.size();
    }

}
