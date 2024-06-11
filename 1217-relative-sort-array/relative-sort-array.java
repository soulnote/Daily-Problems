class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int n1 = arr1.length, n2 = arr2.length;
        int[]ans = new int[n1];
        int idx=0;
        for(int i=0;i<n2;i++){
            for(int j=0;j<n1;j++){
                if(arr2[i]==arr1[j]){
                    ans[idx] = arr1[j];
                    System.out.println(ans[idx]);
                    idx++;
                }
            }
        }
        Arrays.sort(arr1);
        for(int i=0;i<n1;i++){
            boolean found=false;
            for(int j=0;j<n2;j++){
                if(arr1[i]==arr2[j]){
                    found = true;
                }
            }
            if(!found){
                ans[idx] = arr1[i];
                idx++;
            }
        }
      
        return ans;
    }
}