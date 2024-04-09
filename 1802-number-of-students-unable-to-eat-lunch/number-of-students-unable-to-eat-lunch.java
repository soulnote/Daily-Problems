class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> studentsSt = new LinkedList<>();
        Stack<Integer> sandwichesSt = new Stack<>();
        for(int i = sandwiches.length-1; i>=0;i--){
            sandwichesSt.push(sandwiches[i]);
        }
        for(int i=0;i < students.length;i++){
            studentsSt.offer(students[i]);
        }
        int count=0;
        while(!studentsSt.isEmpty()){
            int studentval = studentsSt.poll();
            int  sandwichval = sandwichesSt.peek();
            if(studentval==sandwichval){
                sandwichesSt.pop();
                count=0;
            }
            else{
                studentsSt.offer(studentval);
                count++;
            }
            if(count==studentsSt.size()) return count;
        }
        return count;
    }
}