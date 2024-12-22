package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1244 {
    static int N;
    static boolean[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 전구 입력 (1 -> True / 0 -> False)
        N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        arr = new boolean[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = input[i-1].equals("1");
        }
        // 학생 명령 입력
        int students = Integer.parseInt(br.readLine());
        for (int i = 0; i < students; i++) {
            String[] command = br.readLine().split(" ");
            int sex = Integer.parseInt(command[0]);
            int switchNum = Integer.parseInt(command[1]);

            if(sex == 1)
                male(switchNum);
            else if(sex == 2)
                female(switchNum);
        }

        for(int i=1; i<=N; i++) {
            System.out.print((arr[i] ? 1 : 0) + " ");
            if(i % 20 == 0)
                System.out.println();
        }
    }

    static void male(int switchNum) {
        for(int i=switchNum; i<=N; i = i+switchNum) {
            if(arr[i]) {
                arr[i] = false;
            } else {
                arr[i] = true;
            }
        }
    }

    static void female(int switchNum) {
        int left = switchNum;
        int right = switchNum;

        while(left > 0 && right <= N) {
            if (arr[left] == arr[right]) {
                left--;
                right++;
            }
            else {
                break;
            }
        }

        if(switchNum-1 == left) {
            if(arr[switchNum])
                arr[switchNum] = false;
            else
                arr[switchNum] = true;
        }

        else {
            for (int j = left+1; j < right; j++) {
                if (arr[j]) {
                    arr[j] = false;
                } else {
                    arr[j] = true;
                }
            }
        }
    }
}