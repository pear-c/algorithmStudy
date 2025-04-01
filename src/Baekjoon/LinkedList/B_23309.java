package Baekjoon.LinkedList;

import java.io.*;

public class B_23309 {
    static int N, M;
    static int[] nextStations = new int[1000001];
    static int[] prevStations = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);

        inputs = br.readLine().split(" ");
        int headStation = Integer.parseInt(inputs[0]);
        int curStation = headStation;

        for(int i=1; i<N; i++) {
            int nextStation = Integer.parseInt(inputs[i]);

            nextStations[curStation] = nextStation;
            prevStations[nextStation] = curStation;

            curStation = nextStation;
        }
        prevStations[headStation] = curStation;
        nextStations[curStation] = headStation;

        while(M-- > 0) {
            inputs = br.readLine().split(" ");
            String command = inputs[0];
            int i = Integer.parseInt(inputs[1]);
            if(command.equals("BN")) {
                int j = Integer.parseInt(inputs[2]);

                int originNextStation = nextStations[i];
                sb.append(originNextStation).append("\n");

                nextStations[i] = j;
                prevStations[j] = i;
                nextStations[j] = originNextStation;
                prevStations[originNextStation] = j;
            } else if(command.equals("BP")) {
                int j = Integer.parseInt(inputs[2]);

                int originPrevStation = prevStations[i];
                sb.append(originPrevStation).append("\n");

                prevStations[i] = j;
                nextStations[j] = i;
                prevStations[j] = originPrevStation;
                nextStations[originPrevStation] = j;
            } else if(command.equals("CP")) {
                int removeStation = prevStations[i];
                sb.append(removeStation).append("\n");

                int grandPrevStation = prevStations[removeStation];
                nextStations[grandPrevStation] = i;
                prevStations[i] = grandPrevStation;
            } else if(command.equals("CN")) {
                int removeStation = nextStations[i];
                sb.append(removeStation).append("\n");

                int grandNextStation = nextStations[removeStation];
                nextStations[i] = grandNextStation;
                prevStations[grandNextStation] = i;
            }
        }
        System.out.println(sb);
    }
}
