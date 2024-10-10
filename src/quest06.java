import java.util.*;

public class quest06 {
    private static int[] solution(int N, int[] stages){
        int user = stages.length; // 유저 수

        int[] failStage = new int[N+1]; // 현재 스테이지 당 유저 수
        for(int i=0; i<user; i++){
            failStage[stages[i]-1]++;
        }

        HashMap<Integer, Double> res = new HashMap<>();
        for(int i=0; i<failStage.length-1; i++){
            if(failStage[i] == 0)
                res.put(i, 0.);
            else{
                res.put(i, failStage[i]/(double)user);
                user -= failStage[i];
            }
        }

        List<Map.Entry<Integer, Double>> list = new ArrayList<>(res.entrySet());
        list.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        int[] sorted = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            sorted[i] = list.get(i).getKey() + 1;
        }

        return sorted;
    }

    public static void main(String[] args) {
        int N = 4;
        int[] stages = {4, 4, 4, 4, 4};

        int[] res = solution(N, stages);
        for(int n : res)
            System.out.printf("%d ", n);
    }
}
