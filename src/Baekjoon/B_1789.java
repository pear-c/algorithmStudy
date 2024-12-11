package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Long S = Long.parseLong(br.readLine());

        int count = 0;
        while(true) {
            count++;
            S -= count;
            if(S == 0) {
                System.out.println(count);
                break;
            }
            else if(S < 0) {
                System.out.println(count-1);
                break;
            }
        }
    }
}
