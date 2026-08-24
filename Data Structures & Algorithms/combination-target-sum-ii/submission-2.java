class Solution {
   

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ArrayList<Integer> currentPath = new ArrayList<>();
        List<List<Integer>> resultLists = new ArrayList<>();
        Arrays.sort(candidates);
        backTrackSum2(0, target, candidates, currentPath, resultLists);
        return resultLists;
    }

    //Input: candidates = [9,2,2,4,6,1,5], target = 8
    //  [1,2,5],
    //  [2,2,4],
    //  [2,6]
    private static void backTrackSum2(int index, int target, int[] nums, ArrayList<Integer> currentPath, List<List<Integer>> resultLists) {
        
        if (target == 0) {
            resultLists.add(new ArrayList<>(currentPath));
               return;
        }
        if (target < 0 || index == nums.length) {
            return;
        }
// --- CHOICE 1: INCLUDE ---
    currentPath.add(nums[index]);
    backTrackSum2(index + 1, target - nums[index], nums, currentPath, resultLists);
    currentPath.remove(currentPath.size() - 1);
    
    // --- CHOICE 2: SKIP ---
    // Fast-forward our next index past any duplicates
    int nextIndex = index + 1;
    while (nextIndex < nums.length && nums[nextIndex] == nums[index]) {
        nextIndex++;
    }
    
    // Recurse with the completely new number
    backTrackSum2(nextIndex, target, nums, currentPath, resultLists);

    }
}
