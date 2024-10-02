class Solution {
    public int[] arrayRankTransform(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 1;
        int[] arr = new int[nums.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = nums[i];
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], count);
                count++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            nums[i] = map.get(nums[i]);
        }
        return nums;

    }
}