package 栈与队列;

import java.util.*;

public class 前K个高频元素 {
    // 前K个高频元素

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> {
            if (Objects.equals(o1.getValue(), o2.getValue())) {
                return o1.getKey() - o2.getKey();
            }
            return o2.getValue() - o1.getValue();
        });
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = list.get(i).getKey();
        }
        return res;
    }

    // 优先队列
    public int[] topKFrequent2(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((o1, o2) -> {
            if (Objects.equals(o1.getValue(), o2.getValue())) {
                return o2.getKey() - o1.getKey();
            }
            return o1.getValue() - o2.getValue();
        });
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            pq.offer(integerIntegerEntry);
            if (pq.size() > k){
                pq.poll();
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll().getKey();
        }
        return res;
    }
}
