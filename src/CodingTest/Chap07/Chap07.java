package CodingTest.Chap07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Chap07 {
    static int binary_search(int[] arr, int target, int start, int end) {
        if(start> end) return -1;
        int mid = (start + end) / 2;
        // 찾은 경우 중간점 인덱스 반환
        if(arr[mid] == target) return mid;
        // 중간점의 값보다 찾고자 하는 값이 작은 경우 왼쪽 확인
        else if(arr[mid] > target)
            return binary_search(arr, target, start, mid - 1);
        // 중간점의 값보다 찾고자 하는 값이 큰 경우 오른쪽 확인
        else
            return binary_search(arr, target, mid + 1, end);
    }

    static int binary_search1(int[] arr, int target, int start, int end) {
        while(start <= end) {
            int mid = (start + end) / 2;
            // 찾은 경우 중간점 반환
            if(arr[mid] == target) return mid;
            // 중간점의 값보다 찾고자 하는 값이 작은 경우 왼쪽 확인
            else if(arr[mid] > target)
                end = mid - 1;
            // 중간점의 값보다 찾고자 하는 값이 큰 경우 오른쪽 확인
            else
                start = mid + 1;
        }
        return -1;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // n과 target 입력
        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        // 배열 원소 입력
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = binary_search1(arr, target, 0, n - 1);
        if(result == -1)
            System.out.println("원소가 존재하지 않습니다");
        else
            System.out.println(result+1);
    }
}
