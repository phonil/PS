package theme5_divide_and_conquer;

/**
 * TODO : 재귀의 연산은 기저 조건..!
 * Description : 최솟값 / 최댓값 찾기
 */

public class FindMaxMin {

    private static int[] findMaxMin(int[] A, int i, int j) {

        int[] result = new int[2];
        int[] left = new int[2];
        int[] right = new int[2];

        int mid;

        if (i == j) {
            result[0] = A[i];
            result[1] = A[i];
        } else if (i == j - 1) {
            if (A[i] < A[j]) {
                result[0] = A[i];
                result[1] = A[j];
            } else {
                result[0] = A[j];
                result[1] = A[i];
            }

        } else {
            mid = (i + j) / 2;

            left = findMaxMin(A, i, mid);
            right = findMaxMin(A, mid + 1, j);

            // 본 배열 A[]의 최대, 최소
            if (left[0] < right[0])
                result[0] = left[0];
            else
                result[0] = right[0];

            if (left[1] < right[1])
                result[1] = right[1];
            else
                result[1] = left[1];

        }

        return result;

    }

    public static void main(String[] args) {
        int[] A = {24, 75, 92, 83, 61, 48, 97, 50};
        int[] answer = new int[2];
        
        answer = findMaxMin(A, 0, A.length - 1);

        System.out.println("최솟값: " + answer[0]);
        System.out.println("최댓값: " + answer[1]);
    }
}
