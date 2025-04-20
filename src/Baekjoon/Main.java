package Baekjoon;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        input = input.replace(" ", "");

        if(input.equals("12345678")) {
            System.out.println("ascending");
        } else if(input.equals("87654321")) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }
    }
}
