public class GrafoNaoPonderado extends GrafoMutavel {

    public GrafoNaoPonderado(String nome) {
        super(nome);
    }

    /**
     * Adiciona uma aresta entre dois vértices do grafo.
     * Não verifica se os vértices pertencem ao grafo.
     * 
     * @param origem  Vértice de origem
     * @param destino Vértice de destino
     */
    public boolean addAresta(int origem, int destino) {
        boolean adicionou = false;
        Vertice saida = this.existeVertice(origem);
        Vertice chegada = this.existeVertice(destino);
        if (saida != null && chegada != null) {
            saida.addAresta(destino);
            chegada.addAresta(origem);
            adicionou = true;
        }

        return adicionou;
    }

    /*
     *  Subgrafo não ponderado
     */
    public GrafoNaoPonderado subGrafo(Lista<Vertice> vertices) {

        Vertice[] vert = null; 

        GrafoNaoPonderado grafoNaoPonderado = new GrafoNaoPonderado(this.nome);
        GrafoNaoPonderado subGrafoNaoPonderado = new GrafoNaoPonderado(this.nome);

        

        for(int j=1; j<vertices.allElements(vert).length;j++){
            grafoNaoPonderado.existeVertice(j);
                //copiaVerticeParaSubGrafo
                //copia arestas

                for(int i=1;i<grafoNaoPonderado.ordem();i++){
                //
                //
            }
        }

        return null;
    }
}
