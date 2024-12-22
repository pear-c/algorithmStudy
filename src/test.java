public class test {
    static int solution(int X, int[][] H) {
        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] days = new int[7];

        int idx = X-1;
        int count = 0;

        for(int i=0; i<months.length; i++) {
            for(int j=1; j<=months[i]; j++) {
                days[idx % 7]++;
                for(int k=0; k<H.length; k++) {
                    if(H[k][0] == i+1 && H[k][1] == j && (idx % 7) != 5 && (idx % 7) != 6) {
                        count++;
                    }
                }
                idx++;
            }
        }

        int answer = days[5] + days[6] + count;
        return answer;
    }
    public static void main(String[] args) {
        int[][] H = {
                {1, 1}, {1, 21}, {1, 22}, {1, 23},
                {3, 1}, {5, 5}, {5, 27}, {6, 6}, {8, 15},
                {9, 28}, {9, 29}, {9, 30}, {10, 3}, {10, 9}, {12, 25}
        };
        System.out.println(solution(7, H));
    }
}
