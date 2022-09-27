import java.io.File;
import java.util.Scanner;

public abstract class GrafoMutavel extends Grafo {

    public GrafoMutavel(String nome) {
        super(nome);
    }

    /**
     * Adiciona uma aresta entre dois vértices do grafo.
     * Não verifica se os vértices pertencem ao grafo.
     * 
     * @param origem  Vértice de origem
     * @param destino Vértice de destino
     */
        public abstract boolean addAresta(int origem, int destino);

    /**
     * Adiciona, se possível, um vértice ao grafo. O vértice é auto-nomeado com o
     * próximo id disponível.
     */
    public boolean addVertice(int id) {
        Vertice novo = new Vertice(id);
        return this.vertices.add(id, novo);
    }

    public void carregar(String nomeArquivo) throws Exception {
        Scanner scanner = new Scanner(new File(nomeArquivo));
        scanner.useDelimiter(";");
        while (scanner.hasNext()) {
            System.out.println(scanner.next());
        }
        scanner.close();
    }

    public boolean delAresta(int origem, int destino) {
        return false;
    }

    public boolean delVertice(int idVertice) {
        return false;
    }

    public void salvar(String nomeArquivo) {
        // this.name;
        // this.vertices.size();
        // How am I going to load the edges from the graph?
        // How am I going to save the graphs at the end of the file?
    }

}
