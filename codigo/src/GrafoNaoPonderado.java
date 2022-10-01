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
            saida.addAresta(1, destino);
            chegada.addAresta(1, origem);
            adicionou = true;
        }

        return adicionou;
    }

    /*
     *  Subgrafo não ponderado
     */
    public GrafoNaoPonderado subGrafo(Lista<Vertice> vertices) {
  
        GrafoNaoPonderado subGrafoNPonderado = new GrafoNaoPonderado(this.nome);

        Vertice[] vert = new Vertice[Integer.parseInt(vertices.toString())];
        vertices.allElements(vert);

       for (int i = 1; i <= this.ordem(); i++){
          for (int y = 0; y < vertices.allElements(vert).length; y++){
            if (vert[y].getId() == this.vertices.find(i).getId())
            subGrafoNPonderado.vertices.add(y, this.vertices.find(i));
          }
       }
        return subGrafoNPonderado;
    }
}
