class Solution {
    class Car {
        int position;
        int speed;
        
        public Car(int position, int speed) {
            this.position = position;
            this.speed = speed;
        }
    }
    
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Car[] cars = new Car[n];
        
        for(int i = 0; i < n; i++) {
            cars[i] = new Car(position[i], speed[i]);
        }
        
        Arrays.sort(cars, (a, b) -> b.position - a.position);
        
        Stack<Double> stack = new Stack<>();
        
        for(Car car : cars) {
            double time = (double)(target - car.position) / car.speed;
            
            if(stack.isEmpty() || stack.peek() < time)
                stack.push(time);
        }
        
        return stack.size();
    }
}