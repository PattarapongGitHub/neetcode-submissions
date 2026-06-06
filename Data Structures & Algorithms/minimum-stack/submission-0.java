class MinStack {
    public Deque<Integer> mainStack = new ArrayDeque<>();
    public Deque<Integer> minStack = new ArrayDeque<>();

    public MinStack() {}

    public void push(int val) {
        if (minStack.isEmpty()) {
            minStack.push(val);
        } else {
            int min = minStack.peek();
            minStack.push(Math.min(val, min));
        }
        mainStack.push(val);
    }

    public void pop() {
        mainStack.pop();
        minStack.pop();
    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
