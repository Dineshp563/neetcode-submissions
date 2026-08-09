
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums); 
        //-4,-1,0,1,2
        int left, right, sum;
        for (int i = 0; i < nums.length - 1; i++) {
            int val1 = nums[i];
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
                if (right<(nums.length-2) && nums[right] == nums[right + 1]) {
                    right--;
                    continue;
                } else if (left>i+1 && nums[left] == nums[left - 1]) {
                    left++;
                    continue;
                }
                sum = val1 + nums[right] + nums[left];
                if (sum == 0) {
                    result.add(List.of(val1, nums[right], nums[left]));
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }
}