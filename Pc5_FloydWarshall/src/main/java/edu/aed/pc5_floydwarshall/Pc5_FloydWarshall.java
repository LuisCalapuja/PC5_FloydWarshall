package edu.aed.pc5_floydwarshall;

public class Pc5_FloydWarshall {
    
    public static final int INF = Integer.MAX_VALUE;
    
    public void floydWarshall(int[][] graph) {
        int n = graph.length;
        int[][] dist = new int[n][n];

        // Inicializar matriz de distancias
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        // Aplicar el algoritmo de Floyd-Warshall
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Imprimir las distancias mínimas
        System.out.println("Matriz de distancias mínimas:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dist[i][j] == INF) {
                    System.out.print("INF\t");
                } else {
                    System.out.print(dist[i][j] + "\t");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        /*int[][] graph = {
            {0, 5, INF, 10},
            {INF, 0, 3, INF},
            {INF, INF, 0, 1},
            {INF, INF, INF, 0}
        
        };*/
        int[][] graph = {
            {0, 2, INF, -4, INF},
            {INF, 0, -2, 1, 3},
            {INF, INF, 0, INF , 1},
            {INF, INF, INF, 0, 4},
            {INF, INF, INF, INF,0}
        };

        Pc5_FloydWarshall fw = new Pc5_FloydWarshall();
        fw.floydWarshall(graph);
    }
}
    
   
