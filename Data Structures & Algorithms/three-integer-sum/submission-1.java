
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        // 1. We still sort it first! This makes skipping duplicates incredibly easy.
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            // Prevent duplicate anchors
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; 
            }
            
            // 2. Create a fresh HashSet for this specific anchor
            HashSet<Integer> seen = new HashSet<>();
            
            // 3. Run standard Two Sum on the rest of the array
            for (int j = i + 1; j < nums.length; j++) {
                int complement = -(nums[i] + nums[j]);
                
                if (seen.contains(complement)) {
                    // We found a match!
                    result.add(Arrays.asList(nums[i], nums[j], complement));
                    
                    // Prevent duplicate triplets by skipping identical 'j' numbers
                    while (j + 1 < nums.length && nums[j] == nums[j + 1]) {
                        j++;
                    }
                }
                
                // Add the current number to the set for future pairs to check
                seen.add(nums[j]);
            }
        }
        
        return result;
    }
}