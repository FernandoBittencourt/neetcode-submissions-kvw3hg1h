class Solution {
    public int minEatingSpeed(int[] piles, int hours) {

        int i=1;
        int j=findMaxPile(piles);
        int result=j;
        while(i<=j){
            int middle=(i+j)/2;
            boolean isValid = canEat(piles, middle, hours);
            if(isValid){
                result=middle;
                j=middle-1;
            }else{
                i=middle+1;
            }
            
        }
        return result;
    }

    private boolean canEat(int[] piles, int bananas, int hours){
        for(int i=0;i<piles.length;i++){
            int pile=piles[i];
            hours-=(pile + bananas - 1) / bananas;
        }
        return hours>=0;
    }

    private int findMaxPile(int[] piles){
        int result=0;
        for(int i=0;i<piles.length;i++){
            if(piles[i]>result){
                result=piles[i];
            }
        }
        
        return result;
    }
}
