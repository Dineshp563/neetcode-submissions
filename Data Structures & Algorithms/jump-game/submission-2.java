class Solution {
 
    public boolean canJump(int[] nums) {
        int currentMaxJumpReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (currentMaxJumpReach < i) {
                return false;
            }
            currentMaxJumpReach= Math.max(currentMaxJumpReach,i+nums[i]);
            if(currentMaxJumpReach>= nums.length){
                return true;
            }
        }
        return true;
    }
}
