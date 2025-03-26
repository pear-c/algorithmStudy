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

        int index = Arrays.binarySearch(arr, x);
        if(index == -8) {
            System.out.println(-1);
            return;
        }

        int toLeftIndex = index - 1;
        int toRightIndex = index + 1;
        int count = 1;
        while(arr[toLeftIndex] == x && toLeftIndex > 0) {
            count++;
            toLeftIndex--;
        }
        while(arr[toRightIndex] == x && toRightIndex < N) {
            count++;
            toRightIndex++;
        }
        System.out.println(count);
    }
}
