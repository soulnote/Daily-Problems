class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        HashSet<Integer> set1= new HashSet<>();
        HashSet<Integer> set2= new HashSet<>();
        for(int i =0;i<nums1.length;i++){
            set1.add(nums1[i]);
        }
        for(int i =0;i<nums2.length;i++){
            set2.add(nums2[i]);
        }
        int min = Integer.MAX_VALUE;
        boolean isPresent=false;
        for(int val : set1){
            if(set2.contains(val) && val<min){
                min = val;
                isPresent=true;
            }
        }
        if(isPresent) return min;
        return -1;
    }
}