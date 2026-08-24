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

        currentPath.add(nums[index]);
        backTrackSum2(index+1, target - nums[index], nums, currentPath, resultLists);
        Integer removed = currentPath.remove(currentPath.size() - 1);
        int i = 1;
        while (index+i<nums.length &&nums[index + i] == removed ) {
            i++;
        }
        backTrackSum2(index + i, target, nums, currentPath, resultLists); 

    }
}
