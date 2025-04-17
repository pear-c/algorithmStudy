package Baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class B_2798 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        for(int i=0; i<N; i++) {
            list.add(sc.nextInt());
        }

        Collections.sort(list);

        int max = 0;
        for(int i=0; i<N-2; i++) {
            for(int j=i+1; j<N-1; j++) {
                for(int k=j+1; k<N; k++) {
                    int sum = list.get(i) + list.get(j) + list.get(k);
                    if(sum <= M) {
                        max = Math.max(sum, max);
                    }
                }
            }
        }
        System.out.println(max);
    }
}
