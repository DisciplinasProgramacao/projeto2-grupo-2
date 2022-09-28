import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

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
            addVertice(i);
        }

        String linha = null;
        String[] splitText = null;
        int vetOrigem;
        int vetDestino;

        while(true) {
            if(linha != null) {

                splitText = linha.split(";");
                vetOrigem = Integer.parseInt(splitText[0]);
                vetDestino = Integer.parseInt(splitText[1]);

                for (int i = 1; i <= ordem; i++) {
                    if(i == vetOrigem) {
                        addAresta(vetOrigem, vetDestino);
                    }
                }
            } else {
                break;
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

    public void salvar(String nomeArquivo) {

        BufferedWriter bw = new BufferedWriter(new FileWriter(nomeArquivo));

        int ordem = ordem();

        bw.write(this.nome + "\n");
        bw.write(ordem + "\n");

        for(int i = 1; i <= ordem; i++) {
            
            //verificar vertice

            for (int j = 1; j <= ordem; j++) {
                //escrever aresta
            }
        }
        bw.write("\n"+ this.nome + "\n" + this.vertices.size()+ "\n" +"" );

        bw.close();
        }
    }
}
