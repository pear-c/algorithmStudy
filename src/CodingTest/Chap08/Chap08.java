package CodingTest.Chap08;

public class Chap08 {
//    static int fibo(int n) {
//        if (n == 1 || n == 2) return 1;
//        return fibo(n - 1) + fibo(n - 2);
//    }

    static int[] d = new int[100];  // 메모이제이션 배열
//    // 피보나치 수열 - 다이나믹 프로그래밍
//    static int fibo(int n) {
//        // 종료 조건 (1 or 2일때 1반환)
//        if(n == 1 || n == 2) return 1;
//        // 이미 계산한 적 있는 문제라면 그대로 반환
//        if(d[n] != 0) return d[n];
//        // 아직 계산하지 않은 문제라면 점화식에 따라서 피보나치 결과 반환
//        d[n] = fibo(n - 1) + fibo(n - 2);
//        return d[n];
//    }

    public static void main(String[] args) {
        int[] d = new int[100]; // DP 테이블

        // 첫 번째 피보나치 수와 두 번째 피보나치 수는 1
        d[1] = 1;
        d[2] = 2;

        // 피보나치 함수 반복문으로 구현 (Bottom Up)
        for(int i=3; i<100; i++) {
            d[i] = d[i-1] + d[i-2];
        }

        System.out.println(d[99]);
    }
}
