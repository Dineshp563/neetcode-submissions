class Solution {
     public int rob(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        if (length == 0) {
            return 0;
        } else if (length == 1) {
            return nums[0];
        }
        return Math.max(rob2(nums, 0, length - 2), rob2(nums, 1, length - 1));
    }

    public int rob2(int[] nums, int start, int end) {
        int latest = 0, earliest = 0;
        for (int i = start; i <= end; i++) {
            int temp = Math.max(earliest + nums[i], latest);
            earliest = latest;
            latest = temp;
        }
        return latest;
    }
}
