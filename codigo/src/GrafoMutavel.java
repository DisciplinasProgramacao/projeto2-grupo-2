import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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


    /**
     * Adiciona, se possível, um vértice ao grafo. O vértice é auto-nomeado com o
     * próximo id disponível.
     */
    public boolean addVertice(int id) {
        Vertice novo = new Vertice(id);
        return this.vertices.add(id, novo);
    }

    public void carregar(String nomeArquivo) throws Exception {
        
        int vertices;
        int arestas;

        File file = new File(nomeArquivo);
        Scanner scanner = new Scanner(file);

        // scanner.useDelimiter(";");
        String[] valoresAresta = new String[2]; //origem e destino 

        while (scanner.hasNext()) {
            
            String nome = scanner.nextLine(); 
            scanner.next();
            vertices = scanner.nextInt(); 
            arestas = scanner.nextInt();
            
            for(int i = 1; i <= vertices; i++){
                addVertice(i);
            }

            scanner.next();

            arestas = scanner.nextInt(); // quantidade arestas

            for(int i = 1; i <= arestas; i++){

                valoresAresta = scanner.next().split(";");
                addAresta(Integer.parseInt(valoresAresta[0]), Integer.parseInt(valoresAresta[1]));
                scanner.next();        
            }            
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
        //BE CAREFULL about the file path
        try {
            FileWriter fw = new FileWriter("codigo/src/grafos.csv", true);
            fw.write("\n"+ this.nome + "\n" + this.vertices.size()+ "\n" +"" );
            fw.close();
            System.out.println("Appended to the file.");
        } catch (IOException ioe) {
            System.out.print("\nSomething went wrong!");
        }
    }

}
