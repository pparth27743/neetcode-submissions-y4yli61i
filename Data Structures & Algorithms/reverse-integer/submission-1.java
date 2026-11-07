class Solution {
    public int reverse(int x) {
        int sign = (x>0) ? 1 : -1;

        long longval = reverNumberLong(Math.abs(x));
        int intval = reverNumberInt(Math.abs(x));

        // System.out.println(intval);
        // System.out.println(longval);


        if(longval != intval) {
            return 0;
        }   
        
        return sign * intval;
    }

    private long reverNumberLong(long x) {
        long ans = 0;
        while(x!=0) {
            ans = ans*10 + (x%10);
            x = x/10;
        }
        return ans;
    }

    private int reverNumberInt(int x) {
        int ans = 0;
        while(x!=0) {
            ans = ans*10 + (x%10);
            x = x/10;
        }
        return ans;
    }
}
