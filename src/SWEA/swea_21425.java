package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class swea_21425 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            String[] lines = br.readLine().split(" ");
            int a = Integer.parseInt(lines[0]);
            int b = Integer.parseInt(lines[1]);
            int N = Integer.parseInt(lines[2]);

            int count = 0;
            while(a <= N && b <= N){
                if(a < b)
                    a+=b;
                else
                    b+=a;
                count++;
            }
            System.out.println(count);
        }
    }
}
