class Solution {
    public int[] productExceptSelf(int[] nums) {
        int countZero=0;
        int product=1;
        for(int num: nums){
            if(num==0){
                countZero++;
            } else{                
                product*=num;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(countZero==1 && nums[i]==0){
                nums[i]=product;
            } else if(countZero==1 && nums[i]!=0){
                nums[i]=0;
            } else if(countZero>1){
                nums[i]=0;
            }else{
                nums[i]=product/nums[i];
            }
        }
        return nums;
    }
}  
