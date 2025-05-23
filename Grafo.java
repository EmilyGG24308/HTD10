import java.util.Arrays;

public class Grafo{
    //matriz d adyacencia q va a representar la dis
    private int[][] matriz;
    private final int INF = 99999;
    private String[] vertices = {
        "Ciudad de Guatemala", // A
        "Zacapa",              // B
        "Chiquimula",          // C
        "Quetzaltenango",      // D
        "Coban"                // E
    };

    
    public Grafo() {
        matriz = new int [5][5];
        for (int i=0; i<5; i++)
        Arrays.fill(matriz[i], INF); //begining disconected
        for (int i=0; i<5; i++)
        matriz[i][i] = 0; // a-->a = 0
    }

    //adds arco: origen --> destino con el km
    public void agregarArco(int origen, int destino, int peso) {
        matriz[origen][destino] = peso;
    }

    //elimina : distancia entre origen y destino a infinity
    public void eliminarArco(int origen, int destino) {
        matriz[origen][destino] = INF;
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public String[] getVertices() {
        return vertices;
    }
}
