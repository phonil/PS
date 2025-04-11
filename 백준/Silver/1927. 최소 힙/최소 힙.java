
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] heap = new int[100005];
    static int sz = 0; // heap에 들어있는 원소의 수

    static void push(int x){ // 삽입하고 올라가는 것
        heap[++sz] = x;
        int idx = sz;
        while (idx != 1) {
            if (heap[idx] > heap[idx/2]) break;
            int tmp = heap[idx];
            heap[idx] = heap[idx/2];
            heap[idx/2] = tmp;
            idx /= 2;
        }
    }

    static int top(){ // 맨 위 반환
        return heap[1];
    }

    static void pop(){ // 마지막이랑 바꾸고, 마지막 삭제, 루트 내리기
        heap[1] = heap[sz--];
        int idx = 1;
        while (idx * 2 <= sz) {
            int lc = idx * 2;
            int rc = idx * 2 + 1;
            int min = lc;
            if (rc <= sz && heap[lc] > heap[rc])
                min = rc;
            if (heap[idx] <= heap[min]) break;
            int tmp = heap[idx];
            heap[idx] = heap[min];
            heap[min] = tmp;
            idx = min;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        while (N --> 0) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                if (sz == 0) sb.append(0).append('\n');
                else {
                    sb.append(top()).append('\n');
                    pop();
                }
            } else {
                push(num);
            }
        }
        System.out.print(sb);
    }
}
