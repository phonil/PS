package theme3_sort;

public class SelectSort {

    public static void selectSort(int[] arr) {

        int size = arr.length;
        int min;

        for (int i = 0; i < size - 1; i++) {
            min = i;
            for (int j = i + 1; j < size; j++) {
                if (arr[min] > arr[j])
                    min = j;
            }
            swap(arr, i, min);
        }
    }

    private static void swap(int[] arr, int i, int min) {
        int temp;
        temp = arr[i];
        arr[i] = arr[min];
        arr[min] = temp;
    }

    public static void main(String[] args) {

        int[] arr = {7, 3, 6, 1, 5, 4, 13, 11};
        selectSort(arr);
        for (int i = 0; i < arr.length; i++) {

            System.out.println(arr[i]);
        }

    }
}
