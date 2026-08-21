class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 1. Build the Frequency Map: O(N) Time, O(N) Space
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // 2. Create the Buckets Array: O(N) Space
        // We use nums.length + 1 so the index can perfectly match the maximum possible frequency
        List<Integer>[] buckets = new List[nums.length + 1];
        
        for (int key : count.keySet()) {
            int freq = count.get(key);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(key);
        }

        // 3. Gather the top k elements by reading the buckets backwards: O(N) Time
        int[] result = new int[k];
        int index = 0;
        
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    result[index++] = num;
                    if (index == k) { // We found exactly k elements, so stop!
                        return result;
                    }
                }
            }
        }
        
        return result;
    }
}