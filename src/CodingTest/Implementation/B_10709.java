package CodingTest.Implementation;

import java.util.Scanner;

public class B_10709 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int H = sc.nextInt();
        int W = sc.nextInt();

        for(int i = 0; i < H; i++) {
            String line = sc.next();
            boolean isCloud = false;
            int count = 0;
            StringBuilder sb = new StringBuilder();

            for(int j = 0; j < W; j++) {
                if(line.charAt(j) == 'c') {
                    isCloud = true;
                    sb.append("0").append(" ");
                    count = 0;
                } else if(!isCloud) {
                    sb.append("-1").append(" ");
                } else {
                    sb.append(++count).append(" ");
                }
            }
            System.out.println(sb);
        }
    }
}
