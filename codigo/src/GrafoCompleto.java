import java.io.LineNumberInputStream;

public class GrafoCompleto extends Grafo {
    private int ordem;

    public GrafoCompleto(String nome, int ordem) {
        super(nome);
        this.ordem = ordem;

        for (int i = 1; i <= this.ordem; i++) {
            //addVertice(i);

            Vertice novo = new Vertice(i);
            this.vertices.add(i, novo);

            for (int j = (i + 1); j <= this.ordem; j++) {
                // addAresta(i, j);

                boolean adicionou = false;
                Vertice saida = this.existeVertice(i);
                Vertice chegada = this.existeVertice(j);
                if (saida != null && chegada != null) {
                    saida.addAresta(j);
                    chegada.addAresta(i);
                    adicionou = true;
                }
            }
        }
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

    public boolean eureliano() {

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
