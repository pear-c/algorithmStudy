package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_5374 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스
        int n = Integer.parseInt(br.readLine());

        while(n-- > 0) {
            String[] line = br.readLine().split(" ");
            // 조건 보고 int -> long 변경 (100만)
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);

            System.out.println(lcm(a,b));
        }
    }

    // GCD, 최대공약수
    public static long gcd(int a, int b) {
        if(b == 0)
            return a;
        return gcd(b, a % b);
    }
    // LCM, 최소공배수
    public static long lcm(int a, int b) {
        return (long)a * b / gcd(a, b);
    }
}
