package SWEA;

import java.util.Scanner;

public class swea_1213 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = 10;
        for(int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            String search = sc.next();
            String line = sc.next() + " ";
            String[] res = line.split(search);
            System.out.println("#" + tc + " " + (res.length-1));
        }
    }
}
