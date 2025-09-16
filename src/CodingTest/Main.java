package CodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Character> list = new ArrayList<>();

        String input = br.readLine();
        int count = 0;

        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(c - '0' >= 0 && c - '0' <= 9) {
                count += c - '0';
            } else {
                list.add(c);
            }
        }

        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for(char c : list) {
            sb.append(c);
        }
        sb.append(count);

        System.out.println(sb);
    }
}
