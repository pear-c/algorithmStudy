package CodingTest.DP;

import java.util.Arrays;
import java.util.Scanner;

// 백준 18353 - 병사 배치하기
public class DP_34 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
        }

        int[] dp = new int[N];
        Arrays.fill(dp, 1);

        for(int i=1; i<N; i++) {
            for(int j=0; j<i; j++) {
                if(arr[j] > arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int maxLDS = 0;
        for(int i=0; i<N; i++) {
            maxLDS = Math.max(maxLDS, dp[i]);
        }
        System.out.println(N - maxLDS);

    }
}
