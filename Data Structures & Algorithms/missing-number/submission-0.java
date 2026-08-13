class Solution {
    public int missingNumber(int[] nums) {
        int sum=0;
        for (int num:nums){
            sum+=num;
        }
        int length = nums.length;
        return ((length*(length+1))/2-sum);
    }
}
