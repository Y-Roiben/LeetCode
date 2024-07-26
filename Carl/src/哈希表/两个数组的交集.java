package 哈希表;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class 两个数组的交集 {
//    Hashset
    public int[] intersection(int[] nums1, int[] nums2) {


        Set<Integer> set = new HashSet<>();
        Set<Integer> set1 = new HashSet<>();
        for (int j : nums2) {
            set.add(j);
        }
        for (int i : nums1) {
            if (set.contains(i)){
                set1.add(i);
            }
        }
        int[] res = new int[set1.size()];
        int index = 0;
        for (Integer i : set) {
            res[index] = i;
            index++;
        }
        return res;
//        return set1.stream().mapToInt(value -> value).toArray();

    }
//    数组
    public int[] intersection1(int[] nums1, int[] nums2) {
        boolean[] record = new boolean[1005];
        for (int i : nums1) {
            record[i] = true;
        }
        Set<Integer> set = new HashSet<>();
        for (int i : nums2) {
            if (record[i]){
                set.add(i);
                record[i] = false;
            }
        }
        int[] res = new int[set.size()];
        int index = 0;
        for (Integer i : set) {
            res[index] = i;
            index++;
        }
        return res;

    }
}
