package Baekjoon.operations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_3029 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] now = br.readLine().split(":");
        String[] throwTime = br.readLine().split(":");

        int currentTimes = Integer.parseInt(now[0]) * 3600
                + Integer.parseInt(now[1]) * 60
                + Integer.parseInt(now[2]);

        int throwTimes = Integer.parseInt(throwTime[0]) * 3600
                + Integer.parseInt(throwTime[1]) * 60
                + Integer.parseInt(throwTime[2]);

        int remainTime = throwTimes - currentTimes;

        if(remainTime <= 0) {
            remainTime += 24 * 3600;
        }

        int hours = remainTime / 3600;
        int minutes = remainTime % 3600 / 60;
        int seconds = remainTime % 60;

        System.out.printf("%02d:%02d:%02d", hours, minutes, seconds);
    }
}
