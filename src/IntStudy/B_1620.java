package IntStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// [백준_1620] 나는야 포켓몬 마스터 이다솜
public class B_1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N(포켓몬 개수), M(문제 개수) 입력
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // key : 포켓몬, value : 도감번호
        HashMap<String, Integer> map = new HashMap<>();
        // 도감번호 -> 포켓몬 접근용 배열
        String[] arr = new String[N+1];


        // 포켓몬 입력
        for(int i=1; i<=N; i++){
            String pokemon = br.readLine();
            map.put(pokemon, i);
            arr[i] = pokemon;
        }

        // 풀어야 할 문제 (입력 : 포켓몬 -> 도감번호 / 도감번호 -> 포켓몬)
        for(int i=0; i<M; i++){
            String prob = br.readLine();
            if(prob.charAt(0) >= '0' && prob.charAt(0) <= '9') {
                int do_num = Integer.parseInt(prob);
                System.out.println(arr[do_num]);
            }
            else {
                System.out.println(map.get(prob));
            }
        }
    }
}
