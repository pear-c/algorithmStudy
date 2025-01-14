package CodingTest.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Greedy_04 {
    public static int N;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        // 1. N 입력, 각 동전 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(input[i]);
        }

        // 2. 각 동전으로 만들 수 있는 경우의 수 모두 계산
        Arrays.sort(arr);

        int target = 1;
        for(int i : arr) {
            if(target < i)
                break;
            target += i;
        }
        System.out.println(target);
    }

}
