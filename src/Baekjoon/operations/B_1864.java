package Baekjoon.operations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class B_1864 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Character, Integer> map = new HashMap<>();
        map.put('-', 0);
        map.put('\\', 1);
        map.put('(', 2);
        map.put('@', 3);
        map.put('?', 4);
        map.put('>', 5);
        map.put('&', 6);
        map.put('%', 7);
        map.put('/', -1);

        while(true) {
            int num = 0;

            String s = br.readLine();
            if(s.equals("#"))
                break;

            StringBuilder sb = new StringBuilder(s);
            sb.reverse();
            for(int i=0; i<sb.length(); i++) {
                char c = sb.charAt(i);
                num += (map.get(c) * Math.pow(8, i));
            }
            System.out.println(num);
        }
    }
}
