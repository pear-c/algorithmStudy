package SWEA;

import java.util.Scanner;

public class swea_1217 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int tc = 1; tc <= 10; tc++) {
            int t = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println("#" + t + " " + pow(a, b));
        }
    }
    static int pow(int a, int b) {
        if(b == 0) {
            return 1;
        }
        return a * pow(a, b - 1);
    }
}
