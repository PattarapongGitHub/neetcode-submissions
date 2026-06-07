class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] output = new int[temperatures.length];
        Deque<Integer> temp = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!temp.isEmpty() && temperatures[i] > temperatures[temp.peek()]) {
                int pastIndex = temp.pop();
                output[pastIndex] = i - pastIndex;
            }
            temp.push(i);
        }
        return output;
    }
}
