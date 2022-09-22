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

    public boolean completo() {
        return true;
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
