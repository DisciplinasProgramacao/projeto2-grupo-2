public class Aresta {

    private int peso;
    private int destino;
    private boolean visitada;

    /**
     * Construtor para arestas com ou sem peso
     * @param peso Peso da aresta
     * @param dest Vértice de destino
     */
    public Aresta(int peso, int destino){
        this.peso = peso;
        this.destino = destino;
        this.visitada = false;
    }

    /**
     * Método de acesso para o peso da aresta
     * @return the peso
     */
    public int peso() {
        return this.peso;
    }
   
    /**
     * Método de acesso para o destino da aresta
     * @return the destino
     */
    public int destino() {
        return this.destino;
    }

    /**
     * Método para visitar uma aresta
     * @return visitada igual a verdadeiro
     */
    public void visitar(){
        this.visitada = true;
    }

    /**
     * Método para limpar visita
     * @return visitada igual a falso
     */
    public void limparVisita(){
        this.visitada = false;
    }

    /**
     * Método para retornar o status 
     * @return O estado booleano da aresta visitada
     */
    public boolean visitada(){
        return this.visitada;
    }

     /**
     * Método get para o destino da aresta
     * @return O destino da aresta
     */
    public int getDestino(){
        return this.destino;
    }

    

}
