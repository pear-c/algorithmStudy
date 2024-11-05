package Ebook;

import java.util.HashMap;
import java.util.HashSet;

public class quest07 {
    // 좌표 평면을 벗어나는지
    private static boolean isValidMove(int nx, int ny){
        return 0 <= nx && nx < 11 && 0 <= ny && ny < 11;
    }

    // 다음 좌표  결정을 위한 해시맵
    private static final HashMap<Character, int[]> location = new HashMap<>();

    private static void initLocation(){
        location.put('U', new int[]{0,1});
        location.put('D', new int[]{0,-1});
        location.put('L', new int[]{-1,0});
        location.put('R', new int[]{1,0});
    }

    private static int solution(String dirs){
        initLocation();

        int x = 5, y = 5;
        HashSet<String> answer = new HashSet<>(); // 겹치는 좌표는 1개로 처리

        for(int i=0; i<dirs.length(); i++){
            int[] offset = location.get(dirs.charAt(i));
            int nx = x + offset[0];
            int ny = y + offset[1];
            if(!isValidMove(nx, ny)){
                continue;
            }

            answer.add(x + " " + y + " " + nx + " " + ny);
            answer.add(nx + " " + ny + " " + x + " " + y);

            x = nx;
            y = ny;
        }

        return answer.size() / 2;
    }
    public static void main(String[] args) {
        String dirs = "ULURRDLLU";
        System.out.println(solution(dirs));
    }
}
