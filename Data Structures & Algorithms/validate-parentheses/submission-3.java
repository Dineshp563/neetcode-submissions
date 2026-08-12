class Solution {
    public boolean isValid(String s){
       Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> map = Map.of('[', ']', '{', '}', '(', ')');
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.push(map.getOrDefault(c, c));
            } else if (stack.peek() != null && c == stack.peek()) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
