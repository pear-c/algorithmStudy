package CodingTest.Greedy;

import java.util.Scanner;

public class B_1541 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sum = Integer.MAX_VALUE;
        String[] subStr = sc.nextLine().split("-");

        for(int i=0; i<subStr.length; i++) {
            int temp = 0;

            String[] addStr = subStr[i].split("\\+");

            for(int j=0; j<addStr.length; j++) {
                temp += Integer.parseInt(addStr[j]);
            }

            if(sum == Integer.MAX_VALUE) {
                sum = temp;
            } else {
                sum -= temp;
            }
        }

        System.out.println(sum);
    }
}
