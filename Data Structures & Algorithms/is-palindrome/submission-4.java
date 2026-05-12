class Solution {
    public boolean isPalindrome(String s) {

        int len = s.length();
        int l=0, r=len-1;

        while(l<r) {
            while(l<len && !Character.isLetterOrDigit(s.charAt(l)))
                l++;
            
            if(l>r) return true;

            while(r>0 && !Character.isLetterOrDigit(s.charAt(r)))
                r--;

            if(l>r) return true;
            
            if(Character.toLowerCase(s.charAt(l++)) != Character.toLowerCase(s.charAt(r--)))
                return false;
            
        }

        return true;
        
    }
}
