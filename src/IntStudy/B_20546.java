package IntStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_20546 {
    // 준현 매매법 - BNP
    static int BNP(int seedMoney, int[] stocks) {
        // 매수한 주식 개수
        int count = 0;
        for (int stock : stocks) {
            // 시드머니 떨어지면 즉시 종료
            if(seedMoney == 0) break;

            // 시드머니로 주식 구매 가능하다면, 최대한 매수
            if (stock <= seedMoney) {
                int nowCount = (seedMoney / stock);
                seedMoney -= (stock * nowCount);
                count += nowCount;
            }
        }
        return seedMoney + count * stocks[13];
    }
    // 성민 매매법 - TIMING
    static int TIMING(int seedMoney, int[] stocks) {
        int count = 0;  // 매수한 주식 개수
        int checkUp = 0;    // 3일 연속 상승하는지 확인용
        int checkDown = 0;  // 3일 연속 하락하는지 확인용
        for(int i=1; i<stocks.length; i++) {
            // 주가가 하락할 때
            if(stocks[i-1] > stocks[i]) {
                checkDown++;
                checkUp = 0;
                // 3일 연속 하락했고, 시드머니로 주식을 살 수 있으면 구매
                if(checkDown >= 3 && seedMoney >= stocks[i]) {
                    int nowCount = (seedMoney / stocks[i]);
                    seedMoney -= (stocks[i] * nowCount);
                    count += nowCount;
                }
            }
            // 주가가 상승할 때
            else if(stocks[i-1] < stocks[i]) {
                checkUp++;
                checkDown = 0;
                // 3일 연속 상승했고, 보유 주식이 있으면 모두 판매
                if(checkUp >= 3 && count > 0) {
                    seedMoney += (count * stocks[i]);
                    count = 0;
                    checkUp = 0;
                }
            }
        }
        return seedMoney + count * stocks[13];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 시드머니, 주가 입력
        int seedMoney = Integer.parseInt(br.readLine());
        int[] stocks = new int[14];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<stocks.length; i++) {
            stocks[i] = Integer.parseInt(st.nextToken());
        }
        int res1 = BNP(seedMoney, stocks);
        int res2 = TIMING(seedMoney, stocks);
        if(res1 == res2)
            System.out.println("SAMESAME");
        else
            System.out.println(res1 > res2 ? "BNP" : "TIMING");
    }
}
