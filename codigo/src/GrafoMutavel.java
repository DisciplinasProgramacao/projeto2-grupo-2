import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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

    public boolean delAresta(int origem, int destino) {
        return false;
    }

    public boolean delVertice(int idVertice) {
        return false;
    }

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
