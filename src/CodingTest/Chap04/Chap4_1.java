package CodingTest.Chap04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Chap4_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int x = 1;
        int y = 1;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        String[] moves = {"L", "R", "U", "D"};

        String[] command = br.readLine().split(" ");
        for(int i=0; i<command.length; i++) {
            for(int j=0; j<moves.length; j++) {
                if(command[i].equals(moves[j])) {
                    x += dx[j];
                    y += dy[j];
                    if(x < 1 || y < 1 || x > N || y > N) {
                        x -= dx[j];
                        y -= dy[j];
                        continue;
                    }
                    break;
                }
            }
        }
        System.out.println(y + " " + x);
    }
}
