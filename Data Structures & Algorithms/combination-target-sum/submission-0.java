class Solution {
    
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> resultLists = new ArrayList<>();
        backTrack(0, target, nums, new ArrayList<Integer>(), resultLists);
        return resultLists;
    }

     
    private static void backTrack(int index, int target, int[] nums, ArrayList<Integer> currentPath, List<List<Integer>> resultLists) {
        if (target < 0 || index >= nums.length) {
            return;
        }

        if (target == 0) {
            resultLists.add(new ArrayList<>(currentPath));
            return;
        }

        int currIndexValue = nums[index];
        currentPath.add(currIndexValue);
        backTrack(index, target - currIndexValue, nums, currentPath, resultLists);

        currentPath.remove(currentPath.size() - 1);
        backTrack(index + 1, target, nums, currentPath, resultLists);
    }
}
