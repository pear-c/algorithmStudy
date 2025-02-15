package CodingTest.Implementation;

import java.util.Arrays;

public class Impl_04 {
    // 90도 회전 함수
    static int[][] rotate(int[][] key) {
        int n = key.length;
        int[][] rotated = new int[n][n];

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                rotated[j][n-i-1] = key[i][j];
            }
        }
        return rotated;
    }

    static boolean check(int[][] extendedLock, int lockSize) {
        for(int i=lockSize; i<lockSize*2; i++) {
            for(int j=lockSize; j<lockSize*2; j++) {
                if(extendedLock[i][j] != 1)
                    return false;
            }
        }

        return true;
    }

    static boolean solution(int[][] key, int[][] lock) {
        int lockSize = lock.length;
        int keySize = key.length;

        // 자물쇠 확장
        int newSize = lockSize * 3;
        int[][] extendedLock = new int[newSize][newSize];

        // 중앙에 기존 lock 삽입
        for(int i=0; i<lockSize; i++) {
            for(int j=0; j<lockSize; j++) {
                extendedLock[i + lockSize][j + lockSize] = lock[i][j];
            }
        }

        // 90도씩 4번 회전
        for(int rot=0; rot<4; rot++) {
            key = rotate(key);

            for(int x=0; x<newSize - keySize; x++) {
                for(int y=0; y<newSize - keySize; y++) {
                    // key 삽입
                    for(int i=0; i<keySize; i++) {
                        for(int j=0; j<keySize; j++) {
                            extendedLock[x+i][y+j] += key[i][j];
                        }
                    }

                    // key가 lock에 맞는지 확인
                    if(check(extendedLock, lockSize)) {
                        return true;
                    }

                    // key 제거
                    for(int i=0; i<keySize; i++) {
                        for(int j=0; j<keySize; j++) {
                            extendedLock[x+i][y+j] -= key[i][j];
                        }
                    }
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] key = {
                {0,0,0},
                {1,0,0},
                {0,1,1}
        };
        int[][] lock = {
                {1,1,1},
                {1,1,0},
                {1,0,1}
        };

        System.out.println(solution(key, lock));
    }
}
