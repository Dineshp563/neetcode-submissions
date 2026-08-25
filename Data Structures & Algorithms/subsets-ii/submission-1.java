class Solution {
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        Arrays.sort(nums);
        subsetsWithDupRecursWithForLoop(0, nums, subsets, new ArrayList<>());
        return subsets;
    }
public void subsetsWithDupRecursWithForLoop(int index, int[] nums, List<List<Integer>> subsets, List<Integer> curArray) {
        subsets.add(new ArrayList<>(curArray));
        for (int start = index; start < nums.length; start++) {
            if (start > index && nums[start] == nums[start - 1]) {
                continue;
            }
            curArray.add(nums[start]);
            subsetsWithDupRecurs(start+1, nums, subsets, curArray);
            curArray.remove(curArray.size() - 1);
        }
    }

    public void subsetsWithDupRecurs(int index, int[] nums, List<List<Integer>> subsets, List<Integer> curArray) {
        if (index == nums.length) {
            subsets.add(new ArrayList<>(curArray));
            return;
        }
        curArray.add(nums[index]);
        subsetsWithDupRecurs(index + 1, nums, subsets,curArray);
        curArray.remove(curArray.size() - 1);
        int newIndex=index+1;
        while (newIndex < nums.length && (nums[newIndex] == nums[newIndex - 1])) {
            newIndex++;
        }
        subsetsWithDupRecurs(newIndex, nums, subsets, curArray);
    }
}
