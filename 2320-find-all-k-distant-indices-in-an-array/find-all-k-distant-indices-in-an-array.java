class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            if(nums[i]==key){
                int maxLeft = Math.max(0,i-k);
                int minRight = Math.min(n-1, i+k);
                for(int kDistant = maxLeft;kDistant<=minRight;kDistant++){
                    set.add(kDistant);
                }
            }
        }

        List<Integer> ans = new ArrayList<>(set);
        Collections.sort(ans);
        return ans;
    }
}