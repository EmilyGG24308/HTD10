public class rutasInterdepartamental {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();

        // Agregamos las rutas con su distancia (km)
        grafo.agregarArco(0, 1, 3); // A -> B
        grafo.agregarArco(0, 3, 7); // A -> D
        grafo.agregarArco(1, 2, 1); // B -> C
        grafo.agregarArco(1, 4, 8); // B -> E
        grafo.agregarArco(2, 3, 2); // C -> D
        grafo.agregarArco(3, 4, 3); // D -> E
        grafo.agregarArco(4, 0, 4); // E -> A

        //obtener shortest routes
        int[][] resultado = Floyd.floydWarshall(grafo.getMatriz());
        String[] ciudades = grafo.getVertices();

        // letra = ciudad
        System.out.println("Mapeo de letras a ciudades:");
        char letra = 'A';
        for (String ciudad : ciudades) {
            System.out.println(letra + ": " + ciudad);
            letra++;
        }

        //distancias min para cada route 
        System.out.println("\nDistancias mínimas entre letras del grafo:\n");

        for (int i = 0; i < resultado.length; i++) {
            for (int j = 0; j < resultado.length; j++) {
                if (i != j) {
                    char desde = (char) ('A' + i);
                    char hacia = (char) ('A' + j);
                    if (resultado[i][j] == 99999) {
                        System.out.println("No hay ruta de " + desde + " a " + hacia);
                    } else {
                        System.out.println( desde + " --> " + hacia +
                                ", se va a recorrer " + resultado[i][j] + " km.");
                    }
                }
            }
        }

        //matriz de distancias min
        System.out.println("\nMatriz de distancias mínimas:");

        // Encabezado columnas
        System.out.print(" \t");
        for (int i = 0; i < resultado.length; i++) {
            System.out.print((char)('A' + i) + "\t");
        }
        System.out.println();

        // Encabezado Filas
        for (int i = 0; i < resultado.length; i++) {
            System.out.print((char)('A' + i) + "\t"); // Letra al inicio de la fila
            for (int j = 0; j < resultado.length; j++) {
                if (resultado[i][j] == 99999)
                    System.out.print("∞\t");
                else
                    System.out.print(resultado[i][j] + "\t");
            }
            System.out.println();
        }

        //centro del grafo
        int centro = Floyd.centroDelGrafo(resultado);
        System.out.println("\nCentro del grafo: " + (char)('A' + centro) + " (" + ciudades[centro] + ")");
    }
}
