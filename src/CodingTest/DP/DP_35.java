package CodingTest.DP;

import java.util.Scanner;

// Google 인터뷰
public class DP_35 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] dp = new int[n+1];
        dp[0] = 1;

        int i2 = 0, i3 = 0, i5 = 0;
        int next2 = 2, next3 = 3, next5 = 5;

        for(int i=1; i<n; i++) {
            dp[i] = Math.min(next2, Math.min(next3, next5));
            if(dp[i] == next2) {
                i2++;
                next2 = dp[i2] * 2;
            }
            if(dp[i] == next3) {
                i3++;
                next3 = dp[i3] * 3;
            }
            if(dp[i] == next5) {
                i5++;
                next5 = dp[i5] * 5;
            }
        }
        System.out.println(dp[n-1]);
    }

}
