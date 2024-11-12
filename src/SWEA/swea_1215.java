package SWEA;

import java.util.Scanner;

public class swea_1215 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = 10;
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();

            int count = 0;
            boolean flag = true;

            char[][] arr = new char[8][8];

            for(int i=0; i<8; i++){
                String s = sc.next();
                for(int j=0; j<8; j++){
                    arr[i][j] = s.charAt(j);
                }
            }

            for(int i=0; i<8; i++){
                for(int j=0; j<8-N+1; j++){
                    flag = true;
                    for(int k=0; k<N/2; k++){
                        if(arr[i][j+k] != arr[i][j-k+N-1])
                            flag = false;
                    }
                    if(flag) count++;

                    flag = true;
                    for(int k=0; k<N/2; k++){
                        if(arr[j+k][i] != arr[j-k+N-1][i])
                            flag = false;
                    }
                    if(flag) count++;
                }
            }
            System.out.println("#" + tc + " " + count);
        }
    }
}
