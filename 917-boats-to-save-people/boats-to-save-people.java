class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left=0,right=people.length-1;
        int count=0;
        while(left<=right){
            if(people[right]>limit)right--;
            if(people[right]<=limit){
                if(people[left]+people[right]<=limit){
                    count++;
                    left++;
                    right--;
                }
                else{
                    count++;
                    right--;
                }
            }
        }
        return count;
    }
}