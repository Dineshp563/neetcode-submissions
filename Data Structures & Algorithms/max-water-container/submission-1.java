class Solution {
 public int maxArea(int[] heights) {
        int ma=0,left=0, right=heights.length-1;
        while(left<right){
            int lh = Math.min(heights[left],heights[right]);
            int ca=(right-left)*lh;
            if(ma<ca){
                ma=ca;
            }
            if(lh==heights[left]){
                left++;
            }else {
                right--;
            }
        }
        return ma;
    }
}
