class Solution {
    public boolean isValid(String s) {

        Stack<Character> stk = new Stack<>();
        int len = s.length();
        Set<Character> openBracket = new HashSet<>();

        openBracket.add('(');
        openBracket.add('{');
        openBracket.add('[');

        for(int i=0; i<len; i++) {
            if(openBracket.contains(s.charAt(i))) {
                stk.push(s.charAt(i));
            } else {
                
                if(stk.empty())
                    return false;


                char ch = stk.pop();
                if((s.charAt(i) == ')' && ch != '(') ||
                    (s.charAt(i) == '}' && ch != '{') ||
                    (s.charAt(i) == ']' && ch != '[')) {
                        return false;
                    }
            }
        }

        if(!stk.empty())
            return false;

        return true;
    }
}
