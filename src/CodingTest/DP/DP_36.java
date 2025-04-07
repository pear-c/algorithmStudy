package CodingTest.DP;


import java.util.Scanner;

public class DP_36 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String A = sc.nextLine();
        String B = sc.nextLine();

        int n = A.length();
        int m = B.length();

        int[][] dp = new int[n+1][m+1];

        for(int i=0; i<=n; i++) {
            dp[i][0] = i;
        }
        for(int i=0; i<=m; i++) {
            dp[0][i] = i;
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(A.charAt(i-1) == B.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1]));
                }
            }
        }
        System.out.println(dp[n][m]);
    }
}
