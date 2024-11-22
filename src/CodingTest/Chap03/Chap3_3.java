package CodingTest.Chap03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Chap3_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int max = Integer.MIN_VALUE;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int min = Integer.MAX_VALUE;
            for(int j=0; j<M; j++) {
                int num = Integer.parseInt(st.nextToken());
                min = Math.min(min, num);
            }
            max = Math.max(max, min);
        }
        System.out.println(max);
    }
}
