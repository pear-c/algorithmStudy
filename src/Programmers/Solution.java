package Programmers;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static int[] solution(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<numbers.length; i++){
            int sub = target - numbers[i];
            if(map.containsKey(sub)) {
                return new int[]{map.get(sub), i};
            }
            map.put(sub, i);
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        int target = 9;
        int[] numbers = new int[] {3, 30, 30, 5, 9};
    }
}
