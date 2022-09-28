import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GrafoPonderado extends GrafoMutavel {

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

    public GrafoPonderado subGrafo(Lista<Vertice> vertices) {
        GrafoPonderado subgrafo = new GrafoPonderado("Subgrafo de " + this.nome);
        return subgrafo;
    }

    public void carregar(String nomeArquivo) {
        try (Scanner scanner = new Scanner(new File(nomeArquivo))) {
            scanner.useDelimiter(";");
            while (scanner.hasNext()) {
                System.out.println(scanner.next());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
