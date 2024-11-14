package SWEA;

import java.util.*;

public class swea_1221 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> map = new HashMap<>();
        map.put("ZRO", 0);
        map.put("ONE", 1);
        map.put("TWO", 2);
        map.put("THR", 3);
        map.put("FOR", 4);
        map.put("FIV", 5);
        map.put("SIX", 6);
        map.put("SVN", 7);
        map.put("EGT", 8);
        map.put("NIN", 9);

        int tc = sc.nextInt();
        while (tc-- > 0) {
            String test = sc.next();
            int n = sc.nextInt();
            ArrayList<String> nums = new ArrayList<>();
            for(int i=0; i<n; i++) {
                nums.add(sc.next());
            }

            Collections.sort(nums, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return Integer.compare(map.get(o1), map.get(o2));
                }
            });
            System.out.println(test);
            for(int i=0; i<nums.size(); i++) {
                System.out.print(nums.get(i) + " ");
            }
            System.out.println();
        }
    }
}
