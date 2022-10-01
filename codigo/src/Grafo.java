import java.util.Iterator;
import java.util.LinkedList;

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

        return ordem() + (qtdeArestas / 2);
    }

    public int ordem() {
        return this.vertices.size();
    }

    public Grafo buscaEmProfundidade(Vertice vert) {

        Vertice[] vertice = new Vertice[vertices.size()];
        vertices.allElements(vertice);

        vert.visitar();

        Vertice vertO = this.existeVertice(vert);

        while(!vert.visitado()) {


            buscaEmProfundidade(vert);
        }
        


        int t = 0; // Inicializar tempo global

        2. para todo vértice v ∈ V(G) faça
        a. TD[v] ← 0; // Inicializar tempo de descoberta
        b. TT[v] ← 0; // Inicializar tempo de término
        c. pai[v] ← null; // Inicializar predecessor ou pai

        3. enquanto existir algum vértice v tal que TD[v] = 0 efetuar
        a. Executar Busca_Profundidade(v); // Executar busca para raiz v

        --------------------------------------------------------

        1. t ← t + 1; TD[v] ← t; // Definir tempo de descoberta

        2. para todo vértice w ∈ Γ(v) faça // Para toda a vizinhança de v

        a. se TD[w] = 0 então // Se w é visitado pela 1ª vez
        Visitar aresta {v, w}; // {v, w} é aresta de árvore
        pai[w] ← v;

        Executar Busca_Profundidade(w);

        b. senão se TT[w] = 0 e w ≠ pai[v] então // Se w for ancestral mas não pai
        Visitar aresta {v, w}; // {v, w} é aresta de retorno

        3. t ← t + 1; TT[v] ← t; // Definir tempo de término     
        
        
        return ;
    }
}
