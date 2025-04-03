package CodingTest.DP;

import java.util.Scanner;

// 백준 14501 - 퇴사
public class DP_33 {
    static int N;
    static int[] timeSchedule;
    static int[] priceSchedule;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        timeSchedule = new int[N];
        priceSchedule = new int[N];

        for(int i=0; i<N; i++) {
            timeSchedule[i] = sc.nextInt();
            priceSchedule[i] = sc.nextInt();
        }

        for(int i=0; i<N; i++) {
            int[] dp = new int[N];
            dp[i] = priceSchedule[i];

            int time = 0;
            int price = 0;
            while(time < N) {

            }
        }

    }
}
