public class Floyd {

    public static int[][] floydWarshall(int[][] grafo) {
        int n = grafo.length;
        int[][] dist = new int[n][n];

        
        for (int i = 0; i < n; i++)
            System.arraycopy(grafo[i], 0, dist[i], 0, n);
        
            //algo. de floyd
        for (int k = 0; k < n; k++)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];

        return dist;
    }

    //centro del grafo (node with menor exentricidad <mayor distancia mas corta>)
    public static int centroDelGrafo(int[][] distancias) {
        int n = distancias.length;
        int[] excentricidades = new int[n];

        //exentricidad de cada nodo (max desde uno al otro)
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < n; j++) {
                if (distancias[i][j] != 99999 && distancias[i][j] > max)
                    max = distancias[i][j];
            }
            excentricidades[i] = max;
        }

        //finds node with menor
        int centro = 0;
        for (int i = 1; i < n; i++)
            if (excentricidades[i] < excentricidades[centro])
                centro = i;

        return centro;
    }
}
