class Solution {
    public int findMin(int[] nums) {
        int i=0;
        int j=nums.length-1;
        while(i<j){
            int middle = i + (j - i) / 2;

            if (nums[middle] > nums[j]) {
                i = middle + 1;
            } else {
                j = middle;
            }
        }
        return nums[i];
    }


}
