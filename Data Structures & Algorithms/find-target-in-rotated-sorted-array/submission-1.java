class Solution {
    public int search(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        int mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (nums[mid] == target)
                return mid;

            if (nums[mid] <= nums[right]) {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid;

                }
            } else {
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;

                }
            }
        }
        return nums[left] == target ? left : -1;
    }
}
