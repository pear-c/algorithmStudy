package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class swea_1228 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int tc = 1; tc <= 10; tc++) {
            String[] res = new String[10];
            String[] sub = new String[10];
            int n1 = Integer.parseInt(br.readLine());
            String[] strarr1 = br.readLine().split(" ");
            // 초기화
            for(int i=0; i<10; i++)
                res[i] = strarr1[i];

            int n2 = Integer.parseInt(br.readLine());
            String[] strarr2 = br.readLine().split("I ");
            for(int i=1; i<=n2; i++) {
                String[] substr = strarr2[i].split(" ");
                int start = Integer.parseInt(substr[0]);
                int end = Integer.parseInt(substr[1]);
                for(int j=start; j<end; j++)
                    sub[j] = substr[j+2];
            }
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<10; i++) {
                res[i] = sub[i];
                sb.append(res[i]).append(" ");
            }
            System.out.println(sb);
        }
    }
}
