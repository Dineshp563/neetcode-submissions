class Solution {
 public int maxArea(int[] heights) {
        int ma=0,left=0, right=heights.length-1;
        while(left<right){
            int lh = heights[left];
            int rh = heights[right];
            int ca=(right-left)*Math.min(lh, rh);
            if(ma<ca){
                ma=ca;
            }
            if(lh<rh){
                left++;
            }else {
                right--;
            }
        }
        return ma;
    }
}
