
class MedianFinder {
    PriorityQueue<Integer> topKReverseElement; // Max-Heap (Lower half)
    PriorityQueue<Integer> topLowElement;      // Min-Heap (Upper half)

    public MedianFinder() {
        topKReverseElement = new PriorityQueue<>(Comparator.reverseOrder());
        topLowElement = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // 1. Add to max-heap, then route the biggest to min-heap
        topKReverseElement.add(num);
        topLowElement.add(topKReverseElement.poll());

        // 2. THE BALANCING RULE: Max-Heap must always be >= Min-Heap
        if (topLowElement.size() > topKReverseElement.size()) {
            topKReverseElement.add(topLowElement.poll());
        }
    }

    public double findMedian() {
        // If sizes are unequal, total is odd (Max-Heap holds the extra middle element)
        if (topKReverseElement.size() > topLowElement.size()) {
            return topKReverseElement.peek();
        }
        // If sizes are equal, total is even (Average the two middle elements)
        else {
            return (topKReverseElement.peek() + topLowElement.peek()) / 2.0;
        }
    }
}