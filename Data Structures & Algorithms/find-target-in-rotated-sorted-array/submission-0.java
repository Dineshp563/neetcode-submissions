class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (target <= nums[nums.length - 1]) {
            right = nums.length - 1;
        } else {
            right = left - 1;
            left = 0;
        }
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
