package CodingTest.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// DFS/BFS Q.19 - 연산자 끼워넣기
public class DFS_BFS_19 {
    static int N;
    static int[] numbers;
    static int[] operators = new int[4];
    static int minValue = Integer.MAX_VALUE;
    static int maxValue = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력 정보 저장
        N = Integer.parseInt(st.nextToken());
        numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, numbers[0]);
        System.out.println(maxValue);
        System.out.println(minValue);
    }

    static void dfs(int index, int currentValue) {
        if(index == N) {
            minValue = Math.min(minValue, currentValue);
            maxValue = Math.max(maxValue, currentValue);
            return;
        }

        for(int i=0; i<4; i++) {
            if(operators[i] > 0) {
                operators[i]--;
                int newValue = calculate(currentValue, numbers[index], i);
                dfs(index + 1, newValue);
                operators[i]++;
            }
        }
    }

    static int calculate(int a, int b, int op) {
        switch (op) {
            case 0: return a+b;
            case 1: return a-b;
            case 2: return a*b;
            case 3: return a/b;
        }
        return 0;
    }
}
