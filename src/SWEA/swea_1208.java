package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class swea_1208 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = 10;
        int N = 100;
        for(int tc=1; tc<=10; tc++){
            int dump = sc.nextInt();
            int[] arr = new int[N];
            for(int i=0; i<N; i++){
                arr[i] = sc.nextInt();
            }
            for(int i=0; i<dump; i++) {
                Arrays.sort(arr);
                arr[0]++;
                arr[99]--;
            }
            Arrays.sort(arr);
            System.out.println("#" + tc + " " + (arr[99] - arr[0]));
        }
    }
}
