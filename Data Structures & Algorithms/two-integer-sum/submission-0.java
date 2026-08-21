class Solution {
    public int[] twoSum(int[] nums, int target) {
     // Map stores: <Value, Index>
    Map<Integer, Integer> map = new HashMap<>();
    
    for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];
        
        // If we found the remaining value, we have a match!
        if (map.containsKey(complement)) {
            // Because we are looking backwards at numbers we already processed, 
            // the map's index will ALWAYS be smaller than our current 'i'.
            return new int[] { map.get(complement), i };
        }
        
        // Otherwise, add the current number and index to the map
        map.put(nums[i], i);
    }
    
    // Return empty array if no pair is found (though the prompt guarantees one)
    return new int[0];   
    }
}
