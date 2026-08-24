
class KthLargest {
     PriorityQueue<Integer> topKElement = new PriorityQueue<>();
    int k = 0;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num : nums) {
            topKElement.add(num);
            if (topKElement.size() > k) {
                topKElement.poll();
            }
        }
    }

    public int add(int val) {
        topKElement.add(val);
        if (topKElement.size() > k) {
            topKElement.poll();
        }
        return topKElement.peek();
    }
}
