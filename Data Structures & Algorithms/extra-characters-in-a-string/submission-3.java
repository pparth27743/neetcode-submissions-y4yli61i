class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Set<String> dict = new HashSet<>(Arrays.asList(dictionary));
        int n = s.length();
        int[] memo = new int[n];
        Arrays.fill(memo, -1);

        return rec(0, s, n, dict, memo);        
    }


    public int rec(int s, String str, int n, Set<String> dict, int[] memo) {
 
        if(n-s == 0 || dict.contains(str.substring(s,n)))
            return 0;

        if(n-s == 1)
            return 1;

       if(memo[s] != -1)
            return memo[s];

        int minLeftChar = n - s;

        for(int i=s; i<n; i++) {
            for(int j=i+1; j<=n; j++) {
                if(dict.contains(str.substring(i, j))) {
                    minLeftChar = Math.min(minLeftChar, (i-s) + rec(j, str, n, dict, memo));
                }
            }
        }

        return memo[s] = minLeftChar;
    }
}