package SWEA;

import java.util.Scanner;

public class swea_1216 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = 10;
        for(int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            char[][] arr = new char[100][100];
            for(int i=0; i<arr.length; i++) {
                String s = sc.next();
                for(int j=0; j<arr[i].length; j++) {
                    arr[i][j] = s.charAt(j);
                }
            }


        }
    }
}
