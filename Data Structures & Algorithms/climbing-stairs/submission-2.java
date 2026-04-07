class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n];
        return climbStairsMemo(n, memo);
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
