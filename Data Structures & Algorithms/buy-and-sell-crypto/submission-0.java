class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] minValue = new int[n];
        minValue[0] = prices[0];
        for(int i = 1; i<n; i++){
            minValue[i] = Math.min(minValue[i-1],prices[i]);
        }
        int result = 0;
        for(int i = 0; i<n; i++){
            result = Math.max(prices[i] - minValue[i], result);
        }
        return result;
    }
}
