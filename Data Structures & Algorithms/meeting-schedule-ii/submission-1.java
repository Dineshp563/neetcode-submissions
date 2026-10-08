/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    
    public int minMeetingRooms(List<Interval> intervals) {

        int maxMeetingRoomRequired = 0;
        intervals.sort(Comparator.comparing(a -> a.start));
        Queue<Integer> endTimeQueue = new PriorityQueue<>();

        for (Interval interval : intervals) {
            if (!endTimeQueue.isEmpty() && endTimeQueue.peek() <= interval.start) {
                endTimeQueue.poll();
            }
            endTimeQueue.offer(interval.end);

            maxMeetingRoomRequired = Math.max(maxMeetingRoomRequired, endTimeQueue.size());
        }


        return maxMeetingRoomRequired;


    }

}
