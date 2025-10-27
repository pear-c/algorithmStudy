package Programmers;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static int solution(int[] players, int m, int k) {
        int count = 0;
        int[] servers = new int[players.length];

        // Queue 생성 후

        for(int i=0; i<24; i++) {
            int n = players[i] / m;
            if(n > 0) {
                // 큐에 n


                if(servers[i] == 0) {
                    for(int j=0; j<k; j++) {
                        servers[i] = n;
                    }
                    count += n;
                } else {
                    for(int j=0; j<k; j++) {
                        servers[i] = n;
                    }

                }



                count += n;
            }





        }




        return count;
    }
    public static void main(String[] args) {
        int m = 3;
        int k = 5;
        int[] players = new int[] {0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5};
        System.out.println(solution(players, m, k));
    }
}
