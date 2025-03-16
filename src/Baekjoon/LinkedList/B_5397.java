package Baekjoon.LinkedList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class B_5397 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int index = 0;
            String L = br.readLine();
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < L.length(); i++) {
                if(L.charAt(i) == '<') {
                    index--;
                    if(index < 0) {
                        index = 0;
                    }
                }

                else if(L.charAt(i) == '>') {
                    index++;
                    if(index >= sb.length()) {
                        index = sb.length();
                    }
                }

                else if((48 <= L.charAt(i) && L.charAt(i) <= 57) || (65 <= L.charAt(i) && L.charAt(i) <= 90) || (97 <= L.charAt(i) && L.charAt(i) <= 122)) {
                    sb.insert(index, L.charAt(i));
                    index++;
                }

                else if(L.charAt(i) == '-') {
                    if(index == 0)
                        continue;
                    sb.delete(index-1, index);
                    index--;
                    if(index < 0) {
                        index = 0;
                    }
                }
            }
            System.out.println(sb);
        }
    }
}
