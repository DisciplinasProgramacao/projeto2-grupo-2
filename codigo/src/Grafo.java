import java.io.File;
import java.util.Scanner;

/** 
 * Classe básica para um Grafo simples
 */
public abstract class Grafo {
    public final String nome;
    protected ABB<Vertice> vertices;

    /**
     * Construtor. Cria um grafo vazio com capacidade para MAX_VERTICES
     */
    public Grafo(String nome){
        this.nome = nome;
        this.vertices = new ABB<>();
    }

    public void carregar(String nomeArquivo) throws Exception{
        Scanner scanner = new Scanner(new File(nomeArquivo));
        scanner.useDelimiter(";");
        while(scanner.hasNext()){
            System.out.println(scanner.next());
        }
        scanner.close();
    }

    public void salvar(String nomeArquivo){
        //this.name;
        //this.vertices.size();
        //How am I going to load the edges from the graph?
        //How am I going to save the graphs at the end of the file? 
        

        
    }
    /**
     * Adiciona, se possível, um vértice ao grafo. O vértice é auto-nomeado com o próximo id disponível.
     */
    public boolean addVertice(int id){
        Vertice novo = new Vertice(id);
        return this.vertices.add(id, novo);
    }

    /**
     * Adiciona uma aresta entre dois vértices do grafo. 
     * Não verifica se os vértices pertencem ao grafo.
     * @param origem Vértice de origem
     * @param destino Vértice de destino
     */
    public boolean addAresta(int origem, int destino){
        boolean adicionou = false;
        Vertice saida = this.existeVertice(origem);
        Vertice chegada = this.existeVertice(destino);
        if(saida!=null && chegada !=null){
            saida.addAresta(destino);
            chegada.addAresta(origem);
            adicionou = true;
        }
        
        return adicionou;

    }

    public Vertice existeVertice(int idVertice){
        return this.vertices.find(idVertice);
    }




    /**
     * (Precisa testar) 
     * @param verticeA
     * @param verticeB
     * @return
     */
    public Aresta existeAresta(int verticeA, int verticeB){
        Vertice saida = this.existeVertice(verticeA);
        return saida.existeAresta(verticeB);
    }
    
    /**
     * Verifica se este é um grafo completo. 
     * @return TRUE para grafo completo, FALSE caso contrário
     */
    public boolean completo(){
        boolean resposta = true;
        
        return resposta;
    }

    public Grafo subGrafo(Lista<Vertice> vertices){
        Grafo subgrafo = new Grafo("Subgrafo de "+this.nome);
        

        return subgrafo;
    }
    
    public int tamanho() {
        vertices.size();
        return 0;
    }

    public int ordem(){
        return this.vertices.size();
    }

}
