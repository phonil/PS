package theme5_divide_and_conquer;

public class MergeSort {

    /**
     * Description : 
     *  mergeSort() 라는 함수 자체가 쪼개는 것 (왼 / 오)
     *  merge() 라는 함수는 정렬을 포함함
     */

    // Description : iteration
    public static void mergeSort2(int[] A, int n) {
        int size = 1;

        while (size < n) {
            for (int i = 0; i < n; i = i + 2 * size) {
                merge(A, i, i + size - 1, i + 2 * size - 1);
            }

            size *= 2;
        }
    }

    // Description : recursion
    public static void mergeSort(int[] A, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;

            mergeSort(A, low, mid);
            mergeSort(A, mid + 1, high);
            merge(A, low, mid, high);
        }

    }

    private static void merge(int[] A, int low, int mid, int high) {
        int h, i, j;

        int[] B = new int[A.length + 1];
        h = low;
        i = low;
        j = mid + 1;

        // 1. 크기 비교 후 넣기
        while (i <= mid && j <= high) {
            if (A[i] <= A[j]) {
                B[h] = A[i];
                i++;
            } else {
                B[h] = A[j];
                j++;
            }
            h++;
        }

        // 2. 왼 / 오 중 남은 것 채워넣기
        if (i > mid) {
            for (int k = j; k <= high; k++) {
                B[h] = A[k];
                h++;
            }
        } else {
            for (int k = i; k <= mid; k++) {
                B[h] = A[k];
                h++;
            }
        }

        for (int k = low; k <= high; k++) {
            A[k] = B[k];
        }
    }

    public static void printArray(int[] A) {
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] A = {91, 82, 13, 85, 68, 70, 98, 24};

        System.out.println("주어진 배열");
        printArray(A);

        mergeSort(A, 0, A.length - 1);
//        mergeSort2(A, A.length - 1);

        System.out.println("정렬된 배열");
        printArray(A);
    }

}
