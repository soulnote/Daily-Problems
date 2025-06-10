class Solution {
    public int maxDifference(String s) {
        int[]arr = new int[26];
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            arr[ch-'a']++;
        }
        int oddMax = 0, evenMin=100;
        for(int i=0;i<26;i++){
            if(arr[i]%2==0){
                if(arr[i]<evenMin && arr[i]!=0)evenMin= arr[i];
            }
            else{
                if(arr[i]>oddMax)oddMax= arr[i];
            }
        }
        return oddMax - evenMin;
    }
}