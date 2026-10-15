class Solution {
    public int leastInterval(char[] tasks, int n) {

        Map<Character, Integer> count = new HashMap<>();

        for (char t : tasks) {
            count.put(t, count.getOrDefault(t, 0) + 1);
        }

        int f = 0;
        for (Integer t : count.values()) {
            if (t > f) {
                f = t;
            }
        }

        int m = 0;
        for (Integer t : count.values()) {
            if (t == f) {
                m++;
            }
        }

        int result = Math.max(((f-1) * (n+1)) + m, tasks.length);

        return result;

    }
}
