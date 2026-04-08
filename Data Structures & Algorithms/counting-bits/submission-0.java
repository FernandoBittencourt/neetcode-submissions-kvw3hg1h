class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n+1];
        for(int i=1;i<=n;i++){
            int value=i;
            int sum=0;
            while(value!=0){
                sum+=value&1;
                value>>>=1;
            }
            result[i]=sum;
        }
        return result;
    }
}
