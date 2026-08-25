class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
     List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] numsUsed = new boolean[nums.length];
        System.out.println("numsUsed: " + Arrays.toString(numsUsed));
        backTrack1(nums, numsUsed, new ArrayList<>(), result);
        return result;
    }

    private void backTrack1(int[] nums, boolean[] numsUsed, List<Integer> curr, List<List<Integer>> result) {
        System.out.println("numsUsed: " + Arrays.toString(numsUsed));
        System.out.println("curr: " + curr);
        if (curr.size() == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }//1 1 2
        for (int i = 0; i < nums.length; i++) {
            // 1. Skip if this exact index is already in our current permutation
            if (numsUsed[i]) {
                continue;
            }

            // 2. Skip if it's a duplicate of the previous number AND the previous
            //    number was just used and backtracked from at this level
            if (i > 0 && nums[i] == nums[i - 1] && !numsUsed[i - 1]) {
                continue;
            }

            // Choose
            curr.add(nums[i]);
            numsUsed[i] = true;

            // Explore
            backTrack1(nums, numsUsed, curr, result);

            // Un-choose (Backtrack)
            curr.remove(curr.size() - 1);
            numsUsed[i] = false;
        }
    }

}