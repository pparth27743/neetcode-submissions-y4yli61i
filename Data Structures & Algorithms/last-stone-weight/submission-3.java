class Solution {
    public int lastStoneWeight(int[] stones) {

        Queue<Integer> pq = new PriorityQueue<>((v1,v2) -> (v2-v1));

        for(int weight : stones) {
            pq.add(weight);
        } 

        while(pq.size() > 1) {
            int x = pq.poll();
            int y = pq.poll();

            if(x == y)
                continue;
            else   
                pq.add(Math.abs(x-y));
        }

        return (pq.size() > 0) ? pq.poll() : 0;
        
    }
}
