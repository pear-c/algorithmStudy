package CodingTest.BinarySearch;

import java.util.Scanner;

public class BinarySearch_28 {
    static int N;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
        }

        int left = 0;
        int right = N-1;
        System.out.println(findFixedPos(arr, left, right));
    }
    static int findFixedPos(int[] arr, int left, int right) {
        int mid = (left + right) / 2;
        if(left > right) {
            return -1;
        }
        if(arr[mid] == mid) {
            return mid;
        } else if(arr[mid] < mid) {
            return findFixedPos(arr, mid+1, right);
        } else if(arr[mid] > mid) {
            return findFixedPos(arr, left, mid-1);
        }
        return -1;
    }
}
