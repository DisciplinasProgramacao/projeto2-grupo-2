public class GrafoNaoPonderado extends GrafoMutavel {

    public GrafoNaoPonderado(String nome) {
        super(nome);
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
