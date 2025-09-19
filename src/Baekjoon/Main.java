package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());

        while(tc-- > 0) {
            List<int[]> q = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                q.add(new int[] {i, Integer.parseInt(st.nextToken())});
            }

            int count = 0;
            while(!q.isEmpty()) {
                int[] front = q.remove(0);
                boolean isMax = true;

                for(int i=0; i<q.size(); i++) {
                    if(front[1] < q.get(i)[1]) {
                        q.add(front);
                        for(int j=0; j<i; j++) {
                            q.add(q.remove(0));
                        }

                        isMax = false;
                        break;
                    }
                }

                if(!isMax) {
                    continue;
                }

                count++;
                if(front[0] == target) {
                    break;
                }
            }

            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}
