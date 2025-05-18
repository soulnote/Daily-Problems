class MedianFinder {
    private PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
    private PriorityQueue<Integer> large = new PriorityQueue<>();
    private boolean even = true;

    public void addNum(int num) {
        //total elements even  → both heaps have equal size
        if(even){ //total elements odd  → small heap have one extra element
            large.offer(num); 
            small.offer(large.poll());
        } else {
            small.offer(num);
            large.offer(small.poll()); 
        }
        even = !even; 
    }

    public double findMedian() {
        if (even)
            return (small.peek() + large.peek()) / 2.0;
        else
            return small.peek();
    }
}

