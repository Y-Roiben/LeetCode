package 贪心;

public class 买卖股票的最佳时机II {
    public int maxProfit(int[] prices) {
        if (prices.length < 2){
            return 0;
        }
        int max = 0;
        int profit;
        for (int i = 1; i < prices.length; i++) {
            profit = prices[i] - prices[i-1];
            max += Math.max(profit, 0);
        }
        return  max;
    }
}
