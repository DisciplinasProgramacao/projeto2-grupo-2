import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public abstract class GrafoMutavel extends Grafo {

     /**
     * Método construtor Grafo Mutável
     * @param nome Nome do Grafo Mutável
     */

    public GrafoMutavel(String nome) {
        super(nome);
    }

    /**
     * Método para adicionar uma aresta entre dois vértices do grafo.
     * Não verifica se os vértices pertencem ao grafo.
     * 
     * @param origem  Vértice de origem
     * @param destino Vértice de destino
     */

    public abstract boolean addAresta(int origem, int destino);

    /**
     * Método para adicionar, se possível, um vértice no grafo. O vértice é auto-nomeado com o
     * próximo id disponível.
     * @param id do vértice
     * @return Se o vértice foi adicionado
     */
    public boolean addVertice(int id) {
        Vertice novo = new Vertice(id);
        return this.vertices.add(id, novo);
    }

    /**
     * Método carregar grafos a partir de um arquivo
     * próximo id disponível.
     * @param nomeArquivo Caminho do arquivo txt
     */
    public void carregar(String nomeArquivo) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(nomeArquivo));

        String nomeDoGrafo = br.readLine(); //csv file linha 0
        this.nome = nomeDoGrafo;

        int ordem = Integer.parseInt(br.readLine()); //csv file linha 1

        for (int i = 1; i <= ordem; i++) {
            this.addVertice(i);
        }

        String linha = null;
        String[] splitText = null;
        int vertOrigem;
        int vertDestino;

        linha = br.readLine();

        while(linha != null) {
            splitText = linha.split(";");
            vertOrigem = Integer.parseInt(splitText[0]);
            vertDestino = Integer.parseInt(splitText[1]);

            Vertice vertO = this.existeVertice(vertOrigem);
            Vertice vertD = this.existeVertice(vertDestino);
            
            if (vertD.existeAresta(vertO.getId()) == null && // se não existe aresta entre os vertices
              vertO.existeAresta(vertD.getId()) == null){
              vertO.addAresta(vertDestino);
            }

            linha = br.readLine();
        }
        br.close();
    }

     /**
     * Método deletar aresta entre dois vértices
     * @param origem Vértice de origem
     * @param destino Vértice de destino
     * @return Se foi deletada ou não
     */

    public boolean delAresta(int origem, int destino) {
        return false;
    }

    /**
     * Método deletar um vértice
     * @param idVertice O ID do vértice
     * @return Se foi deletado ou não
     */

    public boolean delVertice(int idVertice) {
        return false;
    }

    /**
     * Método para salvar o grafo no arquivo
     * @param caminhoArquivo  Caminho do arquivo txt
     */


    public void salvar(String caminhoArquivo) throws IOException {

        BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoArquivo));
        Vertice[] vert = new Vertice[vertices.size()];
        vertices.allElements(vert);

        bw.write(this.nome);
        bw.newLine();
        bw.write(Integer.toString(ordem()));
        bw.newLine();

        for(int i = 0; i < ordem(); i++) {
            bw.write(vert[i].toString());    
        }

        bw.close();
    }
    
}
