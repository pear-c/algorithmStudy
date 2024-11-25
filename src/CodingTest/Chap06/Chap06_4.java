package CodingTest.Chap06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Chap06_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        Integer[] B = new Integer[N];   // 내림차순 정렬하기 위해 Integer 배열 선언
        // 배열 A 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        // 배열 B 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        // A는 오름차순, B는 내림차순 정렬
        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());

        // K번 바꿔치기 하므로, K번까지는 두 배열 중 큰 수를 더하고, 이후에는 A배열의 나머지 원소를 더함
        int sum = 0;
        for(int i=0; i<K; i++) {
            if(B[i] > A[i])
                sum += B[i];
            else
                sum += A[i];
        }
        for(int i=K; i<N; i++) {
            sum += A[i];
        }
        System.out.println(sum);
    }
}
