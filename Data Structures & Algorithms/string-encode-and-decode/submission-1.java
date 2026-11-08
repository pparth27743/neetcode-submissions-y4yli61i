class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs) {
            sb.append(str.length());
            sb.append("#");
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        int slen = str.length();
        int i=0;
        List<String> strs = new ArrayList<>();

        while(i<slen) {
            StringBuilder sb1 = new StringBuilder();
            while(str.charAt(i) != '#') {
                sb1.append(str.charAt(i));
                i++;
            }
            i++; // Skip  character #
            
            int len = Integer.valueOf(sb1.toString());

            

            strs.add(str.substring(i, i+len));

            i = i+len;
        }

        return strs;
    }
}
