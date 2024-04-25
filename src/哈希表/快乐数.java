package 哈希表;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 快乐数 {
    public  boolean isHappy(int n) {
        Set<Integer> sumSet = new HashSet<>();
        sumSet.add(n);
        boolean b = true;
        while (n!=1 && b){
            n = addSum(n);
            b = sumSet.add(n);
        }
        return n==1;

    }

    public int addSum(int n){
        int sum = 0;
        while (n > 0){
            Integer i = n%10;
            sum += i * i;
            n = n / 10;
        }

        return sum;
    }


}
