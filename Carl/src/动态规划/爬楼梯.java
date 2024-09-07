package 动态规划;

public class 爬楼梯 {
    public int climbStairs(int n) {
        int[] f = new int[n+1];
        f[0] = 0;
        f[1] = 1;
        if (n >= 2) f[2] = 2;
        for (int i = 3; i < n; i++) {
            f[i] = f[i -2] + f[i - 1];
        }
        return f[n];

    }

    public int climbStairs1(int n) {
        if (n <= 2) return n;
        return climbStairs1(n - 2) + climbStairs1(n-1);
    }

    public static void main(String[] args) {
        System.out.println(new 爬楼梯().climbStairs1(45));
    }
}
