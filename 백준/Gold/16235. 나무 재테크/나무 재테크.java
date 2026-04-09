import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static int answer;

    static int N, M, K;
    static int[][] A;

    static int[][] points; // 양분
    static List<Integer>[][] lTree; // 살아있는 나무들의 나이
    static List<Integer>[][] dTree; // 죽어있는 나무들의 나이

    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    static boolean bound(int nx, int ny) {
        return nx < 0 || ny < 0 || nx >= N || ny >= N;
    }

    static void sortTreeAge() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (lTree[i][j].isEmpty()) continue;
                Collections.sort(lTree[i][j]); /////////
            }
        }
    }

    static void spring() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dTree[i][j] = new ArrayList<>();

                if (lTree[i][j].isEmpty()) continue;

                List<Integer> lTreeList = lTree[i][j];
                List<Integer> toDTreeIdxs = new ArrayList<>();

                for (int k = 0; k < lTreeList.size(); k++) {
                    Integer lTree = lTreeList.get(k);
                    if (points[i][j] < lTree) // 나이가 양분보다 많으면
                        toDTreeIdxs.add(k);
                    else {
                        points[i][j] -= lTree;
                        lTreeList.set(k, lTree + 1); // 나이 1 증가
                    }
                }

                if (toDTreeIdxs.isEmpty()) continue;
                // 뒷 idx부터 삭제 -> idx rmv 순서
                toDTreeIdxs.sort(Collections.reverseOrder());
                // dTree로 이동
                for (int toDTreeIdx : toDTreeIdxs) {
                    Integer addedDTree = lTreeList.get(toDTreeIdx);
                    dTree[i][j].add(addedDTree);

                    lTree[i][j].remove(toDTreeIdx);
                }
            }
        }
    }

    static void summer() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                List<Integer> dTreeList = dTree[i][j];
                if (dTreeList.isEmpty()) continue;
                for (Integer dTree : dTreeList) {
                    int addedPoint = dTree / 2;
                    points[i][j] += addedPoint;
                }
            }
        }
    }

    static void fall() {
        List<Pair> exTreeList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                List<Integer> lTreeList = lTree[i][j];
                if (lTreeList.isEmpty()) continue;
                for (Integer lTree : lTreeList) { // lTree == Tree Age
                    if (lTree == 0 || lTree % 5 != 0) continue;

                    for (int k = 0; k < 8; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (bound(nx, ny)) continue;
                        exTreeList.add(new Pair(nx, ny));
                    }
                }
            }
        }

        // 번식
        for (Pair pair : exTreeList)
            lTree[pair.x][pair.y].add(1);
    }

    static void winter() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (A[i][j] == 0) continue;
                points[i][j] += A[i][j];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        answer = 0;

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        K = Integer.parseInt(split[2]);

        points = new int[N][N];
        lTree = new ArrayList[N][N];
        dTree = new ArrayList[N][N];

        A = new int[N][N];
        for (int i = 0; i < N; i++) {
            split = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(split[j]);
                points[i][j] = 5;
                lTree[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < M; i++) {
            split = br.readLine().split(" ");
            int x = Integer.parseInt(split[0]) - 1;
            int y = Integer.parseInt(split[1]) - 1;
            int z = Integer.parseInt(split[2]);
            lTree[x][y].add(z);
        }

        while (K --> 0) {
            sortTreeAge();
            spring();
            summer();
            fall();
            winter();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (lTree[i][j].isEmpty()) continue;
                answer += lTree[i][j].size();
            }
        }
        System.out.print(answer);
    }

    static class Pair {
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
