package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_18511 {
    static int n, k, max;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // N, K 입력
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        // K원소 배열
        arr = new int[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // K원소 배열 정렬
        Arrays.sort(arr);

        max = 0;
        dfs(0);
        System.out.println(max);
    }

    static void dfs(int num) {
        // num이 n보다 크면 리턴(스택에서 제거)
        if(num > n) return;

        max = Math.max(max, num);

        for(int i=0; i<k; i++) {
            dfs(Integer.parseInt(num+"" + arr[i]+""));
        }
    }
}
