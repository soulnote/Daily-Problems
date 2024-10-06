class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        // Split both sentences into arrays of words
        String[] arr1 = sentence1.split(" ");
        String[] arr2 = sentence2.split(" ");
        
        // Ensure arr1 is the smaller or equal length array
        if (arr1.length > arr2.length) {
            return areSentencesSimilar(sentence2, sentence1);
        }
        
        int n1 = arr1.length;
        int n2 = arr2.length;
        
        // Check the prefix and suffix match
        int i = 0; // for prefix
        while (i < n1 && arr1[i].equals(arr2[i])) {
            i++;
        }
        
        int j = 0; // for suffix
        while (j < n1 - i && arr1[n1 - 1 - j].equals(arr2[n2 - 1 - j])) {
            j++;
        }
        
        // If i + j covers the entire smaller sentence, it's similar
        return i + j == n1;
    }
}
