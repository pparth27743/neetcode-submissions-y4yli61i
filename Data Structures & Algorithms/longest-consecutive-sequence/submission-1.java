class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> setNums = new HashSet<>();
        Map<Integer, Integer> memo = new HashMap<>();

        for(int num : nums) {
            setNums.add(num);
        }

        for(int num : nums) {
            recurrance(num, setNums, memo);
        }
        
        int maxLen = 0;
        
        for(Map.Entry<Integer, Integer> entry : memo.entrySet()) {
            maxLen = Math.max(maxLen, entry.getValue());
        }

        return maxLen;
    }


    public int recurrance(int x, Set<Integer> setNums, Map<Integer, Integer> memo) {

        if(!setNums.contains(x))
            return 0;

        if(memo.containsKey(x))
            return memo.get(x);
        
        int maxLen = 1 + recurrance(x+1, setNums, memo);
        memo.put(x, maxLen);

        return maxLen;
    }
}
