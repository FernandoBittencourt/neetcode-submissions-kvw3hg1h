class Solution {
    public int search(int[] nums, int target) {
        int middle=nums.length/2;
        int i=0;
        int j=nums.length-1;
        
        while(i<=j){
            if(target==nums[middle]){
                return middle;
            } else if(target<nums[middle]){
                j=middle-1;
            } else{
                i=middle+1;
            }
            middle=(i+j)/2;
        }
        return -1;
    }
}
