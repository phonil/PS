
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split(" ");

        Stack<Integer> leftSt = new Stack<>();
        for (int i = 0; i < N; i++)
            leftSt.push(Integer.parseInt(split[i]));
        Stack<Integer> rightSt = new Stack<>();

        int[] ansArr = new int[N];
        for (int i = N - 1; i >= 0; i--) {
            Integer left = leftSt.pop();
            while (!rightSt.isEmpty() && rightSt.peek() <= left) rightSt.pop();
            if (rightSt.isEmpty()) ansArr[i] = -1;
            else ansArr[i] = rightSt.peek();
            rightSt.push(left);
        }
        for (int i : ansArr)
            sb.append(i).append(" ");
        System.out.print(sb);
    }
}
