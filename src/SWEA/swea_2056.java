package SWEA;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class swea_2056 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int T = sc.nextInt();

        for(int i=0; i<T; i++){
            StringBuilder sb = new StringBuilder();
            String line = sc.next();
            String a = line.substring(0, 4);
            String b = line.substring(4, 6);
            String c = line.substring(6, 8);

            if(Integer.parseInt(b) >= 1 && Integer.parseInt(b) <= 12 && Integer.parseInt(c) >= 1 && Integer.parseInt(c) <= days[Integer.parseInt(a)-1]){
                sb.append(a).append("/").append(b).append("/").append(c);
                System.out.println(sb);
            }
            else
                System.out.println(-1);
        }
    }
}
