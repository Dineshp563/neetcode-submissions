class Solution {
   
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<Integer> currentPath = new ArrayList<>();
        List<List<Integer>> resultLists = new ArrayList<>();
        backTrackPermutation(nums, currentPath, resultLists);
        return resultLists;
    }

    private static void backTrackPermutation(int[] nums, ArrayList<Integer> currentPath, List<List<Integer>> resultLists) {

        if (currentPath.size() == nums.length) {
            resultLists.add(new ArrayList<>(currentPath));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (currentPath.contains(nums[i])) {
                continue;
            }
            currentPath.add(nums[i]);
            backTrackPermutation(nums, currentPath, resultLists);
            currentPath.remove(currentPath.size() - 1);
        }
    }
}
