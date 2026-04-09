class Solution {
    public int longestConsecutive(int[] nums) {
        
        int output=0;
        HashSet<Integer> set= new HashSet<Integer>();
        for(int i=0; i<nums.length;i++){
            set.add(nums[i]);
        }
        for(int i=0;i<nums.length;i++){
            if(!set.contains(nums[i]-1)){
                int j=nums[i]+1;
                while(set.contains(j)){
                    j++;
                }
                if(output<j-nums[i]){
                    output=j-nums[i];
                }
            } 
        }
        return output;
    }
}
