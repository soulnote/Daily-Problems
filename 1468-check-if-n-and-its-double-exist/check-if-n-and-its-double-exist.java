class Solution {
    public boolean checkIfExist(int[] arr) {
        HashSet<Float> map = new HashSet<>();
        for(float num : arr){
            
            float twice = num*2, half = num/2;
            if(map.contains(twice)||map.contains(half)){
                // System.out.println(twice);
                // System.out.println(half);
                return true;
            }
            map.add(num);
        }
        return false;
    }
}