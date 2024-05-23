class Solution {

    public boolean isSafe(int nums[], List<Integer> part, int j, int k) {
        for (int i = 0; i < part.size(); i++) {
            if (Math.abs(nums[j] - part.get(i)) == k) {
                return false;
            }
        }

        return true;
    }

    public int count = 0;

    public void subSetArr(int[] nums, int i, List<Integer> part, int k) {
        if (i >= nums.length) {
            count++;
            return;
        }
        if (isSafe(nums, part, i, k)) {
            part.add(nums[i]);
            subSetArr(nums, i + 1, part, k);
            part.remove(part.size() - 1);
        }
        subSetArr(nums, i + 1, part, k);
    }

    public int beautifulSubsets(int[] nums, int k) {
        count = 0;

        subSetArr(nums, 0, new ArrayList<>(), k);
        return count - 1;
    }
}