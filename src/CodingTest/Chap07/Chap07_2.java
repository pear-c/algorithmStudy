package CodingTest.Chap07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Chap07_2 {
    static int binary_search(int[] arr, int target, int start, int end) {
        if(start > end) return -1;
        int mid = (start + end) / 2;
        if(arr[mid] == target) return mid;
        else if(arr[mid] > target)
            return binary_search(arr, target, start, mid - 1);
        else
            return binary_search(arr, target, mid + 1, end);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            int res = binary_search(arr, Integer.parseInt(st.nextToken()), 0, N - 1);
            if(res == -1) System.out.print("no ");
            else System.out.print("yes ");
        }
    }
}
