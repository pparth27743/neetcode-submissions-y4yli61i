class KthLargest {

    Queue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {

        this.pq = new PriorityQueue<>((v1, v2) -> (v1-v2));
        this.k = k;

        for(int i : nums) {
            pq.add(i);

            if(pq.size() > k)
                pq.poll();
        }
        
    }
    
    public int add(int val) {
        pq.add(val);
        
        if(pq.size() > k)
            pq.poll();

        return pq.peek();
        
    }
}
