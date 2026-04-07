class Solution {
    public int maxProfit(int[] prices) {
        int max=0;
        int init=prices[0];

        for(int i=1;i<prices.length;i++){
            if(init>prices[i]){
                init=prices[i];
            } else if(prices[i]-init>max){
                max=prices[i]-init;
            }
        }

        return max;
    }
}
