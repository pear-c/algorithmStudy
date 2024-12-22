package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_18222 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        // k = 1 or 2 이면 무조건 0, 1
        if(k == 1)
            System.out.println(0);
        else if(k == 2)
            System.out.println(1);
        // k가 3 이상일 때
        else {
            // k가 2의 몇승 인지 체크 (배열 크기 확인용)
            double check = Math.log(k) / Math.log(2);
            int findArrIdx = check % 1 == 0 ? (int)check : (int)check + 1;

            // X 배열 생성, 초기화
            StringBuilder[] X = new StringBuilder[findArrIdx + 1];
            for(int i = 0; i < X.length; i++) {
                X[i] = new StringBuilder();
            }
            // X' 배열 생성, 초기화
            StringBuilder[] X_ = new StringBuilder[findArrIdx + 1];
            for(int i = 0; i < X_.length; i++) {
                X_[i] = new StringBuilder();
            }
            // X는 맨 처음에 "0"으로 시작
            X[0].append("0");
            X[1].append("01");
            X_[0].append("1");
            X_[1].append("10");

            for(int i = 2; i < findArrIdx + 1; i++) {
                X[i].append(X[i-1]).append(X_[i-1]);
                X_[i].append(X_[i-1]).append(X[i-1]);
            }

            System.out.println(X[findArrIdx].charAt(k));
        }
    }
}
