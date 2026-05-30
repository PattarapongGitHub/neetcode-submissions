class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] output = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int index1 = numbers[i];
                int index2 = numbers[j];
                int sum = index1 + index2;

                if (sum == target && index1 < index2) {
                    output[0] = i + 1;
                    output[1] = j + 1;
                }
            }
        }

        return output;
    }
}
