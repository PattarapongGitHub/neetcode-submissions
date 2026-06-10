class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pairs = new int[position.length][2];

        for (int i = 0; i < position.length; i++) {
            pairs[i][0] = position[i];
            pairs[i][1] = speed[i];
        }

        Arrays.sort(pairs, (a, b) -> Integer.compare(b[0], a[0]));

        Deque<Double> fleets = new ArrayDeque<>();

        for (int[] pair : pairs) {
            int position2 = pair[0];
            int speed2 = pair[1];
            double time = (target - position2) * 1.0 / speed2;
            if (fleets.isEmpty() || fleets.peek() < time) {
                fleets.push(time);
            }
        }

        return fleets.size();
    }
}