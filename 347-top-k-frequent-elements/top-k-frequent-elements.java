class Solution {
    public int[] topKFrequent(int[] nums, int k) {
      
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) map.put(nums[i], 1);
            else map.put(nums[i], map.get(nums[i]) + 1);
        }

        int n = map.size();
        int[][] arr = new int[n][2];

        int idx = 0;
        for (Integer i: map.keySet()) {
            arr[idx][0] = i;
            arr[idx][1] = map.get(i);
            idx++;
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[1], b[1]));

        int[] res = new int[k];
        idx = 0;

        for (int i = n - 1; i > n - 1 - k; i--) {
            res[idx++] = arr[i][0];
        }
        return res;


    }
}