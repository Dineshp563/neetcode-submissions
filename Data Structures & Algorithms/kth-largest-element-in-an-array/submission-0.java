class Solution {
        public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> topKElement = new PriorityQueue<>(k + 1);
        for (int num : nums) {
            topKElement.add(num);
            if (topKElement.size() > k) {
                topKElement.remove();
            }
        }
        return topKElement.peek();
    }
}
