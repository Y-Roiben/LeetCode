package 贪心;

import java.util.Arrays;
import java.util.Map;

/**
 * hard
 * */
public class 分发糖果 {
    public int candy(int[] ratings) {

        int[] candy = new int[ratings.length];
        Arrays.fill(candy, 1);
        for (int i = 1; i < ratings.length; i++) {
            // 右边比左边大
            if (ratings[i] > ratings[i-1]){
                candy[i] = candy[i-1] + 1;
            }
        }
//        System.out.println(Arrays.toString(candy));
        // 左边比右边大
        for (int r = candy.length-2; r >= 0; r--) {
            if (ratings[r] > ratings[r+1]){
                // 既要满足左边，也要满足右边, 取max
                candy[r] = Math.max(candy[r+1] + 1, candy[r]);
            }
        }
//        System.out.println(Arrays.toString(candy));
        int sum = 0;
        for (int i : candy) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        int candy = new 分发糖果().candy(new int[]{1, 3, 4, 5, 2});
        System.out.println(candy);
    }
}
