package 栈与队列;

import java.util.Arrays;
import java.util.Deque;
import java.util.Hashtable;
import java.util.LinkedList;

// 单调队列
class MyQueue3{

    private final Deque<Integer> q = new LinkedList<>();

    public void pop(int val){
        if (!q.isEmpty() && q.peekFirst() == val){
            q.removeFirst();
        }
    }
    public void add(int val){
        while (!q.isEmpty() && val > q.getLast()){
            q.removeLast();
        }
        q.addLast(val);
    }
    public int getMax(){
        return q.getFirst();
    }
}

public class 滑动窗口最大值 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1) return nums;
        MyQueue3 q = new MyQueue3();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            q.add(nums[i]);
        }
        res[0] = q.getMax();
        int num = 1;
        for (int i = k; i < nums.length; i++) {
            q.pop(nums[i - k]);
            q.add(nums[i]);
            res[num] = q.getMax();
            num++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] res = maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(res));
    }
}
