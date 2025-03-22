package CodingTest.Sort;

import java.util.Arrays;
import java.util.Scanner;

// 정렬 Q.24 : 백준 18310 - 안테나
public class Sort_24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int result  = (N % 2 == 0) ? N/2 - 1 : N/2;
        System.out.println(arr[result]);
    }
}
