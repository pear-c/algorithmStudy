package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class B_20436 {
    static Map<Character, int[]> LeftKey = new HashMap<>();  // 왼손 키보드
    static Map<Character, int[]> RightKey = new HashMap<>(); // 오른손 키보드
    static int count = 0;  // 정답

    // 거리 계산 함수
    static int distance(int[] a, int[] b) {
        return (int)(Math.sqrt(Math.pow((a[0]-b[0]), 2)) + Math.sqrt(Math.pow((a[1]-b[1]), 2)));
    }

    // 입력된 문자가 왼쪽 자판인지 오른쪽 자판인지 확인용 함수
    static boolean checkLeftKey(char c) {
        return LeftKey.containsKey(c);
    }
    static boolean checkRightKey(char c) {
        return RightKey.containsKey(c);
    }

    public static void main(String[] args) throws IOException {
        // 키보드 설정(왼손)
        LeftKey.put('z', new int[]{0, 0}); LeftKey.put('a', new int[]{0, 1}); LeftKey.put('q', new int[]{0, 2});
        LeftKey.put('x', new int[]{1, 0}); LeftKey.put('s', new int[]{1, 1}); LeftKey.put('w', new int[]{1, 2});
        LeftKey.put('c', new int[]{2, 0}); LeftKey.put('d', new int[]{2, 1}); LeftKey.put('e', new int[]{2, 2});
        LeftKey.put('v', new int[]{3, 0}); LeftKey.put('f', new int[]{3, 1}); LeftKey.put('r', new int[]{3, 2});
                                           LeftKey.put('g', new int[]{4, 1}); LeftKey.put('t', new int[]{4, 2});
        // 키보드 설정(오른손)
        RightKey.put('b', new int[]{4, 0});
        RightKey.put('n', new int[]{5, 0}); RightKey.put('h', new int[]{5, 1}); RightKey.put('y', new int[]{5, 2});
        RightKey.put('m', new int[]{6, 0}); RightKey.put('j', new int[]{6, 1}); RightKey.put('u', new int[]{6, 2});
                                            RightKey.put('k', new int[]{7, 1}); RightKey.put('i', new int[]{7, 2});
                                            RightKey.put('l', new int[]{8, 1}); RightKey.put('o', new int[]{8, 2});
                                                                                RightKey.put('p', new int[]{9, 2});

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        // 시작 자판 입력
        char startLeft = input[0].charAt(0);
        char startRight = input[1].charAt(0);

        // 입력 문자열
        String s = br.readLine();

        // 왼쪽, 오른쪽 손 위치
        char leftHand = startLeft;
        char rightHand = startRight;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            // 왼쪽 자판 키 입력 됐을 경우
            if(checkLeftKey(c)) {
                int distance = distance(LeftKey.get(c), LeftKey.get(leftHand));
                count += (distance + 1);
                leftHand = c;
            }
            else if(checkRightKey(c)) {
                int distance = distance(RightKey.get(c), RightKey.get(rightHand));
                count += (distance + 1);
                rightHand = c;
            }
        }

        System.out.println(count);
    }
}
