package CodingTest.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DP_test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        int[] dp = new int[30001];

        for(int i = 2; i <= X; i++) {
            dp[i] = dp[i-1] + 1;

            if(i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i%2] + 1);
            }

        }
    }
}
