class Solution {
    public int pivotInteger(int n) {
        if(n==1) return 1;
        int left = 1, right= n;
        int leftsum = 1, rightsum = n;
        
        while(left<=right){
            if(leftsum == rightsum && left == right)return left;
            else if(leftsum<rightsum){
                left++;
                leftsum += left;
            }
            else {
                right--;
                rightsum += right;
            }
            // else{
            //     right--;
            //     left++;
            //     leftsum+=left;
            //     rightsum+=right;
            // }
        } 
        return -1;
    }
}