package theme7_greedy;

import java.util.Scanner;

public class CoinChange {

    public static void main(String[] args) {
        int[] coinValue = {500, 100, 50, 10, 5, 1};

        int[] numCoin = new int[6];
        int change;
        int count = 0;
        int index = 0;
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < numCoin.length; i++)
            numCoin[i] = 0;

        System.out.print("거스름돈을 입력하세요[0-999]: ");
        change = sc.nextInt();

        System.out.println(change + "원의 거스름돈은 다음과 같다: ");
        while (change > 0) {
            numCoin[index] = change / coinValue[index];
            count += numCoin[index];
            change %= coinValue[index];

            if (numCoin[index] > 0) {
                System.out.println(coinValue[index] + "원짜리 동전 " + numCoin[index] + "개");
            }
            index++;
        }
        System.out.println("\n거스름돈에 포함되는 동전들의 수: " + count);
        sc.close();
    }
}
