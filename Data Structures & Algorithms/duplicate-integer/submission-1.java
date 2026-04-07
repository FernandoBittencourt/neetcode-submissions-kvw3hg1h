class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> duplicateSet= new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            if(duplicateSet.contains(nums[i])){
                return true;
            }
            duplicateSet.add(nums[i]);
        }
        return false;
    }
}