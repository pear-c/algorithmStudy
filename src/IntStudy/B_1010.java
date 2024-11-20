package IntStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1010 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int res = Combine(b, a); // nCr
            System.out.println(res);
        }

    }
    public static int Combine(int n, int r){
        if(r == 0 || n == 0) return 1;
        int result = 1;
        for(int i=0; i<r; i++) {
            result *= (n-i); // ex) 5C4 -> 5 x 4 x 3 x 2 ...
            result /= (i+1); // ex) 5C4 ->   / 4 / 3 / 2 ...
        }

        return result;
    }
}
