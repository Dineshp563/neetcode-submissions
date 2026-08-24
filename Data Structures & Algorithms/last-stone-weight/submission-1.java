class Solution {
     public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone : stones) {
            queue.add(stone);
        }
        int remainingStone = 0;
        while (queue.size() >= 2) {
            int heavyStone = queue.poll();
            int smallStone = queue.poll();
            int newStone = heavyStone - smallStone;
            if (newStone > 0) {
                queue.add(newStone);
            }
        }
return queue.isEmpty() ? 0 : queue.peek();    }
}
