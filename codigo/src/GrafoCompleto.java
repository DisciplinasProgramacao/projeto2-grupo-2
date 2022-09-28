public class GrafoCompleto extends Grafo {
    private int ordem;

    public GrafoCompleto(String nome, int ordem) {
        super(nome);
        this.ordem = ordem;

        for (int i = 1; i <= this.ordem; i++) {
            addVertice(i);

            for (int j = (i + 1); j <= this.ordem; j++) {
                addAresta(i, j);
            }
        }
    }

    private boolean addVertice(int id) {
        Vertice novo = new Vertice(id);
        return this.vertices.add(id, novo);
    }

    private boolean addAresta(int origem, int destino) {
    
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

    @Override
    public boolean completo() {
        return true;
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

    public boolean eureliano(GrafoNaoPonderado grafo) {
        //CONDITIONS Fleury's Algoritm 
        Grafo grafoCopy = grafo; // This needs to be a clone 
        int qtVertices = grafo.ordem();
        int qtArestas = grafo.tamanho(); // MOCK
        
        int qtImpares = 0;
        int grauVertice = 0;
        int verticeImpar;

        //Things to resolve first:
        /*
         * Get the degree of each vertice 
         * Get the number of edges of a graph
         * check if a edge is not a bridge
         */

        // if d(v) for each vertice is even 
       
        // if there are only 2 vertices with odd degrees

        for(int i = 1; i <= qtVertices; i++){
           grauVertice =  grafoCopy.vertices.size(); //MOCK CODE verify if it is odd 
           if(grauVertice %2 !=0){
                qtImpares ++;
                verticeImpar = i;
           }
          
        }
        
        if(qtImpares > 2){ // If the Graph has 3 vertices with odd degrees, it is not Eulerian
            return false;
        }
        
        
        //Select an initial edge, if there are odds start with one of them
        //HERE

        //Garbage conditions bellow
        while(qtArestas != 0){ //While are edges on the graph's copy 
            int nextEdge =0;

            if(nextEdge < 0){ // If the d(v) > 1 select an edge that is not a bridge

            }else{
                //Select the only edge 
            }
            //Walk to edge chosen
            //Delete the edge between the last and the new edge
            //grafo.delAresta(origem, destino)

        }
        return true;
    }
    
    public GrafoCompleto subGrafo(Lista<Vertice> vertices) {

        Vertice[] vert = null; 
        int ordemSubGrafo = vertices.allElements(vert).length;

        if(this.ordem > ordemSubGrafo) {
            GrafoCompleto subgrafo = new GrafoCompleto("Subgrafo de " + this.nome,ordemSubGrafo);
            return subgrafo;

        } else{
            GrafoCompleto subgrafo = new GrafoCompleto("Subgrafo de " + this.nome,this.ordem);
            return subgrafo;
        }
    }
}
