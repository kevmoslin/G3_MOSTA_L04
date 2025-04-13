package ejercicios;

public class ElViajeMasBarato {
    public static final int INF = Integer.MAX_VALUE;

    // Calcula la matriz de costos mínimos desde cada ciudad a cada otra
    public static int[][] calcularCostosMinimos(int[][] tablaCostos) {
        int n = tablaCostos.length;
        int[][] costos = new int[n][n];

        // Inicializar la matriz de costos
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                costos[i][j] = (i == j) ? 0 : tablaCostos[i][j];
            }
        }

        // Algoritmo de costos mínimos
        for (int origen = n - 1; origen >= 0; origen--) {
            for (int destino = origen + 1; destino < n; destino++) {
                for (int intermedio = origen + 1; intermedio < destino; intermedio++) {
                    if (tablaCostos[origen][intermedio] != INF && costos[intermedio][destino] != INF) {
                        costos[origen][destino] = Math.min(costos[origen][destino],tablaCostos[origen][intermedio] + costos[intermedio][destino]);
                    }
                }
            }
        }

        return costos;
    }

    // Imprime la matriz de costos de forma legible
    public static void imprimirMatriz(int[][] matriz) {
        int n = matriz.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print((matriz[i][j] == INF ? "INF" : matriz[i][j]) + "\t");
            }
            System.out.println();
        }
    }

    // Método principal para probar el algoritmo
    public static void main(String[] args) {
        int[][] tablaCostos = {
            { 0,    1,   6,   10 },
            { INF,  0,   1,   3 },
            { INF, INF, 1,   0 },
            { INF, INF, INF, 0 }
        };

        int[][] resultado = calcularCostosMinimos(tablaCostos);
        System.out.println("Matriz de costos mínimos:");
        imprimirMatriz(resultado);
    }
}