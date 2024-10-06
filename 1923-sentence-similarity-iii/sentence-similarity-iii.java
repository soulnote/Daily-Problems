class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if(sentence1.length()==sentence2.length()){
            if(sentence1.equals(sentence2)) return true;
            else return false;
        }
        
        String[] arr1 = sentence1.split(" ");
        String[] arr2 = sentence2.split(" ");
        
        int l1 = arr1.length;  // l1 = length of the 1st array arr1.
        int l2 = arr2.length;  // l2 = length of the 2st array arr2.
        
        int f1 =0, f2 =0;        // f1 and f2 are the front of the array arr1 and arr2;
        int b1 =l1-1, b2 = l2-1; // b1 and b2 are the back of the array arr1 and arr2;
        
        // If the front element of both array are equal we delete them and increment the front.
        while(l1!=0 && l2!=0 && arr1[f1].equals(arr2[f2])){
            l1--;
            l2--;
            f1++;
            f2++;
        }
        
        // If the back element of both array are equal we delete them and decrement the back.
        while(l1!=0 && l2!=0 && arr1[b1].equals(arr2[b2])){
            l1--;
            l2--;
            b1--;
            b2--;
        }
        
        return l1==0 || l2==0;  
    }
}