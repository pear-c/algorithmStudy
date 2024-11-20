package IntStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_15724 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);
        int[][] arr = new int[N][M];
        int[][] dp =  new int[N+1][M+1];    // dp 배열 설정
        // arr 초기화
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }
        // dp 배열 초기화
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                dp[i][j] = arr[i-1][j-1] + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];
            }
        }

        int K = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(K-- > 0){
            String[] s = br.readLine().split(" ");
            int x1 = Integer.parseInt(s[0]); // 배열 인덱스 : 0 ~ N-1
            int y1 = Integer.parseInt(s[1]);
            int x2 = Integer.parseInt(s[2]);
            int y2 = Integer.parseInt(s[3]);

            int sum = dp[x2][y2] - dp[x1 - 1][y2] - dp[x2][y1-1] + dp[x1-1][y1-1];
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
