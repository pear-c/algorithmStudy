package Baekjoon;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        for(int i=0; i<N; i++) {
            list.add(sc.nextInt());
        }

        Collections.sort(list);


        int prev = 0;
        A: for(int i=0; i<N-2; i++) {
            for(int j=i+1; j<N-1; j++) {
                for(int k=j+1; k<N; k++) {
                    int sum = list.get(i) + list.get(j) + list.get(k);
                    if(sum == M) {
                        System.out.println(sum);
                        break A;
                    } else if(sum > M) {
                        System.out.println(prev);
                        break A;
                    }
                    prev = sum;
                }
            }
         }
    }
}
