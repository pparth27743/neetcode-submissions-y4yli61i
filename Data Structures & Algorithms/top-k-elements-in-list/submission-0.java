class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();

        for(int num : nums) {
            mp.put(num, mp.getOrDefault(num, 0)+1);
        }

        PriorityQueue<Integer[]> pq = new PriorityQueue<>((e1, e2) -> (e1[0]-e2[0]));

        for(Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            Integer[] arr = new Integer[2];
            arr[0] = entry.getValue();
            arr[1] = entry.getKey();
            pq.add(arr);

            if(pq.size() > k)
                pq.poll();
        }

        int[] topKElement = new int[k];
        int i=0;

        while(!pq.isEmpty()) {
            Integer[] topEle = pq.poll();
            topKElement[i++] = topEle[1];
        }

        return topKElement;
        
    }
}
