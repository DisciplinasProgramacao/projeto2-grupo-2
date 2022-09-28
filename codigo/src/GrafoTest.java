import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class GrafoTest {

    /*
     * PLANO DE TESTES DA CLASSE MICROWAVE
     * - Carregar um novo grafo 
     * - Gerar um grafo completo
     *   - Verificar se é um grafo completo
     * - Tamanho de um grafo 
     * - Subgrafo completo
     */

    static GrafoPonderado grafoPonderado;
    static GrafoCompleto grafoCompleto;

    @BeforeEach
    public void init(){
        grafoPonderado = new GrafoPonderado("Grafo ponderado");
        
    }

    @Test
    public void carregaUmArquivoCsvParaLeitura(){
        grafoPonderado.carregar("grafos.csv");
        int existe=0;
        if(grafoPonderado.existeVertice(4) != null){
            existe++;
        }
        assertEquals(1, existe);
    }

    @Test
    public void criarGrafoCompleto() {
        int grafoCriado = 0;
        grafoCompleto = new GrafoCompleto("Grafo completo", 4);
        if(grafoCompleto.completo()){
            grafoCriado++;
        }
        assertEquals(1,grafoCriado);
    }

    @Test
    public void gerarSubGrafoCompleto(){
        int subGrafoCriado = 0;
        Lista<Vertice> vertices = new Lista<Vertice>();
        Vertice v1 = new Vertice(4);
        Vertice v2 = new Vertice(3);
        vertices.add(v1);
        vertices.add(v2);

        grafoCompleto = new GrafoCompleto("Grafo completo", 4);

        grafoCompleto.subGrafo(vertices);

    }







    


}
