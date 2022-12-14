public class Vertice {

    private ABB<Aresta> arestas;
    private final int id;
    private boolean visitado;

    /**
     * Construtor para criação de vértice identificado
     * 
     * @param id Número/id do vértice a ser criado (atributo final).
     */
    public Vertice(int id) {
        this.id = id;
        this.arestas = new ABB<Aresta>();
        this.visitado = false;
    }

    /**
     * Adiciona uma aresta ponderada neste vértice para um destino
     * 
     * @param peso Peso da aresta (1 para grafos não ponderados)
     * @param dest Vértice de destino
     */
    public boolean addAresta(int destino, int peso) {
        return this.arestas.add(destino, new Aresta(peso, destino));
    }

    /**
     * Adiciona uma aresta neste vértice para um destino
     * 
     * @param dest Vértice de destino
     */
    public boolean addAresta(int destino) {
        return this.arestas.add(destino, new Aresta(0, destino));
    }

    /**
     * Verifica se já existe aresta entre este vértice e um destino. Método privado
     * 
     * @param dest Vértice de destino
     * @return TRUE se existe aresta, FALSE se não
     */
    public Aresta existeAresta(int destino) {
        return this.arestas.find(destino);
    }

    /**
     * Retorna o grau do vértice
     * 
     * @return Grau (inteiro não negativo)
     */
    public int grau() {
        return this.arestas.size();
    }


    /**
     * Visitar um vértice
     */
    public void visitar() {
        this.visitado = true;
    }

    /**
     * limpar Visita de um  vértice
     */
    public void limparVisita() {
        this.visitado = false;
    }

     /**
     * Verificar se um vértice foi visitado
     * @return TRUE se foi visitado FALSE se não
     */
    public boolean visitado() {
        return this.visitado;
    }

    /**
     * Pegar o id do vértice
     * @return o ID do vértice
     */
    public int getId() {
        return this.id;
    }

    @Override
    public String toString(){
        
        String arestasVerticeAtual = "";
        Aresta[] arest = new Aresta[arestas.size()];

        arestas.allElements(arest);

        for(int i = 0; i < arest.length; i++){
          arestasVerticeAtual = this.id + ";" + Integer.toString(arest[i].getDestino()) + '\n';
        }

        return arestasVerticeAtual;
    }
}
