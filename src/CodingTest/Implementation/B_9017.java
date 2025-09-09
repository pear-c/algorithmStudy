package CodingTest.Implementation;

import java.util.Arrays;
import java.util.Scanner;

public class B_9017 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while(T-- > 0) {
            int N = sc.nextInt();
            int[] order = new int[N];

            int maxTeamId = 0;
            for(int i=0; i<N; i++) {
                order[i] = sc.nextInt();
                if(order[i] > maxTeamId) {
                    maxTeamId = order[i];
                }
            }

            int[] totalCount = new int[maxTeamId + 1];
            for(int t : order) {
                totalCount[t]++;
            }

            boolean[] check = new boolean[maxTeamId + 1];
            for(int i = 1; i <= maxTeamId; i++) {
                check[i] = (totalCount[i] >= 6);
            }

            int[] validTeam = new int[maxTeamId + 1];
            int[] score =  new int[maxTeamId + 1];
            int[] fifthMember = new  int[maxTeamId + 1];
            Arrays.fill(fifthMember, -1);

            int rank = 0;
            for(int t : order) {
                if(!check[t]) {
                    continue;
                }
                rank++;
                validTeam[t]++;
                if(validTeam[t] <= 4) {
                    score[t] += rank;
                } else if(validTeam[t] == 5) {
                    fifthMember[t] = rank;
                }
            }

            int winner = -1;
            int bestSum = Integer.MAX_VALUE;
            int bestFifth = Integer.MAX_VALUE;

            for(int i = 1; i <= maxTeamId; i++) {
                if(!check[i]) {
                    continue;
                }
                if(validTeam[i] < 5) {
                    continue;
                }

                if(score[i] < bestSum) {
                    bestSum = score[i];
                    bestFifth = fifthMember[i];
                    winner = i;
                } else if(score[i] == bestSum) {
                    if(fifthMember[i] < bestFifth) {
                        bestFifth = fifthMember[i];
                        winner = i;
                    }
                }
            }
            System.out.println(winner);
        }
    }
}
