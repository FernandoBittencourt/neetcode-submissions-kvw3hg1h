class Solution {
    public int climbStairs(int n) {
       // int[] memo = new int[n];
       // return climbStairsMemo(n, memo);

       if(n<2){
        return n;
       }

        int prev2 = 1;
        int prev1 = 2;

        for (int i = 3; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }



    private int climbStairsMemo(int n, int[] memo){
        if(n==0){
            return 1;
        } else if(n<0){
            return 0;
        }
        if(memo[n-1]!=0){
            return memo[n-1];
        }
        memo[n-1]=climbStairsMemo(n-1, memo)+climbStairsMemo(n-2, memo);
        return memo[n-1];
    }
}
