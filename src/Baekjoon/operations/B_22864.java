package Baekjoon.operations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_22864 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int A = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);
        int C = Integer.parseInt(input[2]);
        int M = Integer.parseInt(input[3]);

        int time = 0;
        int tired = 0, work = 0;
        while(time < 24) {
            if(tired + A <= M) {
                tired += A;
                work += B;
                time++;
            } else {
                tired -= C;
                time++;
                if(tired < 0)
                    tired = 0;
            }
        }
        System.out.println(work);
    }
}
