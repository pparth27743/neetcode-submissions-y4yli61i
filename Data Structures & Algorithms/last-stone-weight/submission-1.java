class Solution {
    public int lastStoneWeight(int[] stones) {

        Queue<Integer> pq = new PriorityQueue<>((v1, v2) -> (v2 - v1));

        for(int i : stones) {
            pq.add(i);
        }
        int x,y,z;
        while(pq.size() > 1) {
            x = pq.poll();
            y = pq.poll();
            z = Math.abs(x-y);
            if (z != 0)
                pq.add(z);
        }

        if(pq.size() == 0)
            return 0;
        
        return pq.peek();
    }
}
