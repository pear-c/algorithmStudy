package CodingTest.Greedy;


import java.util.Arrays;
import java.util.Scanner;

public class B_11399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        int[] arr = new int[N];
        int[] temp = new int[N];

        for(int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        temp[0] = arr[0];
        for(int i=1; i<N; i++) {
            temp[i] = temp[i-1] + arr[i];
        }

        System.out.println(Arrays.stream(temp).sum());
    }
}
