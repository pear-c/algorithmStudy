package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_18511 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        String s = n+"";
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            int num = (int)(s.charAt(i) - '0');

            for(int j=k-1; j>=0; j--) {
                if(arr[j] == num)
                    sb.append(arr[j]);
                else if(arr[j] < num) {
                    sb.append(arr[j]);
                }
            }


        }
    }
}
