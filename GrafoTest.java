import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GrafoTest {
    @Test
    //add arc (a-->b with 10 km)
    public void testAgregarYEliminarArco() {
        Grafo grafo = new Grafo();
        grafo.agregarArco(0, 1, 10);
        assertEquals(10, grafo.getMatriz()[0][1]);

        //delete the arc created
        grafo.eliminarArco(0, 1);
        assertEquals(99999, grafo.getMatriz()[0][1]);
    }

    @Test
    public void testFloydWarshall() {
        Grafo grafo = new Grafo();
        grafo.agregarArco(0, 1, 3); 
        grafo.agregarArco(1, 2, 4);
        grafo.agregarArco(0, 2, 10);

        //camino mas corto a-->c debe ser 7
        int[][] resultado = Floyd.floydWarshall(grafo.getMatriz());
        assertEquals(7, resultado[0][2]);
    }
}
