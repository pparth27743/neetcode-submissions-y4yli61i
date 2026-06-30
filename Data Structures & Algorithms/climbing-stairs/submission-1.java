class Solution {
    public int climbStairs(int n) {

        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);

        return rec(n, memo);
     
    }

    public int rec(int n, int[] memo) {
        if(n < 0)
            return 0;
        
        if(n == 0)
            return 1;

        if(memo[n] != -1)
            return memo[n];
        
        return (memo[n] = rec(n-1, memo) + rec(n-2, memo));
        
    }
}
