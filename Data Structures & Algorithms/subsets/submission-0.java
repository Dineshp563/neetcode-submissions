class Solution {
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsetsRecurs(0, nums, subsets, new ArrayList<>());
        return subsets;
    }


    public void subsetsRecurs(int index, int[] nums, List<List<Integer>> subsets, List<Integer> curArray) {
       
       System.out.println("curArray Ans:" + curArray);
       
        if (index == nums.length) {
        subsets.add(new ArrayList<>(curArray));
            return;
        }

        int currentIndexValue = nums[index];
        curArray.add(currentIndexValue);
        subsetsRecurs(index + 1, nums, subsets, curArray);
        curArray.remove(curArray.size() - 1);
        subsetsRecurs(index + 1, nums, subsets, curArray);
    }


}
