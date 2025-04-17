package Baekjoon;

import java.util.Scanner;

public class B_1259 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            String line = sc.nextLine();
            if(line.equals("0")) break;

            int check = 0;
            for(int i=0; i<line.length()/2; i++) {
                if(line.charAt(i) != line.charAt(line.length()-1-i)) {
                    check = 1;
                    break;
                }
            }
            if(check == 1) System.out.println("no");
            else System.out.println("yes");
        }
    }
}
