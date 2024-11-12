package SWEA;

import java.io.IOException;
import java.util.Scanner;

public class swea_1206 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        for(int i=0; i<10; i++) {
            int N = sc.nextInt();
            int arr[] = new int[N];
            for(int j=0; j<N; j++) {
                arr[j] = sc.nextInt();
            }

            int count = 0;
            for(int j=2; j<N-2; j++) {
                int max = Math.max(arr[j-2], Math.max(arr[j-1], Math.max(arr[j+1], arr[j+2])));
                if(arr[j] - max > 0)
                    count += (arr[j] - max);
            }
            System.out.println("#" + (i+1) + " " + count);
        }
    }
}
