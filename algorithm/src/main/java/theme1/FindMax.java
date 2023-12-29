package theme1;

public class FindMax {

    public static int findMax(int[] arr) {

        int max = arr[0];

        for (int i : arr) {
            if (max < i)
                max = i;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] intArr = {5, 75, 46, 23, 77, 90, 65};

        int max = findMax(intArr);
        System.out.println(max);
    }
}
