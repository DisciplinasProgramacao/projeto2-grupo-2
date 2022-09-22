public class GrafoNaoPonderado extends GrafoMutavel {

    public GrafoNaoPonderado(String nome) {
        super(nome);
    }

    public boolean addAresta(int origem, int destino) {
        return false;
    }

    /*
     *  Subgrafo não ponderado
     */

    public GrafoNaoPonderado subGrafo(Lista<Vertice> vertices) {

        Vertice[] vert = null; 
        
        GrafoNaoPonderado grafoNaoPonderado = new GrafoNaoPonderado(this.nome);

        for(int i=1;i<grafoNaoPonderado.ordem();i++){

            for(int j=1; j<vertices.allElements(vert).length;j++){
                if(grafoNaoPonderado.existeVertice());

            }

        }




        return null;
    }

}
