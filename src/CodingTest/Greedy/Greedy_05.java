package CodingTest.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Greedy_05 {
    public static void main(String[] args) throws Exception {
        // N, M 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        // 무게 별 볼링공 갯수
        int[] arr = new int[11];
        input = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            arr[Integer.parseInt(input[i])]++;
        }

        int result = 0;
        for(int i=1; i<=M; i++){
            N -= arr[i];
            result += arr[i] * N;
        }

        System.out.println(result);
    }
}
