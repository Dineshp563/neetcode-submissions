class Solution {
    public String minWindow(String s, String t) {
        String answer = "";
        HashMap<Character, Integer> map = new HashMap<>();
        if (t.length() > s.length()) {
            return "";
        }

        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        int count = 0;
        int minwindowLength = Integer.MAX_VALUE;
        int left = 0, right = 0;
//     Input: s = "OUZODYXAZV", t = "XYZ"

        while (right < s.length()) {
            char rc = s.charAt(right);
            if (map.containsKey(rc)) {
                int value = map.get(rc) - 1;
                map.put(rc, value);
                if (value == 0) {
                    count++;
                }
//aaaabcadd - abcdd
                if (count == map.size()) {
                    while (left < right) {
                        char lc = s.charAt(left);
                        if (map.containsKey(lc) && map.get(lc) <= 0) {
                            int leftValue = map.get(lc) + 1;
                            if (leftValue == 1) {

                                break;
                            }
                            map.put(lc, leftValue);
                        }
                        left++;
                    }
                    int windowLength = right - left + 1;
                    if (minwindowLength > windowLength) {
                        answer = s.substring(left, right + 1);
                        minwindowLength = windowLength;
                    }
                }

            }
            right++;
        }
        return answer;
    }
    }
