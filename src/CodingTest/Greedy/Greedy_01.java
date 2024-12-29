package CodingTest.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Greedy_01 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[N];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(arr, Collections.reverseOrder());

        int group = 0;
        for(int i=0; i<N; i++) {
            group++;
            i += (arr[i]-1);
        }
        System.out.println(group);
    }
}
