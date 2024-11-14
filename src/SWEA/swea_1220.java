package SWEA;

import java.util.Scanner;

public class swea_1220 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int tc = 1; tc <= 10; tc++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            int count = 0;

            for (int j = 0; j < n; j++) {
                boolean flag = false;
                for(int i = 0; i < n; i++) {
                    if(arr[i][j] == 1)
                        flag = true;
                    if(flag && arr[i][j] == 2) {
                        count++;
                        flag = false;
                    }
                }
            }
            System.out.println("#" + tc + " " + count);
        }
    }
}
