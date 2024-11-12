package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class swea_1204 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int scores[] = new int[101];
            String[] s = br.readLine().split(" ");

            for(int i=0; i<s.length; i++){
                scores[Integer.parseInt(s[i])]++;
            }

            int max = 0;
            int maxIdx = 0;
            for(int i=0; i<scores.length; i++){
                if(scores[i] >= max){
                    max = scores[i];
                    maxIdx = i;
                }
            }

            System.out.println("#" + n + " " + maxIdx);
        }
    }
}
