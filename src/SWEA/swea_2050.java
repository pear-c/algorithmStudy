package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_2050 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            System.out.print((c-'A'+1) + " ");
        }
    }
}
