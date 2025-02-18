
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static char[][] candy;
    static char[][] tmpCandy;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static boolean bound(int nx, int ny) {
        return nx < 0 || ny < 0 || nx >= N || ny >= N;
    }

    static void exchange(int i, int j, int nx, int ny) {
        tmpCandy = new char[N][N];
        for (int k = 0; k < N; k++) {
            for (int l = 0; l < N; l++) {
                tmpCandy[k][l] = candy[k][l];
            }
        }
        char tmp = tmpCandy[i][j];
        tmpCandy[i][j] = tmpCandy[nx][ny];
        tmpCandy[nx][ny] = tmp;
    }

    static int count() {
        int max = 0;
        for (int i = 0; i < N; i++) {
            int rowSum = rowCnt(i);
            int colSum = colCnt(i);
            int mxSum = Math.max(rowSum, colSum);
            max = Math.max(max, mxSum);
        }
        return max;
    }

    static int rowCnt(int i) {
        int rowSum = 1;
        int cnt = 1;
        for (int j = 0; j < N - 1; j++) {
            if (tmpCandy[i][j] != tmpCandy[i][j+1]) {
                rowSum = Math.max(rowSum, cnt);
                cnt = 1;
                continue;
            }
            cnt++;
        }
        rowSum = Math.max(rowSum, cnt);
        return rowSum;
    }
    static int colCnt(int i) {
        int colSum = 1;
        int cnt = 1;
        for (int j = 0; j < N - 1; j++) {
            if (tmpCandy[j][i] != tmpCandy[j+1][i]) {
                colSum = Math.max(colSum, cnt);
                cnt = 1;
                continue;
            }
            cnt++;
        }
        colSum = Math.max(colSum, cnt);
        return colSum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        candy = new char[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                candy[i][j] = line.charAt(j);
            }
        }
        int mxCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (bound(nx, ny)) continue;
                    if (candy[i][j] == candy[nx][ny]) continue;
                    exchange(i, j, nx, ny);
                    mxCnt = Math.max(mxCnt, count());
                }
            }
        }
        System.out.print(mxCnt);
    }
}
