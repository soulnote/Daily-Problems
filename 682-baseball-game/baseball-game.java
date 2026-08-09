class Solution {
    public int calPoints(String[] operations) {
        List<Integer> list = new ArrayList<>();
        for(String str : operations){
            int n = list.size();
            if(str.equals("C")){
                list.remove(n-1);
            }
            else if(str.equals("D")){
                list.add(list.get(n-1)*2);
            }
            else if(str.equals("+")){
                int sum = list.get(n-1) + list.get(n-2);
                list.add(sum);
            }
            else{
                int num = Integer.valueOf(str);
                list.add(num);
            }
        }
        int sum =0;
        for(int i=0;i<list.size();i++){
            sum+= list.get(i);
        }
        return sum;
    }
}