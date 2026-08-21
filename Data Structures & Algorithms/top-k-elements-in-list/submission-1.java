class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        int length = nums.length + 1;
        ArrayList<Integer>[] bucketArray = new ArrayList[length];
        for (Integer numValue : countMap.keySet()) {
            Integer count = countMap.get(numValue);
            if (bucketArray[count] == null) {
                bucketArray[count] = new ArrayList<>();
            }
            bucketArray[count].add(numValue);
        }
        int[] result = new int[k];
        int count = 0;
        for (int i = length - 1; i > 0; i--) {
            ArrayList<Integer> numValuesList = bucketArray[i];
            if (numValuesList != null && !numValuesList.isEmpty()) {
                for (Integer numValue : numValuesList) {
                    result[count++] = numValue;
                    if (count == k) {
                        return result;
                    }
                }
            }
        }
        return result;
    }
}
