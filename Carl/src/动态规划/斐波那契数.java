package 动态规划;

public class 斐波那契数 {
    public int fib(int n) {
        int[] f =new int[n+1];
        f[0] = 0;
        if (n >= 1) f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i-1] +f[i -2];
        }
        return f[n];
    }

    public int fib1(int n) {
        if (n <= 1) return n;
        return fib1(n-1) + fib1(n-2);
    }

}
