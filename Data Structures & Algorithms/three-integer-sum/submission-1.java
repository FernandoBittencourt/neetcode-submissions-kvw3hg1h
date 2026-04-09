class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int k=0;k<nums.length-1;k++){
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            int i=k+1;
            int j=nums.length-1;
            while(i<j){
                if(nums[k]+nums[i]+nums[j]==0){
                    List<Integer> sum = new ArrayList<Integer>();
                    sum.add(nums[k]);
                    sum.add(nums[i]);
                    sum.add(nums[j]);
                    output.add(sum);
                    i++;
                    j--;
                    while (i < j && nums[i] == nums[i - 1]) i++;
                    while (i < j && nums[j] == nums[j + 1]) j--;
                } else if(nums[k]+nums[i]+nums[j]>0){
                    j--;
                } else{
                    i++;
                }
            }
        }
        return output;
    }
}
