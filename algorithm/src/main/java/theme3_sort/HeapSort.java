package theme3_sort;

public class HeapSort {

    public static void heapSort(int[] A) {
        int eh, temp;

        eh = A.length - 1;

        // Description : 주어진 배열을 힙으로
        buildHeap(A, eh);

        // 힙에서 최댓값 제거 후 다시 힙으로
        while (eh > 1) {
            // 루트와 맨 마지막 교환
            temp = A[1];
            A[1] = A[eh];
            A[eh] = temp;

            // 힙에서 최댓값 제거
            eh -= 1;

            // 남은 트리를 다시 힙으로 만든다
            pushDown(A, 1, eh/2, eh);
        }
    }

    // 배열을 힙으로 만든다
    private static void buildHeap(int[] A, int eh) {
        int bh, x;

        bh = (A.length - 1) / 2 + 1;

        while (bh > 1) {
            bh -= 1;
            x = bh;

            pushDown(A, x, bh, eh);
        }
    }


    // A[x]를 힙 조건이 만족될 때까지 트리의 아래 층으로 내려 보낸다
    private static void pushDown(int[] A, int x, int bh, int eh) {
        int y, temp;

        y = findLarger(A, x, eh);

        while (A[x] < A[y]) {
            temp = A[x];
            A[x] = A[y];
            A[y] = temp;

            x = y;

            y = findLarger(A, x, eh);
        }
    }

    // A[x]보다 더 큰 값을 가지는 x의 자식 노드의 지수를 구한다
    private static int findLarger(int[] A, int x, int eh) {
        int y = 0;

        if (2 * x  + 1 <= eh) { // 자식 노드가 둘 다 있는 경우

            if (A[2 * x] > A[x] || A[2 * x + 1] > A[x]) {
                // A[x]보다 더 큰 값을 가지는 자식 노드의 지수를 구한다
                if (A[2 * x] >= A[2 * x + 1]) {
                    y = 2 * x;

                } else {
                    y = 2 * x + 1;
                }
            } else { // 자식 노드가 하나만 있는 경우

                if (2 * x <= eh && A[2 * x] > A[x]) {
                    y = 2 * x;
                }
            }

        }
        return y;
    }

    public static void main(String[] args) {

        int[] intArray = {0, 1, 2, 6, 4, 8, 7};

        System.out.print("정렬 전 배열 : ");
        for (int i = 1; i < intArray.length; i++) {
            System.out.print(intArray[i] + " ");
        }

        heapSort(intArray);

        System.out.print("\n정렬 후 배열 : ");
        for (int i = 1; i < intArray.length; i++) {
            System.out.print(intArray[i] + " ");
        }

    }
}
