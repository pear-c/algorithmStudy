package CodingTest.Chap08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Chap08_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());
        // dp 테이블
        int[] dp = new int[30001];
        // Bottom Up
        for(int i=2; i<X+1; i++) {
            // 현재 수에서 1을 빼는 경우
            dp[i] = dp[i-1] + 1;
            // 현재 수가 2로 나누어 떨어지는 경우
            if(i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i/2] + 1);
            }
            // 현재 수가 3으로 나누어 떨어지는 경우
            if(i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i/3] + 1);
            }
            // 현재 수가 5로 나누어 떨어지는 경우
            if(i % 5 == 0) {
                dp[i] = Math.min(dp[i], dp[i/5] + 1);
            }
        }
        System.out.println(dp[X]);
    }
}
