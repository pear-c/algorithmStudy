package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_14916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int coin = 0;   // 동전 개수
        int n = Integer.parseInt(br.readLine()); // 테스트 케이스

        while(n % 5 != 0 && n > 0) {
            n-=2;
            coin++;
        }
        if(n % 5 == 0) {
            coin += (n/5);
            System.out.println(coin);
        } else {
            System.out.println(-1);
        }
    }
}
