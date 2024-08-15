package 双指针;

public class 盛最多水的容器 {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int Area = 0;
        int max = 0;
        while (left <= right){
            if (height[right] > height[left]){
                Area = (right - left) * height[left];
                max = Math.max(Area, max);
                left++;
            }else {
                Area = (right - left) * height[right];
                max = Math.max(Area, max);
                right--;
            }
        }
        return max;
    }
    public int maxArea1(int[] height) {
        int Area = 0;
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = 1; j < height.length; j++) {
                Area = (j - i) * Math.min(height[i], height[j]);
                max = Math.max(max, Area);

            }
        }
        return max;
    }


}
