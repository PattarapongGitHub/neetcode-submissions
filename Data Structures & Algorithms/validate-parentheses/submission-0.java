class Solution {
    public boolean isValid(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                deque.offerLast(c);
            } else if (!deque.isEmpty() && (deque.peekLast() == '(' && c == ')')) {
                deque.removeLast();
            } else if (!deque.isEmpty() && (deque.peekLast() == '{' && c == '}')) {
                deque.removeLast();
            } else if (!deque.isEmpty() && (deque.peekLast() == '[' && c == ']')) {
                deque.removeLast();
            } else {
                return false;
            }
        }
        return deque.isEmpty();
    }
}
