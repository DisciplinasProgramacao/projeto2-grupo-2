public class App {

    public static void main(String[] args) throws Exception {
        GrafoNaoPonderado grafo = new GrafoNaoPonderado("Primeiro");
        grafo.carregar("src/grafos.csv");
    }
}
