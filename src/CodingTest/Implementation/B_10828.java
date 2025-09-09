package CodingTest.Implementation;

import java.util.*;

public class B_10828 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] info = new int[N][2];

        for(int i=0; i<N; i++) {
            info[i][0] = sc.nextInt();
            info[i][1] = sc.nextInt();
        }

        for(int i=0; i<N; i++) {
            int rank = 1;

            for(int j=0; j<N; j++) {
                if(i == j) {
                    continue;
                }

                if(info[i][0] < info[j][0] && info[i][1] < info[j][1]) {
                    rank++;
                }
            }

            System.out.print(rank + " ");
        }
    }
}
