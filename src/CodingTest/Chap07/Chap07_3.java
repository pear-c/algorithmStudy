package CodingTest.Chap07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Chap07_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // N, M 입력
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        // 떡 길이 입력
        int[] cakes = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cakes[i] = Integer.parseInt(st.nextToken());
        }
        // 이진 탐색 시작점, 끝점
        int start = 0;
        int end = Arrays.stream(cakes).max().getAsInt();
        // 이진 탐색 수행
        int result = 0;
        while(start <= end) {
            int total = 0;
            int mid = (start + end) / 2;
            for(int i : cakes) {
                if(i > mid)
                    total += (i - mid);
            }
            // 떡의 양이 부족한 경우 더 많이 자르기(왼쪽 부분 탐색)
            if(total < M)
                end = mid - 1;
            // 떡의 양이 충분한 경우 덜 자르기(오른쪽 부분 탐색)
            else {
                result = mid;   // 최대한 덜 잘랐을 때가 정답이므로, 여기에서 result에 기록
                start = mid + 1;
            }
        }
        System.out.println(result);
    }
}
