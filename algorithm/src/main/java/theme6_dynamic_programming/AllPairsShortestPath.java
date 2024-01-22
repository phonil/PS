package theme6_dynamic_programming;

public class AllPairsShortestPath {

    final static int INF = 9999;

    private void findAllPairShortestPath(int[][] graph, int n) {
        int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        printSolution(dist, n);

    }

    private void printSolution(int[][] dist, int n) {
        System.out.println("모든 두 정점들의 쌍 사이의 최단 거리 행렬");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] graph = { {0, INF, 2, INF}, {1, 0, INF, INF}, {INF, 8, 0, 3}, {6, 4, INF, 0}};
        int n = 4;

        AllPairsShortestPath allPairsShortestPath = new AllPairsShortestPath();

        allPairsShortestPath.findAllPairShortestPath(graph, n);
    }
}
