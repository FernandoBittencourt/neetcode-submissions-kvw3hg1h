class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++){
            if(cache.get(target-nums[i])!=null){
                return new int[]{cache.get(target-nums[i]),i};
            }
            cache.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }
}
