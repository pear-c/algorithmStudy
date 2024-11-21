package CodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Chap3_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
//        // 방법 1.
//        int sum = 0;
//        for(int i=1; i<=M; i++) {
//            if(i % K == 0)
//                sum += arr[N-2];
//            else
//                sum += arr[N-1];
//        }
//        System.out.println(sum);
        int first = arr[N-1];   // 가장 큰 수
        int second = arr[N-2];  // 두번째 큰 수

        // 가장 큰 수가 더해지는 횟수 계산
        int count = (M / (K+1)) * K;
        count += M % (K+1);

        int result = 0;
        result += count * first; // 가장 큰 수 더하기
        result += (M - count) * second;     // 두 번째로 큰 수 더하기

        System.out.println(result);
    }
}
