package CodingTest.DP;

import java.util.Scanner;

public class DP_31 {
    static int tc, n, m;
    static int[][] map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        tc = sc.nextInt();
        while(tc-- > 0) {
            n = sc.nextInt();
            m = sc.nextInt();
            map = new int[n][m];

            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            int[][] dp = new int[n][m];
            for(int i=0; i<n; i++) {
                dp[i][0] = map[i][0];
            }

            int leftUp = 0;
            int leftDown = 0;
            int left = 0;
            for(int j=1; j<m; j++) {
                for(int i=0; i<n; i++) {
                    if(i == 0) {
                        leftUp = 0;
                    } else {
                        leftUp = dp[i-1][j-1];
                    }
                    if(i == n-1) {
                        leftDown = 0;
                    } else {
                        leftDown = dp[i+1][j-1];
                    }
                    left = dp[i][j-1];
                    dp[i][j] = map[i][j] + Math.max(left, Math.max(leftUp, leftDown));
                }
            }

            int result = 0;
            for(int i=0; i<n; i++) {
                result = Math.max(result, dp[i][m-1]);
            }
            System.out.println(result);
        }
    }
}
