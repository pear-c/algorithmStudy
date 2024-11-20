package IntStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B_11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ab = br.readLine().split(" ");
        int N = Integer.parseInt(ab[0]);
        int M = Integer.parseInt(ab[1]);
        ArrayList<Integer> res = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            res.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            res.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(res);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<res.size(); i++) {
            sb.append(res.get(i)).append(" ");
        }

        System.out.println(sb);
    }
}
