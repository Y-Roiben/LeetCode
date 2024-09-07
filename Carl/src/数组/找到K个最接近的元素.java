package 数组;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2024-8-29
 * 字节一面手手撕*/
public class 找到K个最接近的元素 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - 1;
        while (right - left >= k){
            if (Math.abs(arr[left] - x) > Math.abs(arr[right] - x)){
                left++;
            }else{
                right--;
            }
        }
        List<Integer> list= new ArrayList<>();
        for (int i = left; i < left+k; i++) {
            list.add(arr[i]);
        }
        return list;

    }

    public List<Integer> findClosestElements2(int[] arr, int k, int x) {
    int left = 0;
    int right = arr.length - 1;

    // Binary search to find the closest element to x
    while (left < right) {
        int mid = left + (right - left) / 2;
        if (arr[mid] < x) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }

    // Initialize two pointers
    int low = Math.max(0, left - 1);
    int high = low + 1;

    // Find the k closest elements
    while (k-- > 0) {
        if (low < 0 || (high < arr.length && Math.abs(arr[high] - x) < Math.abs(arr[low] - x))) {
            high++;
        } else {
            low--;
        }
    }

    // Collect the result
    List<Integer> result = new ArrayList<>();
    for (int i = low + 1; i < high; i++) {
        result.add(arr[i]);
    }

    return result;
}
}
