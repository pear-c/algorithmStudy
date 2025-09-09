package CodingTest.Greedy;

import java.util.Scanner;

public class B_11047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] arr = new int[N];
        for(int i=N-1; i>=0; i--) {
            arr[i] = sc.nextInt();
        }

        for(int i=0; i<N; i++) {
            if(arr[i] <= K) {
                count += (K / arr[i]);
                K %= arr[i];
            }
        }

        System.out.println(count);
    }
}
