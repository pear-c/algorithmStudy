package Baekjoon;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] tArr = new int[6];
        for(int i=0; i<6; i++) {
            tArr[i] = sc.nextInt();
        }

        int T = sc.nextInt();
        int P = sc.nextInt();

        int tCount = 0;
        for(int i=0; i<6; i++) {
            if(tArr[i] != 0) {
                if(tArr[i] % T == 0) {
                    tCount += (tArr[i] / T);
                } else {
                    tCount += (tArr[i] / T) + 1;
                }
            }
        }
        System.out.println(tCount);
        System.out.println((N/P) + " " + (N%P));
    }
}
