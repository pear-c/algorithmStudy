package Baekjoon;

import java.io.IOException;
import java.util.*;

public class Main {

    public static int[] solution(int[] arr) {
        // 1. 중복 제거 후 정렬
        Set<Integer> set = new HashSet<>();
        for(int num : arr){
            set.add(num);
        }

        List<Integer> sorted = new ArrayList<>(set);
        Collections.sort(sorted);

        int n = sorted.size();
        int[] result = new int[n];

        // 2. 지그재그 패턴으로 배치
        // 패턴: 가운데부터 시작해서 오른쪽, 왼쪽, 오른쪽, 왼쪽... 순서로 배치

        int mid = (n - 1) / 2;  // 가운데 인덱스
        int leftPtr = mid;      // 왼쪽 포인터
        int rightPtr = mid + 1; // 오른쪽 포인터

        // 첫 번째는 가운데 값 (mid 인덱스)
        result[0] = sorted.get(leftPtr--);

        // 나머지는 오른쪽, 왼쪽 번갈아가며 배치
        for(int i = 1; i < n; i++) {
            if(i % 2 == 1) {
                // 홀수 인덱스: 오른쪽에서 가져오기
                if(rightPtr < n) {
                    result[i] = sorted.get(rightPtr++);
                } else {
                    result[i] = sorted.get(leftPtr--);
                }
            } else {
                // 짝수 인덱스: 왼쪽에서 가져오기
                if(leftPtr >= 0) {
                    result[i] = sorted.get(leftPtr--);
                } else {
                    result[i] = sorted.get(rightPtr++);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {

        int[] arr = {
                3, -2, 8, 5, 3, 9
        };

        for(int num : solution(arr)){
            System.out.print(num + " ");
        }
    }
}
