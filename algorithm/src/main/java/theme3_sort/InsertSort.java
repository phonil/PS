package theme3_sort;

public class InsertSort {
    
    // for문은 진행 순서에 따라 for문의 구조가 달라질 수 있다는 생각 하기
    // 나눠졌다고 무조건 나눠진대로 for문을 분리하는 것은 x !! -> 순서도 생각해야 함
    // arr1[] arr2[] 두 개로 분리됨 but, --> arr2 먼저, 그 후 arr1 하는 경우처럼 말이야 !

    // 작게 분리 후, 분리된 작은 뭉치의 목적이 뭔 지 생각
    // insertNum을 적절한 위치에 넣기 -> arr[j] > insertNum : 말 그대로 더 앞으로 가야된다는 소리 ! / 멈추는 조건은 안가도 될 때
    // 종료 조건 잘 생각
    
    public static void insertSort(int[] arr) {
        int j;
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            j = i - 1; // arr1[]
            int insertNum = arr[i];
            while (j >= 0 && arr[j] > insertNum) { // insertNum이 arr[j]보다 크면(크거나 같으면) 삽입하고 반복 종료.
                arr[j + 1] = arr[j]; // j 오른쪽으로 한 칸 이동
                j -= 1; // 이제 왼쪽 j 보자
            }
            arr[j + 1] = insertNum; // 삽입
        }
    }

    public static void main(String[] args) {

        int[] arr = {7, 3, 6, 1, 5, 4, 13, 11};
        insertSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
