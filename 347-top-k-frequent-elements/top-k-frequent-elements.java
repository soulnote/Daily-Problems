class Solution {
  public int[] topKFrequent(int[] nums, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int a : nums) {
      map.put(a, map.getOrDefault(a, 0) + 1);
    }

    int[][] newArr = new int[map.size()][2];
    int idx = 0;
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      newArr[idx] = new int[] { entry.getKey(), entry.getValue() };
      idx++;
    }

    Arrays.sort(newArr, (int[] a, int[] b) -> b[1] - a[1]); // Sort by frequency (descending)

    int[] ans = new int[k];
    for (int i = 0; i < k; i++) {
      ans[i] = newArr[i][0];
    }
    return ans;
  }
}
