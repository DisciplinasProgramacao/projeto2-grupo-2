import java.io.BufferedReader;
import java.io.FileReader;

public class GrafoPonderado extends GrafoMutavel {
    /**
     * Método construtor Grafo não Ponderado
     * 
     * @param nome Nome do Grafo Mutável
     */

    public GrafoPonderado(String nome) {
        super(nome);
    }

    /**
     * Adiciona uma aresta ponderada entre dois vértices do grafo.
     * Não verifica se os vértices pertencem ao grafo.
     * 
     * @param origem  Vértice de origem
     * @param destino Vértice de destino
     * @param peso    Peso da aresta
     */
    public boolean addAresta(int origem, int destino, int peso) {
        boolean adicionou = false;
        Vertice saida = this.existeVertice(origem);
        Vertice chegada = this.existeVertice(destino);
        if (saida != null && chegada != null) {
            saida.addAresta(peso, destino);
            chegada.addAresta(peso, origem);
            adicionou = true;
        }

        return adicionou;
    }

    /**
     * Adiciona uma aresta entre dois vértices do grafo.
     * Não verifica se os vértices pertencem ao grafo.
     * Considera o peso = 1.
     * 
     * @param origem  Vértice de origem
     * @param destino Vértice de destino
     */
    public boolean addAresta(int origem, int destino) {
        return addAresta(origem, destino, 1);
    }

    /**
     * Método para gerar um subgrafo
     * 
     * @param vertices Uma lista de vertices
     * @return Um subgrafo
     */

    public GrafoPonderado subGrafo(Lista<Vertice> vertices) {
        GrafoPonderado subgrafo = new GrafoPonderado("Subgrafo de " + this.nome);
        return subgrafo;
    }

    /**
     * Método carregar grafos a partir de um arquivo
     * próximo id disponível.
     * 
     * @param nomeArquivo Caminho do arquivo txt
     */
    public void carregar(String nomeArquivo) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader(nomeArquivo));

        String nomeDoGrafo = br.readLine(); // csv file linha 0
        GrafoMutavel auxGraf = new GrafoNaoPonderado(nomeDoGrafo);

        int ordem = Integer.parseInt(br.readLine()); // csv file linha 1

        for (int i = 1; i <= ordem; i++) {
            auxGraf.addVertice(i);
        }

        String linha = null;
        String[] splitText = null;
        int vertOrigem;
        int vertDestino;

        while (br.readLine() != null) {
            if (linha != null) {

                splitText = linha.split(";");
                vertOrigem = Integer.parseInt(splitText[0]);
                vertDestino = Integer.parseInt(splitText[1]);

                Vertice vertO = auxGraf.existeVertice(vertOrigem);
                Vertice vertD = auxGraf.existeVertice(vertDestino);

                vertO.addAresta(vertDestino);
                vertD.addAresta(vertOrigem);
            }

            linha = br.readLine();
        }

        br.close();
    }

}
