
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] heap = new int[100005];
    static int sz = 0; // heap에 들어있는 원소의 수

    static void swap(int a, int b) {
        int tmp = heap[a];
        heap[a] = heap[b];
        heap[b] = tmp;
    }

    static void push(int x){
        heap[++sz] = x;
        int idx = sz;
        while (idx > 1) {
            if (heap[idx/2] > heap[idx]) break;
            swap(idx, idx/2);
            idx /= 2;
        }
    }

    static int top(){ // 맨 위 반환
        return heap[1];
    }

    static void pop(){
        heap[1] = heap[sz--];
        int idx = 1;
        while (idx * 2 <= sz) {
            if (heap[idx] > heap[idx * 2] && heap[idx] > heap[idx * 2 + 1]) break;
            int lIdx = idx * 2;
            int rIdx = idx * 2 + 1;
            int max = lIdx;
            if (heap[lIdx] < heap[rIdx])
                max = rIdx;
            swap(idx, max);
            idx = max;
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
            } else push(num);
        }
        System.out.print(sb);
    }
}
