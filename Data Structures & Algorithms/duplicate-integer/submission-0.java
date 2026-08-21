class Solution { 
      public boolean hasDuplicate(int[] nums) {
    Set<Integer> seen = new HashSet<>();
    for (int num : nums) {
        // If the set already contains the number, add() returns false
        if (!seen.add(num)) {
            return true; // Early exit! We found a duplicate.
        }
    }
    return false;
      }
}