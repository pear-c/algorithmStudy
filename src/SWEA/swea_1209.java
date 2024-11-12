package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class swea_1209 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = 10;
        int[][] arr = new int[100][100];

        for(int tc = 1; tc <= T; tc++) {
            int t = sc.nextInt();
            for(int i=0; i<100; i++){
                for(int j=0; j<100; j++){
                    arr[i][j] = sc.nextInt();
                }
            }

            int leftCross = 0;
            int rightCross = 0;
            int[] colTotal = new int[100];
            int[] rowTotal = new int[100];
            for(int i=0; i<100; i++){
                for(int j=0; j<100; j++){
                    if(i == j)
                        leftCross += arr[i][j];
                    if(i+j == arr.length-1)
                        rightCross += arr[i][j];

                    rowTotal[i] += arr[i][j];
                    colTotal[i] += arr[j][i];
                }
            }
            Arrays.sort(rowTotal);
            Arrays.sort(colTotal);

            int max = Math.max(leftCross, Math.max(rightCross, Math.max(rowTotal[99], colTotal[99])));
            System.out.println("#" + tc + " " + max);
        }
    }
}
