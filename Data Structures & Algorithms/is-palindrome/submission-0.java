class Solution {
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        s=s.toLowerCase();
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            char lc = s.charAt(left), rc = s.charAt(right);
            if (Character.isLetterOrDigit(lc) && Character.isLetterOrDigit(rc) && lc != rc) {
                return false;
            } else if (!Character.isLetterOrDigit(lc)) {
                left++;
            } else if (!Character.isLetterOrDigit(rc)) {
                right--;
             } else {
                left++;
                right--;
            }
        }
        return true;
    }
}
