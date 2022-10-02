import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class GrafoTest {

    /*
     * PLANO DE TESTES DA CLASSE MICROWAVE
     * - Carregar um novo grafo
     * - Gerar um grafo completo
     * - Verificar se é um grafo completo
     * - Tamanho de um grafo
     * - Subgrafo completo
     */

    static GrafoPonderado grafoPonderado;
    static GrafoCompleto grafoCompleto;
    static final String caminhoArquivo = "C:/Users/bruno/OneDrive/Documentos/folder/projeto2-grupo-2/codigo/";
    static final String nomeArquivoLeitura = "grafos.txt";
    static final String nomeArquivoSalvar = "novoGrafo.txt";

    @BeforeEach
    public void init() {
        grafoPonderado = new GrafoPonderado("Grafo ponderado");
    }

    @Test
    public void criarGrafoCompleto() {
        int grafoCriado = 0;
        grafoCompleto = new GrafoCompleto("Grafo completo", 4);
        if (grafoCompleto.completo()) {
            grafoCriado++;
        }
        assertEquals(1, grafoCriado);
    }

    @Test
    public void carregarGrafo() throws Exception {
        GrafoMutavel g = new GrafoNaoPonderado("Grafo completo");
        g.carregar(caminhoArquivo + nomeArquivoLeitura);
        assertEquals(8, g.tamanho());
    }

    @Test
    public void gerarSubGrafoCompleto() {
        Lista<Vertice> vertices = new Lista<Vertice>();
        GrafoCompleto novoSubGrafo = null;
        Vertice v1 = new Vertice(4);
        Vertice v2 = new Vertice(3);
        vertices.add(v1);
        vertices.add(v2);
        grafoCompleto = new GrafoCompleto("Grafo completo", 4);
        novoSubGrafo = grafoCompleto.subGrafo(vertices);
        assertEquals(4, novoSubGrafo.ordem());
    }

    @Test 
    public void gerarSubGrafoNaoPonderado() throws Exception {
        GrafoNaoPonderado g = new GrafoNaoPonderado("");
        GrafoNaoPonderado novoSubGrafo = null;
        g.carregar(caminhoArquivo + nomeArquivoLeitura);
        Lista<Vertice> vertices = new Lista<Vertice>();
        Vertice v1 = new Vertice(4);
        Vertice v2 = new Vertice(3);
        vertices.add(v1);
        vertices.add(v2);
        novoSubGrafo = g.subGrafo(vertices);
        assertEquals(2, novoSubGrafo.ordem());
    } 

    @Test 
    public void carregarESalvarArquivo() throws Exception{
        int tamanhoCarregado = 0;
        int tamanhoSalvo = 0;
        GrafoNaoPonderado g = new GrafoNaoPonderado("");
        g.carregar(caminhoArquivo + nomeArquivoLeitura);
        tamanhoCarregado = g.tamanho();
        g.salvar(caminhoArquivo + nomeArquivoSalvar);     
        g.carregar(caminhoArquivo + nomeArquivoSalvar);  
        tamanhoSalvo = g.tamanho(); 
        assertEquals(tamanhoSalvo, tamanhoCarregado);     
    }

    @Test 
    public void fazerBuscaEmProfundidade() throws Exception{
        GrafoMutavel g = new GrafoNaoPonderado("Grafo completo");
        g.carregar(caminhoArquivo + nomeArquivoLeitura);
        g.buscaEmProfundidade(g.existeVertice(1));
        assertTrue(g.existeVertice(4).existeAresta(1).visitada());
    }

    @Test 
    public void caminhoEntreDoisVertices() throws Exception{
        GrafoMutavel g = new GrafoNaoPonderado("Grafo completo");
        g.carregar(caminhoArquivo + nomeArquivoLeitura);
        g.caminhoEntreVertices(g.existeVertice(1), g.existeVertice(4));
        assertFalse(g.existeVertice(4).existeAresta(1).visitada());
    }

}
