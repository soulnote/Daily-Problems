class Person{   // creating a custom class Person to encapsulate names with their heights
    String name;
    int height;

    // Constructor
    Person(String name, int height){ 
        this.name = name;
        this.height = height;
    }
}

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        Person[] people = new Person[n];    // Array to store the People

        for(int i=0;i<n;i++){
            people[i] = new Person(names[i],heights[i]);
        }

        Arrays.sort(people, (a,b)->{ return b.height - a.height;});

        String[] ans = new String[n];  
        for(int i=0;i<n;i++){
            ans[i] = people[i].name;
        }

        return ans;
    }
}