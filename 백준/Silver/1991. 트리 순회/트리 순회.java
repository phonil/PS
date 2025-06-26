
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] p;
    static int[] lc;
    static int[] rc;
    static StringBuilder sb = new StringBuilder();
    static void preOrder(int parent) {
        sb.append((char) (parent + 'A' - 1));
        int left = lc[parent];
        if (left != 0)
            preOrder(left);
        int right = rc[parent];
        if (right != 0)
            preOrder(right);
    }

    static void inOrder(int parent) {
        int left = lc[parent];
        if (left != 0)
            inOrder(left);
        sb.append((char) (parent + 'A' - 1));
        int right = rc[parent];
        if (right != 0)
            inOrder(right);
    }

    static void postOrder(int parent) {
        int left = lc[parent];
        if (left != 0)
            postOrder(left);
        int right = rc[parent];
        if (right != 0)
            postOrder(right);
        sb.append((char) (parent + 'A' - 1));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        p = new int[N + 1];
        lc = new int[N + 1];
        rc = new int[N + 1];

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            char parent = split[0].charAt(0);
            char left = split[1].charAt(0);
            char right = split[2].charAt(0);
            if (left != '.') {
                p[left - 'A' + 1] = parent - 'A' + 1;
                lc[parent - 'A' + 1] = left - 'A' + 1;
            }
            if (right != '.') {
                p[right - 'A' + 1] = parent - 'A' + 1;
                rc[parent - 'A' + 1] = right - 'A' + 1;
            }
        }
        preOrder(1);
        sb.append('\n');
        inOrder(1);
        sb.append('\n');
        postOrder(1);
        System.out.print(sb);
    }
}
