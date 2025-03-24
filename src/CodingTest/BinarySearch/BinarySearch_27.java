package CodingTest.BinarySearch;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BinarySearch_27 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int x = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
        }

        int startIndex = Arrays.binarySearch(arr, x);
        if(startIndex == -1) {
            System.out.println(-1);
            return;
        }

        int result = 0;
        while(arr[startIndex] == x) {
            result++;
            startIndex++;
        }
        System.out.println(result);
    }
}
