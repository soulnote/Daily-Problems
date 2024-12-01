class Solution {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : arr){
            int twice = num*2, half = num/2;
            if(set.contains(twice)||(num % 2 == 0 && set.contains(half))){
                return true;
            }
            set.add(num);
        }
        return false;
    }
}