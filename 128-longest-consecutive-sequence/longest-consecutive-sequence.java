class Solution {

    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        for (int num : nums) {

            if (set.contains(num) && !set.contains(num - 1)) {

                int length = 1;
                int next = num + 1;

                set.remove(num);

                while (set.contains(next)) {
                    length++;
                    set.remove(next);
                    next++;
                }

                longest = Math.max(longest, length);
            }
        }

        return longest;
    }
}