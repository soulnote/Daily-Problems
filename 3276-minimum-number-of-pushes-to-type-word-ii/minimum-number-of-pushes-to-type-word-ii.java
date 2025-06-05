class Solution {
    public int minimumPushes(String word) {
      
        int[]arr = new int[26];
        for(int i=0;i<word.length();i++){
            arr[word.charAt(i)-'a']++;
        }
        Arrays.sort(arr);
        for(int i=0;i<13;i++){
            int temp = arr[i];
            arr[i] = arr[25-i];
            arr[25-i] = temp;
        }
        int pushes =0;
        for(int i =0;i<8;i++){
            pushes+=arr[i];
        }
        for(int i=8;i<16;i++){
            pushes+= arr[i]*2;
        }
        for(int i=16;i<24;i++){
            pushes+= arr[i]*3;
        }
        for(int i=24;i<26;i++){
            pushes+= arr[i]*4;
        }
        return pushes;
    }
}