import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GrafoPonderado extends GrafoMutavel {

    public GrafoPonderado(String nome) {
        super(nome);
    }

    public boolean addAresta(int origem, int destino) {
        return false;
    }

    public boolean addAresta(int origem, int destino, int peso) {
        return false;
    }

    public GrafoPonderado subGrafo(Lista<Vertice> vertices) {
        Grafo subgrafo = new Grafo("Subgrafo de " + this.nome);
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
