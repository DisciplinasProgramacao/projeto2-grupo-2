import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GrafoPonderado extends GrafoMutavel {

    public GrafoPonderado(String nome) {
        super(nome);
    }

    public boolean addAresta(int origem, int destino, int peso) {
        return false;
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
